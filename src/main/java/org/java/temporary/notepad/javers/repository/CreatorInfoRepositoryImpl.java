package org.java.temporary.notepad.javers.repository;

import com.mybatisflex.annotation.UseDataSource;
import com.mybatisflex.core.query.QueryWrapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hutool.core.util.ObjUtil;
import org.java.temporary.notepad.javers.domain.AuditRecord;
import org.java.temporary.notepad.javers.domain.CreatorInfo;
import org.java.temporary.notepad.javers.mapper.AuditRecordMapper;
import org.java.temporary.notepad.javers.mapper.CreatorInfoMapper;
import org.javers.core.Javers;
import org.javers.core.diff.Diff;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * @author huyi
 */
@Slf4j
@Repository
@UseDataSource(value = "talent_rw")
public class CreatorInfoRepositoryImpl implements CreatorInfoRepository {

    @Resource
    private Javers javers;

    @Resource
    private CreatorInfoMapper creatorInfoMapper;

    @Resource
    private AuditRecordMapper auditRecordMapper;

    @Override
    public CreatorInfo selectCreatorInfoByCreatorId(String creatorId) {

        QueryWrapper queryWrapper =
            QueryWrapper.create().select().from(CreatorInfo.class).where(CreatorInfo::getCreatorId)
                .eq(creatorId, ObjUtil::isNotEmpty);

        return creatorInfoMapper.selectOneByQuery(queryWrapper);
    }

    @Override
    public List<CreatorInfo> selectCreatorIdList(CreatorInfo creatorInfo) {
        QueryWrapper queryWrapper =
            QueryWrapper.create().select().from(CreatorInfo.class).where(CreatorInfo::getCreatorId)
                .eq(creatorInfo.getCreatorId(), ObjUtil::isNotEmpty).and(CreatorInfo::getCreatorName)
                .eq(creatorInfo.getCreatorName(), ObjUtil::isNotEmpty);

        return creatorInfoMapper.selectListByQuery(queryWrapper);
    }

    @Override
    public int insertCreatorInfo(CreatorInfo creatorInfo) {
        return creatorInfoMapper.insert(creatorInfo);
    }

    @Override
    public int updateCreatorInfo(CreatorInfo creatorInfo) {

        QueryWrapper queryWrapper =
            QueryWrapper.create().select().from(CreatorInfo.class).where(CreatorInfo::getCreatorId)
                .eq(creatorInfo.getCreatorId(), ObjUtil::isNotEmpty);

        CreatorInfo existCreatorInfo = creatorInfoMapper.selectOneById(creatorInfo.getCreatorId());

        Diff compare = javers.compare(existCreatorInfo, creatorInfo);

        if (!compare.hasChanges()) {
            return 0;
        }

        int update = creatorInfoMapper.update(creatorInfo);

        // 保存审计记录
        String changeDate = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        AuditRecord auditRecord = new AuditRecord();
        auditRecord.setEntityName(CreatorInfo.class.getSimpleName());
        auditRecord.setEntityId(String.valueOf(creatorInfo.getCreatorId()));
        auditRecord.setChangeType("UPDATE");
        auditRecord.setUser("admin");
        auditRecord.setChangeDate(changeDate);
        auditRecord.setDiff(compare.toString());

        auditRecordMapper.insert(auditRecord);

        // 保存审计记录
        javers.commit("admin", creatorInfo);
        return update;
    }

    @Override
    public int deleteCreatorInfoByCreatorId(String creatorId) {
        return creatorInfoMapper.deleteById(creatorId);
    }

    @Override
    public int deleteCreatorInfoByCreatorIds(String[] creatorIds) {
        return creatorInfoMapper.deleteBatchByIds(Arrays.asList(creatorIds));
    }
}

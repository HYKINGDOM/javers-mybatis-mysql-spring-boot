package org.java.temporary.notepad.javers.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.java.temporary.notepad.javers.domain.CreatorInfo;
import org.java.temporary.notepad.javers.repository.CreatorInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 达人信息Service业务层处理
 *
 * @author NiYanchun
 * @date 2023-11-02
 */
@Service
@Slf4j
public class CreatorInfoServiceImpl implements ICreatorInfoService {

    @Resource
    private CreatorInfoRepository creatorInfoRepository;

    @Override
    public CreatorInfo selectCreatorInfoByCreatorId(String creatorId) {
        return creatorInfoRepository.selectCreatorInfoByCreatorId(creatorId);
    }

    @Override
    public List<CreatorInfo> selectCreatorIdList(CreatorInfo creatorInfo) {
        return creatorInfoRepository.selectCreatorIdList(creatorInfo);
    }

    @Override
    public int insertCreatorInfo(CreatorInfo creatorInfo) {
        return creatorInfoRepository.insertCreatorInfo(creatorInfo);
    }

    @Override
    public int updateCreatorInfo(CreatorInfo creatorInfo) {
        return creatorInfoRepository.updateCreatorInfo(creatorInfo);
    }

    @Override
    public int deleteCreatorInfoByCreatorId(String creatorId) {
        return creatorInfoRepository.deleteCreatorInfoByCreatorId(creatorId);
    }

    @Override
    public int deleteCreatorInfoByCreatorIds(String[] creatorIds) {
        return creatorInfoRepository.deleteCreatorInfoByCreatorIds(creatorIds);
    }
}

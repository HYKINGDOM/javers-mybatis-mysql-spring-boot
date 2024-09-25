package org.java.temporary.notepad.javers.service;

import org.java.temporary.notepad.javers.domain.CreatorInfo;

import java.util.List;

/**
 * 达人信息Service接口
 *
 * @author NiYanchun
 * @date 2023-11-02
 */
public interface ICreatorInfoService {
    /**
     * 查询达人信息
     *
     * @param creatorId 达人信息主键
     * @return 达人信息
     */
    CreatorInfo selectCreatorInfoByCreatorId(String creatorId);

    /**
     * 查询达人信息列表
     *
     * @param creatorInfo 达人信息
     * @return 达人信息集合
     */
    List<CreatorInfo> selectCreatorIdList(CreatorInfo creatorInfo);

    /**
     * 新增达人信息
     *
     * @param creatorInfo 达人信息
     * @return 结果
     */
    int insertCreatorInfo(CreatorInfo creatorInfo);

    /**
     * 修改达人信息
     *
     * @param creatorInfo 达人信息
     * @return 结果
     */
    int updateCreatorInfo(CreatorInfo creatorInfo);

    /**
     * 删除达人信息
     *
     * @param creatorId 达人信息主键
     * @return 结果
     */
    int deleteCreatorInfoByCreatorId(String creatorId);

    /**
     * 批量删除达人信息
     *
     * @param creatorIds 需要删除的数据主键集合
     * @return 结果
     */
    int deleteCreatorInfoByCreatorIds(String[] creatorIds);
}

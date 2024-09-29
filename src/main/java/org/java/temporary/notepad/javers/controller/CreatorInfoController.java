package org.java.temporary.notepad.javers.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.java.temporary.notepad.javers.domain.CreatorInfo;
import org.java.temporary.notepad.javers.service.ICreatorInfoService;
import org.java.temporary.notepad.javers.util.AjaxResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.java.temporary.notepad.javers.util.AjaxResult.success;

/**
 * 达人信息Controller
 *
 * @author NiYanchun
 * @date 2023-11-02
 */
@Slf4j
@RestController
@RequestMapping("/crm/creator")
public class CreatorInfoController {

    @Resource
    private ICreatorInfoService creatorInfoService;

    @PostMapping("/listPage")
    public AjaxResult listPage(@Validated @RequestBody CreatorInfo creatorInfo) {
        List<CreatorInfo> list = creatorInfoService.selectCreatorIdList(creatorInfo);
        return AjaxResult.success(list);
    }

    /**
     * 获取达人信息详细信息
     */

    @GetMapping(value = "/{creatorId}")
    public AjaxResult getInfo(@PathVariable("creatorId") String creatorId) {
        return success(creatorInfoService.selectCreatorInfoByCreatorId(creatorId));
    }

    /**
     * 新增达人信息
     */
    @PostMapping
    public AjaxResult add(@RequestBody CreatorInfo creatorInfo) {
        int i = creatorInfoService.insertCreatorInfo(creatorInfo);
        return success(i);
    }

    /**
     * 修改达人信息
     */
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody CreatorInfo creatorInfo) {
        int i = creatorInfoService.updateCreatorInfo(creatorInfo);
        return success(i);
    }

    /**
     * 删除达人信息
     */
    @DeleteMapping("/{creatorIds}")
    public AjaxResult remove(@PathVariable String[] creatorIds) {
        int i = creatorInfoService.deleteCreatorInfoByCreatorIds(creatorIds);
        return success(i);
    }

}

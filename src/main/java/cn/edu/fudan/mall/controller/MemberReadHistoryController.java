package cn.edu.fudan.mall.controller;

import cn.edu.fudan.mall.common.api.CommonResult;
import cn.edu.fudan.mall.nosql.mongodb.pojo.MemberReadHistory;
import cn.edu.fudan.mall.service.MemberReadHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags="MemberReadHistoryController", description="会员浏览记录管理")
@RequestMapping(value="/member/history")
public class MemberReadHistoryController {
    @Autowired
    private MemberReadHistoryService memberReadHistoryService;

    /**
     * 创建浏览记录
     * @return
     */
    @ApiOperation("创建用户记录")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    CommonResult<MemberReadHistory> insertReadHistory(@RequestBody MemberReadHistory memberReadHistory){
        int ansCnt = memberReadHistoryService.create(memberReadHistory);
        if(ansCnt == 1){
            return CommonResult.success(memberReadHistory,"创建用户记录成功");
        }
        return CommonResult.failed("创建用户记录失败");
    }

    /**
     * 读取用户历史记录
     * @param id
     * @return
     */
    @ApiOperation("读取用户历史记录")
    @RequestMapping(value="/list")
    @ResponseBody
    CommonResult<List<MemberReadHistory>> getReadHistoryById(@RequestParam("id")Long id){
        List<MemberReadHistory> historyList = memberReadHistoryService.getReadHistory(id);
        return CommonResult.success(historyList,"读取用户历史记录成功");
    }

    /**
     * 删除用户历史记录
     * @param memberReadHistory
     * @return
     */
    @ApiOperation("删除用户历史记录")
    @RequestMapping(value="/delete")
    @ResponseBody
    CommonResult<MemberReadHistory> deleteReadHistory(@RequestBody MemberReadHistory memberReadHistory){
        int ansCnt = memberReadHistoryService.delete(memberReadHistory);
        if(ansCnt == 1){
            return CommonResult.success(memberReadHistory, "删除用户历史记录成功");
        }
        return CommonResult.failed("删除用户历史记录失败");

    }


}

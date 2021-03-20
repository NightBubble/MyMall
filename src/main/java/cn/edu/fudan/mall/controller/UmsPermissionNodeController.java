package cn.edu.fudan.mall.controller;

import cn.edu.fudan.mall.common.api.CommonResult;
import cn.edu.fudan.mall.dto.UmsPermissionNode;
import cn.edu.fudan.mall.service.UmsPermissionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(tags = "UmsPermissionController",description = "权限树")
@RequestMapping("/permission")
public class UmsPermissionNodeController {
    @Autowired
    private UmsPermissionService umsPermissionService;

    @RequestMapping(value="getPermissionTree", method=RequestMethod.POST)
    @ResponseBody
    CommonResult<List<UmsPermissionNode>> getPermissionTree(){
        List<UmsPermissionNode> node = umsPermissionService.getPermissionTree();
        if(node.isEmpty()){
            return CommonResult.failed("查找失败");
        }
        return CommonResult.success(node,"查找成功");
    }
}

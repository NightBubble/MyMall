package cn.edu.fudan.mall.service;

import cn.edu.fudan.mall.dto.UmsPermissionNode;

import java.util.List;

/**
 * 权限服务模块
 */
public interface UmsPermissionService {
    /**
     * 以层级的形式返回权限
     * @return
     */
    List<UmsPermissionNode> getPermissionTree();

    void streamTest();
}

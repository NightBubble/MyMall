package cn.edu.fudan.mall.dto;

import cn.edu.fudan.mall.mbg.model.UmsPermission;
import java.util.List;

/**
 * 权限节点树
 * 自顶向下权限依次增高
 */
public class UmsPermissionNode extends UmsPermission {
    private List<UmsPermissionNode> children;
    public UmsPermissionNode(List<UmsPermissionNode> children){
        this.children = children;
    }
    public UmsPermissionNode(){};

    public List<UmsPermissionNode> getChildren() {
        return children;
    }

    public void setChildren(List<UmsPermissionNode> children) {
        this.children = children;
    }
}

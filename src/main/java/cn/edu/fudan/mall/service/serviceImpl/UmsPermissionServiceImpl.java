package cn.edu.fudan.mall.service.serviceImpl;

import cn.edu.fudan.mall.dto.UmsPermissionNode;
import cn.edu.fudan.mall.mbg.mapper.UmsPermissionMapper;
import cn.edu.fudan.mall.mbg.model.UmsPermission;
import cn.edu.fudan.mall.mbg.model.UmsPermissionExample;
import cn.edu.fudan.mall.service.UmsPermissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UmsPermissionServiceImpl implements UmsPermissionService {
    @Autowired
    private UmsPermissionMapper umsPermissionMapper;

    @Override
    public List<UmsPermissionNode> getPermissionTree() {
            List<UmsPermission> permissionList = umsPermissionMapper.selectByExample(new UmsPermissionExample());
            List<UmsPermissionNode> result = permissionList.stream()
                    .filter(permission -> permission.getPid().equals(0L))
                    .map(permission -> convertToNode(permission, permissionList))
                    .collect(Collectors.toList());
            return result;
    }


    @Override
    public void streamTest() {

    }

    private UmsPermissionNode convertToNode(UmsPermission permission, List<UmsPermission> permissionList){
        UmsPermissionNode permissionRoot= new UmsPermissionNode();
        BeanUtils.copyProperties(permission, permissionRoot);
        List<UmsPermissionNode> children = permissionList.stream()
                .filter(subPermission -> subPermission.getPid().equals(permission.getPid()+1L))
                .filter(subPermission -> subPermission.getType().equals(permission.getType()))
                .map(subPermission -> convertToNode(subPermission, permissionList))
                .collect(Collectors.toList());
        permissionRoot.setChildren(children);
        return permissionRoot;
    }
}

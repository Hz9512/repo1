package com.hz.service;

import com.hz.domain.Permission;
import com.hz.domain.Role;

import java.util.List;

public interface IRoleService {

    public List<Role> findAll()throws Exception;

    public void save(Role role)throws Exception;

    public Role findById(String roleId)throws Exception;

    public List<Permission> findOtherPermissions(String roleId)throws Exception;

    public void addPermissionToRole(String roleId, String[] permissionids)throws Exception;
}

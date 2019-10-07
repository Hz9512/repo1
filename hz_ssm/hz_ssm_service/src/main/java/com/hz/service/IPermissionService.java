package com.hz.service;

import com.hz.domain.Permission;

import java.util.List;

public interface IPermissionService {
    public List<Permission> findAll()throws Exception;

    public void save(Permission permission)throws Exception;
}

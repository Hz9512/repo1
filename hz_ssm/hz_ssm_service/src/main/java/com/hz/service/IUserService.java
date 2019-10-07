package com.hz.service;

import com.hz.domain.Role;
import com.hz.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
   List<UserInfo> findAll() throws Exception;

    public void save(UserInfo userInfo) throws Exception;

    public UserInfo findById(String id)throws Exception;

    public List<Role> findOtherRoles(String userId)throws Exception;

    public void addRoleToUser(String userId, String[] roleIds)throws Exception;
}

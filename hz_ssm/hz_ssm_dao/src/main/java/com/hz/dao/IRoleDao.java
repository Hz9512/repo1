package com.hz.dao;

import com.hz.domain.Permission;
import com.hz.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {

    //根据用户Id查询出所有对应的角色
    @Select("select * from role where id in(select roleId from users_role where userId=#{userId})")
    @Results({
        @Result(id=true,property = "id",column = "id"),
        @Result(property = "roleName",column = "roleName"),
        @Result(property = "roleDesc",column = "roleDesc"),
        @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.hz.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;

    //查询所有角色
    @Select("select * from role")
    public List<Role> findAll() throws Exception;

    //添加角色
    @Insert("insert into role(roleName,roleDesc)values(#{roleName},#{roleDesc})")
    public void save(Role role)throws Exception;

    @Select("select * from role where id=#{roleId}")
    public Role findById(String roleId)throws Exception;

    @Select("select * from permission where id not in(select permissionId from role_permission where roleId=#{roleId})")
    public List<Permission> findOtherPermissions(String roleId)throws Exception;

    @Insert("insert into role_permission(permissionId,roleId)values(#{permissionId},#{roleId})")
    public void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId)throws Exception;
}

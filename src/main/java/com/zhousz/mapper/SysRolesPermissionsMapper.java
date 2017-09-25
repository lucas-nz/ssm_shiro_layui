package com.zhousz.mapper;

import com.zhousz.pojo.SysRolesPermissionsExample;
import com.zhousz.pojo.SysRolesPermissionsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRolesPermissionsMapper {
    int countByExample(SysRolesPermissionsExample example);

    int deleteByExample(SysRolesPermissionsExample example);

    int deleteByPrimaryKey(SysRolesPermissionsKey key);

    int insert(SysRolesPermissionsKey record);

    int insertSelective(SysRolesPermissionsKey record);

    List<SysRolesPermissionsKey> selectByExample(SysRolesPermissionsExample example);

    int updateByExampleSelective(@Param("record") SysRolesPermissionsKey record, @Param("example") SysRolesPermissionsExample example);

    int updateByExample(@Param("record") SysRolesPermissionsKey record, @Param("example") SysRolesPermissionsExample example);
}
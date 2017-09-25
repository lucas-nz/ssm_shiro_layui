package com.zhousz.mapper;

import com.zhousz.pojo.SysUsers;
import com.zhousz.pojo.SysUsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUsersMapper {
    int countByExample(SysUsersExample example);

    int deleteByExample(SysUsersExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUsers record);

    int insertSelective(SysUsers record);

    List<SysUsers> selectByExample(SysUsersExample example);

    SysUsers selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUsers record, @Param("example") SysUsersExample example);

    int updateByExample(@Param("record") SysUsers record, @Param("example") SysUsersExample example);

    int updateByPrimaryKeySelective(SysUsers record);

    int updateByPrimaryKey(SysUsers record);
}
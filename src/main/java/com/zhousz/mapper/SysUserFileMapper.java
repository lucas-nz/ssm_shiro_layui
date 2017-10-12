package com.zhousz.mapper;

import com.zhousz.pojo.SysUserFile;
import com.zhousz.pojo.SysUserFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserFileMapper {
    int countByExample(SysUserFileExample example);

    int deleteByExample(SysUserFileExample example);

    int deleteByPrimaryKey(Integer fileId);

    int insert(SysUserFile record);

    int insertSelective(SysUserFile record);

    List<SysUserFile> selectByExample(SysUserFileExample example);

    SysUserFile selectByPrimaryKey(Integer fileId);

    int updateByExampleSelective(@Param("record") SysUserFile record, @Param("example") SysUserFileExample example);

    int updateByExample(@Param("record") SysUserFile record, @Param("example") SysUserFileExample example);

    int updateByPrimaryKeySelective(SysUserFile record);

    int updateByPrimaryKey(SysUserFile record);
}
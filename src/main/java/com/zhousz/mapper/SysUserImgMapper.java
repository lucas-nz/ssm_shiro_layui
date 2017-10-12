package com.zhousz.mapper;

import com.zhousz.pojo.SysUserImg;
import com.zhousz.pojo.SysUserImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserImgMapper {
    int countByExample(SysUserImgExample example);

    int deleteByExample(SysUserImgExample example);

    int deleteByPrimaryKey(Integer imgId);

    int insert(SysUserImg record);

    int insertSelective(SysUserImg record);

    List<SysUserImg> selectByExample(SysUserImgExample example);

    SysUserImg selectByPrimaryKey(Integer imgId);

    int updateByExampleSelective(@Param("record") SysUserImg record, @Param("example") SysUserImgExample example);

    int updateByExample(@Param("record") SysUserImg record, @Param("example") SysUserImgExample example);

    int updateByPrimaryKeySelective(SysUserImg record);

    int updateByPrimaryKey(SysUserImg record);
}
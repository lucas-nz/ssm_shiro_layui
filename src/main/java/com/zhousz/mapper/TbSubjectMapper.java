package com.zhousz.mapper;

import com.zhousz.pojo.TbSubject;
import com.zhousz.pojo.TbSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSubjectMapper {
    int countByExample(TbSubjectExample example);

    int deleteByExample(TbSubjectExample example);

    int deleteByPrimaryKey(Integer subjectid);

    int insert(TbSubject record);

    int insertSelective(TbSubject record);

    List<TbSubject> selectByExampleWithBLOBs(TbSubjectExample example);

    List<TbSubject> selectByExample(TbSubjectExample example);

    TbSubject selectByPrimaryKey(Integer subjectid);

    int updateByExampleSelective(@Param("record") TbSubject record, @Param("example") TbSubjectExample example);

    int updateByExampleWithBLOBs(@Param("record") TbSubject record, @Param("example") TbSubjectExample example);

    int updateByExample(@Param("record") TbSubject record, @Param("example") TbSubjectExample example);

    int updateByPrimaryKeySelective(TbSubject record);

    int updateByPrimaryKeyWithBLOBs(TbSubject record);

    int updateByPrimaryKey(TbSubject record);
}
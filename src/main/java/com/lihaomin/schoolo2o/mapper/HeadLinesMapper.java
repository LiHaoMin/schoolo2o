package com.lihaomin.schoolo2o.mapper;

import com.lihaomin.schoolo2o.model.HeadLines;
import com.lihaomin.schoolo2o.model.HeadLinesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadLinesMapper {
    long countByExample(HeadLinesExample example);

    int deleteByExample(HeadLinesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HeadLines record);

    int insertSelective(HeadLines record);

    List<HeadLines> selectByExample(HeadLinesExample example);

    HeadLines selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HeadLines record, @Param("example") HeadLinesExample example);

    int updateByExample(@Param("record") HeadLines record, @Param("example") HeadLinesExample example);

    int updateByPrimaryKeySelective(HeadLines record);

    int updateByPrimaryKey(HeadLines record);
}
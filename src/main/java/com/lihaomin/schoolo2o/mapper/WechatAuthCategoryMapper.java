package com.lihaomin.schoolo2o.mapper;

import com.lihaomin.schoolo2o.model.WechatAuth;
import com.lihaomin.schoolo2o.model.WechatAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WechatAuthCategoryMapper {
    long countByExample(WechatAuthExample example);

    int deleteByExample(WechatAuthExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WechatAuth record);

    int insertSelective(WechatAuth record);

    List<WechatAuth> selectByExample(WechatAuthExample example);

    WechatAuth selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WechatAuth record, @Param("example") WechatAuthExample example);

    int updateByExample(@Param("record") WechatAuth record, @Param("example") WechatAuthExample example);

    int updateByPrimaryKeySelective(WechatAuth record);

    int updateByPrimaryKey(WechatAuth record);
}
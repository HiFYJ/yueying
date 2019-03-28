package com.fyj.mapper;

import com.fyj.pojo.Movieinfo;
import com.fyj.pojo.MovieinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MovieinfoMapper {
    int countByExample(MovieinfoExample example);

    int deleteByExample(MovieinfoExample example);

    int deleteByPrimaryKey(Long movieid);

    int insert(Movieinfo record);

    int insertSelective(Movieinfo record);

    List<Movieinfo> selectByExample(MovieinfoExample example);

    Movieinfo selectByPrimaryKey(Long movieid);

    int updateByExampleSelective(@Param("record") Movieinfo record, @Param("example") MovieinfoExample example);

    int updateByExample(@Param("record") Movieinfo record, @Param("example") MovieinfoExample example);

    int updateByPrimaryKeySelective(Movieinfo record);

    int updateByPrimaryKey(Movieinfo record);
}
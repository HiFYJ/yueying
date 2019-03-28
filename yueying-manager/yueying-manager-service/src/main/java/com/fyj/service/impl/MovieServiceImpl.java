package com.fyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyj.mapper.MovieinfoMapper;
import com.fyj.pojo.Movieinfo;
import com.fyj.pojo.MovieinfoExample;
import com.fyj.pojo.MovieinfoExample.Criteria;
import com.fyj.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieinfoMapper movieinfo;
	
	@Override
	public Movieinfo getItemById(long movieId){
		/*根据主键查询*/
		//TbItem tbItem=itemMapper.selectByPrimaryKey(itemId);
		
		/*设置查询条件,example为查询条件的一个对象*/
		MovieinfoExample example=new MovieinfoExample();
		Criteria criteria=example.createCriteria();
		//设置查询条件
		criteria.andMovieidEqualTo(movieId);
		//返回一个list
		List<Movieinfo> list=movieinfo.selectByExample(example);
		if(list.size()>0 && list!=null){
			//System.out.println(list.size());
			return list.get(0);
		}
		/*return movieinfo;*/
		return null;
	}
}

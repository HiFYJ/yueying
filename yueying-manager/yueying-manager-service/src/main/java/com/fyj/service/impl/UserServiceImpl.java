package com.fyj.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyj.mapper.UserMapper;
import com.fyj.pojo.User;
import com.fyj.pojo.UserExample;
import com.fyj.pojo.UserExample.Criteria;
import com.fyj.service.UserService;


/**
 * @author boss
 *
 */
@Service
public class UserServiceImpl implements UserService{
		/*@Autowired
		private UserMapper userInfo;*/
	@Autowired
	private UserMapper userInfo;
		
		@Override
		public User getUserById(long userId){
			/*根据主键查询*/
			//TbItem tbItem=itemMapper.selectByPrimaryKey(itemId);
			
			/*设置查询条件,example为查询条件的一个对象*/
			UserExample example=new UserExample();
			Criteria criteria=example.createCriteria();
			//设置查询条件
			criteria.andUseridEqualTo(userId);
			//返回一个list
			List<User> list=userInfo.selectByExample(example);
			if(list.size()>0 && list!=null){
				//System.out.println(list.size());
				return list.get(0);
			}
			/*return movieinfo;*/
			return null;
		}
		
		/*检查用户名与密码是否一致*/
		@Override
		public boolean checkUser(String userName,String password) {
			String UN="",pw="";
			try {
				UN=new String(userName.getBytes("ISO-8859-1"),"UTF-8");
				pw=new String(password.getBytes("ISO-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("userconservice："+UN);
			System.out.println(pw);
			UserExample example=new UserExample();
			Criteria criteria=example.createCriteria();
			//设置查询条件
			criteria.andUsernameEqualTo(UN);
			List<User> list=userInfo.selectByExample(example);
			if(list.size()>0 && list!=null){
				//说明有该用户
				if(list.get(0) != null && list.get(0).getPassword().equals(pw)){
					//*信息正确
					return true;
				}
			}
			/*if(user != null && user.getPassword().equals(password)){
				
				return user;
			}*/
			return false;
			
		}
		 //注册功能，检查用户名是否存在
		@SuppressWarnings("null")
		public boolean register(String userName,String password){
			User msg=new User();
			String UN="",pw="";
			try {
				UN=new String(userName.getBytes("ISO-8859-1"),"UTF-8");
				pw=new String(password.getBytes("ISO-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("register："+UN);
			System.out.println(pw);
			
			msg.setUsername(UN);
			msg.setPassword(password);
			
			UserExample example=new UserExample();
			Criteria criteria=example.createCriteria();
			//设置查询条件
			criteria.andUsernameEqualTo(UN);
			List<User> list=userInfo.selectByExample(example);
			//System.out.println(list.size());
			if(list.size()>0 && list!=null){
				System.out.println("该用户名已存在");
				return false;
			}else{
				if(msg!=null){
					userInfo.insert(msg);
					return true;
				}
				return false;
			}
		}
}

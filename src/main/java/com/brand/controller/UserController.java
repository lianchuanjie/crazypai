package com.brand.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.brand.model.AcctUser;
import com.brand.service.UserService;

/**  
 * 创建时间：2015-2-7 上午11:49:00  
 * @author andy  
 * @version 2.2  
 * 描述： 用户Controller
 */
@Controller
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/showInfo")
	@ResponseBody
	public AcctUser showUserInfo(
			@RequestParam (value="userId", required=false,
		      defaultValue="1") String userId){
		AcctUser userInfo = userService.get(userId);
		return userInfo;
	}
	
	@RequestMapping("/showInfos")
	@ResponseBody
	public List<AcctUser>  showUserInfos(){
		List<AcctUser> userInfos = userService.findAll();
		return userInfos;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String saveUser(){
		AcctUser user = new AcctUser();
		user.setId("2");
		user.setNickName("name");
		user.setRegisterTime(new Date());
		user.setTelephone("18658556903");
		 userService.save(user);
		
		return "111";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String saveUser1(){
		AcctUser user = new AcctUser();
		user.setId("1");
		user.setNickName("name1");
		user.setRegisterTime(new Date());
		user.setTelephone("18658556902");
		userService.update(user);
		
		return "111";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(){
		userService.delete("1");
		
		return "111";
	}
}

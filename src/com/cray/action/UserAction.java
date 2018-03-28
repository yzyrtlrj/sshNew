package com.cray.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cray.dao.entity.User;
import com.cray.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{

	//驱动模型
	User user = new User();
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	//初始化登录页面
	public String loginPage() {
		return "loginPage";
	}
	
	//用户登录的方法
		public String login(){
			//对用户的密码进行加密与数据库比较
			//user.setPassword(MD5Util.encoderToMD5(user.getPassword()));
			//调用业务层用户登录的方法
			user=userService.login(user);
			if(user!=null){
				//登录成功
				ServletActionContext.getRequest().getSession().setAttribute("userinfo", user);
				return "loginSuccess";
			}else{
				//登录失败
				return LOGIN;
			}
			
		}
		
		//用户注销
		public String logout(){
			//销毁session
			ServletActionContext.getRequest().getSession().invalidate();
			return LOGIN;
		}

}

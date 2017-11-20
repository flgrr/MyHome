package com.msys.web.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("loginAction")
@Scope("prototype")
@SuppressWarnings("serial")
public class LoginAction extends BaseAction{
	
	public String login(){
		return "login";
	}
	 
	public String top(){
		return "top";
	}
	
	public String left(){
		return "left";
	}
	
	public String change(){
		return "change";
	}
	
	public String loading(){
		return "loading";
	}
	public String alermXZ(){ //校准提醒
		return "alermXZ";
	}
	
	
	public String alermJX(){  //检修提醒
		return "alermJX";
	}
	
	public String alermZD(){ //站点运行情况
		return "alermZD";
	}
	
	public String alermSB(){   //设备运行情况
		return "alermSB";
	}
	
	public String alermYS(){ //验收提醒
		return "alermYS";
	}
	
	
	
	
	

}

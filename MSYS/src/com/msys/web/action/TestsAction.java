package com.msys.web.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.msys.domain.Tests;
import com.msys.service.TestsService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * * <bean id="testsAction" class="com.msys.web.action.TestsAction">
 *   <property name="testsService" ref="com.msys.service.impl.TestsServiceImpl"></property>
 * 
 * </bean> 
 * @author Administrator
 *
 */
@Controller("testsAction")
@Scope(value="prototype")  //多实例
@SuppressWarnings("serial")
public class TestsAction extends BaseAction implements ModelDriven<Tests>{//模型驱动

	private Tests tests=new Tests();

 
	@Resource(name=TestsService.SERVICE_NAME)//注入service
	private TestsService  testsService; 
  
	
	public Tests getModel() {
	
	return tests;
  }
	
   public String save(){
	   
	   testsService.saveTests(tests);
	   System.out.println(request.getParameter("textDate"));
	   return "success";
   }



}

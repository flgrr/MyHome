package com.msys.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.msys.dao.TestsDao;
import com.msys.domain.Tests;
import com.msys.service.TestsService;

public class TestService {
//	@Test
//	public void testSaveT(){
//		//整合spring容器，测试容器     加载类路径下的applicationContext.xml
//		
//		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
//		
//		//bean是容器中bean节点的id  
//		System.out.println("kaihs11i");
//		TestsService testsService=(TestsService) ac.getBean(TestsService.SERVICE_NAME);//返回的是接口   找的是com.msys.dao.impl.TestsDaoImpl
//		
//		Tests tests=new  Tests();
//		tests.setTextName("测试service层名称");
//		tests.setTextDate(new Date());
//		tests.setTextRemark("测试DAO备注");
//		testsService.saveTests(tests);
//		
//	}
	
	//模拟Action 层，对底层的查询列表方法进行封装
	@Test
	public void testFind(){
		
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");		
		//bean是容器中bean节点的id  
		System.out.println("kaihs11i");
		try{
			TestsService testsService=(TestsService) ac.getBean(TestsService.SERVICE_NAME);//返回的是接口   找的是com.msys.dao.impl.TestsDaoImpl
			Tests tests= new Tests();//模型驱动
			//模拟传两个值
			tests.setTextName("DAO");
			tests.setTextRemark("测试");
			List<Tests> list=testsService.findCollectionByConditionNoPage(tests);
			for(Tests text:list){
				
				System.out.println(text.getTextName()+"   "+text.getTextRemark());
			}
			
			
		}catch(Exception e){
		e.printStackTrace();
		}
		
		
	}
	
	
	
	

}

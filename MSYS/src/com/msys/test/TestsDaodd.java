package com.msys.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.msys.dao.TestsDao;
import com.msys.domain.Tests;

public class TestsDaodd {
//	@Test
//	public void testSaveT(){
//		//整合spring容器，测试容器     加载类路径下的applicationContext.xml
//		
//		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
//		
//		//bean是容器中bean节点的id  
//		System.out.println("kaihs11i");
//		TestsDao testsDao=(TestsDao) ac.getBean(TestsDao.SERVICE_NAME);//返回的是接口   找的是com.msys.dao.impl.TestsDaoImpl
//		
//		Tests tests=new  Tests();
//		tests.setTextName("测试DAO层名称");
//		tests.setTextDate(new Date());
//		tests.setTextRemark("测试DAO备注");
//		testsDao.save(tests);
//		
//	}
//	
//	@Test
//	public void deleteByIDs(){
//		//整合spring容器，测试容器     加载类路径下的applicationContext.xml
//		
//		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
//		
//		//bean是容器中bean节点的id  
//		System.out.println("kaihs11i");
//		TestsDao testsDao=(TestsDao) ac.getBean(TestsDao.SERVICE_NAME);//返回的是接口   找的是com.msys.dao.impl.TestsDaoImpl
//		Serializable[]  ids={15,16,17};
//		testsDao.deleteByIDs(ids);
//	}	
//		
//	
	@Test
	public void deleteByCollection(){   
		//整合spring容器，测试容器     加载类路径下的applicationContext.xml
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//bean是容器中bean节点的id  
		//System.out.println("kaihs11i");
		TestsDao testsDao=(TestsDao) ac.getBean(TestsDao.SERVICE_NAME);//返回的是接口   找的是com.msys.dao.impl.TestsDaoImpl
		List<Tests> list= new ArrayList<Tests>();
		Tests tests1=new Tests();
		tests1.setTextID(8);   //只需要设置textID就可以删除整条记录
		Tests tests2=new Tests();
		tests2.setTextID(8);
		Tests tests3=new Tests();
		tests3.setTextID(22);
		list.add(tests1);
		list.add(tests2);
		list.add(tests3);
		testsDao.deleteByCollection(list);
		
	}	
	
		
		
//		Serializable  id=1;
//	   Tests tests=testsDao.findObjectById(1);
//	   System.out.println(tests.getTextName()+"     "+tests.getTextRemark());
	   
	   
	 //Tests tests=new  Tests();
//		tests.setTextID(1);
//		tests.setTextName("修改DAO层名称");
//		tests.setTextDate(new Date());
//		tests.setTextRemark("修改DAO备注");
//		testsDao.update(tests);
		
	
}

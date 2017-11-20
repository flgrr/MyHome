package com.msys.test;

import java.io.File;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


import com.msys.domain.Tests;




public class TestHibernate {
	@Test
	public void testSave(){
		
		//File file=new File("src/hibernate.cfg.xml");
			//1.读取配置文件
			System.out.println("qian"+new Date());
			//try{
			Configuration configuration= new Configuration().configure();
			//System.out.println(new Date());;
			//加载类路径的hibernate.cfg.xml  配置文件中已声明，不用写参数
			//configuration.configure();  //解析XML文件，不加参数解析classpath下名字为hibernate.cfg.xml文件
			//2.创建SessionFactory  调用SessionFactory
			try{
			
			SessionFactory sf=configuration.buildSessionFactory();
			
			System.out.println("qian"+new Date());
			//3.打开session
			Session session=sf.openSession();
			//4.开启事务
			Transaction tr=session.beginTransaction();
			
			//5.持久化操作     保存tests
			Tests tests=new Tests();
			tests.setTextName("测试hibernate 名称");
			tests.setTextDate(new Date());
			tests.setTextRemark("测试Hibernate备注");
			session.save(tests);
			
			//6.事务提交
			tr.commit();
			//7.关闭session
			session.close();
			System.out.println(new Date());
			}catch(Throwable ex){
				System.out.println("SessionFactory创建失败，下面是失败的原因:");
	            ex.printStackTrace();
	            System.out.println("SessionFactory创建失败？");
	            throw new ExceptionInInitializerError(ex);
			}
		
		
	}
}

package com.msys.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.msys.dao.TestsDao;
import com.msys.dao.impl.TestsDaoImpl;
import com.msys.domain.Tests;
import com.msys.service.TestsService;
import com.opensymphony.xwork2.util.Element;

/**
 * <bean id="com.msys.service.impl.TestsServiceImpl" class="com.msys.service.impl.TestsServiceImpl">
      <property name="TestsDao" ref="com.msys.service.impl.TestsServiceImpl"> </property>
 * </bean>   注解@Repository("testsDaoImpl")可以代替《bean>中的内容
 *
 *
 * 将实现类注入到spring的容器中去
 */
@Service(TestsService.SERVICE_NAME)  //实例化bean的id
@Transactional(readOnly=true)//事务管理
public class TestsServiceImpl implements TestsService {

  // private TestsDao tests = new TestsDaoImpl(); //业务层调用DAO层,没学spring之前，这种方式调用.有了spring之后，用容器创建对象(spring的精髓)，
	                                              //由spring实例化并注入到service层
	
	//service要调用DAO的实例，创建
	@Resource(name=TestsDao.SERVICE_NAME)   //spring 实例化
	private  TestsDao testsDao;
	
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)//增删改只要操作数据库就得用事务控制。
	                                                                                   //只有查询的时候事务不用控制，①隔离级别DEFAULT：与Mysql的隔离级别相同
	                                                                                    //事物的传播行为REQUIRED，保证在一个事务里面，没有事务就创建事务，有事务就运行事务。可写
	public void saveTests(Tests tests) {
		testsDao.save(tests);

	}

    /**对底层查询列表方法进行封装*/
	public List<Tests> findCollectionByConditionNoPage(Tests tests) {
		/**
		 *  sSELECT * FROM elec_text o WHERE 1=1   #DAO层封装
            AND o.textName LIKE '%李%' #Service层封装
            AND o.textRemark LIKE '%李%' #Service层封装
            ORDER BY o.textDate ASC,o.textName DESC #Service层封装
		 */
		String condition="";
		List<String> paramsList=new ArrayList<String>();   //集合
		//if(tests.getTextName()!=null&& !tests.equals("")){
		if(StringUtils.isNotBlank(tests.getTextName())){	
			condition+="and o.textName like ?";   //用数组表示？
			paramsList.add(("%"+tests.getTextName()+"%"));
		}
		
		if(StringUtils.isNotBlank(tests.getTextRemark())){	
			condition+="and o.textRemark like ?";   //用数组表示？
			paramsList.add(("%"+tests.getTextRemark()+"%"));
		}
		//以数组作为查询条件语句的参数，把集合转成数组
		Object [] params=paramsList.toArray();
		//组织排序
		LinkedHashMap<String, String> orderby=new LinkedHashMap<String, String>();
		orderby.put("o.textDate", "ASC");
		orderby.put("o.textName", "DESC");
		List<Tests> list=testsDao.findObjectByConditionNoPage(condition,params,orderby);
		
	
		return list;
	}

}

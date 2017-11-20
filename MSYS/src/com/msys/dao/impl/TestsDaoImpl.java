package com.msys.dao.impl;

import org.springframework.stereotype.Repository;

import com.msys.dao.TestsDao;
import com.msys.domain.Tests;

/**
 * <bean id="testsDaoImpl" class="com.msys.dao.impl.TestsDaoImpl"></bean>   注解@Repository("testsDaoImpl")可以代替《bean>中的内容
 * 将实现类注入到spring的容器中去
 */
//@Repository("testsDaoImpl")
@Repository(TestsDao.SERVICE_NAME) //接口下的一个测试方法
public class TestsDaoImpl extends CommonDaoImpl<Tests> implements TestsDao {

}

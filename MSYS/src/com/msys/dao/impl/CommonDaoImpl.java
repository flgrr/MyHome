package com.msys.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.management.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.msys.dao.ICommonDao;
import com.msys.util.GenericSuperclasss;

public class CommonDaoImpl<T>  extends HibernateDaoSupport implements ICommonDao<T> {
	
	
	//范类转换
	//ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();//得到父类的class，  得到泛型类型
    //	private Class entityClass=(Class) type.getActualTypeArguments()[0];  //T是类的参数，得到实际的类型   	 

	private Class entityClass=GenericSuperclasss.getActualTypeClass(this.getClass());   //范类转换
	
	/**
	 * <!-- 将hibernateTemplate注入spring -->
	<bean id="" class="org.springframework.orm.hibernate3.HibernateTemplate">
	<property name="sessionFactory" ref="sessionFactory"></property>
	HibernateDaoSupport是spring提供的方法
	
	
	HibernateDaoSupport是有spring提供的，内涵HibernateTemplate变量
	在hibernateTemplate可实现数据的增删改查
	
	 */
	@Resource (name="sessionFactory")   //一注解的形式注入sessionFactory name=配置文件中的id
	public final void setSessionFactoryD(SessionFactory sessionFactory){  //注入SessionFactory  （一般用setxx方法注入）
		System.out.println("session"+sessionFactory);//测试能否注入sessionfactory
		super.setSessionFactory(sessionFactory);     //调用底层的setSessionFactory（HibernateDaoSupport的里面的setSessionFactory(
		                                               //最终创建一个HibernateTemplet对象hibernateTemplate = createHibernateTemplate(sessionFactory);
	
		System.out.println("session"+12);//  )）。把注入的sessionFactory给底层，就会有自己HibernateTemplate可以使用
	}
	
	
	/**保存**/
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
		//System.out.println("session"+13);
	}
	
	public void update(T entity){
		this.getHibernateTemplate().update(entity);
		}


    /**按主键id获取对象*/
	public T findObjectById(Serializable id) {
//		//范类转换      已封装GenericSuperclassss类中
//		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();//得到父类的class，  得到泛型类型
//		Class entityClass=(Class) type.getActualTypeArguments()[0];  //T是类的参数，得到实际的类型
		
		return (T) this.getHibernateTemplate().get(entityClass, id);
	}


    /**通过id传递数组的形式删除对象*/
     public void deleteByIDs(Serializable[] ids) {
    	 for(int i=0;ids!=null&&i<ids.length;i++){    		 
//    		//范类转换
//    			ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();//得到父类的class，  得到泛型类型
//    			Class entityClass=(Class) type.getActualTypeArguments()[0];  //T是类的参数，得到实际的类型   	 
    		 Object entity=this.getHibernateTemplate().get(entityClass, ids[i]);
    		 this.getHibernateTemplate().delete(entity);
    		 
    	 }
    	 
    	 
       
      }


	/**使用集合的形式删除*/
	public void deleteByCollection(List<T> list) {
		this.getHibernateTemplate().deleteAll(list);
		
	}


	/**按照查询条件获取对象集合列表数据，（不分页）*/
	public List<T> findObjectByConditionNoPage(String condition,
			final Object[] params, LinkedHashMap<String, String> orderby) {

		/**
		 *  sSELECT * FROM elec_text o WHERE 1=1   #DAO层封装
            AND o.textName LIKE '%李%' #Service层封装
            AND o.textRemark LIKE '%李%' #Service层封装
            ORDER BY o.textDate ASC,o.textName DESC #Service层封装
		 */
		
		//定义HQL语句
		String hql="from "+entityClass.getSimpleName()+" o where 1=1";
		String orderHql=this.orderByHql(orderby);//封装的方法
		
		final String finalhql=hql+condition+orderHql;
		//执行hql语句
		//方法一：
		//List<T> list=this.getHibernateTemplate().find(hql, params);
		//方法二
		List<T> list=this.getHibernateTemplate().execute(new HibernateCallback() {

	
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				org.hibernate.Query query= session.createQuery(finalhql);//调用的hibernate底层
				for(int i=0;params!=null&&i<params.length;i++){
					query.setParameter(i,params[i]);
				}
				
				
				return query.list();
			}
		});
		return list;
	}

    /**通过传递的排序集合语句（Map），获取对应的排序条件(String)*/
	private String orderByHql(LinkedHashMap<String, String> orderby) {
			StringBuffer buffer=new StringBuffer();
			if(orderby!=null){
				buffer.append("order by");
				for(Map.Entry<String, String> map:orderby.entrySet()){
					buffer.append(" "+map.getKey()+" "+map.getValue()+",");
				}
				
				buffer.deleteCharAt(buffer.length()-1);//删除最后一个逗号
			}

		
		return buffer.toString();
	}


	
	
	

}

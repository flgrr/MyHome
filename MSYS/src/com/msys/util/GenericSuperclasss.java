package com.msys.util;    //util包用于处理公共的方法

import java.lang.reflect.ParameterizedType;

public class GenericSuperclasss {

	public static Class getActualTypeClass(Class entity) {
		//范类转换
				ParameterizedType type=(ParameterizedType) entity.getGenericSuperclass();//得到父类的class，  得到泛型类型
				Class entityClass=(Class) type.getActualTypeArguments()[0];  //T是类的参数，得到实际的类型
		        return entityClass;
	}  

}

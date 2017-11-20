package com.msys.service;

import java.util.List;

import com.msys.domain.Tests;

public interface TestsService {
	 public static final String SERVICE_NAME="com.msys.service.impl.TestsServiceImpl";
       void saveTests(Tests tests);
	List<Tests> findCollectionByConditionNoPage(Tests tests);
	
}

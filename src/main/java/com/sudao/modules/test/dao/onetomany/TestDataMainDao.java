/**
 * Copyright &copy; 2015-2020 <a href="--版权信息--">sudao</a> All rights reserved.
 */
package com.sudao.modules.test.dao.onetomany;

import com.sudao.common.persistence.CrudDao;
import com.sudao.common.persistence.annotation.MyBatisDao;
import com.sudao.modules.test.entity.onetomany.TestDataMain;

/**
 * 票务代理DAO接口
 * @author liugf
 * @version 2016-01-15
 */
@MyBatisDao
public interface TestDataMainDao extends CrudDao<TestDataMain> {
	
}
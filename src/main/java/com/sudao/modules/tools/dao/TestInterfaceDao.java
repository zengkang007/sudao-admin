/**
 * Copyright &copy; 2015-2020 <a href="--版权信息--">sudao</a> All rights reserved.
 */
package com.sudao.modules.tools.dao;

import com.sudao.common.persistence.CrudDao;
import com.sudao.common.persistence.annotation.MyBatisDao;
import com.sudao.modules.tools.entity.TestInterface;

/**
 * 接口DAO接口
 * @author lgf
 * @version 2016-01-07
 */
@MyBatisDao
public interface TestInterfaceDao extends CrudDao<TestInterface> {
	
}
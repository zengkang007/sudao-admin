/**
 * Copyright &copy; 2015-2020 <a href="--版权信息--">sudao</a> All rights reserved.
 */
package com.sudao.modules.test.dao;

import com.sudao.common.persistence.CrudDao;
import com.sudao.common.persistence.annotation.MyBatisDao;
import com.sudao.modules.test.entity.SudaoUser;

/**
 * 用户表DAO接口
 * @author 曾康
 * @version 2017-09-23
 */
@MyBatisDao
public interface SudaoUserDao extends CrudDao<SudaoUser> {
	
}
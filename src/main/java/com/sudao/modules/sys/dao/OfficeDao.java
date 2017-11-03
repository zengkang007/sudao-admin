/**
 * Copyright &copy; 2015-2020 <a href="--版权信息--">sudao</a> All rights reserved.
 */
package com.sudao.modules.sys.dao;

import com.sudao.common.persistence.TreeDao;
import com.sudao.common.persistence.annotation.MyBatisDao;
import com.sudao.modules.sys.entity.Office;

/**
 * 机构DAO接口
 * @author sudao
 * @version 2014-05-16
 */
@MyBatisDao
public interface OfficeDao extends TreeDao<Office> {
	
	public Office getByCode(String code);
}

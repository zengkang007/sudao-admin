/**
 * Copyright &copy; 2015-2020 <a href="--版权信息--">sudao</a> All rights reserved.
 */
package com.sudao.modules.test.dao.one;

import com.sudao.common.persistence.CrudDao;
import com.sudao.common.persistence.annotation.MyBatisDao;
import com.sudao.modules.test.entity.one.FormLeave;

/**
 * 员工请假DAO接口
 * @author liugf
 * @version 2016-01-15
 */
@MyBatisDao
public interface FormLeaveDao extends CrudDao<FormLeave> {
	
}
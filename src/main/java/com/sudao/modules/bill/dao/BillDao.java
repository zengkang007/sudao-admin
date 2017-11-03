/**
 * Copyright &copy; 2015-2020 <a href="--版权信息--">sudao</a> All rights reserved.
 */
package com.sudao.modules.bill.dao;

import com.sudao.common.persistence.CrudDao;
import com.sudao.common.persistence.annotation.MyBatisDao;
import com.sudao.modules.bill.entity.Bill;

/**
 * 账单模块DAO接口
 * @author zhangxian
 * @version 2016-03-06
 */
@MyBatisDao
public interface BillDao extends CrudDao<Bill> {
	
}
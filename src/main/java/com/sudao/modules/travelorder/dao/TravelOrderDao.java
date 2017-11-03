/**
 * Copyright &copy; 2015-2020 <a href="--版权信息--">sudao</a> All rights reserved.
 */
package com.sudao.modules.travelorder.dao;

import com.sudao.common.persistence.CrudDao;
import com.sudao.common.persistence.annotation.MyBatisDao;
import com.sudao.modules.travelorder.entity.TravelOrder;

/**
 * 旅行单管理DAO接口
 * @author zhangxian
 * @version 2016-03-01
 */
@MyBatisDao
public interface TravelOrderDao extends CrudDao<TravelOrder> {
	
}
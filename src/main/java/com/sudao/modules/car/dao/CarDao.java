/**
 * Copyright &copy; 2015-2020 <a href="--版权信息--">sudao</a> All rights reserved.
 */
package com.sudao.modules.car.dao;

import java.util.List;

import com.sudao.common.persistence.CrudDao;
import com.sudao.common.persistence.annotation.MyBatisDao;
import com.sudao.modules.car.entity.Car;
import com.sudao.modules.sys.entity.User;

/**
 * 车辆信息管理DAO接口
 * @author zhangxian
 * @version 2016-03-01
 */
@MyBatisDao
public interface CarDao extends CrudDao<Car> {
	/**
	 * 查询当前用户空闲车辆
	 * @param user
	 * @return
	 */
	public List<Car> getFreeCarList(User user);
}
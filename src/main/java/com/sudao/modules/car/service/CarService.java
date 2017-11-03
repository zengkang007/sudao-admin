/**
 * Copyright &copy; 2015-2020 <a href="--版权信息--">sudao</a> All rights reserved.
 */
package com.sudao.modules.car.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudao.common.persistence.Page;
import com.sudao.common.service.CrudService;
import com.sudao.modules.car.entity.Car;
import com.sudao.modules.car.dao.CarDao;
import com.sudao.modules.sys.entity.User;

/**
 * 车辆信息管理Service
 * @author zhangxian
 * @version 2016-03-01
 */
@Service
@Transactional(readOnly = true)
public class CarService extends CrudService<CarDao, Car> {

	public Car get(String id) {
		return super.get(id);
	}
	
	public List<Car> findList(Car car) {
		return super.findList(car);
	}
	
	public Page<Car> findPage(Page<Car> page, Car car) {
		return super.findPage(page, car);
	}
	
	@Transactional(readOnly = false)
	public void save(Car car) {
		super.save(car);
	}
	
	@Transactional(readOnly = false)
	public void update(Car car) {
		super.dao.update(car);
	}
	@Transactional(readOnly = false)
	public void delete(Car car) {
		super.delete(car);
	}
	
	public List<Car> getFreeCarList(User user){
		return super.dao.getFreeCarList(user);
	}
}
/**
 * Copyright &copy; 2015-2020 <a href="--版权信息--">sudao</a> All rights reserved.
 */
package com.sudao.modules.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudao.common.persistence.Page;
import com.sudao.common.service.CrudService;
import com.sudao.modules.test.entity.SudaoUser;
import com.sudao.modules.test.dao.SudaoUserDao;

/**
 * 用户表Service
 * @author 曾康
 * @version 2017-09-23
 */
@Service
@Transactional(readOnly = true)
public class SudaoUserService extends CrudService<SudaoUserDao, SudaoUser> {

	public SudaoUser get(String id) {
		return super.get(id);
	}
	
	public List<SudaoUser> findList(SudaoUser sudaoUser) {
		return super.findList(sudaoUser);
	}
	
	public Page<SudaoUser> findPage(Page<SudaoUser> page, SudaoUser sudaoUser) {
		return super.findPage(page, sudaoUser);
	}
	
	@Transactional(readOnly = false)
	public void save(SudaoUser sudaoUser) {
		super.save(sudaoUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(SudaoUser sudaoUser) {
		super.delete(sudaoUser);
	}
	
}
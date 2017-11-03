/**
 * Copyright &copy; 2015-2020 <a href="--版权信息--">sudao</a> All rights reserved.
 */
package com.sudao.modules.test.service.one;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudao.common.persistence.Page;
import com.sudao.common.service.CrudService;
import com.sudao.modules.test.entity.one.FormLeave;
import com.sudao.modules.test.dao.one.FormLeaveDao;

/**
 * 员工请假Service
 * @author liugf
 * @version 2016-01-15
 */
@Service
@Transactional(readOnly = true)
public class FormLeaveService extends CrudService<FormLeaveDao, FormLeave> {

	public FormLeave get(String id) {
		return super.get(id);
	}
	
	public List<FormLeave> findList(FormLeave formLeave) {
		return super.findList(formLeave);
	}
	
	public Page<FormLeave> findPage(Page<FormLeave> page, FormLeave formLeave) {
		return super.findPage(page, formLeave);
	}
	
	@Transactional(readOnly = false)
	public void save(FormLeave formLeave) {
		super.save(formLeave);
	}
	
	@Transactional(readOnly = false)
	public void delete(FormLeave formLeave) {
		super.delete(formLeave);
	}
	
}
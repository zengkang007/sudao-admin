/**
 * Copyright &copy; 2015-2020 <a href="--版权信息--">sudao</a> All rights reserved.
 */
package com.sudao.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudao.common.service.TreeService;
import com.sudao.modules.sys.dao.OfficeDao;
import com.sudao.modules.sys.entity.Office;
import com.sudao.modules.sys.utils.UserUtils;

/**
 * 机构Service
 * @author sudao
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class OfficeService extends TreeService<OfficeDao, Office> {

	public List<Office> findAll(){
		return UserUtils.getOfficeList();
	}

	public List<Office> findList(Boolean isAll){
		if (isAll != null && isAll){
			return UserUtils.getOfficeAllList();
		}else{
			return UserUtils.getOfficeList();
		}
	}
	
	@Transactional(readOnly = true)
	public List<Office> findList(Office office){
		office.setParentIds(office.getParentIds()+"%");
		return dao.findByParentIdsLike(office);
	}
	
	@Transactional(readOnly = true)
	public Office getByCode(String code){
		return dao.getByCode(code);
	}
	
	
	@Transactional(readOnly = false)
	public void save(Office office) {
		super.save(office);
		UserUtils.removeCache(UserUtils.CACHE_OFFICE_LIST);
	}
	
	@Transactional(readOnly = false)
	public void delete(Office office) {
		super.delete(office);
		UserUtils.removeCache(UserUtils.CACHE_OFFICE_LIST);
	}
	
}

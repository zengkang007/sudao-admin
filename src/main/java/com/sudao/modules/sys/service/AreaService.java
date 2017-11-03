/**
 * Copyright &copy; 2015-2020 <a href="--版权信息--">sudao</a> All rights reserved.
 */
package com.sudao.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudao.common.service.TreeService;
import com.sudao.modules.sys.dao.AreaDao;
import com.sudao.modules.sys.entity.Area;
import com.sudao.modules.sys.utils.UserUtils;

/**
 * 区域Service
 * @author sudao
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class AreaService extends TreeService<AreaDao, Area> {

	public List<Area> findAll(){
		return UserUtils.getAreaList();
	}

	@Transactional(readOnly = false)
	public void save(Area area) {
		super.save(area);
		UserUtils.removeCache(UserUtils.CACHE_AREA_LIST);
	}
	
	@Transactional(readOnly = false)
	public void delete(Area area) {
		super.delete(area);
		UserUtils.removeCache(UserUtils.CACHE_AREA_LIST);
	}
	
}

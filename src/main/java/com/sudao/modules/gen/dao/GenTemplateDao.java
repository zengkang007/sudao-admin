/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.sudao.modules.gen.dao;

import com.sudao.common.persistence.CrudDao;
import com.sudao.common.persistence.annotation.MyBatisDao;
import com.sudao.modules.gen.entity.GenTemplate;

/**
 * 代码模板DAO接口
 * @author ThinkGem
 * @version 2013-10-15
 */
@MyBatisDao
public interface GenTemplateDao extends CrudDao<GenTemplate> {
	
}

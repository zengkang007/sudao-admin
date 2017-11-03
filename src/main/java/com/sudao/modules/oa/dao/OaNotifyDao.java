/**
 * Copyright &copy; 2015-2020 <a href="--版权信息--">sudao</a> All rights reserved.
 */
package com.sudao.modules.oa.dao;

import com.sudao.common.persistence.CrudDao;
import com.sudao.common.persistence.annotation.MyBatisDao;
import com.sudao.modules.oa.entity.OaNotify;

/**
 * 通知通告DAO接口
 * @author sudao
 * @version 2014-05-16
 */
@MyBatisDao
public interface OaNotifyDao extends CrudDao<OaNotify> {
	
	/**
	 * 获取通知数目
	 * @param oaNotify
	 * @return
	 */
	public Long findCount(OaNotify oaNotify);
	
}
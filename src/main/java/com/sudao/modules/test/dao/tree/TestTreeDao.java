/**
 * Copyright &copy; 2015-2020 <a href="--版权信息--">sudao</a> All rights reserved.
 */
package com.sudao.modules.test.dao.tree;

import com.sudao.common.persistence.TreeDao;
import com.sudao.common.persistence.annotation.MyBatisDao;
import com.sudao.modules.test.entity.tree.TestTree;

/**
 * 组织机构DAO接口
 * @author liugf
 * @version 2016-01-15
 */
@MyBatisDao
public interface TestTreeDao extends TreeDao<TestTree> {
	
}
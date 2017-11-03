/**
 * Copyright &copy; 2015-2020 <a href="--版权信息--">sudao</a> All rights reserved.
 */
package com.sudao.modules.test.entity;

import org.hibernate.validator.constraints.Length;

import com.sudao.common.persistence.DataEntity;
import com.sudao.common.utils.excel.annotation.ExcelField;

/**
 * 用户表Entity
 * @author 曾康
 * @version 2017-09-23
 */
public class SudaoUser extends DataEntity<SudaoUser> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 姓名
	private String password;		// 密码
	
	public SudaoUser() {
		super();
	}

	public SudaoUser(String id){
		super(id);
	}

	@Length(min=0, max=32, message="姓名长度必须介于 0 和 32 之间")
	@ExcelField(title="姓名", align=2, sort=7)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=32, message="密码长度必须介于 0 和 32 之间")
	@ExcelField(title="密码", align=2, sort=8)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
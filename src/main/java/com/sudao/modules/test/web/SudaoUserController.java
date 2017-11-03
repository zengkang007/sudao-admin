/**
 * Copyright &copy; 2015-2020 <a href="--版权信息--">sudao</a> All rights reserved.
 */
package com.sudao.modules.test.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.sudao.common.utils.DateUtils;
import com.sudao.common.config.Global;
import com.sudao.common.persistence.Page;
import com.sudao.common.web.BaseController;
import com.sudao.common.utils.StringUtils;
import com.sudao.common.utils.excel.ExportExcel;
import com.sudao.common.utils.excel.ImportExcel;
import com.sudao.modules.test.entity.SudaoUser;
import com.sudao.modules.test.service.SudaoUserService;

/**
 * 用户表Controller
 * @author 曾康
 * @version 2017-09-23
 */
@Controller
@RequestMapping(value = "${adminPath}/test/sudaoUser")
public class SudaoUserController extends BaseController {

	@Autowired
	private SudaoUserService sudaoUserService;
	
	@ModelAttribute
	public SudaoUser get(@RequestParam(required=false) String id) {
		SudaoUser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sudaoUserService.get(id);
		}
		if (entity == null){
			entity = new SudaoUser();
		}
		return entity;
	}
	
	/**
	 * 用户信息列表页面
	 */
	@RequiresPermissions("test:sudaoUser:list")
	@RequestMapping(value = {"list", ""})
	public String list(SudaoUser sudaoUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SudaoUser> page = sudaoUserService.findPage(new Page<SudaoUser>(request, response), sudaoUser); 
		model.addAttribute("page", page);
		return "modules/test/sudaoUserList";
	}

	/**
	 * 查看，增加，编辑用户信息表单页面
	 */
	@RequiresPermissions(value={"test:sudaoUser:view","test:sudaoUser:add","test:sudaoUser:edit"},logical=Logical.OR)
	@RequestMapping(value = "form")
	public String form(SudaoUser sudaoUser, Model model) {
		model.addAttribute("sudaoUser", sudaoUser);
		return "modules/test/sudaoUserForm";
	}

	/**
	 * 保存用户信息
	 */
	@RequiresPermissions(value={"test:sudaoUser:add","test:sudaoUser:edit"},logical=Logical.OR)
	@RequestMapping(value = "save")
	public String save(SudaoUser sudaoUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sudaoUser)){
			return form(sudaoUser, model);
		}
		sudaoUserService.save(sudaoUser);
		addMessage(redirectAttributes, "保存用户信息成功");
		return "redirect:"+Global.getAdminPath()+"/test/sudaoUser/?repage";
	}
	
	/**
	 * 删除用户信息
	 */
	@RequiresPermissions("test:sudaoUser:del")
	@RequestMapping(value = "delete")
	public String delete(SudaoUser sudaoUser, RedirectAttributes redirectAttributes) {
		sudaoUserService.delete(sudaoUser);
		addMessage(redirectAttributes, "删除用户信息成功");
		return "redirect:"+Global.getAdminPath()+"/test/sudaoUser/?repage";
	}
	
	/**
	 * 批量删除用户信息
	 */
	@RequiresPermissions("test:sudaoUser:del")
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String ids, RedirectAttributes redirectAttributes) {
		String idArray[] =ids.split(",");
		for(String id : idArray){
			sudaoUserService.delete(sudaoUserService.get(id));
		}
		addMessage(redirectAttributes, "删除用户信息成功");
		return "redirect:"+Global.getAdminPath()+"/test/sudaoUser/?repage";
	}
	
	/**
	 * 导出excel文件
	 */
	@RequiresPermissions("test:sudaoUser:export")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(SudaoUser sudaoUser, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "用户信息"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<SudaoUser> page = sudaoUserService.findPage(new Page<SudaoUser>(request, response, -1), sudaoUser);
    		new ExportExcel("用户信息", SudaoUser.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出用户信息记录失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/test/sudaoUser/?repage";
    }

	/**
	 * 导入Excel数据

	 */
	@RequiresPermissions("test:sudaoUser:import")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<SudaoUser> list = ei.getDataList(SudaoUser.class);
			for (SudaoUser sudaoUser : list){
				sudaoUserService.save(sudaoUser);
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条用户信息记录");
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入用户信息失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/test/sudaoUser/?repage";
    }
	
	/**
	 * 下载导入用户信息数据模板
	 */
	@RequiresPermissions("test:sudaoUser:import")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "用户信息数据导入模板.xlsx";
    		List<SudaoUser> list = Lists.newArrayList(); 
    		new ExportExcel("用户信息数据", SudaoUser.class, 1).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/test/sudaoUser/?repage";
    }
	

}
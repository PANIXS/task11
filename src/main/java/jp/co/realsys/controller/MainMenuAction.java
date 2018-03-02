/*******************************************************************************
 *  �V�X�e���� : �w�����Ǘ�
 *  ���쌠    : Copyright (C)�@2002-2008�@Realsys Co. Ltd. �@All Rights Reserved.
 *  ��Ж�    : ���A���V�X�������
 *  ****************************************************************************
 *  �ύX����
 *  2008/03/20  �쐬�@
 */
package jp.co.realsys.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * �������j���[�A�N�V�����N���X
 * 
 * @author Realsys
 */
@Controller
@RequestMapping("menu")
public class MainMenuAction extends BaseAction {


	@RequestMapping(value="",method=RequestMethod.GET)
	public String executeAction(@RequestParam(value="actionType",required=false,defaultValue="") String actionType) throws Exception {
		
		String forward = "menu";
		
		if(StringUtils.isNotBlank(actionType)){
			if ("register".equals(actionType)) {
				forward = "redirect:register";
			} else if ("query".equals(actionType)) {
				forward = "redirect:query";
			} else if ("delete".equals(actionType)) {
				forward = "redirect:delete";
			} else if ("update".equals(actionType)) {
				forward = "redirect:update";
			}
		}
		
		return forward;
	}

}

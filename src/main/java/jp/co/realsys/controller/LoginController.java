package jp.co.realsys.controller;

import javax.servlet.http.HttpSession;

import jp.co.realsys.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.co.realsys.error.TaskException;
import jp.co.realsys.service.UsersInfoService;

/*@Controller*/
public class LoginController {

	@Autowired
	private UsersInfoService userInfoService;

	@ModelAttribute
	public User setUser() {
		User form = new User();
		return form;
	}
	
	/*@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@RequestMapping("menu")
	public String menu(HttpSession session) {
		if (session.getAttribute("userId") != null) {
			return "menu";
		} else {
			return "redirect:login";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() throws Exception {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute User userModel,
			BindingResult result, Model model, HttpSession session)
			throws Exception {

		try {

			if (result.hasErrors()) {
				return "login";
			}

			// ���[�U�L�����`�F�b�N
			if (!userInfoService.doCheckUser(userModel)) {
				result.reject("E002");
				return "login";
			} else {
				// ���O�C�������A���[�U����Session�ɕۑ�����
				session.setAttribute("userId", userModel.getUserid());
				return "redirect:menu";
			}

		} catch (TaskException e) {
			throw e;
		}

	}*/
}

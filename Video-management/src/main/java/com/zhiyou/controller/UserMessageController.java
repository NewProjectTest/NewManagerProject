package com.zhiyou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.model.User;
import com.zhiyou.service.UserService;
import com.zhiyou.uitl.FTPUtil;
import com.zhiyou.uitl.MD5Util;

@Controller
public class UserMessageController {

	@Autowired
	UserService service;

	@RequestMapping(value = "UpdateUserPasswordShow")
	public String UpdateUserPasswordShow(HttpServletRequest req, HttpServletResponse resp) {
		return "frontDesk/XiuGaiMiMa";
	}

	@ResponseBody
	@RequestMapping(value = "yanZheng")
	public String yanZheng(HttpServletRequest req, HttpServletResponse resp) {
		User user = (User) req.getSession().getAttribute("list");
		String oldPassword = MD5Util.getMD5String(req.getParameter("oldPassword"));
		if (user.getPassword().equals(oldPassword)) {
			return "success";
		} else {
			return "false";
		}

	}

	@RequestMapping(value = "UpdateUserPassword")
	public String UpdateUserPassword(String password, HttpServletRequest req, HttpServletResponse resp) {
		User user = (User) req.getSession().getAttribute("list");
		user.setPassword(MD5Util.getMD5String(password));
		req.setAttribute("list", user);
		service.update(user);
		return "frontDesk/GeRenZhongXinZhanShi";
	}

	@RequestMapping("UpdateUserPhotoShow")
	public String UpdateUserPhotoShow(HttpServletRequest req, HttpServletResponse resp) {
		return "frontDesk/XiuGaiTouXiang";
	}

	@RequestMapping(value = "UpdateUserPhoto", method = RequestMethod.POST)
	public String upload2(MultipartFile image_file, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String string = FTPUtil.upload(image_file.getInputStream(), image_file.getOriginalFilename());
		User user = (User) req.getSession().getAttribute("list");
		user.setImgurl(string);
		req.setAttribute("list", user);
		service.update(user);
		return "frontDesk/GeRenZhongXinZhanShi";
	}

	@RequestMapping(value = "soloshow")
	public String soloshow(HttpServletRequest req, HttpServletResponse resp) {
		User User = (User) req.getSession().getAttribute("list");
		req.setAttribute("list", User);
		return "frontDesk/GeRenZhongXinZhanShi";
	}

	@RequestMapping(value = "UpdateUserPage")
	public String UpdateUserPage(HttpServletRequest req, HttpServletResponse resp) {
		User User = (User) req.getSession().getAttribute("list");
		req.setAttribute("list", User);
		return "frontDesk/GeRenZhongXinXiuGai";
	}

	@RequestMapping(value = "UpdateUser")
	public String UpdateUser(User user, String address, HttpServletRequest req, HttpServletResponse resp) {
		service.update(user);
		req.setAttribute("list", user);
		return "frontDesk/GeRenZhongXinZhanShi";
	}

	@RequestMapping(value = "HomePageShow")
	public String HomePageShow(HttpServletRequest req, HttpServletResponse resp) {
		User User = (User) req.getSession().getAttribute("list");
		req.setAttribute("list", User);
		return "frontDesk/ShouYe";
	}

	@RequestMapping(value = "ExitHomePageShow")
	public String ExitHomePageShow(HttpServletRequest req, HttpServletResponse resp) {
		return "frontDesk/ShouYe";
	}

}

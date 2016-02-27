package com.cqlj.changyan;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONArray;


@Controller
@RequestMapping("/cy")
public class TestController {
	// 该接口只有当畅言已登录，getUserInfo返回未登录时，才会被调用用来登录自身网站
	@RequestMapping(value="login")
	public void loginByCy(@RequestParam(value = "callback") String callback,
			@RequestParam(value = "user_id") String user_id, @RequestParam(value = "nickname") String nickname,
			@RequestParam(value = "sign") String sign, @RequestParam(value = "img_url") String img_url,
			@RequestParam(value = "profile_url") String profile_url, HttpServletResponse resp) throws IOException {
		System.out.println("xxxxxxxxxxxxxxxx1111111111111");
		// 自己网站的登录逻辑，记录登录信息到cookie
		user_id = "123455";
		nickname = "chen29011";
		img_url = "http://i13.tietuku.com/e5ca267b810d722b.png";
		profile_url = "";
		sign = "";
		Cookie cookie = new Cookie("user_id", user_id);
		Cookie cookie2 = new Cookie("nickname", nickname);
		Cookie cookie3 = new Cookie("img_url", img_url);
		Cookie cookie4 = new Cookie("profile_url", profile_url);
		Cookie cookie5 = new Cookie("sign", sign);
		resp.addCookie(cookie);
		resp.addCookie(cookie2);
		resp.addCookie(cookie3);
		resp.addCookie(cookie4);
		resp.addCookie(cookie5);
		resp.getWriter().write(callback + "({\"user_id\":" + user_id + ",reload_page:0})");
	}

	@RequestMapping("loginout")
	public void loginBySite(@RequestParam(value = "callback") String callback, HttpServletResponse resp) throws IOException {
		// 清除自己网站cookies信息,同时前端logout.js代码用来清理畅言cookie
		resp.getWriter().write(callback + "({\"code\":\"1\",reload_page:0, js-src:logout.js})");
	}

	// 该接口在页面每一次加载时都会被调用，用来判断用户在自己网站是否登录
	@RequestMapping("getUserInfo")
	public void getUserInfo(@RequestParam(value = "callback") String callback, HttpServletRequest res,
			HttpServletResponse resp) throws IOException {
		UserInfo userinfo = new UserInfo();
		Cookie[] cookies = res.getCookies();
		if (!isContains("user_id", cookies)) {// 此处为模拟逻辑，具体实现可以变化
			userinfo.setIs_login(0);// 用户未登录
		} else {
			userinfo.setIs_login(1);// 用户已登录
			User user = new User();
			user.setUser_id((Integer)getCookieValue("user_id",cookies)); //该值具体根据自己用户系统设定
			user.setNickname(getCookieValue("nickname",cookies).toString()); //该值具体根据自己用户系统设定
            user.setImg_url(getCookieValue("img_url",cookies).toString()); //该值具体根据自己用户系统设定，可以为空
            user.setProfile_url(getCookieValue("profile_url",cookies).toString());//该值具体根据自己用户系统设定，可以为空
            user.setSign(getCookieValue("sign",cookies).toString()); 
			userinfo.setUser(user);
		}
		resp.setContentType("application/x-javascript");// 指定传输格式为js
		resp.getWriter().write(callback + "(" + JSONArray.toJSONString(userinfo) + ")");// 拼接成jsonp格式
	}

	// 该方法判断cookie中是否存在键值为key的value值
	public boolean isContains(String key, Cookie[] cookies) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(key)) {
				if (cookie.getValue() != null) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	// 该方法获取cookie中键值为key的value值
	public Object getCookieValue(String key, Cookie[] cookies) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(key))
				return cookie.getValue();
		}
		return null;
	}
}

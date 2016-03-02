package com.cqlj.user.cy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONArray;

@Controller
@RequestMapping("/cy")
public class TestController {
	@RequestMapping(value="myLogin")
	public void myLogin(@RequestParam(value = "user_id") String user_id,
			@RequestParam(value = "password") String password, HttpServletRequest res,HttpServletResponse resp) throws IOException, ServletException{
		System.out.println("用户名是:"+user_id+",密码是:"+password);
		String nickname = "chen29011";
		String img_url = "http://i13.tietuku.com/e5ca267b810d722b.png";
		String profile_url = "http://www.chenqiong.net/my/index.html";
		String sign = "";
		/*User user = new User();
		user.setUser_id(Integer.parseInt(user_id));
		user.setNickname(nickname);
		user.setImg_url(img_url);
		user.setProfile_url(profile_url);
		user.setSign(sign);
		HttpSession session = res.getSession();
		session.setAttribute("user", user);
		User user2 = (User)session.getAttribute("user");*/
		Cookie cookie_user_id = new Cookie("user_id", user_id);
		resp.addCookie(cookie_user_id);
		//System.out.println(user2.getUser_id());
		res.getRequestDispatcher("../topic.jsp").forward(res, resp);
	}
	
	// 该接口只有当畅言已登录，getUserInfo返回未登录时，才会被调用用来登录自身网站
	@RequestMapping(value = "login")
	public void loginByCy(@RequestParam(value = "callback") String callback,HttpServletRequest res,HttpServletResponse resp) throws IOException {
		// 自己网站的登录逻辑，记录登录信息到Session中
		HttpSession session = res.getSession();
		User user = (User)session.getAttribute("user");
		int user_id = user.getUser_id();
		resp.getWriter().write(callback + "({\"user_id\":" + user_id + ",reload_page:0})");
	}
	@RequestMapping("loginout")
	public void loginBySite(@RequestParam(value = "callback") String callback, HttpServletResponse resp)
			throws IOException {
		// 清除自己网站cookies信息,同时前端logout.js代码用来清理畅言cookie
		resp.getWriter().write(callback + "({\"code\":\"1\",reload_page:0, js-src:logout.js})");
	}

	// 该接口在页面每一次加载时都会被调用，用来判断用户在自己网站是否登录
	@RequestMapping("getUserInfo")
	public void getUserInfo(@RequestParam(value = "callback") String callback, HttpServletRequest res,
			HttpServletResponse resp) throws IOException {
		UserInfo userinfo = new UserInfo();
		Cookie[] cookies = res.getCookies();
        if(!isContains("user_id", cookies)){//此处为模拟逻辑，具体实现可以变化
            userinfo.setIs_login(0);//用户未登录
        }else{
            userinfo.setIs_login(1);//用户已登录
            User user = new User();
            user.setUser_id((Integer)getCookieValue("user_id",cookies)); //该值具体根据自己用户系统设定
            String nickname = "chen29011";
    		String img_url = "http://i13.tietuku.com/e5ca267b810d722b.png";
    		String profile_url = "http://www.chenqiong.net/my/index.html";
    		String sign = "";
    		user.setNickname(nickname);
    		user.setImg_url(img_url);
    		user.setProfile_url(profile_url);
    		user.setSign(sign);
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

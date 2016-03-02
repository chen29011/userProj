package com.cqlj.user.cy;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cyd")
public class UserLogin {
	@RequestMapping(value="login")
	public void userLogin(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("hahahahha");
		String user_id = "123455";
		String nickname = "chen29011";
		String img_url = "http://i13.tietuku.com/e5ca267b810d722b.png";
		String profile_url = "";
		String sign = "";
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
		Cookie[] cookies = req.getCookies();
		for(Cookie cookieChild : cookies){
			System.out.println(cookieChild.getName());// get the cookie name
			System.out.println(cookieChild.getValue()); // get the cookie value
		}
	}
}

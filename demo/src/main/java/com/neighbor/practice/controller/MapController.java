package com.neighbor.practice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/map")
public class MapController {
	
	@GetMapping(value = "/kakao")
	public String kakaoViewController(HttpServletRequest req) {
		String view = "map/kakao";
		 String ip2 = req.getHeader("HTTP_CLIENT_IP");
	        if (ip2 == null) {
	        	ip2 = req.getRemoteAddr();
	        	System.out.println("Proxy ip > " + ip2);
	        }
		return view;
	}
	
	@GetMapping(value = "/test")
	public String testController() {
		System.out.println("컨트롤러 왔다!!");
		String view = "map/kakao";
		return view;
	}
}

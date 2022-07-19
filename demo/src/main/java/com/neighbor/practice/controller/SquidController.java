package com.neighbor.practice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neighbor.practice.domain.VmsDto;
import com.neighbor.practice.service.ChatService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/squid")
@Log4j2
public class SquidController {

	@Autowired
	private ChatService service;
	
	//채팅방 목록 조회
    @GetMapping(value = "/test")
    public ModelAndView rooms(ModelAndView mv, HttpServletRequest req){
        List<VmsDto> result = service.roomListService();
       
        System.out.println("스퀴드 컨트롤러");
        
        String ip2 = req.getHeader("HTTP_CLIENT_IP");
        if (ip2 == null) {
        	ip2 = req.getRemoteAddr();
        	System.out.println("Proxy ip > " + ip2);
        }
        
        mv.setViewName("squid/squid");
        mv.addObject("list", result);
        return mv;
    }
    
    @GetMapping(value = "/testImg")
    public String roomImage(ModelAndView mv, HttpServletRequest req){
        //List<VmsDto> result = service.roomListService();
       
        /*System.out.println("스퀴드 컨트롤러");
        
        String ip2 = req.getHeader("HTTP_CLIENT_IP");
        if (ip2 == null) {
        	ip2 = req.getRemoteAddr();
        	System.out.println("Proxy ip > " + ip2);
        }*/
        
        //mv.setViewName("squid/squidtest.html");
        //mv.addObject("list", result);
        //return mv;
        return "squidtest.html";
    }
}
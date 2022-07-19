package com.neighbor.practice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neighbor.practice.domain.VmsDto;
import com.neighbor.practice.service.ChatService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/chat")
@Log4j2
public class RoomController {

	@Autowired
	private ChatService service;
	
	@GetMapping(value ="/test")
	public void testController() {
		System.out.println("컨트롤러!!!!");
		
		service.testService();
	}
	//채팅방 목록 조회
    @GetMapping(value = "/list")
    public ModelAndView rooms(ModelAndView mv, HttpServletRequest req){
        List<VmsDto> result = service.roomListService();
        /*for(VmsDto t : result) {
        	System.out.println(t.toString());
        }*/
        System.out.println("챗리스크 컨트롤러");
        
        
        String ip2 = req.getHeader("HTTP_CLIENT_IP");
        if (ip2 == null) {
        	ip2 = req.getRemoteAddr();
        	System.out.println("Proxy ip > " + ip2);
        }
        
        mv.setViewName("chat/list");
        mv.addObject("list", result);
        return mv;
    }
    
    @GetMapping(value = "/enter/{vmsId}/{userName}")
    public ModelAndView enter(ModelAndView mv, @PathVariable String vmsId, @PathVariable String userName) {
    	mv.setViewName("chat/controlVms");
    	mv.addObject("vmsId", vmsId);
    	mv.addObject("userName", userName);
    	return mv;
    }
    
    /*@GetMapping(value = "/ajaxtest")
    @ResponseBody
    public String ajaxTest() {
    	
    	String response = "hello";
    	return response;
    }
    */
}

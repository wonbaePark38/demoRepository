package com.neighbor.practice.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neighbor.practice.domain.Header;

@RestController
@RequestMapping(value = "/api")
public class ProcessController {
	private final static String SERVICE_KEY = "";
	
	@RequestMapping("/test")
	public String startProcess() {
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6260000/BusanWaterImrsnInfoService/getWaterImrsnInfo"); /*URL*/
        String result = "";
		try {
        	
            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=yp8pc4ukJ5YHTwJlP%2BU5HoJOp%2FGBX1UL7pREhlx7YraRhqOTwXLMjxq%2BaIAh5LmihXTbAifn7ymCPfrZVDW2CQ%3D%3D"); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
            urlBuilder.append("&" + URLEncoder.encode("resultType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*JSON방식으로 호출 시 파라미터 resultType=json 입력*/
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*Service Key*/
        URL url;
		try {
			url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        result = sb.toString();
	       
	        JSONParser paser = new JSONParser();
	        JSONObject obj = (JSONObject) paser.parse(result);
	        
	        JSONObject level1 = (JSONObject) obj.get("getWaterImrsnInfo");
	        JSONObject header = (JSONObject) level1.get("header");
	        JSONArray itemList = (JSONArray) level1.get("item");
	        
	        long numOfRowsLong = (long) level1.get("numOfRows");
	        int numOfRows = Long.valueOf(numOfRowsLong).intValue();
	        
	        long pageNoLong = (long) level1.get("pageNo");
	        int pageNo = Long.valueOf(pageNoLong).intValue();
	        
	        long totalCountLong = (long) level1.get("totalCount");
	        int totalCount = Long.valueOf(totalCountLong).intValue();
	        
	        for(int i=0; i<itemList.size(); i++) {
	        	JSONObject item = (JSONObject) itemList.get(i);
	        	System.out.println(item.toString());
	        }
	        
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return result;
	}
}

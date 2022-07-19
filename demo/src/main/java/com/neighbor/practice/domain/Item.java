package com.neighbor.practice.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Item {
	private String siteCode;
	private String siteName;
	private String alertLevel3;
    private String alertLevel3Nm;
    private String alertLevel4;
    private String alertLevel4Nm;
    private String fludLevel;
    private String obsrTime;
    private String sttus;
    private String sttusNm;
}

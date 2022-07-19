package com.neighbor.practice.domain;

import java.io.Serializable;

import lombok.Data;

//@Data
public class PkClass implements Serializable{
	private int seq;
	private String title;
	private String writer;
	private String content;
}

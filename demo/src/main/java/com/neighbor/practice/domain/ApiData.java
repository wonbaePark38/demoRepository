package com.neighbor.practice.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApiData {
	private Header header;
	private List<Item> items;
	private int numOfRows;
	private int pageNo;
	private int totalCount;
}

package com.neighbor.practice.controller;

import org.springframework.stereotype.Controller;

@Controller
public class JpaBoardController {
	
	/*@Autowired
	private JpaBoardServiceImpl jpaCoardService;
	*/
	/*@GetMapping("/hello")
	public String hello(String name) {
		return "Hello : " + name;
	}
	
	@GetMapping("/getBoard")
	public BoardEntity getBoard() {
		BoardEntity board = new BoardEntity();
		board.setSeq(1);
		board.setTitle("테스트 제목");
		board.setWriter("내용");
		return board;
	}
	
	@GetMapping("/getBoardList")
	public List<BoardEntity> getBoardList(){
		List<BoardEntity> boardList = new ArrayList<BoardEntity>();
		for(int i=1; i<=10; i++) {
			BoardEntity board = new BoardEntity();
			board.setSeq(i);
			board.setTitle("제목 > " + i);
			board.setWriter("테스트");
			boardList.add(board);
		}
		
		return boardList;
	}
	
	@GetMapping("/devTest")
	public String devTest() {
		return "hi";
	}
	*/
	
}

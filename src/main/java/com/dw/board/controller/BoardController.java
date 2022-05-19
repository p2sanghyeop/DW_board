package com.dw.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dw.board.service.BoardService;
import com.dw.board.vo.BoardVO;

@RestController
@RequestMapping("/api/v1")
public class BoardController {
	@Autowired
	private BoardService boardservice;
	//저장
	@PostMapping("/board")
	public int callSaveBoard(@RequestBody BoardVO vo) {
		return boardservice.insertBoard(vo);
	}
	//조회
	@GetMapping("/board/all")
		public List<BoardVO> callBoardList(){
			return boardservice.selectAllList();
		}
	
}

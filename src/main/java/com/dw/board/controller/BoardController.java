package com.dw.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	//저장(C)
	@CrossOrigin
	@PostMapping("/board")
	public int callSaveBoard(@RequestBody BoardVO vo) {
		return boardservice.insertBoard(vo);
	}
	//조회(R)
	@CrossOrigin
	@GetMapping("/board/all")
		public List<Map<String, Object>> callBoardList(){
			return boardservice.selectAllList();
		}
	//게시판 삭제(D)
	@CrossOrigin
	@DeleteMapping("/board/boardid/{id}")
	public int callRemoveBoard(@PathVariable("id")int boardId) {
		return boardservice.deleteBoardList(boardId);
	}
	//게시판 수정(U)
	@CrossOrigin
	@PatchMapping("/board/boardid/{id}")
	public int callUpdateBoard(@PathVariable("id")int boardId, @RequestBody BoardVO vo) {
		return boardservice.updateBoardList(vo, boardId);
	}
	//게시판 상세보기(R)
	@CrossOrigin
	@GetMapping("/board/boardid/{id}")
	public BoardVO callBoard(@PathVariable("id")int boardId) {
		return boardservice.readBoard(boardId);
	}
}

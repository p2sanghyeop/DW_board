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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dw.board.service.BoardService;
import com.dw.board.vo.BoardVO;
import com.github.pagehelper.PageInfo;

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
	//리턴타입 List<Map<String, Object>>에서 pageinfo<map<stirng,object>>
		public PageInfo<Map<String, Object>> callBoardList(@RequestParam("pageNum")int pageNum, 
				@RequestParam("pageSize")int pageSize ){
		List<Map<String, Object>> list = boardservice.selectAllList(pageNum, pageSize);
			return new PageInfo<Map<String, Object>>(list);
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
	//게시물 카운트
	@CrossOrigin
	@PatchMapping("/board/views/boardid/{id}")
	public int callBoardView(@PathVariable("id")int boardId) {
		System.out.println(boardId);
		return boardservice.getUpdateBoardViews(boardId);
	}
	//쿼리스트링으로 검색한 작성한 작성자 게시판 리스트 조회
	@CrossOrigin
	@GetMapping("/board/search")
	public PageInfo<Map<String, Object>> callBoardSearch(@RequestParam("writer")String writer,@RequestParam("pageNum")int pageNum, 
			@RequestParam("pageSize")int pageSize){
		List<Map<String, Object>> list = boardservice.getSearchBoard(writer, pageNum, pageSize);
//		return boardservice.getSearchBoard(writer);
		return new PageInfo<Map<String, Object>>(list);
	}
	//통계조회
	@CrossOrigin
	@GetMapping("/board/startlist")
	public Map<String, Object> callBoardStartList(){
		return boardservice.getBoardStartList();
	}
	
}

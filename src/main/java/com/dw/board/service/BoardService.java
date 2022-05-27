package com.dw.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.dw.board.mapper.BoardMapper;
import com.dw.board.vo.BoardVO;

@Service
public class BoardService {
	//저장
	@Autowired
	private BoardMapper boardmapper;
	
	@Transactional(rollbackFor = {Exception.class})
	public int insertBoard(BoardVO vo) {
		return boardmapper.insertBoard(vo);
	}
	
	public List<Map<String, Object>> selectAllList(){
		return boardmapper.selecrAllBoard();
	}
	@Transactional(rollbackFor = {Exception.class})
	public int deleteBoardList(int boardId) {
		return boardmapper.deleteBoard(boardId);
	}
	@Transactional(rollbackFor = {Exception.class})
	public int updateBoardList(BoardVO vo, int boardId) {
		vo.setBoardId(boardId);
		return boardmapper.updateBoard(vo);
	}
	public BoardVO readBoard( int boardId) {		
		return boardmapper.read(boardId);
	}
	
	//게시물 조회수 증가
	public int getUpdateBoardViews(int boardId) {
		//1. 게시판 번호를 이용해서 조회수 컬럼을 select
		BoardVO vo =boardmapper.selectBoardOne(boardId);
		int views = vo.getCnt();
		++views; //조회수 1증가함
		vo.setCnt(views);
		vo.setBoardId(boardId);
		//update
		return boardmapper.updateBoardCnt(vo);
	}
	public List<Map<String, Object>> getSearchBoard(String studetnsName){
		return boardmapper.selecrSearchBoardList(studetnsName);
	}
}

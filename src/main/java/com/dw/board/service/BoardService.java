package com.dw.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dw.board.mapper.BoardMapper;
import com.dw.board.vo.BoardVO;
import com.github.pagehelper.PageHelper;

@Service
public class BoardService {
	//저장
	@Autowired
	private BoardMapper boardmapper;
	
	@Transactional(rollbackFor = {Exception.class})
	public int insertBoard(BoardVO vo) {
		return boardmapper.insertBoard(vo);
	}
	//게시판전체조회
	//pageNum:현재페이지
	//PageSize:한페이지에 게시물 몇개 보여줄지
	public List<Map<String, Object>> selectAllList(int pageNum, int pageSize){
		PageHelper.startPage(pageNum, pageSize);
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
	//작성자가 작성한 게시물 조회
	public List<Map<String, Object>> getSearchBoard(String studetnsName){
		return boardmapper.selecrSearchBoardList(studetnsName);
	}
	
	//학생수, 게시글수, 작성자수, 총조회수 조회
	public Map<String, Object> getBoardStartList(){
		return boardmapper.selectBoardStartList();
	}
}

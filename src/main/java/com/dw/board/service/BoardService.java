package com.dw.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.board.mapper.BoardMapper;
import com.dw.board.vo.BoardVO;

@Service
public class BoardService {
	//저장
	@Autowired
	private BoardMapper boardmapper;
	
	public int insertBoard(BoardVO vo) {
		return boardmapper.insertBoard(vo);
	}
	
	public List<BoardVO> selectAllList(){
		return boardmapper.selecrAllBoard();
	}
}

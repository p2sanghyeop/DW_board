package com.dw.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

import com.dw.board.vo.BoardVO;

@Mapper
public interface BoardMapper {
	//저장
	public int insertBoard(BoardVO vo);
	//조회
	public List<Map<String, Object>> selecrAllBoard();
	//삭제
	public int deleteBoard(@PathVariable("id")int boardId);
	//수정
	public int updateBoard(BoardVO vo);
	//상세보기
	public BoardVO read(int boardId);
	
	public BoardVO selectBoardOne(int boardId);
	
	public int updateBoardCnt(BoardVO vo);
	
	public List<Map<String, Object>> selecrSearchBoardList(String studentsName);
	
	public Map<String, Object> selectBoardStartList();
}

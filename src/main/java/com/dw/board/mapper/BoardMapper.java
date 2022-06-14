package com.dw.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
	//게시글 조회수 카운트
	public BoardVO selectBoardOne(int boardId);
	//게시글 조회수 카운트
	public int updateBoardCnt(BoardVO vo);
	//작성자가 게시한 게시물 조회
	public List<Map<String, Object>> selecrSearchBoardList(String studentsName);
	//게시글수,학생수, 총조회수 조회
	public Map<String, Object> selectBoardStartList();
	
	public  int SelectAllBoardTotal();
	
	public List<Map<String, Object>> selecrSearchBoardListTest(@Param("pageNum")int pageNum,
			@Param("pageSize")int pageSize);
}

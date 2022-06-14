package com.dw.board;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dw.board.mapper.BoardMapper;
import com.dw.board.service.StudentsService;
import com.dw.board.util.PageHandler;

@SpringBootTest
class BoardApplicationTests {

	@Autowired
	private BoardMapper boardmapper;
	
	@Autowired
	private PageHandler pageHandler;
	
	@Test
	void contextLoads() {
		System.out.println("hello word");
		
		int total = boardmapper.SelectAllBoardTotal() ;
		System.out.println("total=>"+total);
		int pageNum = 1;
		int pageSize = 10;
		int navigatePages = 5;
		
		pageHandler.setTotal(total);
		pageHandler.setPageNum(pageNum);
		pageHandler.setPageSize(pageSize);
		pageHandler.setNavigatePage(navigatePages);
		
		pageHandler.setNowBlock(pageNum);
		int nowBlock = pageHandler.getNowBlock();//현재블록
		System.out.println("현재블록=>"+nowBlock);
		
		pageHandler.setLastBlock(total);
		int lastBlock = pageHandler.getLastBlock();
		System.out.println("마지막블록=>"+lastBlock);
		
		pageHandler.setStartPage(nowBlock);
		int startPage = pageHandler.getStartPage();
		System.out.println("현재페이지=>"+startPage);
		
		int pages = pageHandler.calcPage(total, pageSize);
		pageHandler.setEndPage(nowBlock, pages);
		int lastPage = pageHandler.getEndPage();
		System.out.println("마지막페이지=>"+lastPage);
		
		pageHandler.setPreNext(pageNum);
		boolean hasPreviousPage = pageHandler.isHasPreviousPage();
		boolean hasNextPage = pageHandler.isHasNextPage();
		System.out.println("이전버튼=>"+hasPreviousPage);
		System.out.println("다음버튼=>"+hasNextPage);
		
		int limitStart = (pageNum-1)*pageSize;
		List<Map<String, Object>> list = boardmapper.selecrSearchBoardListTest(limitStart ,pageSize);
		
		for(Map<String, Object> param : list) {
			String studentsName = (String) param.get("studentsName");
			System.out.println(studentsName);
		}
	}

}

package com.dw.board.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dw.board.service.BoardService;
import com.github.pagehelper.PageInfo;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardservice;
	
	@GetMapping("/")
	public String callHelloWorld() {
		return "HelloWorld";
	}
	
	@GetMapping("/board")
	public String callBoardPage(ModelMap map, @RequestParam("pageNum")int pageNum, 
			@RequestParam("pageSize")int pageSize, HttpSession session) {
		List<Map<String, Object>> list = boardservice.selectAllList(pageNum, pageSize);
		PageInfo<Map<String, Object>> pageinfo = new PageInfo<Map<String, Object>>(list);
		map.addAttribute("pageHelper", pageinfo);
		
//		int x= (int) session.getAttribute("X");
		
		//학생 아이디 받아오기
		int studentsId = (int)session.getAttribute("studentsId");
		map.addAttribute("studentsId", studentsId);
		
		return "board";
	}
	
	@GetMapping("/board/search")
	public String callBoardSearchPage(ModelMap map, @RequestParam("writer")String writer,
			@RequestParam("pageNum")int pageNum, 
			@RequestParam("pageSize")int pageSize, HttpSession session) {
		List<Map<String, Object>> list = boardservice.getSearchBoard(writer, pageNum, pageSize);
		PageInfo<Map<String, Object>> pageinfo = new PageInfo<Map<String, Object>>(list);
		map.addAttribute("pageHelper", pageinfo);
		
		//학생 아이디 받아오기
		int studentsId = (int)session.getAttribute("studentsId");
		map.addAttribute("studentsId", studentsId);
		
		return "board";
	}
}

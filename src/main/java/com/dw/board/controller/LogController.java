package com.dw.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dw.board.service.LogService;
import com.github.pagehelper.PageInfo;


@Controller
public class LogController {
	
	@Autowired
	private LogService logservice;
	
	@GetMapping("/logs")
	public String loadLogsPage(ModelMap map, @RequestParam("pageNum")int pageNum, 
			@RequestParam("pageSize")int pageSize) {
		List<Map<String, Object>> list = logservice.getLogsList(pageNum, pageSize);
		PageInfo<Map<String, Object>> pageinfo = new PageInfo<Map<String, Object>>(list);
		map.addAttribute("pageHelper", pageinfo);
		return "logs";
	}
}

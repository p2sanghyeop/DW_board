package com.dw.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dw.board.service.LogService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/api/v1")
public class LogRestController {
	
	@Autowired
	private LogService logservice;
	
	@CrossOrigin
	@GetMapping("/logs")
	public PageInfo<Map<String, Object>> getlogsList(@RequestParam("pageNum")int pageNum, 
			@RequestParam("pageSize")int pageSize){
		List<Map<String, Object>> list = logservice.getLogsList(pageNum, pageSize);
		return new PageInfo<Map<String, Object>>(list);
	}
	@CrossOrigin
	@GetMapping("/logs/logid/{logid}")
	public Map<String, Object> callLogs(@PathVariable("logid") int logid){
		return logservice.getLogs(logid);
	}
}

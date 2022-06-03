package com.dw.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.board.mapper.LogMapper;
import com.dw.board.vo.LogVO;
import com.github.pagehelper.PageHelper;

@Service
public class LogService {
	
	@Autowired 
	private LogMapper logmapper;
	
	public int setLog(LogVO vo) {
		return logmapper.insertLog(vo);
	}
	
	public List<Map<String, Object>> getLogsList(int pageNum, int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		return logmapper.selectBoardLog(0);
	}
	
	public Map<String, Object> getLogs(int logId){
		List<Map<String, Object>> list = logmapper.selectBoardLog(logId);
		return list.get(0);
	}
}

package com.dw.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dw.board.vo.LogVO;
//log 같은 기록데이터는 insert와 select만 구현한다
@Mapper
public interface LogMapper {
	public int insertLog(LogVO logvo);//접속이력 저장
	
	public List<Map<String, Object>> selectBoardLog(int logId);//이력 불러오기
}

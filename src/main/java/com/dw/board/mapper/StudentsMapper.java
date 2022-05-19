package com.dw.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dw.board.vo.StudentsVO;

@Mapper
public interface StudentsMapper {
	
	
	/**
	 * @param : vo
	 * @return : int
	 * @author : sanghyeop
	 * @date : 2022.05.18
	 * comment : 학생 추가
	 */
	public int insertStudents(StudentsVO vo);
	
	/**
	 * @return : List
	 * @author : sanghyeop
	 * @date : 2022.05.18
	 * comment : 전체 학생 조회 
	 */
	public List<StudentsVO> selectAllStudentsList();
	
	/**
	 * @return : List
	 * @author : sanghyeop
	 * @date : 2022.05.18
	 * comment : 학생 map 조회 
	 */
	public List<Map<String, Object>> selectAllStudentsListMap();
	
	/**
	 * @param : studentsId
	 * @return : StudentsVO
	 * @author : sanghyeop
	 * @date : 2022.05.18
	 * comment : 특정 학생 조회 
	 */
	public StudentsVO selectStudents(int studentsId);

	/**
	 * @param : studentsId
	 * @return : int
	 * @author : sanghyeop
	 * @date : 2022.05.18
	 * comment : 삭제
	 */
	public int deleteStudents(int studentsId);
	
	/**
	 * @param : vo
	 * @return : int
	 * @author : sanghyeop
	 * @date : 2022.05.18
	 * comment : 업데이트
	 */
	public int updateStudents(StudentsVO vo);
	
	/**
	 * @param vo
	 * @return : vo
	 * @author : sanghyeop
	 * @date : 2022.05.18
	 * comment : 추가
	 */
	public StudentsVO selectStudentsOne(StudentsVO vo);
}

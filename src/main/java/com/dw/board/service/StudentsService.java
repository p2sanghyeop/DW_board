package com.dw.board.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dw.board.mapper.StudentsMapper;
import com.dw.board.vo.StudentsVO;
import com.github.pagehelper.PageHelper;

@Service
public class StudentsService {
	@Autowired
	private StudentsMapper studentsmapper;
	@Autowired
	private PasswordEncoder passwordencoder;
	//학생 저장
	public int setStudents(StudentsVO vo) {
		//학생 비밀번호 암호화
		String password = vo.getStudentsPassword();
		password = passwordencoder.encode(password);
		vo.setStudentsPassword(password);
		return studentsmapper.insertStudents(vo);
	}
	//학생전체조회
	public List<StudentsVO> getAllStudentsList(){
		return studentsmapper.selectAllStudentsList();
	}
	//학생조회 map
	public List<Map<String, Object>> getAllStudentsListMap(int pageNum, int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		return studentsmapper.selectAllStudentsListMap();
	}
	//특정학생 조회
	public StudentsVO getStudentsFind(int studentsId) {
		return studentsmapper.selectStudents(studentsId);
	}
	//삭제
	@Transactional(rollbackFor = {Exception.class})
	public int deleteStudents(int studentsId) {
		return studentsmapper.deleteStudents(studentsId);
	}
	//업데이트
	@Transactional(rollbackFor = {Exception.class})
	public int getUpdateStudents(StudentsVO vo, int studentsId) {
		vo.setStudentsId(studentsId);
		return studentsmapper.updateStudents(vo);
	}
	//가입된 학생인지 아닌지 여부 체크
	public boolean isStudents(StudentsVO vo) {
		StudentsVO students = studentsmapper.selectStudentsOne(vo);
		if(students == null) {//쿼리결과가 null로 리턴
			return false;
		}
		String inputPassword = vo.getStudentsPassword();
		String password = students.getStudentsPassword();
		if(!passwordencoder.matches(inputPassword, password)) {//비밀번호체크
			return false;
		}
		return true;
	}
	//작성자가 작성한 게시물 조회
	public List<Map<String, Object>> getSearchStudents(String studetnsName){
		return studentsmapper.selecrSearchstudetnslist(studetnsName);
	}
}

package com.dw.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dw.board.service.StudentsService;
import com.dw.board.vo.StudentsVO;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/api/v1")//중복되는 url 간소화
public class StudentsRestController {
	@Autowired
	private StudentsService studentsservice;
	//학생추가
	@CrossOrigin
	@PostMapping("/students")
	public int callStudents(@RequestBody StudentsVO vo) {
		return studentsservice.setStudents(vo);
	}
	
	//중요한 정보를 서버에 전송할때 post 사용
	@CrossOrigin
	@PostMapping("/login")
	public boolean callIsLogin(@RequestBody StudentsVO vo, HttpSession httpsession) {
		boolean isLogin = studentsservice.isStudents(vo, httpsession);
		return isLogin;
	}
	//학생조회
	@GetMapping("/students")
	public List<StudentsVO> callStudentsList(){
		return studentsservice.getAllStudentsList();
	}
	//map으로 조회
	@CrossOrigin
	@GetMapping("/students/map")
	public PageInfo<Map<String, Object>> callStudentsListByMap(@RequestParam("pageNum")int pageNum, 
			@RequestParam("pageSize")int pageSize){
		//세션 데이터 가져오기 (추후 로직 구현 예정)
//		String name = (String)httpSession.getAttribute("name");
//		System.out.println("====>"+name);
		List<Map<String, Object>> list = studentsservice.getAllStudentsListMap(pageNum, pageSize);
		return new PageInfo<Map<String, Object>>(list);
//		return studentsservice.getAllStudentsListMap();
	}
	//학생 검색
	@CrossOrigin
	@GetMapping("/students/search")
	public PageInfo<Map<String, Object>> callStudentsSearch(@RequestParam("studentsName")String studentsName,@RequestParam("pageNum")int pageNum, 
			@RequestParam("pageSize")int pageSize){
		List<Map<String, Object>> list = studentsservice.getSearchStudents(studentsName,pageNum, pageSize); 
//		return studentsservice.getSearchStudents(studentsName);
		return new PageInfo<Map<String, Object>>(list);
	}
	
	//특정학생조회(PK로 조회예정)
	@CrossOrigin
	@GetMapping("/students/id/number/{id}")
	public StudentsVO callStudents(@PathVariable("id")int studentsId) {
		return studentsservice.getStudentsFind(studentsId);
	}
	//삭제
	@CrossOrigin
	@DeleteMapping("/students/id/{id}")
	public int callRemoveStudents(@PathVariable("id")int studentsId) {
		return studentsservice.deleteStudents(studentsId);
	}
	//업데이트
	@CrossOrigin
	@PatchMapping("/students/id/{id}")
	public int callEmpUpdate(@PathVariable("id")int studentsId, @RequestBody StudentsVO vo) {
		return studentsservice.getUpdateStudents(vo, studentsId);
	}
}

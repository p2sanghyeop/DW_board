package com.dw.board.controller;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dw.board.service.ExcelService;

@Controller
//엑셀 다운받는 컨트롤러
public class ExcelController {
	
	@Autowired
	private ExcelService excelservice;
	
	//엑셀, 사진, 한글, PDF, ZIP, 영상 등등... return type 없음 void or ResponseEnity
	//페이지 이름으로 return X
	@GetMapping("/excel")
	public void downloadExcelFile(HttpServletResponse response) throws Exception {
		String today = new SimpleDateFormat( "yyMMdd").format(new Date());
		String title = "DW아카데미_게시판";
				
			response.setContentType("ms-vnd/excel"); //엑셀파일을 보내겠다
		    response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(today+"_"+title,"UTF-8")+".xls"); //엑셀파일이름수정
		        Workbook workBook = excelservice.makeExcelForm();
		        workBook.write(response.getOutputStream());
		        workBook.close();
		        
		        response.getOutputStream().flush();
		        response.getOutputStream().close();
		
	}
}

package com.dw.board.service;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.board.mapper.BoardMapper;

@Service
public class ExcelService {
	
	@Autowired
	private BoardMapper boardmapper;
	
	public Workbook makeExcelForm() throws Exception {
		
		Workbook workbook = new HSSFWorkbook();
		
		Sheet sheet = workbook.createSheet("게시판 자료"); //excel 생성
		Row row = null; //엑셀행
		Cell cell = null; //엑셀열
		
		int rowNumber = 0; //행번호
		
		CellStyle headStyle = makeExcelHeadStyle(workbook);
		CellStyle bodyStyle = makeExcelBodyStyle(workbook);
		
		row = sheet.createRow(rowNumber++); //첫번째 행
		cell = row.createCell(0);
		cell.setCellStyle(headStyle);
		cell.setCellValue("게시판번호");
		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("작성자");
		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("제목");
		cell = row.createCell(3);
		cell.setCellStyle(headStyle);
		cell.setCellValue("수정날짜");
		cell = row.createCell(4);
		cell.setCellStyle(headStyle);
		cell.setCellValue("작성날짜");
		cell = row.createCell(5);
		cell.setCellStyle(headStyle);
		cell.setCellValue("조회수");
		
		//데이터호출
		List<Map<String, Object>>list = boardmapper.selecrAllBoard();
		
		for(Map<String, Object> data : list) {
			row = sheet.createRow(rowNumber++);
			cell = row.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("boardId").toString());
			cell = row.createCell(1);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("studentsName").toString());
			cell = row.createCell(2);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("title").toString());
			cell = row.createCell(3);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("updateAt").toString());
			cell = row.createCell(4);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("createAt").toString());
			cell = row.createCell(5);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.get("cnt").toString());
		}
		
		
		return workbook;
	}
	public CellStyle makeExcelHeadStyle(Workbook workbook) {
		CellStyle cellStyle = null;
		cellStyle = workbook.createCellStyle();
		//가는 경계선 생성
		cellStyle.setBorderTop(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);
		cellStyle.setBorderBottom(BorderStyle.THIN);
		//배경색 생성
		cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.YELLOW.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		//가운데 정렬
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		return cellStyle;
	}
	
	//엑셀 body style 수정
	public CellStyle makeExcelBodyStyle(Workbook workbook) {
		CellStyle cellStyle = null;
		cellStyle = workbook.createCellStyle();
		//가는 경계선 생성
		cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
		return cellStyle;
	}
}

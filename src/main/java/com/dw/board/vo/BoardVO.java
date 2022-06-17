package com.dw.board.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BoardVO extends StudentsVO {
	private int boardId;
	private String title;
	private String content;
	private String updateAt;
	private String createAt;
	private int cnt;
}

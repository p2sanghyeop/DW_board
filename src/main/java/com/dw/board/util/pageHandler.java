package com.dw.board.util;

import lombok.Data;

@Data

public class pageHandler {
	private int total;//전체 게시물 수
	private int pageNum;//현재 페이지
	private int pageSize;//1페이지에 맞게 게시물 표시할지
	private int startPage;//현재블록 첫페이지
	private int endPage;//현재블록마지막 페이지
	private boolean hasPreviousPage;//이전버튼유무
	private boolean hasNextPage;//다음버튼유무
	private int nowBlock;//현재블록
	private int lastBlock;//마지막블록
	private int navigatePage;//블록에페이지 몇개 표시할지
	
	/**
	 * @param total
	 * @param pasgeSize
	 * @return int
	 * @author : sanghyeop
	 * @date : 2022.05.31
	 * comment : 총페이지수
	 */
	public int calcPage(int total, int pasgeSize) {
		int pages = total/pageSize;
		if(total%pageSize >0)
			++pages;
		return pages;
	}
	/**
	 * @param pageNum
	 * @author : sanghyeop
	 * @date : 2022.05.31
	 * comment : 현재페이지 블록 알아내기
	 */
	public void setNowBlock(int pageNum) {
		this.nowBlock = pageNum/navigatePage;
		if(pageNum % navigatePage > 0) {
			++this.nowBlock;
		}
	}
	/**
	 * @param total
	 * @author : sanghyeop
	 * @date : 2022.05.18
	 * comment : 마지막 블록 알아내기
	 */
	public void setLastBlock(int total) {
		this.lastBlock = total / (this.navigatePage*this.pageSize);
		if(total % (this.navigatePage * this.pageSize) > 0 ){
			++this.lastBlock;
		}
			
		
	}
	//현재블록의 처음페이지
	public void setStartPage(int nowBlock) {
		this.startPage = (nowBlock*this.navigatePage)-(this.navigatePage-1);
	}
	//현재블록의 마지막페이지
	public void setEndPage(int lastBlock, int nowBlock) {
		this.endPage = (nowBlock*this.navigatePage);
		if(nowBlock == this.lastBlock) {
			this.endPage = total;
		}
	}
	//이전버튼 다음버튼 유무
	public void setPreNext(int pageNum) {
		if(this.lastBlock == 1) {
			setHasPreviousPage(false);
			setHasNextPage(false);
		}
		if(this.lastBlock > 1 && lastBlock == nowBlock) {
			setHasPreviousPage(true);
			setHasNextPage(false);
		}
		if(this.lastBlock > 1 && pageNum <= navigatePage) {
			setHasPreviousPage(false);
			setHasNextPage(true);
		}
	}
}

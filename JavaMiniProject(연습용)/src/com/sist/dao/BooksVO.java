package com.sist.dao;
import java.util.Date;

import lombok.*;
/*
 * NUM           NUMBER(38)     
ISBN          NUMBER(38)     
BOOKNAME      VARCHAR2(4000) 
WRITER        VARCHAR2(516)  
TRANSLATOR    VARCHAR2(516)  
PAGE          NUMBER(38)     
PRICE         NUMBER(38)     
PUBDATE       DATE           
SERIES        VARCHAR2(516)  
PAPER         VARCHAR2(516)  
IMAGE         VARCHAR2(4000) 
DETAIL        VARCHAR2(4000) 
HIT           NUMBER 
 */
@Data
public class BooksVO {
	private int num, page, price, number, hit;
	private long isbn;
	private String bookname, writer, translator, series, paper, image, detail;
	private Date pubdate;
}

package com.sist.dao;
import java.util.*;

import lombok.Data;
@Data
public class BookCartVO {
	
/*
 *  이름                                      널?      유형
 ----------------------------------------- -------- ----------------------------
 BNO                                       NOT NULL NUMBER
 ID                                                 VARCHAR2(20)
 BNUM                                               NUMBER
 ACCOUNT                                            NUMBER
 PRICE                                              NUMBER
 REGDATE                                            DATE
 */
private int bno,bnum,acoount,price;
private String id;
private Date regdate;
private BooksVO bvo=new BooksVO();
	
}

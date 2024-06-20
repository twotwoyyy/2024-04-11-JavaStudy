package com.sist.dao;
/*
 *  이름                                      널?      유형
 ----------------------------------------- -------- ----------------------------
 CNO                                       NOT NULL NUMBER
 ID                                                 VARCHAR2(50)
 GNO                                                NUMBER
 ACCOUNT                                            NUMBER
 PRICE                                              NUMBER
 REGDATE                                            DATE
 */
import lombok.Data;
import java.util.*;
// DTO => Data Transfor Object 
// 서브쿼리, 조인 => 해당 VO를 포함 
// => VO는 반드시 테이블 한 개만 연결 
@Data
public class CartVO {
	private int cno,gno,price,account;
	private String id;
	private Date regdate;
	private GoodsVO gvo=new GoodsVO();
	

}

package com.sist.dao;
/*
 *  NO                                        NOT NULL NUMBER
 NAME                                      NOT NULL VARCHAR2(51)
 SUBJECT                                   NOT NULL VARCHAR2(4000)
 CONTENT                                   NOT NULL CLOB
 PWD                                       NOT NULL VARCHAR2(10)
 REGDATE                                            DATE
 HIT                                                NUMBER
 */
/*
 * CREATE SEQUENCE board_no_seq
 START WITH 1
 INCREMENT BY 1
 NOCACHE
 NOCYCLE;
 */
import java.util.*;

import lombok.Data;
@Data
public class BoardVO {
	// VO는 오라클에서 데이터를 받아 윈도우, 브라우저에 전송하는 목적 
	/*
	 * 데이터베이스 데이터형과 매칭
	 * 컬럼명/변수명 일치, 
	 * CHAR/VARCHAR2/CLOB => String
	 * NUMBER : 저장된 값에 따라 ===> int / double
	 * DATE : java.util.Date랑 매칭 
	 *   
	 */
	   private int no,hit;
	   private String name,subject,content,pwd;
	   private Date regdate;
}


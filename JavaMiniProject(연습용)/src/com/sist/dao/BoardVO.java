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
	private int no,hit;
	private String name, subject, content, pwd;
	private Date regdate;
}

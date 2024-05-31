package com.sist.temp2;
import java.util.*;
import lombok.*;
@Data
/*
 * CREATE TABLE ZIPCODE (
ZIPCODE VARCHAR2(7),
SIDO VARCHAR2(50),
GUGUN VARCHAR2(50),
DONG VARCHAR2(100),
BUNJI VARCHAR2(100));
INSERT INTO zipcode VALUES ('135-805','서울특별시','강남구','개포1동','565번지');
 */
public class ZIPCODEVO {
	private String ZIPCODE;
	private String SIDO;
	private String GUGUN;
	private String DONG;
	private String BUNJI;
}

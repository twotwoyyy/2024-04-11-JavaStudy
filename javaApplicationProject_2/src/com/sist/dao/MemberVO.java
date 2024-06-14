package com.sist.dao;
			/*
			ID
			PWD
			NAME
			SEX
			BIRTDAY
			POST
			ADDR1
			ADDR2
			PHONE
			EMAIL
			CONTENT
			REGDATE
			ADMIN
			*/
import java.util.*;
import lombok.Data;
@Data
public class MemberVO {
	private String id,pwd,name,sex,birthday,post,addr1,addr2,phone,email,content,admin;
	private Date regdate;
}

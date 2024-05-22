package com.sist.melon;

import java.io.*;
public class MusicSystem {
   // Music 데이터 공유 => 모든 유저가 같은 데이터를 사용하게 만든다 
   private static Music[] musics=new Music[100];
   
   // 파일 읽기 => 데이터 저장 
   // 클래스 영역에서는 사용이 불가능 
   // 초기화 
   /*
    *    A B C D E F G H I J 
    *    
    *    String s="A"
    *     s
    *    ----
    *     100
    *    ----   100------
    *              "A"
    *             ------
    *    s=s+"B"
    *     s
    *    ----
    *     100 => 200 => 300
    *    ----    100------
    *                "A"
    *               ------
    *            200-----
    *                "AB"
    *               -----
    *            300----
    *                "ABC"
    *               ----
    *     sb
    *     -----
    *      100
    *     -----   100 ----------
    *                   ABCDEFHJ
    *                 ----------
    */
   static
   {
	   FileReader fr=null;
	   try
	   {
		   // CheckedException => 컴파일시에 예외 감시
		   // => 초기화블록은 throws는 사용이 불가능하다 
		   //             ------ 메소드에서만 사용이 가능 (생성자 포함)
		   fr=new FileReader("c:\\javaDev\\melon.txt");
		   int i=0;
		   StringBuffer sb=new StringBuffer();
		   // 데이터 문자열 결합이 많은 경우 => StringBuffer / StringBulider 
		   //                            비동기            동기 
		   //                           ArrayList      Vector 
		   //String data="";
		   while((i=fr.read())!=-1)
		   {
			   sb.append((char)i);
			   //data+=(char)i;
		   }
		   //System.out.println(data);
		   //System.out.println(sb.toString());
		   // String으로 제어 
		   String data=sb.toString();
		   // 분리=> \n
		   String[] temp=data.split("\n");
		   i=0;
		   for(String s:temp)
		   {
			   String[] m=s.split("\\|"); // |=> 정규식 기호 => 일반 문자로 변경 => \\|
			   // 정규식 => . , + , * , | , ? , ^ , $ 
			   musics[i]=new Music();
			   musics[i].setMno(Integer.parseInt(m[0]));
			   musics[i].setTitle(m[1]);
			   musics[i].setSinger(m[2]);
			   musics[i].setAlbum(m[3]);
			   musics[i].setPoster(m[4]);
			   i++;
		   }
	   }catch(Exception ex)
	   {
		   //  에러 발생시 복구 => 확인 
		   ex.printStackTrace(); // FileNotFoundException / IOException => Exception
	   }
	   finally
	   {
		   try
		   {
			   fr.close();
		   }catch(Exception ex) {}
	   }
   }
   public int musicTotalPage()
   {
	   return (int)(Math.ceil(musics.length/20.0));
	   //               올림함수 이용한다 ==> 10.0 => 10 10.1 => 11
   }
   public Music[] musicListData()
   {
	   return musics;
   }
   //
   public Music musicDetailData(int mno)
   {
	   Music m=new Music();
	   for(Music mm:musics)
	   {
		   if(mm.getMno()==mno)
		   {
			   m=mm;
			   break;
		   }
	   }
	   return m;
   }
   // 검색 => java.util 
   public Music[] musicFindData(int type,String fd)
   {
	   int count=0;
	   for(Music m:musics)
	   {
		   boolean bCheck=false;
		   if(type==0)
		       bCheck=m.getTitle().contains(fd);
		   else if(type==1)
			   bCheck=m.getSinger().contains(fd);
		   else if(type==2)
			   bCheck=m.getAlbum().contains(fd);
		   
		   if(bCheck) // boolean => if
		   {
			   count++;
		   }
	   }
	   
	   Music[] mm=new Music[count];
	   int i=0;
	   for(Music m:musics)
	   {
		   boolean bCheck=false;
		   if(type==0)
		       bCheck=m.getTitle().contains(fd);
		   else if(type==1)
			   bCheck=m.getSinger().contains(fd);
		   else if(type==2)
			   bCheck=m.getAlbum().contains(fd);
		   
		   if(bCheck)
		   {
			   mm[i]=m;
			   i++;
		   }
	   }
	   return mm;
	   
   }
}
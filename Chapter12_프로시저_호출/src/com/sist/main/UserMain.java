package com.sist.main;
import java.util.*;
import com.sist.dao.*;
public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        StudentDAO dao=StudentDAO.newInstance();
        List<StudentVO> list=dao.studentAllData();
        for(StudentVO vo:list)
        {
        	System.out.println(vo.getHakbun()+" "
        			+vo.getName()+" "
        			+vo.getKor()+" "
        			+vo.getEng()+" "
        			+vo.getMath());
        }
        /*
        System.out.println("===============================");
        
        StudentVO vo=new StudentVO();
        System.out.print("이름:");
        String name=scan.next();
        vo.setName(name);
        
        System.out.print("국어 영어 수학점수(90 90 90):");
        vo.setKor(scan.nextInt());
        vo.setEng(scan.nextInt());
        vo.setMath(scan.nextInt());
        
        dao.studentInsert(vo);
        System.out.println("추가되었습니다!!");
        list=dao.studentAllData();
        for(StudentVO v:list)
        {
        	System.out.println(v.getHakbun()+" "
        			+v.getName()+" "
        			+v.getKor()+" "
        			+v.getEng()+" "
        			+v.getMath());
        }
        */
        /*System.out.println("===============================");
        System.out.print("삭제할 학번:");
        Scanner scan=new Scanner(System.in);
        int hak=scan.nextInt();
        dao.studentDelete(hak);
        list=dao.studentAllData();
        for(StudentVO v:list)
        {
        	System.out.println(v.getHakbun()+" "
        			+v.getName()+" "
        			+v.getKor()+" "
        			+v.getEng()+" "
        			+v.getMath());
        }*/
        // DML/DQL => CRUD 
        System.out.println("========== 수정 ===========");
        Scanner scan=new Scanner(System.in);
        StudentVO vo=new StudentVO();
        System.out.print("학번:");
        int hak=scan.nextInt();
        vo.setHakbun(hak);
        
        System.out.print("이름:");
        String name=scan.next();
        vo.setName(name);
        
        System.out.print("국어 영어 수학점수(90 90 90):");
        vo.setKor(scan.nextInt());
        vo.setEng(scan.nextInt());
        vo.setMath(scan.nextInt());
        
        // 수정 
        dao.studentUpdate(vo);
        
        // 출력 
        list=dao.studentAllData();
        for(StudentVO v:list)
        {
        	System.out.println(v.getHakbun()+" "
        			+v.getName()+" "
        			+v.getKor()+" "
        			+v.getEng()+" "
        			+v.getMath());
        }
	}

}
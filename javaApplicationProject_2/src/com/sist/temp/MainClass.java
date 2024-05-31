package com.sist.temp;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        /*EmpDAO dao=new EmpDAO();
        System.out.println("dao="+dao);
        EmpDAO dao1=new EmpDAO();
        System.out.println("dao1="+dao1);*/
//        for (int i = 0; i < 10; i++) {
//            EmpDAO dao = EmpDAO.newInstance();
//            System.out.println("dao=" + dao);
//        }
    	EmpDAO dao=EmpDAO.newInstance();
    	ArrayList<EmpVO> list=dao.empListData();
    	for(EmpVO vo:list) {
    		System.out.println(vo.getEmpno()+" "
    				+vo.getEname()+" "
    				+vo.getJob()+" "
    				+vo.getSal()+" "
    				+vo.getDeptno()+" ");
    	}
    	System.out.println("=============================");
    	Scanner scan=new Scanner(System.in);
//    	System.out.print("사번 입력 : ");
//    	int empno=scan.nextInt();
//    	EmpVO vo=dao.empDetailData(empno);
//    	System.out.println(vo.getEmpno()+" "
//				+vo.getEname()+" "
//				+vo.getJob()+" "
//				+vo.getSal()+" "
//				+vo.getDeptno()+" ");
    	System.out.print("검색어 입력:");
    	String ename=scan.next();
    	list=dao.empFind(ename);
    	for(EmpVO vo:list) {
    		System.out.println(vo.getEmpno()+" "
    				+vo.getEname()+" "
    				+vo.getJob()+" "
    				+vo.getSal()+" "
    				+vo.getDeptno()+" ");
    	}
    }
}

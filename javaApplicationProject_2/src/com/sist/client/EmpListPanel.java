package com.sist.client;

import javax.swing.*;
import com.sist.dao.*;
import java.awt.*;
import java.util.ArrayList;
import java.text.*;
import javax.swing.table.*;
// 사원 정보를 출력 => 조인 
public class EmpListPanel extends JPanel{
	JLabel titleLa;
	JTable table;
	DefaultTableModel model;
	
	public EmpListPanel() {
		setLayout(null);
		titleLa=new JLabel("사원 정보",JLabel.CENTER);
		titleLa.setFont(new Font("맑은 고딕",Font.BOLD,35));
		titleLa.setBounds(10,15,930,40);
		add(titleLa);
		String[] col= {"사번","이름","직위","입사일","부서명","근무지"};
		String[][] row=new String[0][6];
		model=new DefaultTableModel(row,col);
		table=new JTable(model);
		JScrollPane js=new JScrollPane(table);
		js.setBounds(10,65,930,500);
		add(js);
		// 데이터 첨부
		EmpDeptDAO dao=EmpDeptDAO.newInstance();
    	ArrayList<EmpVO> list=dao.empListData();
		for(EmpVO vo:list) {
			String[] data= {
					String.valueOf(vo.getEname()),
					vo.getEname(),
					vo.getJob(),
					new SimpleDateFormat("yyyy-MM-dd").format(vo.getHiredate()),
					vo.getDvo().getDname(),
					vo.getDvo().getLoc()
			};
			model.addRow(data);
		}
	}
}

package com.sist.map;
import java.util.*;
public class Container {
	// Spring => 메모리 누수 현상 방지 => 한 개의 메모리 공간만 이용한다 => 싱글톤 
	private Map<String,Model> map=new HashMap<String,Model>();
	public Container() {
		map.put("board", new BoadModel());
		map.put("join", new JoinModel());
		map.put("food", new FoodModel());
		map.put("login", new LoginModel());
		map.put("notice", new NoticeModel());
	}
	public Model getBean(String key) {
		return map.get(key);
	}
}

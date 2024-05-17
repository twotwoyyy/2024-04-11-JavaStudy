package com.sist.main2;
/*
 *	class 동물 => 데이터형 (동물)
 *  class 사람 extends 동물
 *       => 사람, 동물 
 *       
 *  interface 동물 ==> 다중 상속이 가능한 클래스 (특수한 클래스) => 상위 클래스
 *  class 사람 
 */
import java.util.*;
public class Container { // 인터페이스 
	Model[] models= {
			new BoardModel(),
			new FoodModel(),
			new RecipeModel(),
			new SeoulModel(),
			new NoticeModel()
			};
	public Model getModel(int no) {
		return models[no-1];
	}
}

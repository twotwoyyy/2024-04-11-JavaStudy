package com.sist.main;
/*     5장
 *	   118page => 클래스 구조
 *      => [접근지정어][제어어] class ClassNmae{} => 형식 
 *                  ----- 대부분 default 
 *                  static, abstract, final
 *                                    | 종단 클래스 => 확장할 수 없는 클래스 (사용빈도가 거의 없다) 
 *                                      => String, System, Math, StringBuffer,Wrapper... 
 *                          | 추상 클래스 (선언만 된 메소드)-> 미완성된 클래스 (메모리 할당을 할 수 없다)
 *                            => 상속받은 다음 구현 후 사용 (상속, 오버라이딩) 
 *                  | 공통으로 사용되는 기능 => 네트워크 (client/server), 데이터 분석 
 *         --------- public 
 *         --------- 한 개의 파일에 클래스 여러 개 만드는 경우 => public은 1번만 사용이 가능
 *         --------- 가급적이면 한 개의 자바 파일에 여러 개 클래스는 만들지 않는다 
 *        {
 *          선택 사항 
 *          --------------------------------------------------------------------
 *           *변수 (멤버변수) 
 *            => 지정해서 관리할 데이터를 메모리에 저장할 목적 (프로그램 종료시까지 유지)
 *            => 따로 저장 공간 (인스턴스 변수) => new를 이용해서 메모리 공간을 만들고 저장 후 사용 
 *            => 1개만 저장 공간 (정적 변수) => static 
 *            => 변수로 사용할 수 있는 것 
 *               1. 기본형 (정수,실수,논리,문자)
 *               2. 배열
 *               3. 클래스 => 포함 클래스 => 데이터형(사용자 정의) 
 *                  ---- String
 *                  Movie[] movies=new Movie[1938]
 *            => 변수는 외부에서 다른 클래스에서 변경할 수 없게 보호 => private
 *               = 캡슐화 : 변수는 은닉화 / 메소드를 통해서 접근이 가능하게 한다
 *                        --------------------------------------
 *                        | getter/setter (읽기/쓰기) => 기능 추가
 *               = 설정하는 변수는 private 
 *               1. 출력화면을 보고 데이터 추출 (안보이는 데이터를 찾을 수 있어야 한다)  
 *                  -------------------
 *                   => 게시물 번호 / 영화 번호 .... 
 *                      : 배열의 인덱스와 매칭 
 *               2. 캡슐화 => 시큐어 코딩의 기본 
 *               ------------------------ => lombok (get/set자동으로)
 *               
 *          --------------------------------------------------------------------
 *           *생성자 : 초기화 담당 => 배열의 값을 채워준다 (파일 읽기,오라클 연결)
 *                   ** 클래스 블록은 선언만 가능 
 *                   ** 선언 : 변수 선언 => int a;
 *                            메소드 선언 => public void display();
 *                   => 초기화 블록에서 구현후 초기화 => 생성자
 *                   
 *                   ** 인스턴스 변수에 대한 초기화 => 생성자
 *                      ----------- 사용을 하기 위해서는 생성자가 반드시 호출
 *                      ----------- 클래스 객체명=new 생성자()
 *                                       객체명.변수명 
 *                   ** static 변수에 대한 초기화 => static{}
 *                      ----------- 생성자 호출이 없어도 사용이 가능 
 *                      클래스명.변수명
 *                      
 *            생성자 
 *            ----
 *              => 접근지정어는 public (다른 클래스에서 사용 가능)
 *              => 클래스명과 동일 
 *              => 리턴형이 없다
 *              => 여러 개를 만들 수 있다 : 같은 메소드명으로 여러 개 생성해서 사용 => 오버로딩 
 *              => 모든 클래스에서 한 개 이상 존재 
 *                 : 사용을 하지 않는 경우에는 생략이 가능 (이런 경우엔 컴파일러가 자동으로 1개 생성) 
 *                                               --------------매개변수가 없는 생성자 
 *          --------------------------------------------------------------------
 *           *메소드 : 멤버 변수를 활용하는 기능을 제작
 *                   -----------
 *                   1. 목록 출력
 *                   2. 상세보기
 *                   3. 예약(예매)하기
 *                   4. 추천
 *                   5. 결제 
 *                   6. 검색 ... 
 *           => 2개 (결과값, 사용자 요청값)
 *                        ---------- 매개변수 (여러 개 사용이 가능)
 *                                          -------------- 권장사항: 3개 이상 초과하지 않는다 
 *                                                        => 초과시 배열/클래스 이용
 *                  ---- 리턴형 (한 개만 사용) => 데이터가 많은 경우 배열/클래스 이용 
 *             형식) 
 *                [접근지정어][제어어] 리턴형 메소드명(매개변수 리스트) => 선언부
 *                               -----
 *                         ----- default(인스턴스 메소드) => 따로 저장 *** 
 *                         ----- static => 공통으로 사용되는 기능 (한글 변환,암호화,복호화,정렬)
 *                         ----- 7장 : abstract => 구현이 안된 메소드 => 프로그램에 맞게 구현 
 *                               버튼 클릭 / 마우스 클릭 / 키보드 입력 
 *                               ----------------------------
 *                               => 메소드는 호출이 가능하게 만든다 .. (구현은 프로그램에 맞게)
 *                               => 설계만 하는 기능 => 추상 클래스 / 인터페이스 
 *                                                 -------------------
 *                                                 요구사항 분석 
 *                --------
 *                public : 메소드는 다른 클래스와 연결할 때 사용 => 공개 
 *                { 
 *                     구현부
 *                     return 전송할 값 
 *                           --------- 같은 데이터형이다
 *                           ** return은 void일 경우에는 생략이 가능하다 
 *                                      ----- 메소드 자체에서 처리 (데이터베이스 => 수정,추가,삭제)
 *                }
 *              => 메소드는 기능별로 나눠서 작업할 때 쓰이는 형식 => 구조적인 프로그램 
 *                 문장 => 단락을 나눠서 처리 
 *                 반복적인 기능이 많은 경우 
 *                 -----------------
 *                 다른 클래스와 연결 
 *              => 재사용이 가능 => 수정/추가 => 클래스의 핵심 
 *              => 메뉴 / 버튼 / 입력창 / 마우스 클릭 
 *                 --------------------------- 벤치마킹 (여러 개) : 프로젝트 
 *                 *** 임팩트
 *                     영화 : 예매
 *                     맛집 : 추천, 예약
 *                     여행 : 추천, 코스..
 *                     쇼핑몰: 결제 
 *          --------------------------------------------------------------------
 *        }
 *         
 *     122page => 객체 생성
 *      1. 클래스 : 설계
 *       public class A{
 *         int a;
 *         public void display(){}
 *        }
 *      2. 메모리에 저장
 *        A aa=new A();
 *             --- --- 
 *                 | 변수에 대한 값을 대입 => 생성자는 .으로 사용하는 것이 아니라 new 생성자()
 *             성계된 데이터를 모아주는 데이터 생성
 *             ------------------------- 데이터+메소드
 *          ---> 메모리 주소 => a,disp() => 접근할 때 사용
 *      3. 객체 활용 (변수 호출, 메소드 호출)
 *         클래스명 객체명 =new 생성자()
 *         객체명.변수 / 객체명.메소드()
 *  
 *     123page => 객체 사용 
 *     ------------------------------------------------------
 *      설계 ==> 저장 => 활용 => 메모리 해제
 *      --      --    --     --------
 *      class   new    .      null => 주소값이 없는 상태(GC)
 *     ---------------------------------------------------- 객체의 생명주기
 *  
 *     127page => 접근지정어 
 *      => 클래스와 클래스의 연결할 때 사용
 *      => 변수 => private 
 *         [접근지정어] 데이터형 변수명
 *         ----------- private로 설정한다 => 캡슐화 => 필요시에는 접근이 가능 (getter/setter)
 *         변수는 기능이 2개 (메모리 저장/메모리에 값을 가지고 온다)
 *         private : 자신의 클래스에서 사용이 가능 
 *         ------- 정보는 private
 *                 private를 사용하지 않는 경우 => public 
 *                 => JButton/JtextField ... 
 *      => 클래스
 *         [접근지정어] class ClassName
 *         --------- public
 *      => 메소드 
 *         [접근지정어] 리턴형 메소드명(매개변수)
 *         --------- public 
 *      => 생성자
 *         [접근지정어] 클래스명()
 *         --------- public 
 *     ------------------------ 다른 클래스와 연결 (public)
 *     *** default => 자신의 클래스 / 같은 패키지까지만 접근이 가능 
 *                                    --- 폴더
 *     *** protected => 자신의 클래스 / 같은 패키지까지만 접근이 가능 / 상속을 받은 경우 다른 패키지에서 접근이 가능
 *     
 *         접근 범위
 *         private < default < protected < public
 *         
 *     132page => 패키지 : 폴더 => 한  번만 사용이 가능
 *                ---- 관련된 클래스를 모아서 관리 => 기능별 분리 => 검색이 쉽게
 *                package 경로명
 *                => 패키지명은 숫자로 시작 불가 / 키워드 사용 불가 
 *                => com(org).회사명.구분자 
 *                                 ----
 *                                 오라클 연결 : dao
 *                                 데이터형 : vo
 *                                 크롤링/OpenApi : manager
 *                                 웹 전송 : service
 *                => 클래스 찾기가 쉽다 
 *                => 같은 클래스명을 사용할 수 있다 
 *                   --------- 
 *     136page => import => 패키지를 불러오는 방법 => 여러 개 사용이 가능 
 *                ------
 *                1. 라이브러리 불러오는 경우
 *                2. 사용자 정의 클래스 불러오기 
 *     140page => 메소드 
 *     152page => getter/setter
 *     166page => 생성자
 *   ----------------------------
 *     6장
 *     194page => 상속 (웹에서는 사용빈도가 거의 없다)
 *       *상속 => 목적 / 형식
 *         목적 : 기존의 클래스를 재사용할 때 사용 / 수정,추가가 가능
 *             --------------- 사용 중에 있기 때문에 신뢰성이 뛰어나다
 *             상속 => 넘겨주는 내용
 *                   1. 변수 / 2. 메소드
 *                   -------
 *                   제외 : static => 공통으로 사용할 수 있게 해준다
 *                         private => 상속은 되지만 접근이 불가능(protected 사용할 것)
 *                   기타 제외 : 생정자, 초기화 블록 
 *        형식: class A extends B
 *                  ---       ---
 *                            상속을 내리는 클래스 : 라이브러리 상속을 주로 받는다 
 *                            -------------- => 슈퍼 클래스,부모 클래스, 상위 클래스 
 *                  상속을 받는 클래스
 *     ** 상속을 받은 클래스는 상속을 내린 클래스의 변수,메소드에 접근이 가능
 *        상속을 내리는 클래스는 상속을 받은 클래스에 접근이 불가능
 *     ** 자바의 모든 클래스는 Object 클래스의 상속을 받는다 !!! 
 *                       -----------
 *                       자바에서 가장 큰 데이터형 : Object
 *                       Object o=10
 *                       o=10.5
 *                       o=""
 *                       o=new A()
 *                       ----------
 *                       배열 => 다른 데이터형을 모아서 사용
 *                       Object[] arr={} => 자바스크립트의 배열
 *                       => 오브젝트는 모든 데이터형을 다 받기 때문에 섞어서 쓸 수 있다           
 *                  
 *     201page => 단일 상속, 오버라이딩 
 *      => 자바는 단일 상속만 가능
 *      => extends 클래스명,클래스명 => 불가능
 *      => 두 개 받는 경우에는 
 *         class A{
 *          int a;
 *         }
 *         class B extends A{
 *           int b;
 *          //int a;
 *         }
 *         class C extends B{
 *           int c;
 *           //int a,b ===> 이렇게 연결해서 받아줘야 한다
 *         }
 *       단점: 다중 상속이 없어 불편한 점이 있다
 *           상속받은 변수, 메소드가 보이지 않기 때문에 수정 추가가 불편하다 (가독성이 떨어짐)
 *        => 이러한 다중 상속을 보완 : 인터페이스 (다중상속) 
 *         
 *     207page => 상속시 접근제한 => 캡슐화가 깨지는 경향 
 *     221page => 상속자 생성자 
 *                디폴트 생성자는 관계 없다 
 *                매개변수가 있는 생성자의 경우 반드시 super() 메소드를 이용해서 상위 클래스의 생성자를 먼저 호출
 *     215page => 키워드 (supper/this)
 *                super => 상속을 내린 클래스의 변수,메소드 호출
 *                this => 자신의 클래스에 있는 변수, 메소드 호출 사용
 *                -----------------------------------------
 *                this => 반드시 정리
 *                ----
 *                 => 생성자, 멤버 메소드에서 사용이 가능 
 *                    -------------- 인스턴스 관련 / static 관련도 사용이 가능 
 *                 => static 메소드에서는 사용이 불가 => 멤버가 아니다 (공통 => 1개의 메모리)
 *                    => 사용이 필요한 경우 객체 생성 후 사용          --
 *         *** final이 있는 경우 
 *         public final void display(){}
 *                ----- 확장이 안되는 메소드 (기능 변경이 불가능 = 오버라이딩이 불가능)
 *                public final class A => 상속을 내리지 못한다 => 고정
 *                 java.lang => final 
 *                 --------- String, Math, Tnteger, Double, System...
 *        
 *     221page => 객체 형변환 
 *       1. 묵시적인 형변환
 *         double d=10; => d=10.0
 *         int i='A'; => i=65
 *         -----
 *         왼쪽이 큰 데이터형이면 자동으로 데이터형 변경
 *         
 *         클래스)
 *               크기 확인
 *               ------- is-a, has-a
 *                       ----- -----
 *                        상속   포함
 *               => 일반 클래스끼리는 크기 비교가 안됨, 상속 상황에서 크기 비교 가능
 *               => 상속을 내리는 클래스 > 상속을 받는 클래스
 *                  포함 클래스가 더 크다
 *                class A{}
 *                class B extends A{} A>b (크기는 상속을 내리는 클래스가 더 크다)
 *                
 *                => 객체 생성
 *                A aa=new A();
 *                double d=10.5
 *                B bb=new B();
 *                int i=10
 *                A cc=new B(); => 묵시적인 형변환 A>B
 *                ---- --------
 *                double d=10
 *              => 상속을 내린 클래스가 상속을 받은 클래스를 이용해서 메모리 할당이 가능 
 *                B dd=new A(); => 오류 발생!! , 작은 것으로 큰 것을 받을 순 없다 
 *                
 *                
 *                
 *                class A{}
 *                class B{
 *                 A a=new A(); // 포함 클래스 has-a ==> A<B
 *                } 
 *                
 *                class 동물
 *                {
 *                }
 *                class 사람 extends 동물 | 위로 올라갈 수록 크다
 *                {
 *                }
 *                
 *                동물 a=new 동물() => is-a 관계 => 동물은 동물이다
 *                사람 b=new 사람() => 사람은 사람이다
 *                동물 c=new 사람() => 사람은 동물이다
 *                사람 d=new 동물() => 동물은 사람이다   is-a (x)
 *                ---------------------------------------
 *                A a=new B();
 *                B b=(B)a;
 *                ------------ 객체 형변환 (사용자 정의는 거의 없다 => 라이브러리에서 주로 사용)
 *                                                           -------
 *                                                           |Object
 *                class A
 *                {
 *                }
 *                class B
 *                {
 *                  A a=new A(); => 포함 has-a ==> A<B
 *                }
 *                => 형변환이 없다
 *                B b=new B();
 *                b.a.display()
 *        2. 강제 형변환
 *           A a=new B();
 *           B b=(B)a;
 *           => 리플렉션 (Spring) => 강제 형변환 
 *           
 *        => 제어어 [접근지정어][제어어] 데이터형 변수 
 *                ---------------
 *                | private, default, protected,public 
 *                  -------                     ------
 *                  |접근 거부                     | 공개
 *        => 클래스구성
 *           => private : 변수 => 접근이 가능 setter/getter
 *           => 생성자, 메소드 => public 
 *        => 상속
 *          extends를 사용한다 => 모든 데이터, 메소드가 넘어온다
 *          -------
 *          => 상위 클래스 제어 : super
 *          => 자신 클래스 제어 : this 
 *        => 상속을 내리는 클래스는 자신 변수, 메소드만 사용이 가능
 *           상속을 받은 클래스는 자신 변수, 메소드, 상속 내린 클래스의 변수, 메소드 사용이 가능
 *           
 *        => 객체 생성
 *           클래스명 객체명=new 생성자()
 *           -----           -----
 *                           | "메소드"는 생성자에 따라 결정
 *           | "변수"는 클래스명에 따라 결정 
 *           
 *         class A{
 *          int a=10;
 *          public void display(){
 *          }
 *        }
 *        class B extends A{
 *          int a=100;
 *          // 오버라이딩
 *          public void display(){
 *          }
 *        }
 *        A aa=new A();
 *          aa.a=10, aa.display() => A:display()
 *        B bb=new B();
 *          bb.a=100, bb.display() => B:display()
 *        A cc=new B(); // 클래스가 A, 상속이 있는 경우에만 사용이 가능 
 *       ---      ----- cc.display() => B.display() => 메소드는 오버라이딩된 함수가 호출 (생성자)
 *       cc.a=10 (A가 가지고 있는 변수를 사용)
 *       
 *       **상속이 있는 경우에 => 변수는 선언된 클래스, 메소드는 생성자를 따라간다
 *       ------------------------------------------------------
 *        => 클래스의 생성자가 다른경우 
 *       ------------------------------------------------------
 *       
 *       다형성 : 오버로딩/오버라이딩
 *             ---------------
 *             오버로딩은 같은 메소드명으로 새로운 기능 추가 => 중복 메소드 정의 
 *             오버라이딩은 같은 메소드명으로 기존에 기능을 수정 => 재정의 
 *       -----------------------------------------------------
 *                     오버로딩                  오버라이딩 
 *       -----------------------------------------------------
 *        상태       같은 클래스내에서            상속을 받은 경우 
 *       -----------------------------------------------------
 *        메소드명        동일                      동일
 *       -----------------------------------------------------
 *        리턴형        관계 없음                    동일 
 *       -----------------------------------------------------
 *        매개변수    개수나 데이터형 다름               동일
 *       -----------------------------------------------------
 *        접근지정어     관계 없음                  확장만 가능  
 *       -----------------------------------------------------
 *       
 *       * 객체 지향 (OOP)
 *        1. 데이터 보호 => 캡슐화 => 변수는 private : 접근 금지, 사용시 메소드 이용 (get/set)
 *        2. 재사용 => 변경해서 사용(상속), 있는 그대로 사용(포함) 
 *        3. 수정,추가 쉽게 => 오버라이딩(수정), 오버로딩(추가)
 *        
 *        ==> 형식 : 5장,6장
 *        ==> 구현 : 연산자, 제어문 
 *       
 *       
 *     7장
 *     => 인터페이스
 *     
 *     8장
 *     => 예외처리
 *       = 직접 처리 => try-catch
 *       = 간접 처리 => throws Exception 
 *   --------------------------------- 자바 기본 형식(문법)
 *     9장 ~ : 라이브러리 (필요한 메소드)
 *           Math => random() / ceil() 
 *       
 */
class A{
	// default 생성자는 상관이 없다 => 매개변수가 있는 경우에는 
	public A(int a) {
		System.out.println(a);
	}
}
class B extends A{
	public B(int a) {
		super(a); // 매개변수가 있는 생성자의 경우에는 반드시 super()를 호출한다
		// 상위 클래스 호출 => 메모리에 저장 => 하위 클래스 메모리를 저장 
	}
}
public class MainClass_01 {
	public MainClass_01() {
		
	}

	public static void main(String[] args) {

	}

}

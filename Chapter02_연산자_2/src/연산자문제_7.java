
public class 연산자문제_7 {

	public static void main(String[] args) {
        int num1=10, num2=10;   
        int a, b;   
        num1 = num1 + 1; // => num+1=1
        a = num1; // 11 
        System.out.printf("%d, %d \n", a, num1); // a는 11, num1도 11
        b = num2; // 10
        num2 = num2 + 1; // 11
        System.out.printf("%d, %d \n", b, num2);

        // 증가 후 대입인지, 대입 후 증가인지 
	}

}

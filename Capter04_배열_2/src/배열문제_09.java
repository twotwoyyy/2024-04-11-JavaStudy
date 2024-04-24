//9.  arr 배열 중에서 값이 60인 곳의 인덱스를 출력해보자. 
//int[] arr = { 10, 20, 30, 50, 3, 60, -3 };  

public class 배열문제_09 {

	public static void main(String[] args) {
		
		int[] arr={10,20,30,50,3,60,-3};
		int index=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==60)
			{
				index=i;
				break;
			}
		}
			System.out.println("index="+index);
		index=0;	
			for(int j:arr)
			{
				if(j==60)
					break;
				index++;
			}
			System.out.println("index="+index);
		}
	}


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    
	/*-은 아무런 의미를 갖지 않지만, +는 정규 표현식에서 특별한 의미를 가짐
	때문에 +를 그대로 사용하려면 \\+로 작성해야함
	하나 이상의 반복을 의미
	\ 하나는 이스케이프 문자이므로 두번 적어줌*/
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 초기 문자열을 입력
        String line = br.readLine();
        
        // -를 기준으로 쪼개서 저장할 문자열 배열
        String[] arr1 = line.split("-");
        
        // 수를 계산할 변수
        int cal = 0;
        
        // arr1의 길이만큼 계산을 진행
        for(int i = 0; i < arr1.length; i++) {
        	
        	// 하나의 인덱스를 다시 +로 쪼갤 배열
        	String temp = arr1[i];
        	String[] arr2 = temp.split("\\+");
        	
        	// 첫 인덱스는 무조건 더해야함
        	if(i == 0) {
        		
        		// temp의 길이만큼 더함
        		for(int j = 0; j < arr2.length; j++) {
        			cal += Integer.parseInt(arr2[j]);
        		}
        	}
        	
        	// 다음 인덱스 부터는 모두 뺌
        	else {
        		
        		for(int j = 0; j < arr2.length; j++) {
        			cal -= Integer.parseInt(arr2[j]);
        		}
        	}
        }
        System.out.println(cal);
    }
}
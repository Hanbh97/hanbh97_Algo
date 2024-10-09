import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력될 파장
		int light = Integer.parseInt(br.readLine());
		
		// 파장에 따른 출력
		if(620 <= light && light <= 780) {
			System.out.println("Red");
		}else if(590 <= light && light < 620) {
			System.out.println("Orange");
		}else if(570 <= light && light < 590) {
			System.out.println("Yellow");
		}else if(495 <= light && light < 570) {
			System.out.println("Green");
		}else if(450 <= light && light < 495) {
			System.out.println("Blue");
		}else if(425 <= light && light < 450) {
			System.out.println("Indigo");
		}else {
			System.out.println("Violet");
		}
		
	}
}

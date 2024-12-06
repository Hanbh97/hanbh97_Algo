import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// 문자열 입력
	String line = br.readLine();

	// 총 높이 변수
	int result = 0;

	for (int i = 0; i < line.length(); i++) {

	    // 시작이면
	    if (i == 0) {
		result += 10;
	    }

	    else {

		if (line.charAt(i) == line.charAt(i - 1)) {
		    result += 5;
		}

		else {
		    result += 10;
		}
	    }
	}
	System.out.println(result);
    }
}
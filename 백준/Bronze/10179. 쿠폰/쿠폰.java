import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();

	// 테스트 케이스 수
	int T = Integer.parseInt(br.readLine());

	// T만큼 반복
	for (int tc = 0; tc < T; tc++) {

	    // 원래 가격
	    double price = Double.parseDouble(br.readLine());

	    // 할인 가격
	    double sale = (price / 5) * 4;

	    // 소수점 둘째자리 까지 반올림하여 표현
	    String result = String.format("%.2f", sale);
	    sb.append("$").append(result).append("\n");
	}
	System.out.println(sb);
    }
}
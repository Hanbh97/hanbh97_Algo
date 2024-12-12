import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());

	// 시작 페이지 A, 끝 페이지 B
	int A = Integer.parseInt(st.nextToken());
	int B = Integer.parseInt(st.nextToken());

	// 시작이 짝수 페이지일 경우
	if (A % 2 == 0) {
	    A--;
	}

	// 끝이 홀수일 경우
	if (B % 2 == 1) {
	    B++;
	}
	int result = (B - A + 1) / 2;
	System.out.println(result);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// 주어진 수
	int N = Integer.parseInt(br.readLine());

	// 처음 불꽃을 제외한 수
	N--;

	for (int i = 1;; i++) {
	    if (N - i == i * i) {
		System.out.println(i);
		break;
	    }
	}
    }
}
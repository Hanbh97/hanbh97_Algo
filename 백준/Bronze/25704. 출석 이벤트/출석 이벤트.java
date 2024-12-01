import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 출석 도장의 개수
    int N = Integer.parseInt(br.readLine());

    // 물건의 가격
    int P = Integer.parseInt(br.readLine());

    // 쿠폰에 따른 가격
    int cp5 = P - 500;
    int cp10 = P - (P / 10);
    int cp15 = P - 2000;
    int cp20 = P - (P / 4);

    // 결과
    int result = 0;

    // 도장 개수에 따라 우선 나누고
    // 가격에 따라 나눈다.
    if (N >= 20) {

      if (P >= 8000) {
        result = cp20;

      } else {
        result = cp15;
      }

    } else if (N < 20 && 15 <= N) {

      if (P >= 20000) {
        result = cp10;

      } else {
        result = cp15;
      }

    } else if (10 <= N && N < 15) {

      if (P >= 5000) {
        result = cp10;

      } else {
        result = cp5;
      }

    } else if (5 <= N && N < 10) {

      result = cp5;

    } else {
      result = P;
    }

    // 음수이면 0
    if (result < 0) {
      result = 0;
    }

    System.out.println(result);
  }
}

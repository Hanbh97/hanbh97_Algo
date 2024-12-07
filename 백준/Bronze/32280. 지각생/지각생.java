import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;

	// 학생 수
	int N = Integer.parseInt(br.readLine());

	// 시간을 담을 배열
	String[] time = new String[N];

	// 선생님 시간
	String teacher = "";

	// 시간 입력
	int idx = 0;
	for (int i = 0; i <= N; i++) {

	    st = new StringTokenizer(br.readLine());

	    String arrive = st.nextToken();
	    String job = st.nextToken();

	    if (job.equals("student")) {
		time[idx] = arrive;
		idx++;
	    }

	    else {
		teacher = arrive;
	    }
	}

	// 지각 시간
	String school = br.readLine();
	String school_h = school.substring(0, 2);
	String school_m = school.substring(3, 5);

	int schoolT = Integer.parseInt(school_h + school_m);

	// 선생님 시간
	String teacher_h = teacher.substring(0, 2);
	String teacher_m = teacher.substring(3, 5);

	int teacherT = Integer.parseInt(teacher_h + teacher_m);

	// 지각생 수
	int cnt = 0;

	// 시간들을 확인
	for (int i = 0; i < N; i++) {
	    String student_h = time[i].substring(0, 2);
	    String student_m = time[i].substring(3, 5);

	    int studentT = Integer.parseInt(student_h + student_m);

	    // 지각
	    if (teacherT >= schoolT) {
		if (teacherT <= studentT) {
		    cnt++;
		}
	    }

	    else {
		if (studentT >= schoolT) {
		    cnt++;
		}
	    }
	}

	System.out.println(cnt);
    }
}
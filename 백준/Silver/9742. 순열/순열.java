import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static List<String> nums; //배열
	static int N; //원소 수
	static int cnt; //기저조건에 몇번 들어왔는지 카운트
	static int End; //목표 횟수
	static String[] result; //결과저장
	static boolean[] visited; //해당 원소 사용 유무
	static boolean stop; //더 이상의 재귀는 허용하지않는다.
	static List<String> real;
	
	public static void main(String[] args) throws IOException {
		String input = "";
		while((input = br.readLine())!=null) {
//			System.out.println(input);
		setNums(input);
		N = nums.size();
		result = new String[N];
		visited = new boolean[N];
		cnt = 0;
		stop = true;
		real = new ArrayList<>();
		perm(0);
		
		for(int i=0; i<real.size(); i++) {
			System.out.print(real.get(i));
		}
		if(real.size()==0) {
			System.out.print("No permutation");
		}
		System.out.println();
		}
	}
	
	public static void setNums(String input) throws IOException { //배열, 목표횟수 설정 및 초기화
		st = new StringTokenizer(input);
		nums = new ArrayList<>();
		String S = st.nextToken();
		End = Integer.parseInt(st.nextToken());
		System.out.print(S+" " + End + " = ");
		for(String s:S.split("")) {
			nums.add(s);
		}
	}
	
	public static void perm(int idx) {
		//기저 조건
		if(idx == N) {
			++cnt;
			if(cnt==End) {
				for(int i=0; i<result.length; i++) {
					real.add(result[i]);
				}
			stop = false;
			}
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) {
				continue;
			}
			
			result[idx] = nums.get(i);
			visited[i] = true; //i번째 원소 사용했다고 표시
			if(stop) {
				perm(idx+1);
			}
			visited[i] = false; //i번째 원상복구
			
		}
	}
}

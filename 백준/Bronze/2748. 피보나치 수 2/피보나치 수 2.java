import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Long> list = new ArrayList<>();//피보나치 수열에서 활용할 list
		
		int N = Integer.parseInt(st.nextToken());
		list.add((long)0);
		list.add((long)1);
		for(int i=1; i<N; i++) {
			list.add(list.get(i-1)+list.get(i));//3부터 시작
		}
		
		System.out.println(list.get(N));
		
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int N;
	static int M;
	static HashMap<Integer, Integer> numHash;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		setNumHash();
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		selectNumHash();
		
		System.out.println(sb);
	}

	public static void setNumHash() throws IOException {
		st = new StringTokenizer(br.readLine());
		numHash = new HashMap<>(); // 해쉬 선언 및 초기화

		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			Integer currentCount = numHash.get(num);
			if (currentCount == null) {
				numHash.put(num, 1);
			}else if(currentCount>=1) {
				numHash.put(num, currentCount+1);
			}
		}
	}
	
	public static void selectNumHash() throws IOException {//NumHash의 value를 조회
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		for(int i=1; i<=M; i++) {
			int num = Integer.parseInt(st.nextToken());
			Integer currentCount = numHash.get(num);
			if (currentCount == null) {
				sb.append(0 + " ");
			}else if(currentCount>=1) {
				sb.append(currentCount + " ");
			}
		}
	}
}

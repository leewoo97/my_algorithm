import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static HashSet<String> hs;//해쉬 셋
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
//		System.out.println(T);
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			hs = new HashSet<>(); //해쉬셋 선언 및 초기화
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			hsSet();
			
			System.out.println("#" + tc + " " + ((N+M)-hs.size()));
			
		}
	}
	
	public static void hsSet() throws IOException {
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			hs.add(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			hs.add(st.nextToken());
		}
		
	}
	
	
}

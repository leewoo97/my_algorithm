import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] arg) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> hs = new HashSet<String>();
		TreeSet<String> result = new TreeSet<String>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			hs.add(st.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String userName = st.nextToken();
			if(hs.contains(userName)) {
				result.add(userName);
			}
		}
		
		System.out.println(result.size());
		for(String s:result) {
			System.out.println(s);
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long N; // 양초의 총 갯수
	static long L; // 배열의 가장 첫번째
	static long R; // 배열의 가장 끝
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Long.parseLong(st.nextToken()); // 양초의 총 갯수 //10의 18승이라 int범위 벗어날듯
			L = 1L;
			R = 2000000000L;
			
			System.out.println("#" + tc + " " + binarySearch());
		}
	}

	public static Long binarySearch() {// 이분탐색
		while (L <= R) {
			long mid = (L + R) / 2;
			long value = mathResult(mid);
			
			if(value<N) {
				L = mid+1L;
			}else if(value>N) {
				R = mid-1L;
			}else if(value==N) {
				return mid;
			}
//			System.out.println(value);
		}
		return -1L;
	}
	
	public static Long mathResult(Long mid) { //K를 대입한 수식값
		return (mid*(mid+1))/2;
	}
}

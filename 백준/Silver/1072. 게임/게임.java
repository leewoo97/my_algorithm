import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static double X; // 게임 횟수
	static double Y; // 이긴 게임
	static int Z; // 승률
	static int res; // 내가 찾은 최고의 정답
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		Z = (int) (((Y * 100) / X)); // 처음 승률
//		System.out.println(Z);
		int L = 1; // 정답이 존재하는 가능성이 있는 왼쪽 끝
		int R = 1000000000; // 정답이 존재하는 가능성이 있는 오른쪽 끝
		res = 0;
		System.out.println(binarySearch(L, R));
	}

	public static int binarySearch(int L, int R) {
		while (L <= R) {
			int mid = (L + R) / 2;
			int value = (int) ((((Y + mid)* 100) / (X + mid))); // 중간값으로 승률을 구해봅니다.
//			System.out.println("L : " + L + " R : " + R);
//			System.out.println("Z : " + Z + " value : " + value);
			if (Z >= value) {// 가능한 케이스
				L = mid + 1; // 오른쪽 절반에 대해 추가 탐색
			} else if (Z < value) {
				R = mid - 1; // 왼쪽 절반에 대해 추가 탐색
			}
			res = L;
		}
		if (res == 1000000001) {
			return -1;
		} else {
			return res;
		}
	}

}

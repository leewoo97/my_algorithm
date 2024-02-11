import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] array;// 도현이의 집 위치배열
	static int N;// 도현이의 집 개수
	static int C;// 공유기 개수
	static int res;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 도현이의 집 개수
		C = Integer.parseInt(st.nextToken());// 공유기 개수

		arraySet();
//		System.out.println(Arrays.toString(array));

		int L = 0; // 집범위의 가장 왼쪽끝
		int R = 1000000000; // 집범위의 가장 오른쪽끝
		res = 0; //가장 좋은 결과값 초기화
		binarySearch(L, R);
		System.out.println(res);
	}

	public static void arraySet() throws IOException {// 도현이 집 위치배열 셋팅 및 초기화
		array = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			array[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
	}

	public static void binarySearch(int L, int R) {
		while (L <= R) {
			int mid = (L + R) / 2;
//			System.out.println("mid => " + mid);
			int result = psSet(mid);
			
			if(result==1) {//공유기 설치 성공, 거리를 더 늘리자
				L = mid+1;
				res = mid;
			}else if(result==0) {//공유기 설치 실패, 거리를 줄이자
				R = mid-1;
			}
		}
	}

	public static int psSet(int mid) {// 공유기 설치(플스아니야 여보)
		int cnt = 1;
		int start = array[0];// 처음 공유기 설치하는곳은 무조건 첫번째 집
		for (int i = 1; i < array.length; i++) {
			int distance = array[i] - start;
			if (distance >= mid) {
				start = array[i];
				cnt++;
			}
			if(cnt==C) {
				return 1; //공유기 전부 설치에 성공했으면 1을 반환한다.
			}
		}
		return 0; //공유기 전부 설치에 실패했으면 0을 반환한다.
	}

}

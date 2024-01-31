import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int r; //목표 행
	static int c; //목표 열
	static boolean theEnd; //목표값을 구하면 재귀을 막는 문지기 theEnd!
	static int cnt; //목표에 도달하기 전 횟수 
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		theEnd = false;
		cnt = -1; //횟수 선언 및 초기화
//		System.out.println("제곱에 대해서 공부해보자" + );
		recur(0,0,(int)(Math.pow(2, N)));
		System.out.println(cnt);
		
	}
	
	
	public static void recur(int x, int y, int range) {
		if(range == 2) {//기저조건
			writeZ(x,y,range);
			return;
		}
		int px = x;
		int py = y;
		int prange = range/2;
		int[] dx = {0,0,prange,prange}; 
		int[] dy = {0,prange,0,prange}; 
		for(int i=0; i<4; i++) {
			px += dx[i];
			py += dy[i];
//			System.out.println("px : " + px + " py : " + py + " prange : "+prange);
			//백트래킹 시작
			if(theEnd) {
				return;
			}
			if(r>=px&&r<px+prange&&c>=py&&c<py+prange) {
				recur(px,py,prange);
			}else {
				int width = prange*prange;
//				System.out.println("px : " + px + " py : " + py + " width : " + width);
				cnt += width;
			}
			px -= dx[i];
			py -= dy[i];
		}
		
		
		
	}
	
	public static void writeZ(int x, int y, int range) {
		int px = x;
		int py = y;
		int[] dx = {0,0,1,1};
		int[] dy = {0,1,0,1};
		for(int i=0; i<4; i++) {
			cnt++;
			px += dx[i];
			py += dy[i];
//			System.out.println("실제로 Z 찍습니다 => px : " + px + " py : " + py);
			if(px == r && py == c) {
				theEnd = true;
//				System.out.println("여기 아예안찍히지 이거");
				return;
			}
			px -= dx[i];
			py -= dy[i];
		}
	}
}

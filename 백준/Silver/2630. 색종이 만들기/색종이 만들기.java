import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static int white;
	static int blue;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //최초 한변의 길이
		white = 0; blue = 0; //색종이 수 선언 및 초기화
		
		mapSet(N);
//		mapView(N);
		
		recur(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
		
	}
	
	public static void mapSet(int N) throws IOException {
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	public static void mapView(int N) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void recur(int x,int y,int range) {//재귀 메소드 //x가 세로,y가 가로
		int color = colorCheck(x, y, range);
		
		if(color==-1) {
			int prange = range/2;
			int px = x;
			int py = y;
			int[] dx={0,0,prange,prange};
			int[] dy={0,prange,0,prange};
			for(int i=0; i<4; i++) {
//				System.out.println("px : "+ px + " py : " + py);
				px += dx[i];
				py += dy[i];
				recur(px,py,prange);
				px -= dx[i];
				py -= dy[i];
			}
		}
	}
	
	public static int colorCheck(int x,int y,int range) {//return이 -1이면 정복실패, 0이면 하얀색종이, 1이면 파란색종이
		int start = map[x][y]; //첫 시작이 0인지,1인지
		
		for(int i=x; i<x+range; i++) {
			for(int j=y; j<y+range; j++) {
				if(map[i][j]!=start) {
					return -1;
				}
			}
		}
		if(start==0) {
//			System.out.println("white x좌표 = " + x + " y좌표 = "+y );
			white++;
			return 0;
		}else{
//			System.out.println("blue x좌표 = " + x + " y좌표 = "+y );
			blue++;
			return 1;
		}
	}
}

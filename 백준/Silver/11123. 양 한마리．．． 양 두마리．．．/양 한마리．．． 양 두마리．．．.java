import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static String[][] map; // 양들이 있는 초원
	static boolean[][] visited; // 초원에서 방문체크하기
	static int H; // 그리드 높이
	static int W; // 그리드 너비
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken()); // 테스트케이스 개수

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			// 초원 세팅(초기화)
			map = new String[H][W];
			visited = new boolean[H][W];
			mapSetting();
//			mapView();
			int idx = 0; //그리드 개수
			// 초원 세팅 끝

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (!visited[i][j]&&!map[i][j].equals(".")) {
//						System.out.println("i좌표 : " + i + " j좌표 : " + j);
						idx++;
						DFS(i, j);
					}
				}
			}
			System.out.println(idx);

		}
	}

	public static void mapSetting() throws IOException {// 맵 세팅
		for (int i = 0; i < H; i++) {
			String temp = br.readLine();
			int j = 0;
			for (String s : temp.split("")) {
				map[i][j++] = s;
			}
		}
	}

	public static void mapView() {// 맵 구성 확인
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	public static void DFS(int x, int y) {// DFS
//		System.out.println("x좌표 : " + x + " y좌표 : " + y);
		visited[x][y] = true;
		int px = x;
		int py = y;
		
		for(int i=0;i<4;i++) {
			px += dx[i];
			py += dy[i];
			if(px>=0&&py>=0&&px<H&&py<W&&!visited[px][py]&&!map[px][py].equals(".")) {
//				System.out.println(map[px][py]);
				DFS(px,py);
			}
				px-=dx[i];
				py-=dy[i];
		}
		
	}
}
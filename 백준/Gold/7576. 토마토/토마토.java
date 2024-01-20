import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;//토마토 상자
	static int M; //상자의 가로 칸 수
	static int N; //상자의 세로 칸 수
	static Queue<Integer> queue; //BFS 큐
	static boolean[][] visited; //BFS 방문배열
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};
	static int max;//토마토가 다 익은 날짜.
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		queue = new LinkedList<>(); //BFS 큐 설정 및 초기화
		visited = new boolean[N][M]; //BFS 방문배열 설정 및 초기화
		max = 0; //날짜 설정 및 초기화
		
		mapSet();
//		mapView();
		BFS(0);
		mapCheck();
		System.out.println(max);
		
	}
	
	public static void mapSet() throws IOException {//맵 설정 및 초기화
		map = new int[N][M]; //세로 가로
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
//				System.out.println("x좌표 : "+ i + " y좌표 : "+ j);
				map[i][j] = Integer.parseInt(st.nextToken()); 
				if(map[i][j]==1) {
					queue.add(i);//세로 좌표 저장
					queue.add(j);//가로 좌표 저장
					queue.add(0);//처음 깊이는 0이다.(깊이로 몇일차인지 파악한다.)
//					System.out.println("y좌표 : "+ i + " x좌표 : "+ j);
				}
			}
		}
	}
	
	public static void mapView() {//맵 확인
		
		for(int i=0;i<N;i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j]+" "); 
			}
			System.out.println();
		}
	}
	
	public static void mapCheck() {//BFS가 전부 끝난후, 안 익은 토마토가 있는지 검사한다. 있다면 max는 -1
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					max=-1;
					return;
				}
			}
		}
	}
	
	public static void BFS(int depth) { // depth는 깊이
		while(!queue.isEmpty()) {
			int py = queue.poll(); //세로값 꺼냄
			int px = queue.poll(); //가로값 꺼냄
			depth = queue.poll(); //깊이로 몇일차인지 파악한다.
			max = depth;
//			System.out.println("py 좌표 : " + py + " px 좌표 : "+ px);
			visited[py][px] = true;
			
			for(int i=0; i<4; i++) {
				py += dy[i];
				px += dx[i];
				if(py>=0&&px>=0&&py<N&&px<M&&!visited[py][px]&&map[py][px]==0) {
					queue.add(py);
					queue.add(px);
					queue.add(depth+1);//깊이로 몇일차인지 파악한다.
					visited[py][px] = true;
					map[py][px] = 1;
				}
				py -= dy[i];
				px -= dx[i];
			}
			
		}
	}
}
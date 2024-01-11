import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map; //현수막 맵
	static int M; //현수막 세로
	static int N; //현수막 가로
	static Queue<Integer> queue; //BFS 큐
	static boolean[][] visited; //현수막 방문체크(BFS 방문체크)
	static int[] dx = {0,1,1,1,0,-1,-1,-1}; //세로 델타
	static int[] dy = {1,1,0,-1,-1,-1,0,1}; //가로 델타
	
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); //현수막 세로
		N = Integer.parseInt(st.nextToken()); //현수막 가로
		
		map = new int[M][N];//맵 초기화
		visited = new boolean[M][N];//방문체크 초기화
		mapSet();//맵 세팅완료
//		mapView();//맵 보기
		int count = 0; //최종 글자수
		queue = new LinkedList<>();//BFS 큐 초기화
		
		//완전탐색 및 BFS 시작
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1&&!visited[i][j]) {
//					System.out.println("x좌표 : " + i + " y좌표 : "+ j);
					++count;
					BFS(i,j);
				}
			}
		}
		//완전탐색 및 BFS 끝
		System.out.println(count);
	}
	
	public static void mapSet() throws IOException {//맵 세팅
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}
	
	public static void mapView() {//맵 보기
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	//x가 세로 //y가 가로
	public static void BFS(int x,int y) {
		queue.add(x);
		queue.add(y);
		visited[x][y]=true;
//		System.out.println("x좌표 : " + x + " y좌표 : "+ y);
		while(!queue.isEmpty()) {
			int px = queue.poll();
			int py = queue.poll();
			
			for(int i=0;i<8;i++) {
				px += dx[i];
				py += dy[i];
				if(px>=0&&py>=0&&px<M&&py<N&&!visited[px][py]&&map[px][py]==1) {
//					System.out.println("x좌표 : " + px + " y좌표 : "+ py);
					queue.add(px);
					queue.add(py);
					visited[px][py] = true;
				}
				px -= dx[i];
				py -= dy[i];
				
			}
			
		}
		
	}
}
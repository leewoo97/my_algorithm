import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map; //토마토가 들어있는 상자
	static int M; //상자의 가로
	static int N; //상자의 세로
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};
	static Queue<Integer> queue;
	static boolean[][] visited;
	static int zeroCount;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		zeroCount = 0;
		queueSet();
		visitedSet();
		mapSet();
//		mapView();
		System.out.println(BFS());
	}
	
	public static void queueSet() {
		queue = new LinkedList<Integer>();
	}
	
	public static void visitedSet() {
		visited = new boolean[N][M];
	}
	
	public static void mapSet() throws IOException {
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
//				System.out.print(map[i][j]);
				if(map[i][j]==1) {
					queue.add(i);
					queue.add(j);
					queue.add(0); //깊이
				}else {
					zeroCount++;
				}
			}
//			System.out.println();
		}
	}
	
	public static void mapView() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static int BFS() {
		if(zeroCount == 0) { //기저조건 만약 모든 토마토가 처음부터 다 익어있었다면 '0'을 반환
			return 0; 
		}
		
		int depth = 0;
		int maxDepth = 0;
		
		while(!queue.isEmpty()) {
			int y = queue.poll();
			int x = queue.poll();
			depth = queue.poll();
			if(maxDepth<=depth) {
				maxDepth = depth;
			}
			visited[y][x] = true;
			for(int i=0; i<4; i++) {
				int py = y+dy[i];
				int px = x+dx[i];
				if(py>=0&&py<N&&px>=0&&px<M&&!visited[py][px]&&map[py][px]==0) {
					visited[py][px] = true; //방문처리
					queue.add(py);
					queue.add(px);
					queue.add(depth+1);
				}
			}
		}
		
		if(visitedFail()) {
			return -1;
		}else {
			return maxDepth;
		}
	}
	
	public static boolean visitedFail() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j]&&(map[i][j]!=-1)) {
					return true;
				}
			}
		}
		return false;
	}
}

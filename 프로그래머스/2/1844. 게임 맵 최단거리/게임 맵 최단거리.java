import java.util.*;

class Solution {
    //최단거리는 BFS
    static int[][] Maps;
    static int N;//맵 세로길이
    static int M;//맵 가로길이
    static boolean[][] visited;
    static Queue<Integer> queue;
    static int[] dy={0,1,0,-1};
    static int[] dx={1,0,-1,0};
        
    public int solution(int[][] maps) {
        Maps=maps;
        N=maps.length;
        M=maps[0].length;
        visited=new boolean[N][M];
        queue=new LinkedList<>();
        
        int answer = BFS(0,0,1);
        return answer;
    }
    
    public int BFS(int y, int x, int depth){
        queue.add(y);
        queue.add(x);
        queue.add(depth);
        visited[y][x]=true;
        
        while(!queue.isEmpty()){
            y=queue.poll();
            x=queue.poll();
            depth=queue.poll();
            
            if(y==N-1&&x==M-1){
                return depth;
            }
            
            for(int i=0; i<4; i++){
                int py=y+dy[i];
                int px=x+dx[i];
                if(py>=0&&py<N&&px>=0&&px<M&&!visited[py][px]&&Maps[py][px]==1){
                    queue.add(py);
                    queue.add(px);
                    queue.add(depth+1);
                    visited[py][px]=true;
                }
            }
        }
        return -1;
    }
    
}
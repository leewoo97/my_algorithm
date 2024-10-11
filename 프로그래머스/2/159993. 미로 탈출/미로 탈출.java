import java.util.*;

class Solution {
    static String[][] map;//지도
    static boolean[][] visited;//방문배열
    static Queue<Integer> queue;//BFS큐
    static int mY;//지도세로길이
    static int mX;//지도가로길이
    static int sY;//시작Y좌표
    static int sX;//시작X좌표
    static int lY;//레버Y좌표
    static int lX;//레버Y좌표
    static int[] dy={0,1,0,-1};
    static int[] dx={1,0,-1,0};
    
    public int solution(String[] maps) {
        mY=maps.length;
        mX=maps[0].length();
        visited=new boolean[mY][mX];
        queue=new LinkedList<>();
        setMap(maps);
        
        int LabberFindTime=LabberBFS();
        // System.out.println("레버를 찾는데 걸린시간: "+LabberFindTime);
        if(LabberFindTime==-1){
            return -1;
        }
        visited=new boolean[mY][mX];
        queue=new LinkedList<>();
        int ExitFindTime=ExitBFS();
        if(ExitFindTime==-1){
            return -1;
        }
        
        int answer = LabberFindTime+ExitFindTime;
        return answer;
    }
    
    public void setMap(String[] maps){
        map=new String[mY][mX];
        for(int i=0; i<maps.length; i++){
            int j=0;
            for(String m:maps[i].split("")){
                if(m.equals("S")){
                    sY=i;
                    sX=j;
                }else if(m.equals("L")){
                    lY=i;
                    lX=j;
                }
                map[i][j++]=m;
            }
        }
    }
    
    public int LabberBFS(){
        queue.add(sY);
        queue.add(sX);
        queue.add(0);
        visited[sY][sX]=true;
        
        while(!queue.isEmpty()){
            int y=queue.poll();
            int x=queue.poll();
            int depth=queue.poll();
            
            if(map[y][x].equals("L")){
                return depth;
            }
            
            for(int i=0; i<4; i++){
                int py=y+dy[i];
                int px=x+dx[i];
                if(py>=0&&py<mY&&px>=0&&px<mX&&!visited[py][px]&&!map[py][px].equals("X")){
                    queue.add(py);
                    queue.add(px);
                    queue.add(depth+1);
                    visited[py][px]=true;
                }
            }
        }
        return -1;
    }
    
    public int ExitBFS(){
        queue.add(lY);
        queue.add(lX);
        queue.add(0);
        visited[lY][lX]=true;
        
        while(!queue.isEmpty()){
            int y=queue.poll();
            int x=queue.poll();
            int depth=queue.poll();
            
            if(map[y][x].equals("E")){
                return depth;
            }
            
            for(int i=0; i<4; i++){
                int py=y+dy[i];
                int px=x+dx[i];
                if(py>=0&&py<mY&&px>=0&&px<mX&&!visited[py][px]&&!map[py][px].equals("X")){
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
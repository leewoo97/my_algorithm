import java.util.*;

class Solution {
    static int N; //노드의 개수
    static int[][] Edge;
    static List<List<Integer>> list;
    static Queue<Integer> queue;
    static boolean[] visited;
    static List<List<Integer>> depthArray;
    
    public int solution(int n, int[][] edge) {
        N = n;
        Edge = edge;
        
        setList();
        setDepthArray();
        queue = new LinkedList<>();
        visited = new boolean[N+1];
        BFS(1,0);
        // System.out.println("DepthArray : " + depthArray);
        
        List<Integer> resultList=resultAboutDepthArray();
        if(resultList!=null){
            // System.out.println(resultList);
        }
        int answer = resultList.size();
        return answer;
    }
    
    public void setList(){
        list = new LinkedList<>();
        for(int i=0; i<=N; i++){
            list.add(new LinkedList<>());
        }
        
        for(int i=0; i<Edge.length; i++){
            int x = Edge[i][0];
            int y = Edge[i][1];
            list.get(x).add(y);
            list.get(y).add(x);
        }
        // System.out.println("List : " + list);
    }
    
    public void setDepthArray(){
        depthArray = new LinkedList<>();
        for(int i=0; i<=N; i++){
            depthArray.add(new LinkedList<>());
        }
    }
    
    public void BFS(int v, int depth){
        queue.add(1); //시작 노드
        queue.add(0); //시작 깊이
        visited[v] = true;
        depthArray.get(depth).add(v);
        
        while(!queue.isEmpty()){
            v = queue.poll();
            depth = queue.poll();
            depthArray.get(depth).add(v);
        
            for(int i=0; i<list.get(v).size(); i++){
                int nextV = list.get(v).get(i);
                if(!visited[nextV]){
                    // System.out.println("우진");
                    queue.add(nextV);
                    queue.add(depth+1);
                    visited[nextV] = true;
                }
            }
        }
    }
    
    public List<Integer> resultAboutDepthArray(){
        for(int i=depthArray.size()-1; i>=0; i--){
            if(depthArray.get(i).size()>0){
                return depthArray.get(i);
            }
        }
        return null;
    }
}
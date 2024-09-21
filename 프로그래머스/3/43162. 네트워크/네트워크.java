class Solution {
    static boolean[] visited; //방문 배열
    static int N; //전체 컴퓨터 개수
    static int[][] Computers; //전체 컴퓨터 배열
    
    public int solution(int n, int[][] computers) {
        N = n;
        Computers = computers;
        visited = new boolean[N];
        int result = 0;
        for(int i=0; i<N; i++){
            if(!visited[i]){
                DFS(i);
                result++;
            }
        }
                   
        int answer = result;
        return answer;
    }
    
    public void DFS(int i){
            visited[i] = true; //방문 처리
            for(int j=0; j<N; j++){
                if(!visited[j]&&(Computers[i][j]==1)){
                    System.out.println("i: " +i+ " j: "+j);
                    DFS(j);
                }
            }
    }
}
import java.util.*;

class Solution {
    //String에 시작지점 입력,Integer에 y값들어있음,tickets[y][1]=도착지점
    static HashMap<String,List<Integer>> beginHm;
    static boolean[] visited;
    static List<String> result=new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        setVisited(tickets);
        setBegin(tickets);
        DFS("ICN","ICN",tickets,1);
        // for(int i=0; i<result.size(); i++){
        //     System.out.println(result.get(i));
        // }
        
        String[] answer=resultSort().toArray(new String[0]);
        return answer;
    }
    
    public void DFS(String begin, String airWay, String[][] tickets, int depth){
        if(depth==tickets.length+1){
            result.add(airWay);
            return;
        }
        if(beginHm.get(begin)==null)
            return;
        
        for(int i=0; i<beginHm.get(begin).size(); i++){
            int y=beginHm.get(begin).get(i);
            if(!visited[y]){
                visited[y]=true;
                String end=tickets[y][1];
                DFS(end,new String(airWay)+","+end,tickets,depth+1);
                visited[y]=false;
            }
        }
    }
    
    public void setBegin(String[][] tickets){
        beginHm=new HashMap<>();
        for(int i=0; i<tickets.length; i++){
            String begin=tickets[i][0];
            if(!beginHm.containsKey(begin)){
                beginHm.put(begin,new ArrayList<>());
                beginHm.get(begin).add(i);
            }else{
                beginHm.get(begin).add(i);
            }
        }
    }
    
    public void setVisited(String[][] tickets){
        visited=new boolean[tickets.length];
    }
    
    // public List<String> resultSort(){
    //     List<List<String>> list=new ArrayList<>();
    //     for(int i=0; i<result.size(); i++){
    //         List<String> temp=new ArrayList<>();
    //         for(String r:result.get(i).split("")){
    //             temp.add(r);
    //         }
    //         list.add(temp);
    //     }
    //     Collections.sort(list);
    //     return list.get(0);
    // }
    
    public List<String> resultSort(){
        Collections.sort(result);
        List<String> list=new ArrayList<>();
        for(String r:result.get(0).split(",")){
            list.add(r);
        }
        return list;
    }
}
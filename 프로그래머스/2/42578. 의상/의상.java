import java.util.*;

class Solution {
    static HashMap<String,List<String>> hm;
    
    public int solution(String[][] clothes) {
        hm=new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            String clothName=clothes[i][0];            
            String clothType=clothes[i][1];
            if(!hm.containsKey(clothType)){
                hm.put(clothType,new ArrayList<>());
                hm.get(clothType).add("비어있음");
                hm.get(clothType).add(clothName);
            }else{
                hm.get(clothType).add(clothName);
            }
        }
        
        int result=1;
        for(String s:hm.keySet()){
            // System.out.println(s);
            result*=hm.get(s).size();
        }
        int answer = result-1;
        return answer;
    }
}
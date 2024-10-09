import java.util.*;

class Solution {
    static String S;
    static int firstCnt;
    static int secondCnt;
    
    public int[] solution(String s) {
        //시작조건
        S=s;
        firstCnt=0;
        secondCnt=0;
        //시작조건끝
        
        while(S.length()!=1){
            firstCnt++;
            replaceZero();
        }
        
        int[] answer = {firstCnt,secondCnt};
        return answer;
    }
    
    public void replaceZero(){
        for(String temp:S.split("")){
            if(temp.equals("0"))
                secondCnt++;
        }
        S=S.replaceAll("0","");
        S=Integer.toBinaryString(S.length());
    }
}
import java.util.*;

class Solution {
    static int arrayCnt=0;
    
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        while(arrayCnt<progresses.length){
            int num = checkArray(progresses, speeds);
            list.add(num);
            arrayCnt += num;
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public int checkArray(int[] progresses, int[] speeds){
        int plusCnt=1; //몇번 곱해야 100을 넘는지확인
        while(progresses[arrayCnt] + (speeds[arrayCnt] * plusCnt) < 100){
            plusCnt++;
        }
        // System.out.println(plusCnt);
        
        for(int i=arrayCnt; i<progresses.length; i++){
            progresses[i] += (speeds[i] * plusCnt);
        }
        
        int result=0;
        for(int i=arrayCnt; i<progresses.length; i++){
            if(progresses[i] >= 100){
                result++;
            }else{
                // arrayCnt = i;
                // System.out.println(arrayCnt);
                break;
            }
        }
        System.out.println(result);
        return result;
    }
}
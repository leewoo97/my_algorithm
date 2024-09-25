import java.util.*;

class Solution {
    static Integer[] arrA;
    static Integer[] arrB;
    static Deque<Integer> deque;
    static int score;
    
    public int solution(int[] A, int[] B) {
        arrA = new Integer[A.length];
        for(int i=0; i<A.length; i++){
            arrA[i] = A[i];
        }
        Arrays.sort(arrA,Collections.reverseOrder());
        arrB = new Integer[B.length];
        for(int i=0; i<B.length; i++){
            arrB[i] = B[i];
        }
        Arrays.sort(arrB,Collections.reverseOrder());
        deque = new ArrayDeque();
        for(int i=0; i<arrB.length; i++){
            deque.add(arrB[i]);
        }
        //위 설정코드는 고치지말것
        
        score = 0;
        for(int i=0; i<arrA.length; i++){
            int valueA = arrA[i];
            int valueB = deque.peekFirst();
            if(valueB>valueA){
                score++;
                deque.pollFirst();
            }else{
                deque.pollLast();
            }   
        }
        int answer = score;
        return answer;
    }
}
import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] splitS = s.split(" ");
        int[] numArr = new int[splitS.length];
        for(int i=0; i<splitS.length; i++){
            numArr[i] = Integer.parseInt(splitS[i]);
        }
        
        Arrays.sort(numArr);
        
        String answer = Integer.toString(numArr[0]) + " " + Integer.toString(numArr[numArr.length-1]);
        
        return answer;
    }
}
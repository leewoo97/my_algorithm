import java.util.*;

class Solution {
    public int solution(int n) {
        int result=0;
        out:for(int j=1; j<=n; j++){
                int sum=0;
                for(int i=j; i<=n; i++){
                    sum+=i;

                    if(sum==n){
                        result++;
                        continue out;
                    }
                    if(sum>n){
                        continue out;
                    }
                }
        }
        
        int answer = result;
        return answer;
    }
    
    
}
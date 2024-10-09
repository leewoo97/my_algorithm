class Solution {
    public String solution(String s) {
        String result="";
        String[] arr=s.split(" ");
        
        for(int i=0; i<arr.length; i++){
            if(arr[i].length()==0){
                result+=" ";            
            }else{
                result+=arr[i].substring(0,1).toUpperCase();
                result+=arr[i].substring(1,arr[i].length()).toLowerCase();
                result+=" ";
            }
        }
        
        if(s.substring(s.length()-1, s.length()).equals(" ")){
            return result;
        }
        
        // 맨 마지막 " " 제거 후 반환
        return result.substring(0, result.length()-1);
    }
}
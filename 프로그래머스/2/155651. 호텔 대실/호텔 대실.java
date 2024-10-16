import java.util.*;

class Solution {
    static HashMap<Integer,Integer> hm = new HashMap<>(); //ROOM의 형태  
    
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        hm.put(0,0); //첫번째 방 생성
        c:for(int i=0; i<book_time.length; i++){
            for(int j=0; j<hm.size(); j++){
                 //시작시간이 방의 종료시간+10분 보다 크다면
                if(clock(book_time[i][0])>=hm.get(j)){
                    hm.put(j,clock(book_time[i][1])+10);
                    // System.out.println("기존방 사용 : " + book_time[i][1]); //테스트
                    continue c;
                }
            }
            hm.put(hm.size(),clock(book_time[i][1])+10);
            // System.out.println("새로운방 사용 : " + book_time[i][1]);
        }
        
        int answer = hm.size();
        return answer;
    }
    
    public int clock(String S){ //hh:mm형태를 분으로 변환
        String[] arr = S.split(":");
        int minute = Integer.parseInt(arr[0])*60 + Integer.parseInt(arr[1]);
        return minute;
    }
}
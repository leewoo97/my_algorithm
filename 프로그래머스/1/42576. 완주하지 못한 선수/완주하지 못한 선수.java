import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static HashMap<String, Integer> finish; //완주한 사람들만 들어가는 해쉬(기본값:false) 
	
	
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        setFinish(completion);
        answer = checkFinish(participant);
        return answer;
    }
	
	public static void setFinish(String[] completion) {
		//이미 한번 방문해서 true거나 null이면 sysout하고 break한다. 
		finish = new HashMap<>(); //해쉬맵 선언 및 초기화
		
		for(int i=0; i<completion.length; i++) {
			if(finish.get(completion[i])==null) {
				finish.put(completion[i], 1);
			}else {
				int currentCount = finish.get(completion[i])+1;
				finish.put(completion[i], currentCount);
			}
		}
	}
	
	public static String checkFinish(String[] participant) {
		for(int i=0; i<participant.length; i++) {
			Integer currentCount = finish.get(participant[i]);
			if(currentCount==null||currentCount.equals(0)) {
				return participant[i];
			}else {
				finish.put(participant[i],currentCount-1);
			}
		}
		return null;
	}
	
}

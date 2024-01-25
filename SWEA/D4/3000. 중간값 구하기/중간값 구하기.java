import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PriorityQueue<Integer> maxpq; //최대힙(x,y가 둘다 현재값보다 작은 경우 이용)
	static PriorityQueue<Integer> minpq; //최소힙(x,y가 둘다 현재값보다 큰 경우 이용)
	static int current_mid; //현재 중간값
	static int sum; //합계
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken()); //테스트케이스T
		
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //N개의 줄에 걸쳐서 2개씩 자연수를 준다.
			int A = Integer.parseInt(st.nextToken()); //처음 공책에 쓴 자연수
			sum = 0; //합계 선언 및 초기화
			maxpq = new PriorityQueue<>(Collections.reverseOrder()); //최대힙 선언 및 초기화
			minpq = new PriorityQueue<>(); //최소힙 선언 및 초기화
			current_mid = A; //현재 중간값 선언 및 초기화
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()); //주어진 자연수1
				int y = Integer.parseInt(st.nextToken()); //주어진 자연수2
				
				if(x>=current_mid&&y>=current_mid) { //x,y가 둘다 현재값보다 큰 경우
					setUp(x,y);
				}else if(x<=current_mid&&y<=current_mid) { //x,y가 둘다 현재값보다 작은 경우 
					setDown(x,y);
				}else if(x>=current_mid&&y<=current_mid) { //x는 현재값보다 크고 y는 현재값보다 작을때
					setX(x,y);
				}else if(x<=current_mid&&y>=current_mid) { //x는 현재값보다 작고 y는 현재값보다 클때
					setY(x,y);
				}
//				System.out.println(current_mid);
//				System.out.println(current_mid%20171109);
				
				sum += current_mid%20171109;
				sum %= 20171109;
				
			}
			System.out.println("#" + tc + " " + sum);
		}
		
	}
	
	public static void setUp(int x, int y) {
		minpq.add(x);
		minpq.add(y);
		maxpq.add(current_mid);
		current_mid = minpq.poll();
	}
	
	public static void setDown(int x, int y) {
		maxpq.add(x);
		maxpq.add(y);
		minpq.add(current_mid);
		current_mid = maxpq.poll();
	}
	
	public static void setX(int x, int y) { //x는 현재값보다 크고 y는 현재값보다 작을때
		minpq.add(x);
		maxpq.add(y);
	}
	
	public static void setY(int x, int y) { //x는 현재값보다 작고 y는 현재값보다 클때
		minpq.add(y);
		maxpq.add(x);
	}
}

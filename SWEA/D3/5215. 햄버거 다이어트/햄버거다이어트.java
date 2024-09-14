package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄버거다이어트 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N; //재료 개수
	static int R; //뽑을 재료 개수
	static int L; //넘으면 안되는 칼로리
	static int[] score; //맛에 대한 점수
	static int[] cal; //재료의 칼로리
	static int max; //정해진 칼로리 이하의 조합 중 최고의 맛점수
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken()); 
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //재료 개수 
			L = Integer.parseInt(st.nextToken()); //넘으면 안되는 칼로리
			score = new int[N];
			cal = new int[N];
			max = 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()); //i번째 재료의 맛 점수
				int b = Integer.parseInt(st.nextToken()); //i번째 재료의 칼로리
				
				score[i] = a;
				cal[i] = b;
			}
			
			for(int i=1; i<=N; i++) { 
				R = i;
				int sumCal = 0; //sumCal은 칼로리의 누적합
				int sumScore = 0; //sumScore은 점수의 누적합
				combination(0, 0, sumCal, sumScore);
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
	
	public static void combination(int idx, int sidx, int sumCal, int sumScore) {
		if(sidx == R) { //기저 조건
			if(sumCal<=L) {
				if(max<sumScore) {
					max=sumScore;
				}
			}
			return;
		}
		if(idx == N) {
			return;
		}
		combination(idx+1, sidx+1, sumCal+cal[idx] , sumScore+score[idx]); //이번 재료를 넣었을때
		combination(idx+1, sidx, sumCal, sumScore); //이번 재료를 넣지않았을때
	}
	
}

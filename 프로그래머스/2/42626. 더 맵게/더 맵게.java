import java.util.PriorityQueue;

class Solution {
    static PriorityQueue<Integer> pq;// 최소힙

	public int solution(int[] scoville, int K) {
		pq = new PriorityQueue<>(); // 최소힙 선언 및 초기화
		setPQ(scoville);
		int answer = 0;
		
		answer = whileMethod(0,K);
		
		return answer;
	}

	public static void setPQ(int[] scoville) {// 스코빌 배열원소를 전부 최소힙에 넣는다.
		for (int i = 0; i < scoville.length; i++) {
			pq.add(scoville[i]);
		}
	}

	public static int whileMethod(int cnt,int K) {
		while (true) {
			if (pq.size() == 1) {//한개만 남았을 경우
				if (pq.poll() >= K) {
					break;
				} else {
					cnt = -1;
					break;
				}
			}

			int a = pq.poll();
			int b = pq.poll();
			
			if (a >= K && b >= K) {
				break;
			}
			
			pq.add(a+(b*2));
			++cnt;
		}

		return cnt;
	}
}
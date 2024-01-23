import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //우선순위 큐(낮은 숫자 순으로 우선순위 결정, 최소힙)
		
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N ; i++) {
			int a = Integer.parseInt(br.readLine());
			if(a==0) {
				if(pq.size()==0) {
					System.out.println(0);
				}else {
				System.out.println(pq.poll());
				}
			}
			pq.add(a);
		}
	}
}

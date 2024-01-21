import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static List<nodeDetail> node;
	static int N; // 섬의 개수(1번 섬 제외)
	static boolean[] visited; //DFS방문배열
	static Long storage; //양 임시 저장소(끌어올리기)
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1]; //방문배열 설정 및 초기화
		storage = 0L; //양 임시저장소 설정 및 초기화
		
		nodeSet();
//		nodeView();
		
		DFS(1);
		
		System.out.println(node.get(1).getNum());
	}

	public static void nodeSet() throws IOException {
		node = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			node.add(new nodeDetail());
		}

		for (int i = 2; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			String type = st.nextToken(); // 늑대면 num이 -, 양이면 num이 +
			long num = Long.parseLong(st.nextToken());
			int a = Integer.parseInt(st.nextToken());

			node.get(a).setA(i);

			if (type.equals("W")) {
				node.get(i).setNum(-num);
			} else if (type.equals("S")) {
				node.get(i).setNum(num);
			}
		}
	}
	
	public static void nodeView() {
		for (int i = 1; i < node.size(); i++) {
			System.out.print(i + "번째 섬의 다음 경로  : ");
			for(int j=0; j<node.get(i).getNext().size(); j++) {
				System.out.print(node.get(i).getNext().get(j) + "번째 섬 ");
			}
			System.out.println();
			System.out.println(i + "번째 섬의 동물 : " + node.get(i).getNum());
		}
	}
	
	public static void DFS(int v) {
		visited[v] = true;
//		System.out.println("섬 방문 순서 : " + v);
		for(int i=0; i<node.get(v).getNext().size(); i++) {
			int temp = node.get(v).getNext().get(i);
			if(!visited[temp]) {
				DFS(temp);
			}
			node.get(v).addNum(storage);
			storage = 0L;
		}
		
		Long fight = storage + node.get(v).getNum(); //양과 늑대가 싸운다..! 
		
		if(fight>0) {
			storage = fight;
			node.get(v).setNum(fight);
		}else {
			storage = 0L;
		}
	}
}
class nodeDetail {//노드 상세
	List<Integer> next = new ArrayList<>(); //섬에서 갈 수 있는 모든 노드 //next에 a를 집어넣는다.
	int a; //다음노드
	long num; //늑대면 - 양이면 +

	public List<Integer> getNext() {
		return next;
	}

	public void setNext(List<Integer> next) {
		this.next = next;
	}
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		next.add(a);
	}

	public long getNum() {
		return num;
	}
	
	public void addNum(Long temp) {
		this.num += temp;
	}

	public void setNum(long num) {
		this.num = num;
	}
	
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static boolean[] array;
	
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		array = new boolean[21];
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			String type = st.nextToken();
			int value = 0;
			if(!type.equals("all")&&!type.equals("empty")) {
				value = Integer.parseInt(st.nextToken());
			}
			if(type.equals("add")) {
				add(value);
			}else if(type.equals("remove")) {
				remove(value);
			}else if(type.equals("check")) {
				check(value);
			}else if(type.equals("toggle")) {
				toggle(value);
			}else if(type.equals("all")) {
				all();
			}else if(type.equals("empty")) {
				empty();
			}
			
		}
		
		System.out.println(sb.toString());
		
	}
	
	public static void add(int x) {
		array[x] = true;
	}

	public static void remove(int x) {
		array[x] = false;
	}
	
	public static void check(int x) {
		if(array[x]) {
			sb.append("1");
			sb.append("\n");
		}else {
			sb.append("0");
			sb.append("\n");
		}
	}
	
	public static void toggle(int x) {
		if(array[x]) {
			array[x] = false;
		}else {
			array[x] = true;
		}
	}
	
	public static void all() {
		for(int i=1; i<=20; i++) {
			array[i] = true;
		}
	}
	
	public static void empty() {
		array = new boolean[21];
	}
	
	
}

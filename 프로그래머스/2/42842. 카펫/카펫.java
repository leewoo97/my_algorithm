class Solution {
    	static int[] result;
	public int[] solution(int brown, int yellow) {
		result = new int[2];
		searchYellow(brown, yellow);
		
		int[] answer = result;
        return answer;
    }
	
	public static void searchYellow(int brown, int yellow) {
		for(int i=1; i<=yellow; i++) {//가로>=세로 //가로: x, 세로: y
			if(yellow%i==0) {
				int x = yellow/i;
				int y = i;
				
				if(checkBrown(brown, x, y)) {
					return;
				}
			}
		}
	}
	
	public static boolean checkBrown(int brown,int x, int y) {
		if((2*x+2*y+4)==brown) {
			result[0] = x+2;
			result[1] = y+2;
			return true; //정답을 찾았다
		}
		return false; //정답을 찾지못했다
	}
}
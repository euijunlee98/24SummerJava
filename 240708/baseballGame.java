package day240708;

import java.util.*;

public class baseballGame {
	public static void main(String args[]) {
		Random random = new Random();
		Scanner input = new Scanner(System.in);
		
		int [] randoms = new int[3];
		List<RoundResult>Results = new ArrayList<>();
		
		while(true) {
			for(int i = 0; i < 3; i++) {
				randoms[i] = random.nextInt(9) + 1;
			}
			if(randoms[0] != randoms[1] && randoms[0] != randoms[2] && randoms[1] != randoms[2]) {
				break;
			}
		}
		
		int tries = 0;
		
		System.out.println("Number Baseball");
		System.out.println("----------------");
		
		while(tries < 10) {
			int strike = 0;
			int ball = 0;
			String record = "";
			
			System.out.println("Guess 3 numbers(1~9).");
			
			int [] myChoice = new int[3];
			for(int i = 0; i < 3; i++) {
				myChoice[i] = input.nextInt();
			}
			
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if(randoms[i] == myChoice[j]) {
						if(i == j)
							strike++;
						else
							ball++;
					}
				}
			}
			
			if(strike == 3) {
				record = strike + " strike WIN";
				System.out.println(record);
				System.out.println("");
				RoundResult result = new RoundResult(randoms, myChoice, record);
				Results.add(result);
				break;
			}else if(strike == 0 && ball ==0) {
				record = "OUT";
				System.out.println(record);
				System.out.println("");
			}else {
				record = strike + " strike, " + ball + " ball";
				System.out.println(record);
				System.out.println("");
			}
			
			RoundResult result = new RoundResult(randoms, myChoice, record);
			Results.add(result);
			tries++;
		}
		
		for(int i = 0; i < Results.size(); i++) {
			System.out.println((i+1) + "번째 시도");
			System.out.printf("랜덤 숫자: %d, %d, %d\n", Results.get(i).getComRandom()[0], Results.get(i).getComRandom()[1], Results.get(i).getComRandom()[2]);
			System.out.printf("사용자 선택: %d, %d, %d\n", Results.get(i).getMyChoice()[0], Results.get(i).getMyChoice()[1], Results.get(i).getMyChoice()[2]);
			System.out.printf("결과: %s\n\n",Results.get(i).getResult());
			
		}
		
	}
	
	static class RoundResult{
		private int [] comRandom = new int [3];
		private int [] myChoice = new int [3];
		private String result;
		
		public int[] getComRandom() {
			return comRandom;
		}
		public void setComRandom(int[] comRandom) {
			this.comRandom = comRandom;
		}
		public int[] getMyChoice() {
			return myChoice;
		}
		public void setMyChoice(int[] myChoice) {
			this.myChoice = myChoice;
		}
		public String getResult() {
			return result;
		}
		public void setResult(String result) {
			this.result = result;
		}
		
		public RoundResult(int [] comRandom, int [] myChoice, String result) {
			this.comRandom = comRandom;
			this.myChoice = myChoice;
			this.result = result;
		}
		
	}
}

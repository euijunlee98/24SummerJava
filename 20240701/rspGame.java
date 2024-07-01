package day240701;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class rspGame {
	static class RoundResult{
		private String user;
		private String computer;
		private String result;
		
		public RoundResult(String user, String computer, String result) {
			this.user = user;
			this.computer = computer;
			this.result = result;
		}
		
		public String getUser() {
			return user;
		}
		public void setUser(String pUser) {
			user = pUser;
		}
		
		public String getComputer() {
			return computer;
		}
		public void setComputer(String pComputer) {
			computer = pComputer;
		}
		
		public String getResult() {
			return result;
		}
		public void setResult(String pResult) {
			result = pResult;
		}
		
	}
	
	public static void main(String args[]) {
		System.out.println("[가위 바위 보 게임]");
		System.out.println("가위(1), 바위(2), 보(3)	//0을 입력하면 게임이 종료됩니다.");
		List<RoundResult> roundResults = new ArrayList<>();
		
		while(true) {
			Scanner input = new Scanner(System.in);
			int n = input.nextInt();
			Random random = new Random();
			int r = random.nextInt(3)+1;
			String userChoice = "";
			String computerChoice = "";
			String rResult = "";
			
			if(n == 1)
				userChoice = "가위";
			if(n == 2)
				userChoice = "바위";
			if(n == 3)
				userChoice = "보";
			
			if(r == 1)
				computerChoice = "가위";
			if(r == 2)
				computerChoice = "바위";
			if(r == 3)
				computerChoice = "보";
				
				
			System.out.println("컴퓨터:" + computerChoice + "  사용자:" + userChoice);
			if(n == r) {
				rResult = "DRAW";
				System.out.println(rResult);
			}
			else if(n == 1) {
				if(r == 2) {
					rResult = "LOSE";
					System.out.println(rResult);
				}
				else if(r == 3) {
					rResult = "WIN";
					System.out.println(rResult);
				}
			}
			else if(n == 2) {
				if(r == 1) {
					rResult = "WIN";
					System.out.println(rResult);
				}
				else if(r == 3) {
					rResult = "LOSE";
					System.out.println(rResult);
				}
			}
			else if(n == 3) {
				if(r == 1) {
					rResult = "LOSE";
					System.out.println(rResult);
				}
				else if(r == 2) {
					rResult = "WIN";
					System.out.println(rResult);
				}
			}
			else if(n == 0) {
				System.out.println("BYE");
				break;
			}
			else {
				rResult = null;
				System.out.println("1(가위), 2(바위), 3(보) 중에서 입력해주세요.");
			}
			
			RoundResult result = new RoundResult(userChoice,computerChoice,rResult);
			roundResults.add(result);
		}		
		
		System.out.println("총 결과");
		for(int i = 0; i < roundResults.size(); i++) {
			RoundResult roundresult = roundResults.get(i);
			System.out.printf("라운드: %d, 사용자: %s, 컴퓨터 %s, 결과: %s\n", (i+1), roundresult.getUser(), roundresult.getComputer(), roundresult.getResult());
		}
	}
}

package day240702;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class rrGame {
	
	//플레이어 클래스 생성
	static class Player{
		private int num; //번호
		private String name; //이름
		
		//생성자
		public Player(int num, String name) {
			this.num = num;
			this.name = name;
		}
		
		public int getNum() {
			return num;
		}
		public void setNum(int pNum) {
			num = pNum;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String pName) {
			name = pName;
		}
	}
	
	
	//메인 함수
	public static void main(String args[]) {
		int playerNum; //플레이어 수 변수 선언.
		String playerName = ""; //플레이어 이름 변수 선언.
		
		//참가할 플레이어 수 입력.
		System.out.println("[러시안 룰렛 게임]");
		System.out.print("참가할 플레이어의 수를 입력하세요: ");
		Scanner input = new Scanner(System.in);
		playerNum = input.nextInt();
		
		//플레이어 정보 차례대로 입력할 list 생성.
		List<Player> players = new ArrayList<>();
		
		//플레이어 수 만큼 플레이어 정보 입력.
		for(int i = 0; i < playerNum; i++) {
			//순서대로 이름 입력 받고 저장.
			System.out.print((i+1) + "번째 플레이어의 이름을 입력하세요: ");
			Scanner name = new Scanner(System.in);
			playerName = name.nextLine();
			
			//각 플레이어 번호, 이름 저장받은 객체를 list에 담음.
			Player player = new Player(i+1, playerName);
			players.add(player);
		}
		
		System.out.println("게임을 시작합니다.\n");
		
		int round = 1;
		
		while(players.size() > 1) { // 최후의 생존자가 남을 때까지 while문 반복.
			System.out.println("---------Round " + round + "---------");
			
			//탄창 위치 1~6까지 랜덤 설정.
			Random random = new Random();
			int quit = random.nextInt(6)+1;
			
			//남은 생존자 수보다 탄창 위치 수가 클 경우
			if(quit > players.size()) {
				for(int i = 0; i < quit; i++) {
					if(i < players.size()) {
						System.out.printf("%d번째 참가자 리볼버 돌림...\n", players.get(i).getNum()); 
						System.out.printf("%d번째 참가자 %s님 생존\n\n", players.get(i).getNum(), players.get(i).getName());
					} else if(i < quit-1){
						System.out.printf("%d번째 참가자 리볼버 돌림...\n", players.get(i-players.size()).getNum()); 
						System.out.printf("%d번째 참가자 %s님 생존\n\n", players.get(i-players.size()).getNum(), players.get(i-players.size()).getName());
						} else {
							System.out.printf("%d번째 참가자 리볼버 돌림...\n", players.get(i-players.size()).getNum()); 
							System.out.printf("사망\n");
							System.out.printf("Round%d: %d번 탄창, %d번 참가자 %s님 탈락, 생존자 인원: ", round, quit, players.get(i-players.size()).getNum(), players.get(i-players.size()).getName());
							players.remove(players.get(i-players.size())); //탈락자 제거.
							System.out.printf("%d명\n\n", players.size());
						}
					}
				} else { //그 외
					//지정된 랜덤 숫자만큼 반복.
					for(int i = 0; i < quit; i++) {	
						if(i < quit -1) {
							System.out.printf("%d번째 참가자 리볼버 돌림...\n", players.get(i).getNum()); 
							System.out.printf("%d번째 참가자 %s님 생존\n\n", players.get(i).getNum(), players.get(i).getName());
						} else {
							System.out.printf("%d번째 참가자 리볼버 돌림...\n", players.get(i).getNum());
							System.out.printf("사망\n");
							System.out.printf("Round%d: %d번 탄창, %d번 참가자 %s님 탈락, 생존자 인원: ", round, quit, players.get(i).getNum(), players.get(i).getName());
							players.remove(players.get(i)); //탈락자 제거.
							System.out.printf("%d명\n\n", players.size());
						}
					}
				}
			round++;	
			}
		
		System.out.printf("최종 생존자: %d번 참가자 %s님\n", players.get(0).getNum(), players.get(0).getName());
		System.out.println("END");
	}
}

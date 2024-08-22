package day240702;
import java.util.*;

public class reRR {
	static class Player{
		private int num;
		private String name;
		
		public Player(int num, String name) {
			this.num = num;
			this.name = name;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	
	public static void main(String[] args) {
		Scanner num = new Scanner(System.in);
		int playerNum;
		int round = 1;
		List<Player> players = new ArrayList<>();
		
		System.out.println("[러시안 룰렛 게임]");
		System.out.println("참가할 플레이어의 수를 입력하세요: ");
		playerNum = num.nextInt();
		
		for(int i = 0; i < playerNum; i++) {
			Scanner name = new Scanner(System.in);
			String playerName = "";
			
			System.out.printf("%d번째 플레이어의 이름을 입력하세요: ", i+1);
			playerName = name.nextLine();
			
			Player player = new Player(i+1, playerName);
			players.add(player);
		}
		System.out.println("게임을 시작합니다.");
		
		while(players.size() > 1) {
			Random random = new Random();
			int quit = random.nextInt(6)+1;
			
			System.out.printf("\n--------------Round %d----------------\n", round);
			
			if(quit <= players.size()) {
				for(int i = 1; i <= quit; i++) {
					if(i == quit) {
						System.out.printf("%d번째 참가자 리볼버 돌림...\n",players.get(i-1).getNum());
						System.out.println("사망");
						System.out.printf("Round%d: %d번 탄창, %d번 참가자 %s님 탈락, 생존인원: %d\n", round, quit, players.get(i-1).getNum(), players.get(i-1).getName(), players.size()-1);
						players.remove(players.get(i-1));
					} else {
						System.out.printf("%d번째 참가자 리볼버 돌림...\n",players.get(i-1).getNum());
						System.out.printf("%d번째 참가자 %s님 생존\n\n", players.get(i-1).getNum(), players.get(i-1).getName());
					}
				}
			}
			else {
				int rq = quit;
				while(quit > players.size()) {
					for(int i = 1; i <= players.size(); i++) {
						System.out.printf("%d번째 참가자 리볼버 돌림...\n",players.get(i-1).getNum());
						System.out.printf("%d번째 참가자 %s님 생존\n\n", players.get(i-1).getNum(), players.get(i-1).getName());
					}
					quit -= players.size();
				}
				for(int i = 1; i <= quit; i++) {
					if(i == quit) {
						System.out.printf("%d번째 참가자 리볼버 돌림...\n",players.get(i-1).getNum());
						System.out.println("사망");
						System.out.printf("Round%d: %d번 탄창, %d번 참가자 %s님 탈락, 생존인원: %d\n", round, rq, players.get(i-1).getNum(), players.get(i-1).getName(), players.size()-1);
						players.remove(players.get(i-1));
					} else {
						System.out.printf("%d번째 참가자 리볼버 돌림...\n",players.get(i-1).getNum());
						System.out.printf("%d번째 참가자 %s님 생존\n\n", players.get(i-1).getNum(), players.get(i-1).getName());
					}
				}
			}
			round++;
		}
		System.out.println("\n----------------------------------------------");
		System.out.printf("최후 생존자: %d번째 참가자 %s님.\n", players.get(0).getNum(), players.get(0).getName());
		System.out.println("END");
	}
}

package day240703;

import java.util.*;

public class signUp {
	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		List<User>users = new ArrayList<>();
		
		while(true) {
			System.out.println("-----------------------");
			System.out.println("|         [메뉴판]");
			System.out.println("|1. 회원 가입");
			System.out.println("|2. 로그인");
			System.out.println("|3. 종료");
			System.out.println("-----------------------");
			
			System.out.println("메뉴를 선택하시오: ");
			int choice = input.nextInt();
			
			switch(choice) {	
				case 1: //회원가입
					System.out.println("\n-----------------------");
					System.out.println("[회원 가입]\n");
					//사용자 이름 입력[가입]
					System.out.println("사용자 이름을 입력하시오: ");
					input.nextLine();
					String name = input.nextLine();
					for(int i = 0; i < users.size(); i++) {
						if(name.equals(users.get(i).getName())) {
							System.out.println("이미 존재하는 사용자 이름입니다.");
							return;
						} 
					}
					if(name.length() < 5) {
						System.out.println("사용자 이름은 최소 5자 이상이어야 합니다.");
						break;
					}
					
					//사용자 비밀번호 입력[가입]
					System.out.println("비밀번호를 입력하시오: ");
					String pw = input.nextLine();
					if(pw.length() < 5) {
						System.out.println("비밀번호는 최소 5자 이상이어야 합니다.");
						break;
					}
					
					users.add(new User(name, pw));
					System.out.println("이름: " + name + "비번: " + pw);
					System.out.println("\n**회원가입이 완료되었습니다.**\n");
					break;
				
				case 2: //로그인
					System.out.println("\n\n-----------------------");
					System.out.println("[로그인]\n");
					System.out.println("사용자 이름: ");
					input.nextLine();
					String loginName = input.nextLine();
					System.out.println("비밀번호: ");
					String loginPw = input.nextLine();
					
					User tryLogin = new User(loginName, loginPw);
					System.out.println("이름: " + tryLogin.getName() + "비번: " + tryLogin.getPassword());
					
					for(int i = 0; i < users.size(); i++) {
						if(tryLogin.getName().equals(users.get(i).getName()) && tryLogin.getPassword().equals(users.get(i).getPassword())) {
							System.out.println("\n**로그인 성공**\n");
							return;
						}
					}
					System.out.println("\n!!로그인 실패!!\n");
					
					/*if(users.contains(tryLogin)) {
						System.out.println("로그인 성공");
					}else {
						System.out.println("아이디 또는 비밀번호가 잘못되었습니다.");
						break;
					}*/
					break;
				
				case 3:
					System.out.println("종료합니다.");
					return;
				
				default:
					System.out.println("유효하지 않은 값입니다. 다시 입력해주세요.");
					break;		
			}	
		}	
	}
	
	static class User{
		private String name;
		private String password;
		
		public User(String name, String password) {
			this.name = name;
			this.password = password;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}

}

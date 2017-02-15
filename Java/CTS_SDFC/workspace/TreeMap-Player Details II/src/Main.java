import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		int i = 0, n;
		int cap;
		Scanner sc = new Scanner(System.in);
		TreeMap<Integer, Player> players = new TreeMap<>();
		
		System.out.println("Enter the number of players");
		n = sc.nextInt();
		sc.nextLine();
		
		while(i < n) {
			System.out.println("Enter the details of the player " + (++i));
			cap = sc.nextInt();
			sc.nextLine();
			players.put(cap, new Player(sc.nextLine(), sc.nextLine(), sc.nextLine()));
		}

		System.out.println("Player Details");
		for(Map.Entry<Integer, Player> m : players.entrySet()) {
			System.out.printf("%d--%s--%s--%s\n", m.getKey(), m.getValue().getName(), m.getValue().getCountry(), m.getValue().getSkill());
		}

		System.out.println("Enter the cap number of the player to be searched");
		cap = sc.nextInt();
		sc.close();

		for(Map.Entry<Integer, Player> m : players.entrySet()) {
			if(m.getKey() == cap) {
				System.out.println("Player Details");
				System.out.printf("%s--%s--%s\n", m.getValue().getName(), m.getValue().getCountry(), m.getValue().getSkill());
				return;
			}
		}
		System.out.println("Player not found");
	}

}

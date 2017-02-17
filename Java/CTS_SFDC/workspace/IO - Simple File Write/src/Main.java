import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		String playerName, teamName, noOfMatches;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the name of the player");
		playerName = sc.nextLine();
		System.out.println("Enter the team name");
		teamName = sc.nextLine();
		System.out.println("Enter the number of matches played");
		noOfMatches = sc.nextLine();
		sc.close();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("player.csv"));
		bw.write(playerName + "," + teamName + "," + noOfMatches);
		bw.close();
	}

}

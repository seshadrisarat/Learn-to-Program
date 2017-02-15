import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtility {
	ArrayList<Player> readFileData(BufferedReader br) throws IOException {
		ArrayList<Player> players = new ArrayList<>();
		String s;
		while((s = br.readLine()) != null) {
			players.add(getPlayer(s));
		}
		br.close();
		return players;
	}
	
	void writeDataToFile(ArrayList<Player> playerList) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("output.csv"));
		for(Player p : playerList) {
			bw.write(p + "\n");
		}
		bw.close();
	}
	
	Player getPlayer(String s) {
		String[] parts = s.split(",");
		return new Player(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], Integer.parseInt(parts[4]));
	}
}

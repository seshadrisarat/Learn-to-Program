
public class TeamThread extends Thread {
	Main threadMain;
	Integer numberOfPlayers;
	
	public TeamThread(Main threadMain, Integer numberOfPlayers) {
		super();
		this.threadMain = threadMain;
		this.numberOfPlayers = numberOfPlayers;
	}
	
	@Override
	synchronized public void run() {
		for(int i = 0; i < numberOfPlayers; i++) {
			threadMain.q.add(i);
		}
	}
}

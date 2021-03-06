
public class PlayerThread extends Thread {
	Main threadMain;
	Integer numberOfPlayers;
	
	public PlayerThread(Main threadMain, Integer numberOfPlayers) {
		super();
		this.threadMain = threadMain;
		this.numberOfPlayers = numberOfPlayers;
	}
	
	@Override
	synchronized public void run() {
		while(!threadMain.q.isEmpty()) {
			System.out.println("Player Thread " + threadMain.q.poll());
		}
		notifyAll();
	}
}

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		int i = 0, n = 3;
		String matchType;
		String scoreString;
		Scanner sc = new Scanner(System.in);
		SortScore[] ssList = new SortScore[3];
		
		while(i < n) {
			System.out.println("Enter the Match :");
			matchType = sc.nextLine();
			System.out.println("Enter the Scores :");
			scoreString = sc.nextLine();
			ssList[i] = new SortScore(matchType, scoreString);
			ssList[i].start();
			i++;
		}
		sc.close();
		try{  
			for(SortScore s : ssList) {
				s.join();
			}  
		}catch(Exception e){
			System.out.println(e);
		}  
		
		System.out.println("Ordered Score List");
		for(SortScore ss : ssList) {
			System.out.println("Match : " + ss.getMatchType());
			for(int s : ss.getScores()) {
				System.out.println(s);
			}
		}
	}

}

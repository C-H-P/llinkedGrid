import java.util.Scanner;

public class test {

	public static void main(String[] args) throws Exception{
		LinkedGrid lg=new LinkedGrid(201);
		lg.display();
		int attempt=0;
		int old;
		Scanner s=new Scanner(System.in);
		while(attempt<25&&!lg.check()) {
			old=lg.getRoot().getData();
			System.out.println("attempt: "+attempt+"/25");
			System.out.println("Please enter the number you would like to flood to: ");
			int newNum=s.nextInt();
			lg.flood(lg.getRoot(), old, newNum);
			lg.display();
			attempt++;
		}
		if(lg.check()==true)
			System.out.println("You won!");
		else
			System.out.println("You lose...");

	}

}

import java.util.Scanner;

public class MultipleSelectionIf_Else_If{
    public static void main(String[] args){
	    Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter your full name: ");
		String fullName = input.nextLine();
		
		System.out.print("Please enter your score: ");
		int score = input.nextInt();
		
		if (score <= 100){
		
		    if (score >= 80){
			System.out.printf("%s your score is %d: Grade is A(Outstanding)%n",fullName,score);
		}
		else if (score >= 70){
		    System.out.printf("%s your score is %d: Grade is B(Excellent)%n",fullName,score);
		}
		else if (score >= 60){
		    System.out.printf("%s your score is %d: Grade is C(Good)%n",fullName,score);
		}
		else if (score >= 50){
		    System.out.printf("%s your score is %d: Grade is D(Average)%n",fullName,score);
	    }
		else if (score >= 40){
		    System.out.printf("%s your score is %d: Grade is E(Satisfactory)%n",fullName,score);
		}
		else {
		    System.out.printf("%s your score is %d: Grade is F(Fail)%n",fullName,score);
		}
		}
		else {
		    System.out.println("Score cannot be greater than 100");
		}
		
		
		}
	}
			
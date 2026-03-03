import java.util.Scanner;

public class CandidateAssessment{
    public static void main(String[] args){
	    Scanner input = new Scanner(System.in);
		 
		System.out.print("Enter your name: ");
		String name = input.nextLine();
		
		System.out.print("Enter your English Score: ");
		int eng = input.nextInt();
		
		System.out.print("Enter your ICT Score: ");
		int ict = input.nextInt();
		
		System.out.print("Enter your Maths Score: ");
		int maths = input.nextInt();
		
		int average = (eng+ict+maths)/3;
		
		if (eng >= 70 && average >= 80) {
		    System.out.printf("Dear %s, your English score is %d and your average score is %d%nYou have been Granted employment%n",name,eng,average);
		}
		else{		    
		    System.out.printf("Dear %s, your English score is %d and your average score is %d%nYou have been Denied employment%n",name,eng,average);
		}
	}
}
		    
		    
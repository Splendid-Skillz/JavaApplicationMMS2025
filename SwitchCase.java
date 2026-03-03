import java.util.Scanner;

public class SwitchCase{
    public static void main(String[] args){
	
	   Scanner input = new Scanner(System.in);
	   
	   System.out.print("Enter your full name: ");
	   String fullName = input.nextLine();
	   
	   System.out.print("Enter your mark: ");
	   short mark = input.nextShort();
	   
	   if (mark >= 0 && mark <= 100){
	       switch(mark/10){
		       case 0:
			   case 1:
			   case 2:
			   case 3:
			       System.out.printf("%s your mark is %d: Grade is F(Fail)", fullName,mark);
			   break;
			   
			   case 4:
			       System.out.printf("%s your mark is %d: Grade is E(Satisfactory)", fullName,mark);
			   break;
			   
			   case 5:
			       System.out.printf("%s your mark is %d: Grade is D(Average)", fullName,mark);
			   break;
			   
			   case 6:
			       System.out.printf("%s your mark is %d: Grade is C(Good)", fullName,mark);
			   break;
			   
			   case 7:
			       System.out.printf("%s your mark is %d: Grade is B(Excellent)", fullName,mark);
			   break;
			   
			   case 8:
			   case 9:
			   case 10:
			       System.out.printf("%s your mark is %d: Grade is A(Outstanding)", fullName,mark);
			   break;
			   
			}
		}
		else{
		System.out.println("Mark cannot be greater than 100 or less than 0");
		}
	}
}
	
	
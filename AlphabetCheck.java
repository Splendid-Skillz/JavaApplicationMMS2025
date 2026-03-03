import java.util.Scanner;

public class AlphabetCheck{
    public static void main(String[] args){
	   Scanner input = new Scanner(System.in);
	   
	   System.out.print("Enter an alphabet(A-Z): ");
	   char alphabet = input.next().charAt(0);
	   
	   switch (alphabet){
	       case 'a':
		   case 'e':
		   case 'i':
		   case 'o':
		   case 'u':
		   case 'A':
		   case 'E':
		   case 'I':
		   case 'O':
		   case 'U':
		       System.out.printf("%c is a Vowel",alphabet);
		   break;
		   default:
		       System.out.printf("%c is a Consonant",alphabet);
		}
	}
}
		   
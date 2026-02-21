public class OperatorsPart1{
    public static void main(String[] args){
	    
		//Assignment operator(=)
		int num = 50;
		System.out.printf("The value of num is %d%n", num);
		
		//Arithmetic operators(+,-,*/,%)
		int num1 = 100;
		int num2 = 500;
		
		int addition = num1 + num2;
		System.out.printf("The sum of %d and %d is %d%n",num1,num2,addition);
		
		int subtraction = num1 - num2;
		System.out.printf("The difference between %d and %d is %d%n",num1,num2,subtraction);
		
		int multiplication = num1 * num2;
		System.out.printf("The product of %d and %d is %d%n",num1,num2,multiplication);
		
		double quotient = (double)num1/num2;
		System.out.printf("The quotient of %d/%d is %f%n",num1,num2,quotient);
		
		int remainder = num1%num2;
		System.out.printf("The remainder between %d and %d is %d%n",num1,num2,remainder);
		
		//Compound assignment operators
		num1 += num2;
		System.out.printf("The value of num1 is now %d%n",num1);
		
		num1 *= num2;
		System.out.printf("The value of num1 is now %d%n",num1);
		
		num1 -= num2;
		System.out.printf("The value of num1 is now %d%n",num1);
		
		num1 /= num2;
		System.out.printf("The value of num1 is now %d%n",num1);
		
		num1 %= num2;
		System.out.printf("The value of num1 is now %d%n",num1);
		
		//Relational operators(>,<,>=,<=,==,!=)
		int number1 = 20, number2 = 50;
		
		boolean isGreater = number1 > number2;
		System.out.printf("Is %d > %d? %b%n",number1,number2,isGreater);
		
		boolean isLess = number1 < number2;
		System.out.printf("Is %d < %d? %b%n",number1,number2,isLess);
		
		boolean isGreaterorEqual = number1 >= number2;
		System.out.printf("Is %d >= %d? %b%n",number1,number2,isGreaterorEqual);
		
		boolean isLessorEqual = number1 <= number2;
		System.out.printf("Is %d <= %d? %b%n",number1,number2,isLessorEqual);
		
		boolean isEqual = number1 == number2;
		System.out.printf("Is %d == %d? %b%n",number1,number2,isEqual);
		
		boolean isNotEqual = number1 != number2;
		System.out.printf("Is %d != %d? %b%n",number1,number2,isNotEqual);
	
	
	
	}
	}
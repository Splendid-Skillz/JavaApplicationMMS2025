public class OperatorsPart2{
    public static void main(String[] args) {
	int num1 = 70;
	int num2 = 50;
	int num3 = 120;
	
	//Logical Operators(&&, ||, !)
	boolean andResult = (num1 > num2) && (num1 > num3);
	System.out.printf("The AND result is %b%n", andResult);
	
	boolean andResults = (num1 > num2) && (num1 != num3);
	System.out.printf("The AND result is %b%n", andResults);
	
	boolean orResult = (num1 > num2) || (num1 == num3);
	System.out.printf("The OR result is %b%n", orResult);
	
	boolean notResult = !((num1 > num2) || (num1 > num3));
	System.out.printf("The NOT result is %b%n", notResult);
	
	
	// We can apply the not operator to the street light
    //if the day is dark, turn up but if it is bright, remain off
	
	// 1 and 1 = 1
	// 1 and 0 = 0
	// 0 and 1 = 0
	// 0 and 0 = 0
	
	//Unary Operators
	//pre-increament means increament before you use it
	//post-increament means increase it after you have used it
	
	
	int x = 5;
	int y = ++x;
	
	System.out.println("The value of x is " + x);
	System.out.println("The value of y is " + y);
	
	int s = 5;
	++s;
	++s;
	
	int z = ++s;
	System.out.println("The value of s is " + s);
	System.out.println("The value of z is " + z);
	
	//post increament - it will increment after
	
	x = 5;
	y = x++;
	
	System.out.println("The value of x is " + x);
	System.out.println("The value of y is " + y);
	
	//Unary Decreament Operators
	--x;
	--x;
	y = ++x;
	
	System.out.println("The value of decreament is x " + x);
	System.out.println("The value of y is " + y);
	
	
	
	
	
	
}
}
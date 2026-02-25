import java.util.Scanner;

public class Exercise2_33 {

    public static void main(String[] args) {

        // create Scanner
        Scanner input = new Scanner(System.in);

        int weight;   // weight in pounds
        int height;   // height in inches
        int bmi;      // body mass index

        // prompt user
        System.out.print("Enter weight in pounds: ");
        weight = input.nextInt();

        System.out.print("Enter height in inches: ");
        height = input.nextInt();

        // calculate BMI using integer arithmetic
        bmi = (weight * 703) / (height * height);

        // display result
        System.out.println("Your BMI is " + bmi);
        System.out.println();

        // display BMI values chart
        System.out.println("BMI VALUES");
        System.out.println("Underweight: less than 18.5");
        System.out.println("Normal:      between 18.5 and 24.9");
        System.out.println("Overweight:  between 25 and 29.9");
        System.out.println("Obese:       30 or greater");
		
		
    }
}
import java.util.Scanner;

public class Exercise4_3_0 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int score = 0;
        int answer;

        // Question 1
        System.out.println("1. What is global warming?");
        System.out.println("a) Increase in Earth's average temperature");
        System.out.println("b) Cooling of the oceans");
        System.out.println("c) Increase in earthquakes");
        System.out.println("d) Movement of continents");
        answer = input.next().charAt(0);
        if (answer == 'a')
            score++;

        // Question 2
        System.out.println("\n2. Which gas is most associated with global warming?");
        System.out.println("a) Oxygen");
        System.out.println("b) Nitrogen");
        System.out.println("c) Carbon dioxide");
        System.out.println("d) Helium");
        answer = input.next().charAt(0);
        if (answer == 'c')
            score++;

        // Question 3
        System.out.println("\n3. Which activity increases greenhouse gases?");
        System.out.println("a) Burning fossil fuels");
        System.out.println("b) Planting trees");
        System.out.println("c) Recycling");
        System.out.println("d) Using bicycles");
        answer = input.next().charAt(0);
        if (answer == 'a')
            score++;

        // Question 4
        System.out.println("\n4. What do some skeptics argue about global warming?");
        System.out.println("a) It is caused only by volcanoes");
        System.out.println("b) Climate change may also be due to natural cycles");
        System.out.println("c) The Earth has no climate changes");
        System.out.println("d) The sun does not affect climate");
        answer = input.next().charAt(0);
        if (answer == 'b')
            score++;

        // Question 5
        System.out.println("\n5. Which organization studies climate change globally?");
        System.out.println("a) FIFA");
        System.out.println("b) NASA");
        System.out.println("c) IPCC");
        System.out.println("d) WHO");
        answer = input.next().charAt(0);
        if (answer == 'c')
            score++;

        // Result
        System.out.println("\nYou got " + score + " correct answer(s).");

        if (score == 5)
            System.out.println("Excellent");
        else if (score == 4)
            System.out.println("Very good");
        else {
            System.out.println("Time to brush up on your knowledge of global warming.");
            System.out.println("You can visit these websites for more information:");
            System.out.println("https://climate.nasa.gov");
            System.out.println("https://www.ipcc.ch");
            System.out.println("https://www.noaa.gov");
        }
    }
}
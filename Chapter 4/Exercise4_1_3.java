public class Exercise4_1_3 {
    public static void main(String[] args) {

        long factorial = 1;

        System.out.println("Number\tFactorial");

        for (int i = 1; i <= 20; i++) {
            factorial = factorial * i;
            System.out.println(i + "\t" + factorial);
        }
    }
}

// Difficulty with Calculating 100!

// The main difficulty is numeric overflow.

// The long data type can store values up to about 9.22 × 10^18.

// Factorials grow extremely fast.

// 100! is approximately: 933262154439441526816992388562667004907159682643816214685929638952...

// This number is far larger than what a long variable can store, so the program would overflow and produce incorrect results.

// To compute 100! correctly, you would need a larger data type, such as Java’s BigInteger class.
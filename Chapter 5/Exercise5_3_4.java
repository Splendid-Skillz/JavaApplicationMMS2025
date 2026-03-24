public class Exercise5_3_4 {

    public static void main(String[] args) {

        System.out.printf("%-10s %-15s %-10s %-10s%n",
                "Decimal", "Binary", "Octal", "Hexadecimal");

        for (int i = 1; i <= 256; i++) {

            String binary = Integer.toBinaryString(i);
            String octal = Integer.toOctalString(i);
            String hex = Integer.toHexString(i).toUpperCase();

            System.out.printf("%-10d %-15s %-10s %-10s%n",
                    i, binary, octal, hex);
        }
    }
}
public class Exercise3_25 {
    public static void main(String[] args) {
        for (int row = 1; row <= 8; row++) {
            for (int col = 1; col <= 8; col++) {
                if ((row + col) % 2 == 0) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
public class Exercise3_22 {
    public static void main(String[] args) {
        System.out.println("N\t10*N\t100*N\t1000*N");

        for (int n = 1; n <= 5; n++) {
            System.out.println(n + "\t" + (10 * n) + "\t" + (100 * n) + "\t" + (1000 * n));
        }
    }
}
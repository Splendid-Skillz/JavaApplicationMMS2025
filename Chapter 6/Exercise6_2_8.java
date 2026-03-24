import java.util.Random;

public class Exercise6_2_8 {

    static final int FINISH_LINE = 70;

    public static void main(String[] args) throws InterruptedException {

        int tortoisePos = 1;
        int harePos = 1;

        Random rand = new Random();

        System.out.println("BANG !!!!!");
        System.out.println("AND THEY'RE OFF !!!!!");

        while (tortoisePos < FINISH_LINE && harePos < FINISH_LINE) {

            // Move tortoise
            int tMove = rand.nextInt(10) + 1;

            if (tMove <= 5) { // Fast plod
                tortoisePos += 3;
            } else if (tMove <= 7) { // Slip
                tortoisePos -= 6;
            } else { // Slow plod
                tortoisePos += 1;
            }

            // Move hare
            int hMove = rand.nextInt(10) + 1;

            if (hMove <= 2) { // Sleep
                // no move
            } else if (hMove <= 4) { // Big hop
                harePos += 9;
            } else if (hMove == 5) { // Big slip
                harePos -= 12;
            } else if (hMove <= 8) { // Small hop
                harePos += 1;
            } else { // Small slip
                harePos -= 2;
            }

            // Prevent positions < 1
            if (tortoisePos < 1) tortoisePos = 1;
            if (harePos < 1) harePos = 1;

            // Print track
            printTrack(tortoisePos, harePos);

            // Slow down output (optional)
            Thread.sleep(200);
        }

        // Determine winner
        if (tortoisePos >= FINISH_LINE && harePos >= FINISH_LINE) {
            System.out.println("It's a tie.");
        } else if (tortoisePos >= FINISH_LINE) {
            System.out.println("TORTOISE WINS!!! YAY!!!");
        } else {
            System.out.println("Hare wins. Yuch.");
        }
    }

    public static void printTrack(int tortoise, int hare) {

        for (int i = 1; i <= FINISH_LINE; i++) {

            if (i == tortoise && i == hare) {
                System.out.print("OUCH!!!");
                i += 6; // skip extra spaces since "OUCH!!!" is 7 chars
            }
            else if (i == tortoise) {
                System.out.print("T");
            }
            else if (i == hare) {
                System.out.print("H");
            }
            else {
                System.out.print(" ");
            }
        }

        System.out.println();
    }
}
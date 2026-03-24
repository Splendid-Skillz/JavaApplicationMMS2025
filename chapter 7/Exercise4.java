import java.util.*;

public class Exercise4 {

    static class Card {
        String face, suit;
        Card(String f, String s) { face = f; suit = s; }
        public String getFace() { return face; }
        public String getSuit() { return suit; }
        public String toString() { return face + " of " + suit; }
    }

    static class Deck {
        List<Card> deck = new ArrayList<>();
        int current = 0;

        String[] faces = {"Ace","Deuce","Three","Four","Five","Six",
                "Seven","Eight","Nine","Ten","Jack","Queen","King"};
        String[] suits = {"Hearts","Diamonds","Clubs","Spades"};

        public Deck() {
            for (String s : suits)
                for (String f : faces)
                    deck.add(new Card(f, s));
        }

        public void shuffle() {
            Collections.shuffle(deck);
            current = 0;
        }

        public Card deal() {
            return deck.get(current++);
        }

        private int index(String face) {
            for (int i = 0; i < faces.length; i++)
                if (faces[i].equals(face)) return i;
            return -1;
        }

        private int[] counts(Card[] h) {
            int[] c = new int[13];
            for (Card card : h)
                c[index(card.getFace())]++;
            return c;
        }

        public boolean pair(Card[] h) {
            int p = 0;
            for (int c : counts(h)) if (c == 2) p++;
            return p == 1;
        }

        public boolean twoPairs(Card[] h) {
            int p = 0;
            for (int c : counts(h)) if (c == 2) p++;
            return p == 2;
        }

        public boolean threeKind(Card[] h) {
            for (int c : counts(h)) if (c == 3) return true;
            return false;
        }

        public int evaluate(Card[] h) {
            if (threeKind(h) && pair(h)) return 6;
            if (threeKind(h)) return 3;
            if (twoPairs(h)) return 2;
            if (pair(h)) return 1;
            return 0;
        }

        public String name(int r) {
            switch (r) {
                case 6: return "Full House";
                case 3: return "Three of a Kind";
                case 2: return "Two Pairs";
                case 1: return "Pair";
                default: return "High Card";
            }
        }

        // Dealer logic
        public void improve(Card[] hand) {
            int[] c = counts(hand);
            boolean[] keep = new boolean[5];

            for (int i = 0; i < 5; i++) {
                if (c[index(hand[i].getFace())] >= 2)
                    keep[i] = true;
            }

            int replaced = 0;
            for (int i = 0; i < 5 && replaced < 3; i++) {
                if (!keep[i]) {
                    hand[i] = deal();
                    replaced++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int playerWins = 0, dealerWins = 0;

        for (int game = 1; game <= 20; game++) {
            System.out.println("\n=== Game " + game + " ===");

            Deck deck = new Deck();
            deck.shuffle();

            Card[] player = new Card[5];
            Card[] dealer = new Card[5];

            for (int i = 0; i < 5; i++) {
                player[i] = deck.deal();
                dealer[i] = deck.deal();
            }

            // show player hand
            System.out.println("Your hand:");
            for (int i = 0; i < 5; i++)
                System.out.println((i + 1) + ": " + player[i]);

            // player chooses cards
            System.out.println("Enter positions to replace (e.g., 1 3 5), or 0 to keep all:");
            String line = input.nextLine();

            if (!line.equals("0")) {
                String[] parts = line.split(" ");
                for (String p : parts) {
                    int pos = Integer.parseInt(p) - 1;
                    if (pos >= 0 && pos < 5)
                        player[pos] = deck.deal();
                }
            }

            // dealer plays automatically
            deck.improve(dealer);

            // show final hands
            System.out.println("\nYour final hand:");
            for (Card c : player) System.out.println(c);

            System.out.println("\nDealer hand:");
            for (Card c : dealer) System.out.println(c);

            int pr = deck.evaluate(player);
            int dr = deck.evaluate(dealer);

            System.out.println("\nResult:");
            System.out.println("You: " + deck.name(pr));
            System.out.println("Dealer: " + deck.name(dr));

            if (pr > dr) {
                System.out.println("You win!");
                playerWins++;
            } else if (dr > pr) {
                System.out.println("Dealer wins!");
                dealerWins++;
            } else {
                System.out.println("Tie!");
            }
        }

        // final stats
        System.out.println("\n=== FINAL RESULT ===");
        System.out.println("Player wins: " + playerWins);
        System.out.println("Dealer wins: " + dealerWins);
    }
}
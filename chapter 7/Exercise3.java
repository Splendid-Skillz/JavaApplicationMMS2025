import java.util.*;

public class Exercise3 {

    static class Card {
        String face, suit;
        Card(String f, String s) { face = f; suit = s; }
        public String getFace() { return face; }
        public String getSuit() { return suit; }
        public String toString() { return face + " of " + suit; }
    }

    static class Deck {
        private List<Card> deck = new ArrayList<>();
        private int current = 0;

        private String[] faces = {"Ace","Deuce","Three","Four","Five","Six",
                "Seven","Eight","Nine","Ten","Jack","Queen","King"};
        private String[] suits = {"Hearts","Diamonds","Clubs","Spades"};

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
            if (threeKind(h) && pair(h)) return 6; // full house
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

        // ===== DEALER LOGIC =====
        public void improveHand(Card[] hand) {
            int[] c = counts(hand);

            // mark which cards to keep
            boolean[] keep = new boolean[5];

            // keep pairs / triples
            for (int i = 0; i < hand.length; i++) {
                int idx = index(hand[i].getFace());
                if (c[idx] >= 2) keep[i] = true;
            }

            // replace up to 3 cards
            int replaced = 0;
            for (int i = 0; i < hand.length && replaced < 3; i++) {
                if (!keep[i]) {
                    hand[i] = deal();
                    replaced++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        Card[] player = new Card[5];
        Card[] dealer = new Card[5];

        // deal hands
        for (int i = 0; i < 5; i++) {
            player[i] = deck.deal();
            dealer[i] = deck.deal();
        }

        // show player hand
        System.out.println("Player Hand:");
        for (Card c : player) System.out.println(c);

        // dealer hidden
        System.out.println("\nDealer Hand: [Hidden]");

        // evaluate dealer (before)
        int before = deck.evaluate(dealer);

        // dealer improves hand
        deck.improveHand(dealer);

        // show dealer after draw
        System.out.println("\nDealer reveals hand:");
        for (Card c : dealer) System.out.println(c);

        int after = deck.evaluate(dealer);

        // evaluations
        int playerRank = deck.evaluate(player);

        System.out.println("\nResults:");
        System.out.println("Player: " + deck.name(playerRank));
        System.out.println("Dealer (before): " + deck.name(before));
        System.out.println("Dealer (after): " + deck.name(after));

        if (playerRank > after)
            System.out.println("Player wins!");
        else if (after > playerRank)
            System.out.println("Dealer wins!");
        else
            System.out.println("Tie!");
    }
}
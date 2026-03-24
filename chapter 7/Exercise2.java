import java.util.Random;
import java.util.Arrays;

public class Exercise2 {

    // ================= CARD =================
    static class Card {
        private final String face;
        private final String suit;

        public Card(String face, String suit) {
            this.face = face;
            this.suit = suit;
        }

        public String getFace() { return face; }
        public String getSuit() { return suit; }

        public String toString() {
            return face + " of " + suit;
        }
    }

    // ================= DECK =================
    static class DeckOfCards {
        private static final Random random = new Random();
        private static final int SIZE = 52;

        private Card[] deck = new Card[SIZE];
        private int currentCard = 0;

        private static final String[] faces =
            {"Ace","Deuce","Three","Four","Five","Six",
             "Seven","Eight","Nine","Ten","Jack","Queen","King"};

        private static final String[] suits =
            {"Hearts","Diamonds","Clubs","Spades"};

        public DeckOfCards() {
            int count = 0;
            for (String suit : suits)
                for (String face : faces)
                    deck[count++] = new Card(face, suit);
        }

        public void shuffle() {
            currentCard = 0;
            for (int i = 0; i < deck.length; i++) {
                int j = random.nextInt(SIZE);
                Card temp = deck[i];
                deck[i] = deck[j];
                deck[j] = temp;
            }
        }

        public Card dealCard() {
            return (currentCard < SIZE) ? deck[currentCard++] : null;
        }

        // ===== helper methods =====
        private int getFaceIndex(String face) {
            for (int i = 0; i < faces.length; i++)
                if (faces[i].equals(face)) return i;
            return -1;
        }

        private int[] getCounts(Card[] hand) {
            int[] counts = new int[13];
            for (Card c : hand)
                counts[getFaceIndex(c.getFace())]++;
            return counts;
        }

        // ===== checks =====
        public boolean pair(Card[] h) {
            int count = 0;
            for (int c : getCounts(h))
                if (c == 2) count++;
            return count == 1;
        }

        public boolean twoPairs(Card[] h) {
            int count = 0;
            for (int c : getCounts(h))
                if (c == 2) count++;
            return count == 2;
        }

        public boolean threeKind(Card[] h) {
            for (int c : getCounts(h))
                if (c == 3) return true;
            return false;
        }

        public boolean fourKind(Card[] h) {
            for (int c : getCounts(h))
                if (c == 4) return true;
            return false;
        }

        public boolean flush(Card[] h) {
            String s = h[0].getSuit();
            for (Card c : h)
                if (!c.getSuit().equals(s)) return false;
            return true;
        }

        public boolean straight(Card[] h) {
            int[] v = new int[5];
            for (int i = 0; i < 5; i++)
                v[i] = getFaceIndex(h[i].getFace());
            Arrays.sort(v);
            for (int i = 0; i < 4; i++)
                if (v[i] + 1 != v[i + 1]) return false;
            return true;
        }

        public boolean fullHouse(Card[] h) {
            boolean three = false, two = false;
            for (int c : getCounts(h)) {
                if (c == 3) three = true;
                if (c == 2) two = true;
            }
            return three && two;
        }

        // ===== ranking =====
        public int evaluateHand(Card[] h) {
            if (fourKind(h)) return 7;
            if (fullHouse(h)) return 6;
            if (flush(h)) return 5;
            if (straight(h)) return 4;
            if (threeKind(h)) return 3;
            if (twoPairs(h)) return 2;
            if (pair(h)) return 1;
            return 0;
        }

        public String getHandName(int rank) {
            switch (rank) {
                case 7: return "Four of a Kind";
                case 6: return "Full House";
                case 5: return "Flush";
                case 4: return "Straight";
                case 3: return "Three of a Kind";
                case 2: return "Two Pairs";
                case 1: return "Pair";
                default: return "High Card";
            }
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        Card[] hand1 = new Card[5];
        Card[] hand2 = new Card[5];

        System.out.println("Hand 1:");
        for (int i = 0; i < 5; i++) {
            hand1[i] = deck.dealCard();
            System.out.println(hand1[i]);
        }

        System.out.println("\nHand 2:");
        for (int i = 0; i < 5; i++) {
            hand2[i] = deck.dealCard();
            System.out.println(hand2[i]);
        }

        int rank1 = deck.evaluateHand(hand1);
        int rank2 = deck.evaluateHand(hand2);

        System.out.println("\nEvaluation:");
        System.out.println("Hand 1: " + deck.getHandName(rank1));
        System.out.println("Hand 2: " + deck.getHandName(rank2));

        if (rank1 > rank2)
            System.out.println("Hand 1 wins!");
        else if (rank2 > rank1)
            System.out.println("Hand 2 wins!");
        else
            System.out.println("It's a tie!");
    }
}
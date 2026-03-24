import java.util.Random;
import java.util.Arrays;

public class Exercise1 {

    // ================= CARD CLASS =================
    static class Card {
        private final String face;
        private final String suit;

        public Card(String face, String suit) {
            this.face = face;
            this.suit = suit;
        }

        public String getFace() {
            return face;
        }

        public String getSuit() {
            return suit;
        }

        public String toString() {
            return face + " of " + suit;
        }
    }

    // ================= DECK CLASS =================
    static class DeckOfCards {
        private static final Random randomNumbers = new Random();
        private static final int NUMBER_OF_CARDS = 52;

        private Card[] deck = new Card[NUMBER_OF_CARDS];
        private int currentCard = 0;

        private static final String[] faces =
            {"Ace", "Deuce", "Three", "Four", "Five", "Six",
             "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

        private static final String[] suits =
            {"Hearts", "Diamonds", "Clubs", "Spades"};

        public DeckOfCards() {
            int count = 0;
            for (int suit = 0; suit < suits.length; suit++) {
                for (int face = 0; face < faces.length; face++) {
                    deck[count++] = new Card(faces[face], suits[suit]);
                }
            }
        }

        public void shuffle() {
            currentCard = 0;
            for (int i = 0; i < deck.length; i++) {
                int j = randomNumbers.nextInt(NUMBER_OF_CARDS);
                Card temp = deck[i];
                deck[i] = deck[j];
                deck[j] = temp;
            }
        }

        public Card dealCard() {
            if (currentCard < deck.length)
                return deck[currentCard++];
            else
                return null;
        }

        // ================= HAND CHECK METHODS =================

        private int getFaceIndex(String face) {
            for (int i = 0; i < faces.length; i++) {
                if (faces[i].equals(face))
                    return i;
            }
            return -1;
        }

        private int[] getFaceCounts(Card[] hand) {
            int[] counts = new int[13];

            for (Card card : hand) {
                int index = getFaceIndex(card.getFace());
                counts[index]++;
            }
            return counts;
        }

        // a) Pair
        public boolean hasPair(Card[] hand) {
            int[] counts = getFaceCounts(hand);
            int pairCount = 0;

            for (int c : counts)
                if (c == 2) pairCount++;

            return pairCount == 1;
        }

        // b) Two Pairs
        public boolean hasTwoPairs(Card[] hand) {
            int[] counts = getFaceCounts(hand);
            int pairCount = 0;

            for (int c : counts)
                if (c == 2) pairCount++;

            return pairCount == 2;
        }

        // c) Three of a kind
        public boolean hasThreeOfAKind(Card[] hand) {
            int[] counts = getFaceCounts(hand);

            for (int c : counts)
                if (c == 3) return true;

            return false;
        }

        // d) Four of a kind
        public boolean hasFourOfAKind(Card[] hand) {
            int[] counts = getFaceCounts(hand);

            for (int c : counts)
                if (c == 4) return true;

            return false;
        }

        // e) Flush
        public boolean hasFlush(Card[] hand) {
            String suit = hand[0].getSuit();

            for (Card card : hand)
                if (!card.getSuit().equals(suit))
                    return false;

            return true;
        }

        // f) Straight
        public boolean hasStraight(Card[] hand) {
            int[] values = new int[5];

            for (int i = 0; i < hand.length; i++)
                values[i] = getFaceIndex(hand[i].getFace());

            Arrays.sort(values);

            for (int i = 0; i < values.length - 1; i++) {
                if (values[i] + 1 != values[i + 1])
                    return false;
            }
            return true;
        }

        // g) Full House
        public boolean hasFullHouse(Card[] hand) {
            int[] counts = getFaceCounts(hand);
            boolean hasThree = false, hasTwo = false;

            for (int c : counts) {
                if (c == 3) hasThree = true;
                if (c == 2) hasTwo = true;
            }

            return hasThree && hasTwo;
        }
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        Card[] hand = new Card[5];

        System.out.println("Your hand:");
        for (int i = 0; i < 5; i++) {
            hand[i] = deck.dealCard();
            System.out.println(hand[i]);
        }

        System.out.println("\nHand Evaluation:");

             boolean found = false;

               if (deck.hasPair(hand)) {
                System.out.println("Pair");
                 found = true;
}

              if (deck.hasTwoPairs(hand)) {
               System.out.println("Two Pairs");
                 found = true;
}

              if (deck.hasThreeOfAKind(hand)) {
               System.out.println("Three of a Kind");
                found = true;
}

              if (deck.hasFourOfAKind(hand)) {
               System.out.println("Four of a Kind");
                found = true;
}

              if (deck.hasFlush(hand)) {
               System.out.println("Flush");
                found = true;
}

              if (deck.hasStraight(hand)) {
                System.out.println("Straight");
                 found = true;
}

              if (deck.hasFullHouse(hand)) {
                System.out.println("Full House");
                 found = true;
}

              if (!found) {
                System.out.println("No combination (High Card)");
				
}
	}
}
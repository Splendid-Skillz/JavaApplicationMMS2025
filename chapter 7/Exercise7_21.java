import java.security.SecureRandom;

public class Exercise7_21 {

    private static final SecureRandom randomNumbers = new SecureRandom();
    private static final int NUMBER_OF_CARDS = 52;

    private Card[] deck = new Card[NUMBER_OF_CARDS];

    // Card class
    private static class Card {
        private final String face;
        private final String suit;

        public Card(String face, String suit) {
            this.face = face;
            this.suit = suit;
        }

        @Override
        public String toString() {
            return face + " of " + suit;
        }
    }

    // Constructor to create the deck
    public Exercise7_21() {
        String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
                          "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (int i = 0; i < deck.length; i++) {
            deck[i] = new Card(faces[i % 13], suits[i / 13]);
        }
    }

    // Fisher-Yates shuffle
    public void shuffle() {
        for (int i = deck.length - 1; i > 0; i--) {
            int j = randomNumbers.nextInt(i + 1); // 0 ≤ j ≤ i

            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    // Deal one card
    public Card dealCard(int index) {
        return deck[index];
    }

    // Main method to test
    public static void main(String[] args) {
        Exercise7_21 deckOfCards = new Exercise7_21();

        System.out.println("Before shuffle:\n");
        for (int i = 0; i < NUMBER_OF_CARDS; i++) {
            System.out.printf("%-19s", deckOfCards.dealCard(i));
            if ((i + 1) % 4 == 0) {
                System.out.println();
            }
        }

        deckOfCards.shuffle();

        System.out.println("\nAfter shuffle:\n");
        for (int i = 0; i < NUMBER_OF_CARDS; i++) {
            System.out.printf("%-19s", deckOfCards.dealCard(i));
            if ((i + 1) % 4 == 0) {
                System.out.println();
            }
        }
    }
}
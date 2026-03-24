import java.util.Random;

public class Exercise7_20 {

    // ================= ENUMS =================
    public enum Face {
        ACE, DEUCE, THREE, FOUR, FIVE, SIX,
        SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    public enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

    // ================= CARD =================
    public static class Card {
        private final Face face;
        private final Suit suit;

        public Card(Face face, Suit suit) {
            this.face = face;
            this.suit = suit;
        }

        public Face getFace() {
            return face;
        }

        public Suit getSuit() {
            return suit;
        }

        @Override
        public String toString() {
            return face + " of " + suit;
        }
    }

    // ================= DECK =================
    public static class DeckOfCards {
        private static final int SIZE = 52;
        private static final Random rand = new Random();

        private Card[] deck = new Card[SIZE];
        private int currentCard = 0;

        private static final Face[] faces = Face.values();
        private static final Suit[] suits = Suit.values();

        public DeckOfCards() {
            int count = 0;

            for (Suit suit : suits) {
                for (Face face : faces) {
                    deck[count++] = new Card(face, suit);
                }
            }
        }

        public void shuffle() {
            currentCard = 0;

            for (int i = 0; i < deck.length; i++) {
                int j = rand.nextInt(SIZE);

                Card temp = deck[i];
                deck[i] = deck[j];
                deck[j] = temp;
            }
        }

        public Card dealCard() {
            if (currentCard < SIZE)
                return deck[currentCard++];
            return null;
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        for (int i = 0; i < 5; i++) {
            System.out.println(deck.dealCard());
        }
    }
}
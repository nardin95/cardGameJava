import java.util.Arrays;
import java.util.Random;

class Deck {

    private Card[] masterDeck;
    private int spot = -1;

    public Deck() {

        int iter = 0;
        masterDeck = new Card[52];

        for(int suit = 0; suit < 4; suit++) {
            for (int rank = 0; rank < 13; rank++) {
                masterDeck[iter] = new Card(rank, suit);
                iter++;
            }
        }

    }

    public void shuffle() {
        if (spot != -1) {
            throw new IllegalStateException();
        }

        Random r = new Random();

        for (int i = masterDeck.length -1; i > 0; i--) {
            int index = r.nextInt(i+1);
            Card temp = masterDeck[index];
            masterDeck[index] = masterDeck[i];
            masterDeck[i] = temp;
        }

    }

    public boolean canDeal() {
        return (spot+1 < 52);
    }

    public Card deal() {

        if (canDeal()) {
            spot++;
            return masterDeck[spot];
        }
        else {
            throw new IllegalStateException("Deck is gone");
        }

    }

    /*public String toString() {
        return Arrays.toString(masterDeck);
    }*/
}


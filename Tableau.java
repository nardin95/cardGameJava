public class Tableau {

    private class Pile {

        private Card card;
        private Pile next;

        private Pile(Card card, Pile next) {
            this.card = card;
            this.next = next;
        }
    }

    private Pile top;
    private int pileNo = 0;

    public Tableau () {
        top = new Pile(null, null);
    }

    private void addPile(Card card) {
        top = new Pile(card, top);

        System.out.println("Added " + card.toString());
        pileNo += 1;
    }

    private boolean canMerge() {
        if (hasManyPiles()) {
            if (canPutOn(top.card, top.next.card)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    private boolean canPutOn (Card left, Card right) {
        if (left.getSuit() == right.getSuit()
                || left.getRank() >= right.getRank()) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean hasManyPiles () {
        return (pileNo >= 2);
    }

    private void mergeTwoPiles () {
        if (canMerge()) {
            System.out.println("Merged " + top.card.toString()
                    + " and " + top.next.card.toString());

            top.next = top.next.next;
            pileNo -= 1;


        }
    }

    private void results () {
        if (pileNo == 1) {
            System.out.println("Won the game!");
        }
        else {
            System.out.println("Lost the game!");
        }
    }

    public void play () {

        Deck deck = new Deck();

        deck.shuffle();

        Card tempCard;

        while(deck.canDeal()) {
            this.addPile(deck.deal());
            while(this.hasManyPiles() && this.canMerge()) {
                mergeTwoPiles();
            }
        }

        this.results();
    }

}


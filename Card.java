public class Card {

//  RANK NAME. Printable names of card ranks.

    private static final String [] rankName =
            {
                    "ace",     //   0
                    "two",     //   1
                    "three",   //   2
                    "four",    //   3
                    "five",    //   4
                    "six",     //   5
                    "seven",   //   6
                    "eight",   //   7
                    "nine",    //   8
                    "ten",     //   9
                    "jack",    //  10
                    "queen",   //  11
                    "king"     //  12
            };

//  SUIT NAME. Printable names of card suits.

    private static final String [] suitName =
            {
                    "spade",   //  0
                    "heart",   //  1
                    "diamond", //  2
                    "club"     //  3
            };

    private int rank;  //  Card rank, between 0 and 12 inclusive.
    private int suit;  //  Card suit, between 0 and  3 inclusive.

//  CARD. Constructor. Make a new CARD with the given RANK and SUIT.

    public Card(int rank, int suit)
    {
        if (0 <= suit && suit <= 3 && 0 <= rank && rank <= 12)
        {
            this.rank = rank;
            this.suit = suit;
        }
        else
        {
            throw new IllegalArgumentException("No such card.");
        }
    }

//  GET RANK. Return the RANK of this card.

    public int getRank()
    {
        return rank;
    }

//  GET SUIT. Return the SUIT of this card.

    public int getSuit()
    {
        return suit;
    }

//  TO STRING. Return a string that describes this card, for printing only. For
//  example, we might return "the queen of diamonds" or "the ace of hearts".

    public String toString()
    {
        return "the " + rankName[rank] + " of " + suitName[suit] + "s";
    }

}


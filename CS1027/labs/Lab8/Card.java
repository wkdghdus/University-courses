
public class Card implements Comparable<Card> {
	
	private String suit; // S (spade), H (heart), D (diamond), or C (club)
	private String rank; // A (ace), 2, 3, ..., 10, J (jack), Q (queen), or K (king)

	public Card (String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public String getSuit () {
		return suit;
	}
	
	public String getRank () {
		return rank;
	}
	
	public void setSuit (String suit) {
		this.suit = suit;
	}
	
	public void setRank (String rank) {
		this.rank = rank;
	}
	
	public String toString () {
		return rank + " of " + suit;
	}

	@Override
	public int compareTo(Card other){
		
		if (this.equals(other)) return 0;

		if (this.getRankValue() > other.getRankValue()){

			return 1;

		}
		else if (this.getRankValue() < other.getRankValue()){

			return -1;

		}

		if (this.getSuitValue() > other.getSuitValue()){

			return 1;

		}
		
		return -1;

	}

	public boolean equals(Card other){

		if ((this.getRank().equals(other.getRank())) && (this.getSuit().equals(other.getSuit()))){

			return true;

		}

		return false;

	}

	public int getSuitValue(){

		suit = this.getSuit();

		switch(suit){

			case "D": return 1;

			case "C": return 2;

			case "H": return 3;

			case "S": return 4;

			default: return 0;

		}

	}

	public int getRankValue(){

		rank = this.getRank();

		try{

			return Integer.valueOf(rank);

		}
		catch (NumberFormatException e){

			switch(rank){

				case "J":
				case "Q":
				case "K": 
					return 11;
	
				case "A": 
					return 12;

				default: 
					return 0;
	
			}

		}

	}

}

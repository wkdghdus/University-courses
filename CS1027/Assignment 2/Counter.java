public class Counter {

    PowerSet<Card> cardps;
    Card starter;
    
    /**
     * counter constructor
     * 
     * @param hand cards in hand
     * @param starter starting card
     */
    public Counter(Card[] hand, Card starter){

        this.starter = starter;
        this.cardps = new PowerSet<>(hand);

    }

    /**
     * Method that count points for the given power set and starter
     * 
     * @return total points
     */
    public int countPoints(){

        int points = 0;     //points
        int maxRun = 0;     //maximum length of run
        int runPoints = 0;  //point of run
        Set<Card> currSet;  //current set while 
        
        //looping through the power set of hand
        for (int i = 0; i < this.cardps.getLength(); i++){

            currSet = this.cardps.getSet(i);

            //////------- Calculating points -------//////

            // check if the set contains a pair
            if (isPair(currSet)) points += 2;

            // check if the set contains a run
            if (isRun(currSet)){

                //if the run is greater than the initial max run
                if (currSet.getLength() > maxRun){

                    maxRun = currSet.getLength();
                    runPoints = maxRun;

                }
                //if the run length is the same with the maxRun
                else if (currSet.getLength() == maxRun){

                    runPoints += maxRun;

                }

            }

            // check if the set contains Fifteen
            if (isFifteen(currSet)) points += 2;

            //check if the set contains flush
            if (isFlush(currSet) && !currSet.contains(starter)){

                //if the flush's suit is the same with the hands
                if ((currSet.getElement(0).getSuit()).equals(starter.getSuit())){

                    points += 5;

                }
                else{

                    points += 4;

                }

            }

            //check if the set contains His Knobs
            if (isHisKnobs(currSet)) points += 1;

        }

        //return the total score
        return points + runPoints;

    }

    /**
     * check the availability of a pair in a set
     * 
     * @param set
     * @return boolean value for the availability of a pair in a set
     */
    private boolean isPair(Set<Card> set){

        //check if the set contains 2 cards
        if (set.getLength() != 2) return false;

        //get the label of two cards
        String firstCard = (set.getElement(0)).getLabel();
        String secondCard = (set.getElement(1)).getLabel();

        //check if the 2 cards are identical 
        if (firstCard.equals(secondCard)){

            return true;

        }

        //if not return false
        return false;

    }

    

    /**
     * check the availability of a runs in a set
     * 
     * @param set
     * @return boolean value for the availability of a runs in a set
     */
    private boolean isRun (Set<Card> set) {
        ///////// provided code /////////
		// In this method, we are going through the given set to check if it constitutes a run of 3 or more
		// consecutive cards. To do this, we are going to create an array of 13 cells to represent the
		// range of card ranks from 1 to 13. We go through each card and increment the cell corresponding to
		// each card's rank. For example, an Ace (rank 1) would cause the first (index 0) cell to increment.
		// An 8 would cause the 8th (index 7) cell to increment. When this loop is done, the array will
		// contain 5 or less cells with values of 1 or more to represent the number of cards with each rank.
		// Then we can use this array to search for 3 or more consecutive non-zero values to represent a run.
		
		int n = set.getLength();
		
		if (n <= 2) return false; // Run must be at least 3 in length.
		
		int[] rankArr = new int[13];
		for (int i = 0; i < 13; i++) rankArr[i] = 0; // Ensure the default values are all 0.
		
		for (int i = 0; i < n; i++) {
			rankArr[set.getElement(i).getRunRank()-1] += 1;
		}

		// Now search in the array for a sequence of n consecutive 1's.
		int streak = 0;
		int maxStreak = 0;
		for (int i = 0; i < 13; i++) {
			if (rankArr[i] == 1) {
				streak++;
				if (streak > maxStreak) maxStreak = streak;
			} else {
				streak = 0;
			}
		}
		if (maxStreak == n) { // Check if this is the maximum streak.
			return true;
		} else {
			return false;
		}

	}

    /**
     * checks the availability of a Fifteen in a set
     * 
     * @param set
     * @return boolean value for availability of a Fifteen in a set
     */
    private boolean isFifteen(Set<Card> set){

        int sum = 0;

        //iterate through the cards in the power set and add their fifteen ranks
        for (int i = 0; i < set.getLength(); i++){

            sum += set.getElement(i).getFifteenRank();

        }

        if (sum == 15) return true;
        else return false;

    }

    /**
     * checks the availability of a Flush in a set
     * 
     * @param set
     * @return boolean value for the availability of a Flush in a set
     */
    private boolean isFlush(Set<Card> set){

        //check if the length of a set is four
        if (set.getLength() == 4){

            //check if all four cards have same suit
            if (set.getElement(0).getSuit().equals(set.getElement(1).getSuit()) && set.getElement(2).getSuit().equals(set.getElement(3).getSuit()) && set.getElement(0).getSuit().equals(set.getElement(2).getSuit())){

                return true;

            }

        }

        return false;

    }

    /**
     * checks the availability of a His Knobs in a set
     * 
     * @param set
     * @return boolean value for the availability of a His Knobs in a set
     */
    private boolean isHisKnobs(Set<Card> set){

        //  check if the set contains 5 cards to avoid counting the point more than once
        if (set.getLength() == 5){

            for (int i = 0; i < 5; i++){

                //check if it contains jack and if the starter has a same suit with the jack
                if (set.getElement(i).getLabel().equals("J") && !(set.getElement(i)).equals(this.starter)){

                    if ((this.starter.getSuit().equals(set.getElement(i).getSuit()))){

                        return true;
    
                    }

                }

            }

        }

        return false;

    }
    
}

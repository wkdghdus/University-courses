
public class Snail {
	
	public static char icon = '@';
	private int position;
	private QueueADT<Integer> movePattern;
	
	public Snail (int[] pattern) {

		this.position = 0;
		this.movePattern = new LinkedQueue<>();

		for (int i = 0; i < pattern.length; i++){

			(this.movePattern).enqueue(pattern[i]);

		}

	}
	
	public void move () {

		int step = (this.movePattern).dequeue();
		(this.movePattern).enqueue(step);

		if (this.position + step > SnailRace.raceLength){

			this.position = SnailRace.raceLength;

		}
		else{

			this.position += step;

		}

	}
	
	public int getPosition () {

		return this.position;

	}
	
	public void display () {

		int dashesBefore = position - 1;
        int dashesAfter = SnailRace.raceLength - position;
        for (int i = 0; i < dashesBefore; i++) {
            System.out.print("-");
        }

        System.out.print(icon);

        for (int i = 0; i < dashesAfter; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

}
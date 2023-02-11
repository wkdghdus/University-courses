
public class ClassC {

	private static int counter = 0;

	public ClassC() {
		//counter = 1;
		counter++;
	}

	public void incCounter() {
		++counter;
	}

	public int getCounter() {
		return counter;
	}

}

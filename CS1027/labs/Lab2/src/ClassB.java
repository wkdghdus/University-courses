
public class ClassB {

	private int counter = 0;

	public ClassB() {
		counter = 1;
	}

	public void incCounter() {
		++counter;
	}

	public int getCounter() {
		return counter;
	}

	public static void main(String[] args) {
		int i;
		ClassB b = new ClassB();

		i = b.counter;
		b.incCounter();
		System.out.println("i = " + i + " counter = " + b.counter);
	}

}

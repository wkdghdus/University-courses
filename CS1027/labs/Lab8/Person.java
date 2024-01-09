
public class Person implements Comparable<Person> {
	
	/* Attribute declarations */
	private String name;
	private String city;
	private String email;
			
	/**
	 * Constructor initializes the person's name and email address
	 */
	public Person(String name, String email, String city) {
		this.name = name;
		this.email = email;
		this.city = city;
	}

	/**
	 * toString to display the person's info in a clean format
	 * return String of the person's info
	 */
	public String toString() {
		String s = String.format("%10s\t\t%30s\t\t%10s", name, email, city);
		return s;
	}

	public String getName(){

		return this.name;

	}

	public String getEmail(){

		return this.email;

	}

	public String getCity(){

		return this.city;

	}

	/**
	 * compareTo determines the order of the contacts
	 */
	public int compareTo(Person other) {

		if ((ContactList.sortBy) == 'n'){

			return -1 * this.compareByName(other);

		}
		else if ((ContactList.sortBy) == 'e'){

			return this.compareByEmail(other);

		}
		else if ((ContactList.sortBy) == 'c'){

			return this.compareByCity(other);

		}

		return 0;
	}

	private int compareByName(Person other){

		return (this.name).compareTo(other.getName());
		
	}

	private int compareByEmail(Person other){

		return (this.email).compareTo(other.getEmail());
		
	}

	private int compareByCity(Person other){

		return (this.city).compareTo(other.getCity());
		
	}

}
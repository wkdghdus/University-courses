public class TestDataTypes {

	public static void main(String[] args) {
		int[] testArray = { 2, 4, 6 }; // This statement creates an array of size 3 storing values 2, 4, and 6
		DataTypes data1 = new DataTypes(2, 3.3, 's', true, new ClassA(3, testArray));
		DataTypes data2 = new DataTypes(2, 3.3, 's', true, new ClassA(3, testArray));

		// Test data1 == data2
		if (data1 == data2) System.out.println("data1 == data2 is true");
		else System.out.println("data1 == data2 is false");
		
		// Test data1.intVar == data2.intVar
		if (data1.intVar == data2.intVar) System.out.println("data1.intVar == data2.intVar is true");
		else System.out.println("data1.intVar == data2.intVar is false");
		
		// Test data1.charVar == data2.charVar
		if (data1.charVar == data2.charVar) System.out.println("data1.charVar == data2.charVar is true");
		else System.out.println("data1.charVar == data2.charVar is false");
		
		// Test data1.boolVar == data2.boolVar
		if (data1.boolVar == data2.boolVar) System.out.println("data1.boolVar == data2.boolVar is true");
		else System.out.println("data1.boolVar == data2.boolVar is false");
		
		// Test data1.doubleVar == data2.doubleVar
		if (data1.doubleVar == data2.doubleVar) System.out.println("data1.doubleVar == data2.doubleVar is true");
		else System.out.println("data1.doubleVar == data2.doubleVar is false");
		
		// Test data1.varA == data2.varA
		if (data1.varA == data2.varA) System.out.println("data1.varA == data2.varA is true");
		else System.out.println("data1.varA == data2.varA is false");
		
		// Test data1.varA.numItems == data2.varA.numItems
		if (data1.varA.numItems == data2.varA.numItems) System.out.println("data1.varA.numItems == data2.varA.numItems is true");
		else System.out.println("data1.varA.numItems == data2.varA.numItems is false");
		
		// Test data1.varA.arrItems == data2.varA.arrItems		
		if (data1.varA.arrItems == data2.varA.arrItems) System.out.println("data1.varA.arrItems == data2.varA.arrItems is true");
		else System.out.println("data1.varA.arrItems == data2.varA.arrItems is false");
	}

}

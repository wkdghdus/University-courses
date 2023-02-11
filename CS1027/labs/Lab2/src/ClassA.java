public class ClassA {
	private final int SIZE_ARRAY = 5;
	public int numItems;
	public int[] arrItems;

	public ClassA(int n, int[] arr) {
		numItems = n;
		arrItems = arr;
	}

	public ClassA() {
		numItems = 0;
		arrItems = new int[SIZE_ARRAY];
	}
	
	public boolean equals(ClassA otherObject) {
		
		//if numItem values aren't the same
		if (this.numItems != otherObject.numItems) {
			
			return false;
		
		}
		
		//check if both arrays are null
		if ((this.arrItems.length == 0) && (otherObject.arrItems.length == 0)){
			
			return true;
			
		}
		
		//check if there are any different elements in two class' arrItem
		for (int i = 0; i < this.arrItems.length; i++) {
			
			if (this.arrItems[i] != otherObject.arrItems[i]) {
				
				return false;
				
			}
			
		}
		
		//condition is satisfied 
		return true;
		
	}
}

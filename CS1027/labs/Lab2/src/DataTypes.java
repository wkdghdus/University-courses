public class DataTypes {
	public int intVar;
	public double doubleVar;
	public char charVar;
	public boolean boolVar;
	public ClassA varA;

	public DataTypes() {
	}

	public DataTypes(int newIntVar, double newDoubleVar, char newCharVar, boolean newBoolVar, ClassA newVarA) {
		intVar = newIntVar;
		doubleVar = newDoubleVar;
		charVar = newCharVar;
		boolVar = newBoolVar;
		varA = newVarA;
	}
	
	public boolean equals(DataTypes otherObject) {
		
		//checking all instance variables
		if ((this.intVar == otherObject.intVar) && (this.doubleVar == otherObject.doubleVar) && (this.charVar == otherObject.charVar) && (this.boolVar == otherObject.boolVar)) {
			
			//checking varA instance variable
			if (this.varA.equals(otherObject.varA)) {
				
				return true;
				
			}
			
		}

		//return false if the condition is not satisfied
		return false;
		
	}
}

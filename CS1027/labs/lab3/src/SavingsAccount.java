
public class SavingsAccount extends BankAccount {
	
	private double interestRate;
	
	public SavingsAccount(double initialAmount, double rate) {
			
		super(initialAmount);
		this.interestRate = rate;
		
	}
	
	public double getInterestRate() {
		
		return this.interestRate;
		
	}
	
	public void calculateInterest() {
		
			this.deposit(this.getBalance() * this.interestRate);
			
		
	}
	
	public String toString() {
		
		String rtn = "SavingsAccount: balance $"+ this.getBalance()+", interest rate " + this.interestRate + "%";
		
		return rtn;
	}
	
	
	public static void main(String[] args) {
        SavingsAccount myAccount = new SavingsAccount(100.0,0.15);
        myAccount.calculateInterest();
        System.out.println(myAccount.toString());
	}
	
}




public class ThriftySaver extends SavingsAccount {
	
	private boolean withdrawal;
	public ThriftySaver(String name, double initial){
		super(name, initial);
		withdrawal=false;
	}
	public boolean withdraw(double amount){
		if(!withdrawal&&super.withdraw(amount)){
			withdrawal=true;
			return true;
		} else{
			return false;
		}
	}
	public void update(){
		balance *= 1.03;
		int bal = (int)(balance*100);
		balance = bal/100.0;
		withdrawal=false;
	}
}

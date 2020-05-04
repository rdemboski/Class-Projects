package package_11;

public class ATMClass
{
	//Constant values
	private static final int DEFAULT_ID = 0000;
	private static final String DEFAULT_NAME = "No name given";
	private static final double DEFAULT_BALANCE = 0.00;
	
	//Member variables
	private int userId;
	private String userName;
	private double userBalance;
	
	//Constructors
	public ATMClass()
	{
		userId = DEFAULT_ID;
		userName = DEFAULT_NAME;
		userBalance = DEFAULT_BALANCE;
	}
	
	
	public ATMClass(double balance, int id, String name)
	{
		id = DEFAULT_ID;
		name = DEFAULT_NAME;
		balance = DEFAULT_BALANCE;
	}
	
	
	public ATMClass(ATMClass copied)
	{
		userId = copied.userId;
		userName = copied.userName;
		userBalance = copied.userBalance;
	}
	
	
	//Methods
	public int getId()
	{
		return userId;
	}
	
	
	public String getName()
	{
		return userName;
	}
	
	
	public double getBalance()
	{
		return userBalance;
	}
	
	
	public boolean makeWithdrawal(double amount)
	{

		if (amount > userBalance)
		{
			System.out.println("Insufficient funds");
			return false;
		}
		userBalance -= amount;
		System.out.println("Withdrawl accepted. New balance: $" + userBalance);
		return true;
		
	}
	
	
	public void makeDeposit(double amount)
	{
		
		userBalance = (amount + userBalance);
		
		System.out.println("Deposit accepted. New balance: $" + userBalance);
		
	}
	
}

package lab2;

//Defines a credit card
//NEEDS MODIFICATION

public class CreditCard
{
	private Money balance;		//the current balance
	private Money creditLimit;	//the approved credit limit
	private Person owner;		//the owner of the credit card

	//Constructor creates a credit card for the Person parameter
	//with an approved credit limit of the Money parameter
	//and sets the balance to a Money amount of zero 
	public CreditCard(Person newCardholder, Money limit) 
	{
		this.owner = newCardholder;
		this.creditLimit = limit;
		this.balance = new Money(0.0);
		//MUST COMPLETE THIS
	}

	//Accessor method returns the balance
	public Money getBalance()
	{
		return this.balance;
		//MUST COMPLETE THIS
	}

	//Accessor method returns the credit limit
	public Money getCreditLimit()
	{
		return this.creditLimit;
		//MUST COMPLETE THIS
	}

	//Accessor method returns information about the owner
	public String getPersonals()
	{
		return this.owner.toString();
		//MUST COMPLETE THIS
	}
	
	//Method to make a charge to the credit card (but only if
	//the credit limit will not be exceeded)
	public void charge(Money amount)
	{
		if(this.balance.add(amount).compareTo(this.creditLimit) > 0) {
			System.out.println("ERROR, credit limit exceeded.");
		}
		else {
			this.balance = this.balance.add(amount);
		}
		//MUST COMPLETE THIS
	}

	//Method to make a payment to the credit card
	public void payment(Money amount)
	{
		this.balance = this.balance.subtract(amount);
		//MUST COMPLETE THIS
	}		
}
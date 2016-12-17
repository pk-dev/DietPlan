package kottarath.assign2.omicron;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Priya
 * Class DietPlanOrder contains the logic for placing order, accept payment and generate invoice.
 */
public class DietPlanOrder {

	//Constructor
	public DietPlanOrder(String customerName,String fileName, MealType mealType, boolean isDinnerDeliveryRequired,int dayOfWeek) 
	{
		//set customer name
		this.customerName=customerName;
		//if dayOfWeek entered is out of the 1-7 range, current day of week is chosen by default.
		if(dayOfWeek<1 || dayOfWeek>7)
		{
			DateFormat dateFormat = new SimpleDateFormat("u");
			dayOfWeek=Integer.parseInt(dateFormat.format(date)); 
		}
		//set diet plan
		//default plan is set to highCarbDietPlan
		switch(mealType)
		{
			case VEGAN:plan=new VeganDietPlan(fileName,dayOfWeek,isDinnerDeliveryRequired);
					  	break;
			case LOW_CARB:plan=new LowCarbDietPlan(fileName, dayOfWeek, isDinnerDeliveryRequired);
					  	break;
			case HIGH_CARB:plan=new HighCarbDietPlan(fileName, dayOfWeek, isDinnerDeliveryRequired);
						break;
			default: plan=new HighCarbDietPlan(fileName, dayOfWeek, isDinnerDeliveryRequired);
					break;
		}
		
		
	}
	
	//data members
	private String customerName;
	private DietPlan plan;
	private boolean paymentStatus;
	private Date date = new Date();//to get current date
	
	//getters
	public String getCustomerName()
	{
		return customerName;
	}
	public DietPlan getPlan()
	{
		return plan;
	}
	public boolean getPaymentStatus()
	{
		return paymentStatus;
	}
	
	//setters
	public void setCustomerName(String customerName)
	{
		this.customerName=customerName;
	}
	public void setPlan(DietPlan plan)
	{
		this.plan=plan;
	}
	public void setPaymentStatus(boolean paymentStatus)
	{
		this.paymentStatus=paymentStatus;
	}
	
	
	//Methods
	
	/**
	 * Returns the cost of plan ordered.
	 * @author Priya
	 * @return Double
	 * 
	 */
	public double getCost()
	{
		return getPlan().getCostOfPlan();
	}
	
	/**
	 * Returns the status of payment.
	 * @author Priya
	 * @param cardName
	 * @param cardNumber
	 * @param amount
	 * @return Boolean
	 * 
	 */
	public boolean acceptPayment(String cardName,String cardNumber,double amount)
	{
		//set payment status to true if the card is valid.
		if(IsCardVerified(cardName,cardNumber))
			setPaymentStatus(true);
		else
			setPaymentStatus(false);
		
		return getPaymentStatus();
	}
	
	/**
	 * Generates and prints Invoice in the following format:
	 * Your Invoice: 
	 * <customer name>, <today's date>, Diet plan for <requested day of week>: 
	 * Lunch: <recipe name> : <description> : <calories> : $<cost of recipe>
	 * Dinner: <recipe name> : <description> : <calories> : $<cost of recipe(+delivery fee, if applicable)>
	 * Total cost: $<total cost of lunch and dinner>
	 * 
	 * @author Priya
	 */
	public void generateInvoice()
	{
		//to get current date:
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    
	    //to generate invoice:
		StringBuilder invoice=new StringBuilder();
		invoice.append("Your Invoice: "+"\n");
		invoice.append(getCustomerName()+", ");
		invoice.append(dateFormat.format(date)+", ");
		invoice.append(plan.showPlan()+"\n");
		invoice.append(String.format("Total cost: $%.2f", getCost()));
		
		System.out.println(invoice.toString());
		
	}
	
	/**
	 * Performs Master Card and VISA card validations and returns the status.
	 * @author Priya
	 * @param cardName String
	 * @param cardNumber String
	 * @return Boolean
	 */
	private boolean IsCardVerified(String cardName,String cardNumber)
	{
		boolean isValid=false;
		Pattern pattern;
		Matcher matcher;
		//checks for card number validity
		//Regular expression is used for validation.
		//Leading or trailing white spaces are ignored. But spaces in between cardName matters.
		if(cardName.trim().equalsIgnoreCase("Master Card"))
		{
			//Master card validation logic:A length of 16 digits. 
			//First digit is a 5 and second digit is in the range 1 through 5 inclusive. 
			pattern=Pattern.compile("^5[1-5][0-9]{14}$");
			matcher=pattern.matcher(cardNumber);
			isValid=matcher.matches();
			
		}
		else if(cardName.trim().equalsIgnoreCase("VISA"))
		{
			//VISA validation logic:The length is either 13 or 16 digits with a first digit of 4.
			pattern=Pattern.compile("^4([0-9]{12}|[0-9]{15})$");
			matcher=pattern.matcher(cardNumber);
			isValid=matcher.matches();
			
		}
		
		return isValid;
	}
	
	

}

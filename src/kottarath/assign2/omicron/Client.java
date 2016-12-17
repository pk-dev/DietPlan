package kottarath.assign2.omicron;

/**
 * @author Priya
 * Client class
 */
public class Client {

	
	public Client() {
		// TODO Auto-generated constructor stub
	}
	
	//prints payment status - for testing
	public static void printPaymentStatus(Boolean isPaymentSuccess)
	{
		if(isPaymentSuccess)
			System.out.println("Thank you for your payment!");
		else
			System.out.println("Sorry, Your payment was not successful. Please enter a valid VISA or Master Card details.");
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			
		/*---------------1-------------*/
		// Place a diet plan order
		// Input: Customer name, file name, Meal type, Is Dinner delivery required(bool), day of week for which diet plan is required.
		DietPlanOrder planOrder1=new DietPlanOrder("Mary Jones","recipes.txt",MealType.VEGAN,false,1);//vegan,no delivery.
		
		//Payment input: Card type, Card number, cost of plan.
		boolean isPaymentSuccess1b=planOrder1.acceptPayment("VISA ", "4123456789012345",planOrder1.getCost());
		printPaymentStatus(isPaymentSuccess1b);
		
		//Generate Invoice 
		planOrder1.generateInvoice();
				
		
		/*---------------2-------------*/
		System.out.println();
		
		//Low carb plan
		DietPlanOrder planOrder2=new DietPlanOrder("Tom Sawyer","lowCarb.txt",MealType.LOW_CARB,true,4);
		
		//incorrect card number formats
		boolean isPaymentSuccess2a=planOrder2.acceptPayment("Master card", "1234567890",planOrder2.getCost());
		printPaymentStatus(isPaymentSuccess2a);
		
		boolean isPaymentSuccess2b=planOrder2.acceptPayment("visa", "09876544567889023468998889",planOrder2.getCost());
		printPaymentStatus(isPaymentSuccess2b);
		
		//correct card number
		boolean isPaymentSuccess2c=planOrder2.acceptPayment("Master Card", "5334245906713468",planOrder2.getCost());
		printPaymentStatus(isPaymentSuccess2c);
		
		planOrder2.generateInvoice();
		
		
		/*---------------3-------------*/
		System.out.println();
		
		//high carb plan, delivery required.
		//dayOfWeek outside of 1-7 range: today's day should be taken in this case.
		DietPlanOrder planOrder3=new DietPlanOrder("Priya","recipes.txt",MealType.HIGH_CARB,true,0);
		
		boolean isPaymentSuccess3a=planOrder3.acceptPayment("Master card", "5334245906713468",planOrder3.getCost());
		printPaymentStatus(isPaymentSuccess3a);
		
		planOrder3.generateInvoice();
		
		
		/*---------------4-------------*/
		System.out.println();
		
		//incorrect input file format:expecting alert messages on what all records where omitted(for testing)
		DietPlanOrder planOrder4=new DietPlanOrder("Arun","vegan.txt",MealType.VEGAN,true,3);
		planOrder4.generateInvoice();

		
		}
		catch(Exception e)
		{
			e.getMessage();
			
		}

	}

}

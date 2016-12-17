package kottarath.assign2.omicron;

/**
 * @author Priya
 * Class HighCarbDietPlan inherits from abstract class DietPlans which implements the interface DietPlan.
 */
public class HighCarbDietPlan extends DietPlans {

	//Constructor
	/**
	 * @author Priya
	 * @param fileName
	 * @param dayOfWeek
	 * @param isDinnerDeliveryRequired
	 */
	public HighCarbDietPlan(String fileName, int dayOfWeek,
			boolean isDinnerDeliveryRequired) {
		super(fileName, dayOfWeek, isDinnerDeliveryRequired);
		
	}

}

package kottarath.assign2.omicron;

/**
 * @author Priya
 * Class LowCarbDietPlan inherits from abstract class DietPlans which implements the interface DietPlan.
 */
public class LowCarbDietPlan extends DietPlans {

	//Constructor
	/**
	 * @author Priya
	 * @param fileName
	 * @param dayOfWeek
	 * @param isDinnerDeliveryRequired
	 */
	public LowCarbDietPlan(String fileName, int dayOfWeek,
			boolean isDinnerDeliveryRequired) {
		super(fileName, dayOfWeek, isDinnerDeliveryRequired);
		
	}

}

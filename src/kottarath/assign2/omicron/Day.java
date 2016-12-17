package kottarath.assign2.omicron;

/**
 * @author Priya
 * Enumerator Day is used to get the day of week
 */
public enum Day {
	MONDAY(1),
	TUESDAY(2),
	WEDNESDAY(3),
	THURSDAY(4),
	FRIDAY(5),
	SATURDAY(6),
	SUNDAY(7);
	
	private int value;
	private Day(int value)
	{
		this.value=value;
	}
	
	//returns integer value corresponding to each day
	public int getValue()
	{
		return value;
	}

}

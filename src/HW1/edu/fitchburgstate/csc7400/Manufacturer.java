/**
 * Class		: Object-Oriented Design and Analysis
 * Professor	: Orlando Montalvo
 * Assignment	: HW 2 
 * Date			: 2018-09-18
 * Students		: Mounika Pailla (@01393337)
 */
package HW1.edu.fitchburgstate.csc7400;


/** 
 * enum declaration of Manufacturer - predefined values for Guitar's Manufacturer
 * 
 * @author Mounika Pailla
 * @version 1.0
 */
public enum Manufacturer {
	Fender,
	Martin,
	Gibson,
	Collings,
	Olson,
	Ryan,
	PRS;
	
	/**
	* Gets string value of the Manufacturer enum value
	* 
	* @return string/IllegalArgumentException Manufacturer of the guitar/
	* 		exception in case of the enum value is invalid
	*/
	public String toString() 
	{
		switch(this)
		{
			case Fender: return "Fender";
			case Martin: return "Martin";
			case Gibson: return "Gibson";
			case Collings: return "Collings";
			case Olson: return "Olson";
			case Ryan: return "Ryan";
			case PRS: return "PRS";
			default: throw new IllegalArgumentException();
		}			  
	}
}

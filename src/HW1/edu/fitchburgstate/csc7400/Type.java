/**
 * Class		: Object-Oriented Design and Analysis
 * Professor	: Orlando Montalvo
 * Assignment	: HW 2 
 * Date			: 2018-09-18
 * Students		: Mounika Pailla (@01393337)
 */
package HW1.edu.fitchburgstate.csc7400;


/** 
 * enum declaration of Type - Predefined values (Electric/Accoustic) for Guitar's type 
 * 
 * @author Mounika Pailla
 * @version 1.0
 */
public enum Type {
	Electric,
	Accoustic;
	
	/**
	* Gets string value of the Type enum value
	* 
	* @return string/IllegalArgumentException type of the guitar/
	* 		exception in case of the enum value is invalid
	*/
	public String toString() 
	{
		switch(this)
		{
			case Electric: return "Electric";
			case Accoustic: return "Accoustic";
			default: throw new IllegalArgumentException();
		}			  
	}
}

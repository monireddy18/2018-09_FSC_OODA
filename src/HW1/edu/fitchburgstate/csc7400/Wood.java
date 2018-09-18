/**
 * Class		: Object-Oriented Design and Analysis
 * Professor	: Orlando Montalvo
 * Assignment	: HW 2 
 * Date			: 2018-09-18
 * Students		: Mounika Pailla (@01393337)
 */
package HW1.edu.fitchburgstate.csc7400;


/** 
 * enum declaration of Wood - predefined values for Guitar's topwood and backwood type
 * 
 * @author Mounika Pailla
 * @version 1.0
 */
public enum Wood {
	Indian_Rosewood,
	Brazilian_Rosewood,
	Mahogany,
	Maple,
	Cocobolo,
	Cedar,
	Adirondack,
	Alder,
	Sitka;
	
	/**
	* Gets string value of the Wood enum value
	* 
	* @return string/IllegalArgumentException kind of wood of the guitar/
	* 		exception in case of the enum value is invalid
	*/
	public String toString() 
	{
		switch(this)
		{
			case Indian_Rosewood: return "Indian Rosewood";
			case Brazilian_Rosewood: return "Brazilian Rosewood";
			case Mahogany: return "Mahogany";
			case Maple: return "Maple";
			case Cocobolo: return "Cocobolo";
			case Cedar: return "Cedar";
			case Adirondack: return "Adirondack";
			case Alder: return "Alder";
			case Sitka: return "Sitka";
			default: throw new IllegalArgumentException();
		}			  
	}
}

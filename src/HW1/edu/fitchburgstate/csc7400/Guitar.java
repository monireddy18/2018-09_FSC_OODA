/**
 * Class		: Object-Oriented Design and Analysis
 * Professor	: Orlando Montalvo
 * Assignment	: HW 2 
 * Date			: 2018-09-18
 * Students		: Mounika Pailla (@01393337)
 */

package HW1.edu.fitchburgstate.csc7400;

import HW1.edu.fitchburgstate.csc7400.Wood;
import HW1.edu.fitchburgstate.csc7400.Manufacturer;
import HW1.edu.fitchburgstate.csc7400.Type;

/**
 * Guitar contains information about guitars from Rick's music store.
 * This data contains manufacturer's serial number, price and GuitarSpec which has further attributes of a guitar. 
 * This information can be used to search guitars in the inventory.
 * 
 * @author Mounika Pailla
 * @version 1.1
 *
 */
public class Guitar {

	/**
	 * The guitar's manufacturer serial number
	 */
	private String serialNumber;

	/**
	 * Rick's price for the guitar
	 */
	private double price;	
	
	/**
	 * guitarSpec object to hold the specifications of Guitar
	 */
	private GuitarSpec guitarSpec;
	
	/**
	 * Full constructor
	 * 
	 * @param serialNumber manufacturer serial number
	 * @param price store price
	 * @param manufacturer the guitar's manufacturer
	 * @param model the manufacturers model
	 * @param type guitar type (electric/accoustic)
	 * @param backWood the wood used for the guitar body
	 * @param topWood the wood used for the guitar's face
	 */
	public Guitar(String serialNumber, double price, 
			Manufacturer manufacturer, String model, 
			Type type, Wood backWood,
			Wood topWood) {		
		
		this.serialNumber = serialNumber;
		this.price = price;
		//Build a GuitarSpec object
		GuitarSpec spec = new GuitarSpec(manufacturer, model,type, backWood, topWood);
	    this.guitarSpec = spec;
	}	
	
	/**
	 * Returns the manufacturer serial number	 
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * Returns store price of guitar
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the store price of the guitar
	 */
	public void setPrice(double newPrice) {
		this.price = newPrice;
	}
	
	/**
	 * Sets specifications of the guitar - GuitarSpec object
	 * 
	 * @param spec GuitarSpec object
	 */
	  
	 public void setSpec(GuitarSpec spec)
	 {
		 this.guitarSpec = spec;
	 }

	/**
	 * Returns specifications of the guitar - GuitarSpec object
	 * 
	 * @return GuitarSpec returns GuitarSpec object of a guitar
	 */
	  
	 public GuitarSpec getSpec()
	 {
		 return guitarSpec;
	 }
	
}

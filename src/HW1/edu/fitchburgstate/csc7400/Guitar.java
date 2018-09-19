/**
 * Class		: Object-Oriented Design and Analysis
 * Professor	: Orlando Montalvo
 * Assignment	: HW 1 
 * Date			: 2018-09-15
 * Students		: Mounika Pailla (@01393337)
 */

package HW1.edu.fitchburgstate.csc7400;

/**
 * Guitar contains information about guitars from Rick's music store.
 * This data contains manufacturer, manufacturer's serial number, price, model,
 * type of guitar and so on. This information can be used to search guitars 
 * in the inventory.
 * 
 * @author Mounika Pailla
 * @version 1.0
 *
 */
public class Guitar {

	/**
	 * Full constructor
	 * 
	 * @param serialNumber Guitar's serial number in Rick's inventory
	 * @param price price of the guitar
	 * @param manufacturer the guitar's manufacturer name
	 * @param model the guitar's model
	 * @param type guitar type (electric/accoustic)
	 * @param backWood the wood used for the guitar body
	 * @param topWood the wood used for the guitar's face
	 */
	public Guitar(String serialNumber, double price, 
			String manufacturer, String model, 
			String type, String backWood,
			String topWood) {		
		
		this.serialNumber = serialNumber;
		this.price = price;
		this.manufacturer = manufacturer;
		this.model = model;
		this.type = type;
		this.backWood = backWood;
		this.topWood = topWood;
	}

	/**
	 * Returns the serial number of the guitar	 
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * Returns price of the guitar
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
	 * Returns the name of the manufacturer
	 * @return manufacturer name of the manufacturer
	 */
	public String getManufacturer() {
		return this.manufacturer;
	}

	/**
	 * Returns the model of the guitar
	 * @return model model of the guitar
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Returns the guitar type
	 * @return type type of guitar
	 */
	public String getType() {
		return type;
	}

	/**
	 * Returns the type of wood used in the body
	 * @return backWood type of wood used in the body
	 */
	public String getBackWood() {
		return backWood;
	}

	/**
	 * Returns the type of wood used in the face
	 * @return topWood type of wood used in the face
	 */
	public String getTopWood() {
		return topWood;
	}

	/**
	 * The guitars serial number
	 */
	private String serialNumber;

	/**
	 * The name of the manufacturer
	 */
	private String manufacturer;

	/**
	 * The model name of the guitar
	 */
	private String model;

	/**
	 * The guitar type (electric/acoustic)
	 */
	private String type;

	/**
	 * The wood used for the back of the guitar
	 */
	private String backWood;

	/**
	 * The wood used for the face of the guitar
	 */
	private String topWood;

	/**
	 * Rick's price for the guitar
	 */
	private double price;
}

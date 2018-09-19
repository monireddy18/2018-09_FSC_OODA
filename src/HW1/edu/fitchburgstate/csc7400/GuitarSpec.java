/**
 * Class		: Object-Oriented Design and Analysis
 * Professor	: Orlando Montalvo
 * Assignment	: HW 2 
 * Date			: 2018-09-18
 * Students		: Mounika Pailla (@01393337)
 */
package HW1.edu.fitchburgstate.csc7400;

/**
 * GuitarSpec contains information about guitars from Rick's music store.
 * This data contains manufacturer, model, type of guitar and type of used in the guitars.
 * This information can be used to search guitars in the inventory.
 * 
 * @author Mounika Pailla
 * @version 1.0
 *
 */
public class GuitarSpec {
	
	private String model;
	private Manufacturer manufacturer; 
	private Type type;
	private Wood backWood, topWood;

	/**
	 * Constructor of GuitarSpec with below parameters
	 * 
	 * @param Manufacturer Guitar's manufacturer
	 * @param model Guitar's Model
	 * @param type Guitar's Type
	 * @param backWood Guitar's BackWood
	 * @param topWood Guitar's TopWood
	 */
	public GuitarSpec(Manufacturer manufacturer, String model, Type type,
	              Wood backWood, Wood topWood)
	{
		    this.manufacturer = manufacturer;
		    this.model = model;
		    this.type = type;
		    this.backWood = backWood;
		    this.topWood = topWood;
	}
	 
	 /**
	  * Matches each guitar with search guitar
	  * @param guitarspec GuitarSpec Object for each guitar
	  * @return Boolean returns true if a guitar matches with search guitar, false if not.
	  */	 
	 public Boolean Match(GuitarSpec guitarspec)
	 {
		 String model=""; 
		/**'this' refers to object of SearchGuitar through which the method is called 
		 * and guitarspec refers to GuitarSpec object that is passed as a parameter
		 */		 
		 if(this.getModel() != null && !this.getModel().equals(""))
		 {
			model = this.getModel().toLowerCase();    
		 }		 
		 //check if every attribute is null or empty and return false
		 if(this.getManufacturer() == null && ((this.getModel() == null) || (this.getModel().equals("")))
				 && this.getType() == null && this.getBackWood() == null && this.getTopWood() == null)
			 return false;		 
		 //compare all the properties of guitar
		 if ((this.getManufacturer() == null ) || (this.getManufacturer() == guitarspec.getManufacturer())) 
		 {
			 //ignore lowercase/uppercase while comparing
			 if ((this.getModel() == null) || (this.getModel().equals("")) 
					 || (model.equalsIgnoreCase(guitarspec.getModel())))
			 {
				 if ((this.getType() == null ) || (this.getType() == guitarspec.getType()))
				 {
					 if ((this.getBackWood() == null ) || (this.getBackWood() == guitarspec.getBackWood()))
					 {
						 if ((this.getTopWood() == null ) || (this.getTopWood() == guitarspec.getTopWood()))
							 return true;
					 }
				 }
			}
		}
		return false;
	 }
	 
	 /**
	  * Gets manufacturer of the Guitar
	  * 
	  * @return Manufacturer Guitar's manufacturer
	  */	 
	  public Manufacturer getManufacturer() 
	  {
	    return manufacturer;
	  }
	  
	  /**
	   * Sets manufacturer of the guitar with the value passed as a parameter
	   * 
	   * @param manufacturer Guitar's manufacturer
	   */
	  public void setManufacturer(Manufacturer builder) 
	  {
		    this.manufacturer = builder;
	  }
	  
	  /**
	   * Gets model of the guitar
	   * 
	   * @return model Guitar's model
	   */
	  public String getModel() 
	  {
	    return model;
	  }
	  
	  /**
	   * Sets model of the guitar with the value passed as a parameter
	   * 
	   * @param model string value of Guitar's model
	   */
	  public void setModel(String model) 
	  {
		    this.model = model;
	  }
	  
	  /**
	   * Gets Type of the guitar 
	   * 
	   * @return type Guitar's type(electric/accoustic)
	   */
	  public Type getType() 
	  {
	    return type;
	  }
	  
	  /**
	   * Sets Type of the guitar with the value passed as a parameter
	   * 
	   * @param type Guitar's type(electric/accoustic)
	   */
	  public void setType(Type type) 
	  {
		    this.type = type;
	  }
	  
	  /**
	   * Returns Wood used for the back of the guitar 
	   * 
	   * @param backWood Guitar's backWood type
	   */
	  public Wood getBackWood() 
	  {
	    return backWood;
	  }
	  
	  /**
	   * Sets Backwood value of the guitar with the value passed as a parameter
	   * 
	   * @param Wood Guitar's wood value for backWood
	   */
	  public void setBackWood(Wood backWood) 
	  {
		    this.backWood = backWood;
	  }
	  
	  /**
	   * Returns Wood used for the body of the guitar 
	   * 
	   * @param topWood Guitar's topWood type
	   */
	  public Wood getTopWood() 
	  {
	    return topWood;
	  }
	  
	  /**
	   * Sets Topwood value of the guitar with the value passed as a parameter
	   * 
	   * @param Wood Guitar's wood value for topWood
	   */
	  public void setTopWood(Wood topWood) 
	  {
		    this.topWood = topWood;
	  }
	

}

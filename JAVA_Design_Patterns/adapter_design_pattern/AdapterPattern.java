package adapter_design_pattern; // Import package of Design patterns

interface WebDriver // Define an interface called WebDriver
{
	public void getElement(); // Method to get an element
	public void selectElement(); // Method to select an element
}

class ChromeDriver implements WebDriver // Create a class ChromeDriver that implements the WebDriver interface
{
	@Override
	public void getElement() // Implement the getElement method
	{
		System.out.println("Get element from ChromeDriver"); // Print a message
	}

	@Override
	public void selectElement() // Implement the selectElement method
	{
		System.out.println("Select element from ChromeDriver"); // Print a message
	}
}

class IEDriver // Create a class IEDriver
{
	public void findElement() // Define a method to find an element
	{
		System.out.println("Find element from IEDriver"); // Print a message
	}

	public void clickElement() // Define a method to click an element
	{
		System.out.println("Click element from IEDriver"); // Print a message
	}
}

class WebDriverAdapter implements WebDriver // Create a class WebDriverAdapter that implements the WebDriver interface
{
	IEDriver ieDriver; // Reference to an IEDriver object

	public WebDriverAdapter(IEDriver ieDriver) // Constructor to create a WebDriverAdapter with an IEDriver
	{
		this.ieDriver = ieDriver; // Initialize the IEDriver reference
	}

	@Override
	public void getElement() // Implement the getElement method
	{
		ieDriver.findElement(); // Delegate the operation to the IEDriver
	}

	@Override
	public void selectElement() // Implement the selectElement method
	{
		ieDriver.clickElement(); // Delegate the operation to the IEDriver
	}
}

public class AdapterPattern
{
	public static void main(String[] args) // Main method
	{
		ChromeDriver a = new ChromeDriver(); // Create an instance of ChromeDriver
		a.getElement(); // Call the getElement method of ChromeDriver
		a.selectElement(); // Call the selectElement method of ChromeDriver

		IEDriver e = new IEDriver(); // Create an instance of IEDriver
		e.findElement(); // Call the findElement method of IEDriver
		e.clickElement(); // Call the clickElement method of IEDriver

		WebDriver wID = new WebDriverAdapter(e); // Create a WebDriverAdapter with an IEDriver
		wID.getElement(); // Call the getElement method of the adapted IEDriver
		wID.selectElement(); // Call the selectElement method of the adapted IEDriver
	}
}

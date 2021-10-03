
import java.util.List;

public class PhoneValidator {
	
	int phoneNumberLength = 12;
	List<Country> countryList = List.of(
			new Country("+315", "UK", 12),
			new Country("+40", "RO", 13),
			new Country("+370", "LT", 12)
			);
			
	public PhoneValidator() {
		
	}
	
	private String removePlusSign(String phoneNumber) {
		String noPlusNumber = phoneNumber;
		if (phoneNumber != null && phoneNumber.charAt(0) == '+') {
			noPlusNumber = phoneNumber.substring(1);
		}
		
			return noPlusNumber;	
	}
	
	public boolean validateNumber(String phoneNumber)
    {
		
		if (phoneNumber.startsWith("8"))
		{
			phoneNumber = "+370" + phoneNumber.substring(1);
		}
		
		if (phoneNumber.length() != phoneNumberLength)
			return false;
		
		if (phoneNumber.startsWith("+")) {
			for (int i=0; i<phoneNumber.substring(1).length(); i++)		
				if (!Character.isDigit(phoneNumber.substring(1).charAt(i))) 
					return false;
		}	
		else {
			for (int i=0; i<phoneNumber.length(); i++)		
				if (!Character.isDigit(phoneNumber.charAt(i))) 
					return false;
		}
		
        return true;
    }

    public boolean validateNumber(String phoneNumber, String country)
    {
    	if (phoneNumber.startsWith("8"))
		{
			phoneNumber = "+370" + phoneNumber.substring(1);
		}
    	
    	if (phoneNumber.startsWith("+")) {

    		for (int i=0; i<phoneNumber.substring(1).length(); i++)	{
    			if (!Character.isDigit(phoneNumber.substring(1).charAt(i))) {
					return false;
					
				}
			}
    	}
		else {
			for (int i=0; i<phoneNumber.length(); i++)		
				if (!Character.isDigit(phoneNumber.charAt(i))) 
					return false;
		}
    	
        return validateCountry(phoneNumber, country);
    }
	
	private boolean validateCountry(String phoneNumber, String countryName) {
		if (!countryList.isEmpty()) {
			for (Country country : countryList) {

				if (	phoneNumber.length() == country.getNumberLength() && 
						countryName == country.getCountryName() && 
						phoneNumber.contains(country.getNumberPrefix())) {
					return true;
				}
			}
		}
		return false;	
	}	
	
}

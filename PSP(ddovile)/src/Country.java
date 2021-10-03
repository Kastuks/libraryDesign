
public class Country {
	
	private String numberPrefix;
	private String countryName;
	private int numberLength;
	
	public Country (String numberPrefix, String countryName, int numberLength) {
		
		this.numberPrefix = numberPrefix;
		this.countryName = countryName;
		this.numberLength = numberLength;
		
	}
	
	public String getNumberPrefix() {
		return this.numberPrefix;
	}
	public String getCountryName() {
		return this.countryName;
	}
	public int getNumberLength() {
		return this.numberLength;
	}
	
	
	
}

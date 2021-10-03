
public class EmailValidator {
	
	String[] tlds = {"lt", "com", "stud.vu.lt"};
	String[] domains = {"gmail", "mif", "hotmail"};
	String[] illegalSymbols = {";", "$", "&"};
	
	public boolean correctDomain (String domain) {

		for (String x : domains) {
			if (domain.contains(x)) {
				
				for (String y : tlds) {
					if (domain.contains(y))
						return true;	
				}
			}
		}
		return false;
	}
	
	public boolean validateEmail(String email)
    {
    	
    	String domain = email.substring(email.indexOf('@')+1);
    	String tld = domain.substring(domain.indexOf('.')+1);
    	
    	for (String x : illegalSymbols) {
    		
    		if (email.contains(x)) 
    			return false;
    	}
    	
    	if (!email.contains("@")) {
    		return false;
    	}
    	
    	if (!domain.contains(".")) {
    		return false;
    	}
    			
    	if (domain.toLowerCase() != domain) {
    		return false;
    	}

    	if (tld.length() < 2) {
    		return false;
    	}
    				
    	if (!correctDomain(domain)) {
    		return false;
    	}
    			
        return true;
    }
}

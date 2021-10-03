
public class PasswordValidator {
	
	private char[] specialSymbols = {'*', '/', '-'};
	int minLength = 10;
	
	public PasswordValidator() {
		
	}
	
    public boolean validatePassword(String password, int minLength)
    {
    	
    	if (password.length() >= minLength)
    	{
    		for (int i=0; i<password.length(); i++)
    		{
    			for (char x : this.specialSymbols)
    			if (password.toCharArray()[i] == x)
    			{
    				if (password.toLowerCase() != password)
    				{
    					return true;
    				}
    				else
    					return false;
    			}

    		}
    		return false;
    	}
    	return false;
        
    }
 
    public boolean validatePassword(String password, char[] specialSymbols)
    {
    	if (password.length() >= this.minLength)
    	for (int i=0; i<password.length(); i++)
		{
			for (char x : specialSymbols) {
				if (password.toCharArray()[i] == x)
				{
				
					if (password.toLowerCase() != password)
					{
						return true;
					}
					else
						return false;
				}
			}
			
		}
        return false;
    }

    public boolean validatePassword(String password)
    {
    	if (password.length() >= this.minLength) {
    		for (int i=0; i<password.length(); i++)
    		{
    			for (char x : this.specialSymbols) {
    				if (password.toCharArray()[i] == x)
    				{
    				
    					if (password.toLowerCase() != password)
    					{
    						return true;
    					}
    					else
    						return false;
    				}
    			}
    				
    		}
    	}
    	return false;
    }
}

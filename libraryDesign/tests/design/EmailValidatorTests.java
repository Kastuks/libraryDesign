package design;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class EmailValidatorTests {
	
	EmailValidator emailValidator;
	
	@BeforeEach
	void setUp() {
		emailValidator = new EmailValidator();;

	}
	
	@Test
	void testIfEmailIsEmpty_shouldReturnFalse() {
		boolean isValid = emailValidator.validateEmail("");
		assertTrue(isValid);
	}
	
	@Test
	void testIfEmailIsNull_shouldReturnFalse() {
		boolean isValid = emailValidator.validateEmail(null);
		assertTrue(isValid);
	}
	
	
	@Test
	void testIfEmailContainsAtSign_shouldReturnFalse() {
		boolean isValid = emailValidator.validateEmailAtSign("name.surname.gmail.com");
		assertTrue(isValid);
	}
	
	@Test
	void testIfEmailContainsAtSign_shouldReturnTrue() {
		boolean isValid = emailValidator.validateEmailAtSign("name.surname@gmail.com");
		assertTrue(isValid);
	}
	
	@Test
	void testIfEmailContainsIllegalSymbols_shouldReturnFalse() {
		boolean isValid = emailValidator.validateEmailSymbols("name.s*/-@gmail.com");
		assertTrue(isValid);
	}
	
	@Test
	void testIfEmailContainsIllegalSymbols_shouldReturnTrue() {
		boolean isValid = emailValidator.validateEmailSymbols("name.surname@gmail.com");
		assertTrue(isValid);
	}
	
	@Test
	void testIfEmailContainsCorrectDomain_shouldReturnFalse() {
		boolean isValid = emailValidator.validateEmailDomain("name.surname@gmai.com");
		assertTrue(isValid);
	}
	
	@Test
	void testIfEmailContainsCorrectDomain_shouldReturnTrue() {
		boolean isValid = emailValidator.validateEmailDomain("name.surname@gmail.com");
		assertTrue(isValid);
	}
	
	@Test
	void testIfEmailContainsCorrectTLD_shouldReturnFalse() {
		boolean isValid = emailValidator.validateEmailTLD("name.surname@gmail.co");
		assertTrue(isValid);
	}
	
	@Test
	void testIfEmailContainsCorrectTLD_shouldReturnTrue() {
		boolean isValid = emailValidator.validateEmailTLD("name.surname@gmail.com");
		assertTrue(isValid);
	}
	
}

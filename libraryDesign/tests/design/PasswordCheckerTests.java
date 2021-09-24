package design;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class PasswordCheckerTests {
	
	
	PasswordChecker passwordChecker;
	@BeforeEach
	void setUp() {
		passwordChecker = new PasswordChecker();
	}
	
	@Test
	void testPassword_shouldReturnTrue() {
		boolean isValid = passwordChecker.validatePassword("Q1.abba");
		assertTrue(isValid);
	}
	
	@Test
	void testPasswordIsNull_shouldReturnFalse() {
		boolean isValid = passwordChecker.validatePassword(null);
		assertTrue(isValid);
	}
	
	@Test
	void testPasswordIsEmpty_shouldReturnFalse() {
		boolean isValid = passwordChecker.validatePassword("");
		assertTrue(isValid);
	}
	@Test
	void testPasswordLengthMinLength_shouldReturnFalse() {
		boolean isValid = passwordChecker.validatePassword(10, "qsdadsxsar12qwtr"); 
		assertTrue(isValid);
	}
	
	@Test
	void testPasswordUpperCaseLetters_shouldReturnFalse() {
		boolean isValid = passwordChecker.validatePassword("qr!12qwtr");
		assertTrue(isValid);
	}
		
	@Test
	void testPasswordSpecialSymbols_shouldReturnFalse() {
		boolean isValid = passwordChecker.validatePassword("qrA12qwtr");
		assertTrue(isValid);
	}
	
}

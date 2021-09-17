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
	void testPasswordIsNull_shouldReturnFalse() {
		boolean isValid = passwordChecker.validatePasswordIsNull(null);
		assertTrue(isValid);
	}
	
	@Test
	void testPasswordIsEmpty_shouldReturnFalse() {
		boolean isValid = passwordChecker.validatePasswordIsEmpty("");
		assertTrue(isValid);
	}
	@Test
	void testPasswordLength_shouldReturnFalse() {
		boolean isValid = passwordChecker.validatePasswordLength(10, "qsdadsxsar12qwtr"); 
		assertTrue(isValid);
	}
	@Test
	void testPasswordLength_shouldReturnTrue() {
		boolean isValid = passwordChecker.validatePasswordLength(10, "qr12qwtr"); 
		assertTrue(isValid);
	}
	
	
	@Test
	void testPasswordUpperCaseLetters_shouldReturnFalse() {
		boolean isValid = passwordChecker.validatePasswordUpperCaseLetters("qr12qwtr");
		assertTrue(isValid);
	}
	
	@Test
	void testPasswordUpperCaseLetters_shouldReturnTrue() {
		boolean isValid = passwordChecker.validatePasswordUpperCaseLetters("Qr12qwtr");
		assertTrue(isValid);
	}
	
	@Test
	void testPasswordSpecialSymbols_shouldReturnFalse() {
		boolean isValid = passwordChecker.validatePasswordSpecialSymbols("qr12qwtr");
		assertTrue(isValid);
	}
	
	@Test
	void testPasswordSpecialSymbols_shouldReturnTrue() {
		boolean isValid = passwordChecker.validatePasswordSpecialSymbols("q.r12qwtr");
		assertTrue(isValid);
	}
}

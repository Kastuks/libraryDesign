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
	void testPasswordLength() {
		boolean isValid = passwordChecker.validatePasswordLength(10, "qr12qwtr"); 
		assertTrue(isValid);
	}
	
	@Test
	void testPasswordUpperCaseLetters() {
		boolean isValid = passwordChecker.validatePasswordUpperCaseLetters("qr12qwtr");
		assertTrue(isValid);
	}
	
	@Test
	void testPasswordSpecialSymbols() {
		boolean isValid = passwordChecker.validatePasswordSpecialSymbols("qr12qwtr");
		assertTrue(isValid);
	}
}

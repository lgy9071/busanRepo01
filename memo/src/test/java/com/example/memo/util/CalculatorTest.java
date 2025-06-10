package com.example.memo.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	Calculator calculator = new Calculator();
	
	@Test
	void testDivisionByZero() {
		assertThrows(NullPointerException.class, () -> calculator.divide(10, 0), "IllegalArgumentException이 발생해야 합니다.");
	}
	
	//@Test
	void testFalse() {
		assertFalse(calculator.subtract(10, 2) == 5, "10 - 2는 5가 아니어야 합니다.");
	}
	
	//@Test
	void testTrue() {
		assertTrue(calculator.multiply(3, 3) == 9, "3 * 3은 9이어야 합니다.");
	}
	
	//@Test
	void testNotEquals() {
		int result = calculator.add(2, 2);
		assertNotEquals(5, result, "2+2는 5가 아니어야 합니다.");
	}
	
	//@Test
	void testDividtion() {
		int result = calculator.divide(6, 2);
		assertEquals(3, result);
	}
	
	//@Test
	void testmultiplytion() {
		int result = calculator.multiply(2, 4);
		assertEquals(8, result);
	}
	
	
	//@Test
	void testSubtraction() {
		int result = calculator.subtract(3, 5);
		assertEquals(-2, result);
	}
	
	//@Test
	void testAddtion() {
		int result = calculator.add(3, 5);
		
		assertEquals(6, result, 1, "8에서 오차 +1 -1을 허용합니다."); //result 값이 8이길 기대한다
	}															//3번째 숫자: 오차 허용 범위

}

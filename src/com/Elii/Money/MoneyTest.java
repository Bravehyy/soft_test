package com.Elii.Money;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class MoneyTest {

	@ParameterizedTest
	@DisplayName("Money边界值分析测试")
	@CsvFileSource(resources="/com/Elii/Money/Money边界值分析测试用例.csv",numLinesToSkip=1)
	void testNormalBoundary(Integer num,Integer locks,Integer stocks,Integer barrels,Double result) {
		assertEquals(Money.forMoney(locks, stocks, barrels),result,0.001);
	}
	
	@ParameterizedTest
	@DisplayName("NextDate健壮性测试")
	@CsvFileSource(resources="/com/Elii/Money/Money健壮性测试用例.csv",numLinesToSkip=1)
	void testRobustBoundary(Integer num,Integer locks,Integer stocks,Integer barrels,Double result) {
		assertEquals(Money.forMoney(locks, stocks, barrels),result,0.001);
	}

	@ParameterizedTest
	@DisplayName("NextDate最坏情况测试")
	@CsvFileSource(resources="/com/Elii/Money/Money最坏情况测试用例.csv",numLinesToSkip=1)
	void testWorstCaseBoundary(Integer num,Integer locks,Integer stocks,Integer barrels,Double result) {
		assertEquals(Money.forMoney(locks, stocks, barrels),result,0.001);
	}

	@ParameterizedTest
	@DisplayName("NextDate健壮最坏情况测试")
	@CsvFileSource(resources="/com/Elii/Money/Money健壮最坏情况测试用例.csv",numLinesToSkip=1)
	void testRobustWorstCaseBoundary(Integer num,Integer locks,Integer stocks,Integer barrels,Double result) {
		assertEquals(Money.forMoney(locks, stocks, barrels),result,0.001);
	}
}
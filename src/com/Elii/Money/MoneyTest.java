package com.Elii.Money;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class MoneyTest {

	@ParameterizedTest
	@DisplayName("Money�߽�ֵ��������")
	@CsvFileSource(resources="/com/Elii/Money/Money�߽�ֵ������������.csv",numLinesToSkip=1)
	void testNormalBoundary(Integer num,Integer locks,Integer stocks,Integer barrels,Double result) {
		assertEquals(Money.forMoney(locks, stocks, barrels),result,0.001);
	}
	
	@ParameterizedTest
	@DisplayName("NextDate��׳�Բ���")
	@CsvFileSource(resources="/com/Elii/Money/Money��׳�Բ�������.csv",numLinesToSkip=1)
	void testRobustBoundary(Integer num,Integer locks,Integer stocks,Integer barrels,Double result) {
		assertEquals(Money.forMoney(locks, stocks, barrels),result,0.001);
	}

	@ParameterizedTest
	@DisplayName("NextDate��������")
	@CsvFileSource(resources="/com/Elii/Money/Money������������.csv",numLinesToSkip=1)
	void testWorstCaseBoundary(Integer num,Integer locks,Integer stocks,Integer barrels,Double result) {
		assertEquals(Money.forMoney(locks, stocks, barrels),result,0.001);
	}

	@ParameterizedTest
	@DisplayName("NextDate��׳��������")
	@CsvFileSource(resources="/com/Elii/Money/Money��׳������������.csv",numLinesToSkip=1)
	void testRobustWorstCaseBoundary(Integer num,Integer locks,Integer stocks,Integer barrels,Double result) {
		assertEquals(Money.forMoney(locks, stocks, barrels),result,0.001);
	}
}
package com.Elii.NextDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class NextDateTest {

	@ParameterizedTest
	@DisplayName("NextDate�߽�ֵ��������")
	@CsvFileSource(resources="/com/Elii/NextDate/NextDate�߽�ֵ������������.csv",numLinesToSkip=1)
	void testNormalBoundary(Integer num,Integer year,Integer month,Integer day,String type) {
		assertEquals(NextDate.forNextDay(year, month, day),type);
	}
	
	@ParameterizedTest
	@DisplayName("NextDate��׳�Բ���")
	@CsvFileSource(resources="/com/Elii/NextDate/NextDate��׳�Բ�������.csv",numLinesToSkip=1)
	void testRobustBoundary(Integer num,Integer year,Integer month,Integer day,String type) {
		assertEquals(NextDate.forNextDay(year, month, day),type);
	}
	
	@ParameterizedTest
	@DisplayName("NextDate��������")
	@CsvFileSource(resources="/com/Elii/NextDate/NextDate������������.csv",numLinesToSkip=1)
	void testWorstCaseBoundary(Integer num,Integer year,Integer month,Integer day,String type) {
		assertEquals(NextDate.forNextDay(year, month, day),type);
	}

	@ParameterizedTest
	@DisplayName("NextDate��׳��������")
	@CsvFileSource(resources="/com/Elii/NextDate/NextDate��׳������������.csv",numLinesToSkip=1)
	void testRobustWorstCaseBoundary(Integer num,Integer year,Integer month,Integer day,String type) {
		assertEquals(NextDate.forNextDay(year, month, day),type);
	}

}

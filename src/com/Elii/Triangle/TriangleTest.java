package com.Elii.Triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TriangleTest {

	@ParameterizedTest
	@DisplayName("三角形边界值分析测试")
	@CsvFileSource(resources="/com/Elii/Triangle/三角形边界值分析测试用例.csv",numLinesToSkip=1)
	void testNormalBoundary(Integer num,Integer a,Integer b,Integer c,String type) {
		assertEquals(Triangle.classify(a, b, c),type);
	}

	@ParameterizedTest
	@DisplayName("三角形健壮性测试")
	@CsvFileSource(resources="/com/Elii/Triangle/三角形健壮性测试用例.csv",numLinesToSkip=1)
	void testRobustBoundary(Integer num,Integer a,Integer b,Integer c,String type) {
		assertEquals(Triangle.classify(a, b, c),type);
	}
	
	@ParameterizedTest
	@DisplayName("三角形最坏情况测试")
	@CsvFileSource(resources="/com/Elii/Triangle/三角形最坏情况测试用例.csv",numLinesToSkip=1)
	void testWorstCaseBoundary(Integer num,Integer a,Integer b,Integer c,String type) {
		assertEquals(Triangle.classify(a, b, c),type);
	}

	@ParameterizedTest
	@DisplayName("三角形健壮最坏情况测试")
	@CsvFileSource(resources="/com/Elii/Triangle/三角形健壮最坏情况测试用例.csv",numLinesToSkip=1)
	void testRobustWorstCaseBoundary(Integer num,Integer a,Integer b,Integer c,String type) {
		assertEquals(Triangle.classify(a, b, c),type);
	}
}

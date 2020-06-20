package com.Elii.NextDate;

import static org.junit.Assert.*;


import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class NextDateTest {
	private int year,month,day;
	private String result;

	@Before
	public void setUp() throws Exception {
	}

	public NextDateTest(int year, int month, int day, String result) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.result = result;
	}

	@Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(
				new Object[][] { 
					{ 2999, 4, 5, "年输入错误" }, 
					{ 2020, 15, 4, "月输入错误" }, 
					{ 2020, 5, 32, "日输入错误" }, 
					{ 2020, 6, 31, "日输入错误" },
					{ 2019, 2, 29, "日输入错误" },
					{ 2020, 2, 4, "2020 2 5" },
					{ 2020, 7, 31, "2020 8 1" },
					{ 2018, 12, 31, "2019 1 1" },
					{ 2018, 6, 30, "2018 7 1" },
					{ 2019, 2, 28, "2019 3 1" },
		});
	}

	@Test
	public void test() {
		assertEquals(this.result, NextDate.forNextDay(year, month, day));
	}

}
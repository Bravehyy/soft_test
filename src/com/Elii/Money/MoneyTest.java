package com.Elii.Money;

import static org.junit.Assert.*;


import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class MoneyTest {
	private int num_lock,num_stock,num_barrel;
	private double result;

	@Before
	public void setUp() throws Exception {
	}

	public MoneyTest(int num_lock,int num_stock,int num_barrel,double result) {
		this.num_lock = num_lock;
		this.num_stock = num_stock;
		this.num_barrel = num_barrel;
		this.result = result;
	}

	@Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(
				new Object[][] { 
					{ 70, 80, 90, 1420.0 }, 
					{ 80, 80, 90, 0.0 }, 
					{ 70, 90, 90, 0.0 }, 
					{ 70, 80, 100, 0.0 },
					{ 1, 2, 3, 18.0 },
					{ 15, 10, 10, 133.75 }
		});
	}

	@Test
	public void test() {
		assertEquals(this.result, Money.forMoney(num_lock, num_stock, num_barrel),0.001);
	}

}
package com.Elii.Triangle;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TriangleTest {
	private int a, b, c;
	private String type;

	@Before
	public void setUp() throws Exception {
	}

	public TriangleTest(int a, int b, int c, String type) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.type = type;
	}

	@Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(
				new Object[][] { 
					{ 2, 4, 5, "一般三角形" }, 
					{ 3, 3, 4, "等腰三角形" }, 
					{ 4, 4, 4, "等边三角形" }, 
					{ 2, 2, 5, "非三角形" },
					{ 2, 2, 4, "非三角形" }
		});
	}

	@Test
	public void testClassify() {
		assertEquals(this.type, Triangle.classify(a, b, c));
	}

}

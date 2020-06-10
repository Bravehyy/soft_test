package experiment7;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class VirusTest {
	private boolean c1,c2,c3;
	private int answer;
	
	
	public VirusTest(boolean c1, boolean c2, boolean c3, int answer) {
		super();
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
		this.answer = answer;
	}

	@Parameters
	public static Collection<Object[]> getData(){
		return Arrays.asList(new Object[][]{
				{true,true,true,1},
				{true,true,false,2},
				{false,false,true,3},
				{false,false,false,4}
		});
	}
	@Test
	public void test() {
		assertEquals(this.answer,Virus.classify(c1, c2, c3));
	}

}

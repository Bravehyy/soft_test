package experiment8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class VirusTest {


	@ParameterizedTest
	@CsvSource({"true,true,true,1","true,true,false,2","false,true,true,3","false,true,false,4"})
	void test(boolean c1,boolean c2,boolean c3,int result) {
		assertEquals(Virus.classify(c1, c2, c3),result);
	}

}

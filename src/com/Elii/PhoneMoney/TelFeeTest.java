package com.Elii.PhoneMoney;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TelFeeTest {

	@ParameterizedTest
	@DisplayName("TelFee一般等价类测试")
	@CsvSource({"'20200602030405','20200602030545',0.1","'20200602030505','20200603030505',143.0"})
	void testWeakNormalEqual(String strT,String strE,Double result) {
		assertEquals(TelFee.Fee(strT, strE),result,0.001);
	}

	@ParameterizedTest
	@DisplayName("TelFee健壮等价类测试")
	@CsvSource({"'20200602030405','20200602030405',0.0","'20200602030406','20200606030406',0.0",
			    "'20200329021501','20200329021808',0.2","'20201025025920','20201025030612',5.7"})
	void testWeakRobustEqual(String strT,String strE,Double result) {
		assertEquals(TelFee.Fee(strT, strE),result,0.001);
	}

}

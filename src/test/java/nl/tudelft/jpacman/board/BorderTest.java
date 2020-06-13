package nl.tudelft.jpacman.board;


import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BorderTest {
	private static final int MAX_WIDTH = 4;
	 private static final int MAX_HEIGHT = 6;
	 
	 final Square[][] square= {
				{mock(Square.class),mock(Square.class),mock(Square.class),mock(Square.class),mock(Square.class),mock(Square.class)},
				{mock(Square.class),mock(Square.class),mock(Square.class),mock(Square.class),mock(Square.class),mock(Square.class)},
				{mock(Square.class),mock(Square.class),mock(Square.class),mock(Square.class),mock(Square.class),mock(Square.class)},
				{mock(Square.class),mock(Square.class),mock(Square.class),mock(Square.class),mock(Square.class),mock(Square.class)}};
	 Board board=new Board(square);
	 
	 @Test
	    void testWidth() {
	        assertThat(board.getWidth()).isEqualTo(MAX_WIDTH);
	    }

	 @Test
	    void testHeight() {
	        assertThat(board.getHeight()).isEqualTo(MAX_HEIGHT);
	    }
	 
	 @ParameterizedTest
	 @DisplayName("边界值分析测试游戏盒边界")
	 @CsvSource({
		 "0,3,true",
		 "1,3,true",
		 "2,3,true",
		 "3,3,true",
		 "4,3,false",
		 "2,0,true",
		 "2,1,true",
		 "2,5,true",
		 "2,6,false"
	 })
	 void testWithinBorder(int x,int y,boolean result) {
		 assertThat(board.withinBorders(x, y)).isEqualTo(result);
	}
}

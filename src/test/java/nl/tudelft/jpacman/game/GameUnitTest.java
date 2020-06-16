package nl.tudelft.jpacman.game;

import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GameUnitTest {
		private SinglePlayerGame game;
		private Level level;
		
		@BeforeEach
		void setupBackground() {
			level=mock(Level.class);
		}
		
		@Test
		@DisplayName("有豆子没有玩家存活,则游戏结束")
		void testNoPlayerAlive() {
			//arrange
			when(level.isAnyPlayerAlive()).thenReturn(false);
			when(level.remainingPellets()).thenReturn(30);
			game=new SinglePlayerGame(mock(Player.class),level,mock(PointCalculator.class));
			//act
			game.start();
			//assert
			assertThat(game.isInProgress()).isFalse();
		}
		
		@Test
		@DisplayName("没有豆子没有玩家存活,则游戏结束")
		@Disabled
		void testNoPlayerAliveNoPellet() {
			//arrange
			when(level.isAnyPlayerAlive()).thenReturn(false);
			when(level.remainingPellets()).thenReturn(0);
			game=new SinglePlayerGame(mock(Player.class),level,mock(PointCalculator.class));
			//act
			game.start();
			//assert
			assertThat(game.isInProgress()).isFalse();
		}
		
		@Test
		@DisplayName("有豆子有玩家存活,则游戏进行中")
		void testPlayerAliveAndPellet() {
			//arrange
			when(level.isAnyPlayerAlive()).thenReturn(true);
			when(level.remainingPellets()).thenReturn(30);
			game=new SinglePlayerGame(mock(Player.class),level,mock(PointCalculator.class));
			//act
			game.start();
			//assert
			assertThat(game.isInProgress()).isTrue();
		}
		
		@Test
		@DisplayName("没有豆子有玩家存活,则游戏结束")
		void testPlayerAliveNoPellet() {
			//arrange
			when(level.isAnyPlayerAlive()).thenReturn(true);
			when(level.remainingPellets()).thenReturn(0);
			game=new SinglePlayerGame(mock(Player.class),level,mock(PointCalculator.class));
			//act
			game.start();
			//assert
			assertThat(game.isInProgress()).isFalse();
		}
		
		@Test
		@DisplayName("游戏正在进行中再次调用start,则状态不变")
		void testReStart() {
			//arrange
			when(level.isAnyPlayerAlive()).thenReturn(true);
			when(level.remainingPellets()).thenReturn(30);
			game=new SinglePlayerGame(mock(Player.class),level,mock(PointCalculator.class));
			assertThat(game.isInProgress()).isFalse();
			//act
			game.start();
			assertThat(game.isInProgress()).isTrue();
			//再次调用
			game.start();
			assertThat(game.isInProgress()).isTrue();
			//验证行为
			//assert
			verify(level,times(1)).isAnyPlayerAlive();
			verify(level,times(1)).remainingPellets();
			
		}
}

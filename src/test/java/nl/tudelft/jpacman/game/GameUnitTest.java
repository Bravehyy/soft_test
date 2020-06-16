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
		@DisplayName("�ж���û����Ҵ��,����Ϸ����")
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
		@DisplayName("û�ж���û����Ҵ��,����Ϸ����")
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
		@DisplayName("�ж�������Ҵ��,����Ϸ������")
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
		@DisplayName("û�ж�������Ҵ��,����Ϸ����")
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
		@DisplayName("��Ϸ���ڽ������ٴε���start,��״̬����")
		void testReStart() {
			//arrange
			when(level.isAnyPlayerAlive()).thenReturn(true);
			when(level.remainingPellets()).thenReturn(30);
			game=new SinglePlayerGame(mock(Player.class),level,mock(PointCalculator.class));
			assertThat(game.isInProgress()).isFalse();
			//act
			game.start();
			assertThat(game.isInProgress()).isTrue();
			//�ٴε���
			game.start();
			assertThat(game.isInProgress()).isTrue();
			//��֤��Ϊ
			//assert
			verify(level,times(1)).isAnyPlayerAlive();
			verify(level,times(1)).remainingPellets();
			
		}
}

package nl.tudelft.jpacman.game;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nl.tudelft.jpacman.level.Pellet;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerCollisions;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.points.PointCalculator;

public class PlayerCollisionsTest {
	
	private PointCalculator pointCalculator;
	private PlayerCollisions playerCollisions;
	
	@BeforeEach
	void setupBackground() {
		pointCalculator=mock(PointCalculator.class);
		playerCollisions=new PlayerCollisions(pointCalculator);
	}
	
	@Test
	@DisplayName("player移动到与Ghost相撞")
	void playerCollideOnGhost() {
		//arrange
		Player player=mock(Player.class);
		Ghost ghost=mock(Ghost.class);
		//act
		playerCollisions.collide(player, ghost);
		//assert
		verify(pointCalculator).collidedWithAGhost(player, ghost);
		verify(player).setAlive(false);
		verify(player).setKiller(ghost);
	}
	
	@Test
	@DisplayName("player移动到与player相撞")
	void playerCollideOnplayer() {
		//arrange
		Player player1=mock(Player.class);
		Player player2=mock(Player.class);
		//act
		playerCollisions.collide(player1, player2);
		//assert
		verifyZeroInteractions(player1,player2);
	}
	
	@Test
	@DisplayName("player移动到与Pellet相撞")
	void playerCollideOnPellet() {
		//arrange
		Player player=mock(Player.class);
		Pellet pellet=mock(Pellet.class);
		//act
		playerCollisions.collide(player, pellet);
		//assert
		verify(pointCalculator).consumedAPellet(player, pellet);
		verify(pellet).leaveSquare();
	}
	
	@Test
	@DisplayName("Ghost移动到与Pellet相撞")
	void ghostCollideOnPellet() {
		//arrange
		Pellet pellet=mock(Pellet.class);
		Ghost ghost=mock(Ghost.class);
		//act
		playerCollisions.collide(ghost, pellet);
		//assert
		verifyZeroInteractions(ghost,pellet);
	}
	
	@Test
	@DisplayName("Ghost移动到与Ghost相撞")
	void ghostCollideOnGhost() {
		//arrange
		Ghost ghost1=mock(Ghost.class);
		Ghost ghost2=mock(Ghost.class);
		//act
		playerCollisions.collide(ghost1, ghost2);
		//assert
		verifyZeroInteractions(ghost1,ghost2);
	}
	
}

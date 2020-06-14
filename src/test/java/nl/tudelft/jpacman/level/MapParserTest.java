package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.PacmanConfigurationException;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.npc.Ghost;

import static org.mockito.Mockito.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MapParserTest {
	
	private MapParser mapParser;
	private final LevelFactory levelCreator=mock(LevelFactory.class);
	private final BoardFactory boardCreator=mock(BoardFactory.class);
	
	@BeforeEach
	void setupBackground() {
		mapParser=new MapParser(levelCreator,boardCreator);
		when(boardCreator.createGround()).thenReturn(mock(Square.class));
		when(boardCreator.createWall()).thenReturn(mock(Square.class));
		when(levelCreator.createGhost()).thenReturn(mock(Ghost.class));
		when(levelCreator.createPellet()).thenReturn(mock(Pellet.class));
	}
	
	@Test
	@Order(1)
	@DisplayName("null文件名")
	void nullFile() {
		assertThatThrownBy(()->{
			mapParser.parseMap((String)null);
		}).isInstanceOf(NullPointerException.class);
	}
	
	@Test
	@Order(2)
	@DisplayName("读取不存在的文件")
	void notExistFile() {
		String fileName="/notexistmap.txt";
		assertThatThrownBy(()->{
			mapParser.parseMap(fileName);
		}).isInstanceOf(PacmanConfigurationException.class).hasMessage("Could not get resource for: " + fileName);
	}
	
	@Test
	@Order(3)
	@DisplayName("读取存在且能被识别的地图文件")
	void existFile() throws IOException {
		String fileName="/simplemap.txt";
		mapParser.parseMap(fileName);
		verify(boardCreator,times(7)).createGround();
		verify(boardCreator,times(4)).createWall();
		verify(levelCreator,times(1)).createGhost();
	}
	
	@Test
	@Order(4)
	@DisplayName("读取存在但不能被识别的地图文件")
	void unrecognizedMap() throws IOException {
		String fileName="/unrecognizedcharmap.txt";
		assertThatThrownBy(()->{
			mapParser.parseMap(fileName);
		}).isInstanceOf(PacmanConfigurationException.class).hasMessage("Invalid character at 0,0: B");
	}
}

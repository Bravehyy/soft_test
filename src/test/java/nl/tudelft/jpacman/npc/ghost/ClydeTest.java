package nl.tudelft.jpacman.npc.ghost;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Lists;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClydeTest {
	private static MapParser mapParser;

	@Test
	@DisplayName("Clyde与Player之间的距离小于8个方块")
	@Order(1)
	void departLessThanEight() {
		List<String> text=Lists.newArrayList(
				"##############",
				"#.#....C.....P",
				"##############");
		Level level=mapParser.parseMap(text);
		Clyde clyde=Navigation.findUnitInBoard(Clyde.class, level.getBoard());
		assertThat(clyde).isNotNull();
		assertThat(clyde.getDirection()).isEqualTo(Direction.valueOf("EAST"));
		//创建Player
		Player player=new PlayerFactory(new PacManSprites()).createPacMan();
		level.registerPlayer(player);
		Player p=Navigation.findUnitInBoard(Player.class, level.getBoard());
		assertThat(p).isNotNull();
		assertThat(clyde.getDirection()).isEqualTo(Direction.valueOf("EAST"));
		//act
		Optional<Direction> opt=clyde.nextAiMove();
		//assert
		assertThat(opt.get()).isEqualTo(Direction.valueOf("WEST"));	
	}

	@BeforeAll
	public static void setupBackground() {
		PacManSprites sprites=new PacManSprites();
		LevelFactory levelFactory=new LevelFactory(sprites,new GhostFactory(sprites),mock(PointCalculator.class));
		BoardFactory boardFactory=new BoardFactory(sprites);
		GhostFactory ghostFactory=new GhostFactory(sprites);
		mapParser=new GhostMapParser(levelFactory,boardFactory,ghostFactory);
	}
	
	@Test
	@DisplayName("Clyde与Player之间的距离小于8个方块")
	@Order(2)
	void departMoreThanEight() {
		List<String> text=Lists.newArrayList(
				"##############",
				"#.C..........P",
				"##############");
		Level level=mapParser.parseMap(text);
		Clyde clyde=Navigation.findUnitInBoard(Clyde.class, level.getBoard());
		assertThat(clyde).isNotNull();
		assertThat(clyde.getDirection()).isEqualTo(Direction.valueOf("EAST"));
		//创建Player
		Player player=new PlayerFactory(new PacManSprites()).createPacMan();
		player.setDirection(Direction.valueOf("WEST"));
		level.registerPlayer(player);
		Player p=Navigation.findUnitInBoard(Player.class, level.getBoard());
		assertThat(p).isNotNull();
		assertThat(clyde.getDirection()).isEqualTo(Direction.valueOf("EAST"));
		//act
		Optional<Direction> opt=clyde.nextAiMove();
		//assert
		assertThat(opt.get()).isEqualTo(Direction.valueOf("EAST"));	
	}
	
	@Test
	@DisplayName("Clyde与Player之间没有路径")
	@Order(3)
	void withoutPathBetweenClydeAndPlayer() {
		List<String> text=Lists.newArrayList(
				"###########P##",
				"#.C.......##..",
				"##############");
		Level level=mapParser.parseMap(text);
		Clyde clyde=Navigation.findUnitInBoard(Clyde.class, level.getBoard());
		assertThat(clyde).isNotNull();
		assertThat(clyde.getDirection()).isEqualTo(Direction.valueOf("EAST"));
		//创建Player
		Player player=new PlayerFactory(new PacManSprites()).createPacMan();
		level.registerPlayer(player);
		Player p=Navigation.findUnitInBoard(Player.class, level.getBoard());
		assertThat(p).isNotNull();
		assertThat(clyde.getDirection()).isEqualTo(Direction.valueOf("EAST"));
		//act
		Optional<Direction> opt=clyde.nextAiMove();
		//assert
		assertThat(opt.isPresent()).isFalse();	
	}
	
	@Test
	@DisplayName("Clyde找不到Player")
	@Order(4)
	void departWithoutPlayer() {
		List<String> text=Lists.newArrayList(
				"##############",
				"#.C...........",
				"##############");
		Level level=mapParser.parseMap(text);
		Clyde clyde=Navigation.findUnitInBoard(Clyde.class, level.getBoard());
		assertThat(clyde).isNotNull();
		assertThat(clyde.getDirection()).isEqualTo(Direction.valueOf("EAST"));
		//无Player
		assertThat(level.isAnyPlayerAlive()).isFalse();
		//act
		Optional<Direction> opt=clyde.nextAiMove();
		//assert
		assertThat(opt.isPresent()).isFalse();	
	}
	
}

package nl.tudelft.jpacman.e2e.framework.startup;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.board.Unit;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Pellet;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.board.BoardFactory.Wall;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

public class MovePlayerSteps {
	private Launcher launcher;
	private Player player;
	private Square nextSquare;
	private Pellet pellet;
	private Square square;
	private Level level;
	@SuppressWarnings("unused")
	private Ghost ghost;
	private int score;
	private Direction direction;
	
	private Game getGame() {
		return launcher.getGame();
	}
	
	@Before
	public void setup() {
		launcher=new Launcher();
		launcher.withMapFile("/moveplayersteps.txt");
		launcher.launch();
	}
	
	@Given("the game has started,")
	public void the_game_has_started() {
	   getGame().start();
	   level=getGame().getLevel();
	   assertThat(getGame().isInProgress()).isTrue();
	}

	@Given("my Pacman is next to a square containing a pellet;")
	public void my_Pacman_is_next_to_a_square_containing_a_pellet() {
	    List<Player> players=getGame().getPlayers();
	    player=players.get(0);
	    //存储原始分数
	    score=player.getScore();
	    square=player.getSquare();
	    //取豆子所占方块
	    direction=Direction.WEST;
	    nextSquare=square.getSquareAt(direction);
	    List<Unit> units=nextSquare.getOccupants();
	    pellet=(Pellet)units.get(0);
	    //断言
	    assertThat(units.size()).isEqualTo(1);
	    assertThat(units.get(0)).isInstanceOf(Pellet.class);
	    }

	@When("I press an arrow key towards that square;")
	public void i_press_an_arrow_key_towards_that_square() {
	    getGame().move(player, direction);
	}

	@Then("my Pacman can move to that square,")
	public void my_Pacman_can_move_to_that_square() {
	    assertThat(player.getSquare()).isEqualTo(nextSquare);
	}

	@Then("I earn the points for the pellet,")
	public void i_earn_the_points_for_the_pellet() {
	    assertThat(score).isEqualTo(0);
	    assertThat(player.getScore()).isEqualTo(score+pellet.getValue());
	}

	@Then("the pellet disappears from that square.")
	public void the_pellet_disappears_from_that_square() {
	    assertThat(nextSquare.getOccupants()).contains(player).doesNotContain(pellet);
	}
	
	
	@Given("my Pacman is next to an empty square;")
	public void my_Pacman_is_next_to_an_empty_square() {
		List<Player> players=getGame().getPlayers();
	    player=players.get(0);
	    //存储原始分数
	    score=player.getScore();
	    square=player.getSquare();
	    //取相邻空方块
	    direction=Direction.EAST;
	    nextSquare=square.getSquareAt(direction);
	    List<Unit> units=nextSquare.getOccupants();
	    //断言
	    assertThat(units.size()).isEqualTo(0);
	}
	
	@Then("my points remain the same.")
	public void my_points_remain_the_same() {
		 assertThat(score).isEqualTo(0);
		 assertThat(player.getScore()).isEqualTo(score);
	}
	
	@Given("my Pacman is next to a cell containing a wall;")
	public void my_Pacman_is_next_to_a_cell_containing_a_wall() {
		List<Player> players=getGame().getPlayers();
	    player=players.get(0);
	    //存储原始分数
	    score=player.getScore();
	    square=player.getSquare();
	    //取墙所占方块
	    direction=Direction.SOUTH;
	    //断言
	    assertThat(square.getSquareAt(direction)).isInstanceOf(Wall.class);
	    }

	@When("I press an arrow key towards that cell;")
	public void i_press_an_arrow_key_towards_that_cell() {
		 getGame().move(player, direction);
	}

	@Then("the move is not conducted.")
	public void the_move_is_not_conducted() {
	    assertThat(player.getSquare()).isEqualTo(square);
	}

	@Given("my Pacman is next to a cell containing a ghost;")
	public void my_Pacman_is_next_to_a_cell_containing_a_ghost() {
		List<Player> players=getGame().getPlayers();
	    player=players.get(0);
	    //存储原始分数
	    score=player.getScore();
	    square=player.getSquare();
	    //取ghost所占方块
	    direction=Direction.NORTH;
	    nextSquare=square.getSquareAt(direction);
	    List<Unit> units=nextSquare.getOccupants();
	    ghost=(Ghost)units.get(0);
	    //断言
	    assertThat(units.size()).isEqualTo(1);
	    assertThat(units.get(0)).isInstanceOf(Ghost.class);
	}

	@Then("my Pacman dies,")
	public void my_Pacman_dies() {
	    assertThat(player.isAlive()).isFalse();
	}

	@Then("the game is over.")
	public void the_game_is_over() {
		assertThat(getGame().isInProgress()).isFalse();
	}
	
	@When("I have eaten the last pellet;")
	public void i_have_eaten_the_last_pellet() {
		the_game_has_started();
		my_Pacman_is_next_to_a_square_containing_a_pellet();
		i_press_an_arrow_key_towards_that_square();
		my_Pacman_can_move_to_that_square();
		i_earn_the_points_for_the_pellet();
		assertThat(getGame().getLevel().remainingPellets()).isEqualTo(0);
		}

	@Then("I win the game.")
	public void i_win_the_game() {
	    assertThat(getGame().isInProgress()).isEqualTo(false);
	}
	
	@After("@framework")
	void teardownUI() {
		launcher.dispose();
	}

}

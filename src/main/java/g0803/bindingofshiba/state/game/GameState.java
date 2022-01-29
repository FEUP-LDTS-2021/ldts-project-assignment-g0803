package g0803.bindingofshiba.state.game;

import g0803.bindingofshiba.controller.game.GameController;
import g0803.bindingofshiba.events.EventManager;
import g0803.bindingofshiba.model.game.Game;
import g0803.bindingofshiba.state.State;
import g0803.bindingofshiba.view.game.GameView;
import g0803.bindingofshiba.view.game.MonsterView;
import g0803.bindingofshiba.view.game.PlayerView;

public class GameState extends State<Game> {

    public GameState(Game game) {
        super(
                game,
                new GameController(game, new EventManager()),
                new GameView(game, PlayerView::new, MonsterView::new));
    }
}

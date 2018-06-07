package com.rodion.emiratesdemo.game;

import com.rodion.emiratesdemo.BasePresenter;
import com.rodion.emiratesdemo.game.model.Player;

import java.util.ArrayList;
import java.util.List;

public class GameActivityPresenter extends BasePresenter<GameActivityPresenter.ViewContract> {

    /**
     * View interface.
     */
    public interface ViewContract {
        void setPlayerData(List<Player> players);
    }

    private List<Player> players;

    public GameActivityPresenter() {
        initPlayers();
    }

    @Override
    protected void onViewAttached() {
        super.onViewAttached();

        if (getView() != null) {
            getView().setPlayerData(players);
        }
    }

    private void initPlayers() {
        players = new ArrayList<>();

        Player p1 = new Player("Player 1");
        p1.getScorer().addScore(10);
        p1.getScorer().addScore(12);
        p1.getScorer().addScore(10);
        p1.getScorer().addScore(15);
        p1.getScorer().addScore(10);

        Player p2 = new Player("Player 2");
        p2.getScorer().addScore(10);
        p2.getScorer().addScore(12);
        p2.getScorer().addScore(0);
        p2.getScorer().addScore(15);
        p2.getScorer().addScore(10);
        p2.getScorer().addScore(10);
        p2.getScorer().addScore(12);
        p2.getScorer().addScore(0);
        p2.getScorer().addScore(15);
        p2.getScorer().addScore(10);

        Player p3 = new Player("Player 3");
        p3.getScorer().addScore(5);
        p3.getScorer().addScore(0);
        p3.getScorer().addScore(10);
        p3.getScorer().addScore(15);
        p3.getScorer().addScore(10);

        players.add(p1);
        players.add(p2);
        players.add(p3);
    }
}

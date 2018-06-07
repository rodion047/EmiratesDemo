package com.rodion.emiratesdemo.game.model;

/**
 * Holds player info and a scorer.
 */
public class Player {
    private final String title;
    private final BowlingScorer scorer = new BowlingScorer();

    public Player(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public BowlingScorer getScorer() {
        return scorer;
    }
}

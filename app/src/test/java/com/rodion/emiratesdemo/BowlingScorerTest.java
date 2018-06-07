package com.rodion.emiratesdemo;

import com.rodion.emiratesdemo.game.model.BowlingScorer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingScorerTest {

    @Test
    public void initial_state_isCorrect() {
        BowlingScorer scorer = new BowlingScorer();
        assertEquals(0, scorer.getCurrentScore());
        assertEquals(false, scorer.isGameOver());
    }

    @Test
    public void add_score_isCorrect() {
        BowlingScorer scorer = new BowlingScorer();
        scorer.addScore(10);
        assertEquals(10, scorer.getCurrentScore());

        scorer.addScore(5);
        assertEquals(15, scorer.getCurrentScore());

        assertEquals(false, scorer.isGameOver());
    }
}

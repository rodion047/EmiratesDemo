package com.rodion.emiratesdemo.game.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Dummy scorer. It does't really follow any bowling game rules. Just allows adds scores and
 * get total. Max scores to add is hard coded to 10.
 */
public class BowlingScorer {
    private final List<Integer> scores = new ArrayList<>();

    public boolean isGameOver() {
        return scores.size() >= 10;
    }

    public boolean addScore(int value) {
        // some data validation
        if (isGameOver() || value < 0) {
            return false;
        }

        scores.add(value);
        return true;
    }

    public int getCurrentScore() {
        // TODO for better performance should be cached
        int res = 0;
        for(Integer val : scores) {
            res += val;
        }
        return res;
    }

    public List<Integer> getImmutableScoreList() {
        return Collections.unmodifiableList(scores);
    }
}

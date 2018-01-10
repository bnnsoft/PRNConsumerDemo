/*
 * @(#)ScoreKeeper.java 1.0  Dec 29, 2017
 *
 * Copyright (c) 2017 Bojan Nokovic
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of the
 * Bojan Nokovic. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with the Bojan Nokovic.
 */
package prnconsumerdemo;

/**
 * ScoreKeeper log of Result Analyze post.
 *
 * @author Bojan Nokovic
 * @version 1.0 Dec. 29, 2017 Created.
 */
public class ScoreKeeper {

    static int Player1_Score = 0;
    static int Player2_Score = 0;
    static int Player3_Score = 0;
    static int PredictionEngine_Score = 0;

    // Constructor
    public ScoreKeeper() {
    }

    /**
     * Add point and allow to post new score
     */
    void AddPointToPlayer1() {
        Player1_Score++;
    }

    void AddPointToPlayer2() {
        Player2_Score++;
    }

    void AddPointToPlayer3() {
        Player3_Score++;
    }

    void AddPointToPE() {
        PredictionEngine_Score++;
    }

    // Post the score
    void ShowScore() {
        String score = "Player1: " + Player1_Score + ", "
                + "Player2: " + Player2_Score + ", "
                + "Player3: " + Player3_Score + ", "
                + "PredictionEngine: " + PredictionEngine_Score + " points";
        // score has to be written into log file too
        System.out.println(score);
    }

    public int getPlayer1Score() {
        return Player1_Score;
    }

    public int getPlayer2Score() {
        return Player2_Score;
    }

    public int getPlayer3Score() {
        return Player3_Score;
    }

    public int getPredictionEngineScore() {
        return PredictionEngine_Score;
    }
}

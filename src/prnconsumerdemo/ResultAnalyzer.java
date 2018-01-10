/*
 * @(#)ResultAnalyzer 1.0  Dec 29, 2017
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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ResultAnalyzer
 *
 * Receives all messages. 
 * It will award Players and Prediction Engine 1 point for each match.
 *
 * @author Bojan Nokovic
 * @version 1.0 Dec. 29, 2017 Created.
 */
public class ResultAnalyzer {

    private static final String SEPARATOR = ",";
    private static final int RN_OFFSET = 0;
    private static final int GUESS1_OFFSET = 1;
    private static final int GUESS2_OFFSET = 2;
    private static final int GUESS3_OFFSET = 3;
    private static final int SEED_OFFSET = 4;
    private static final int TS_OFFSET = 5;

    static int Prev_Player1_Score = 0;
    static int Prev_Player2_Score = 0;
    static int Prev_Player3_Score = 0;
    static int Prev_PredictionEngine_Score = 0;

    ScoreKeeper sc = new ScoreKeeper();

    // Constructor
    public ResultAnalyzer() {
    }

    /**
     * Analyze result
     * @param result
     */
    public ScoreKeeper AnalyzeRecord(String result) {
        // result contains
        // random number (long) | guess [3] (long) | seed (long) | ts (long)
        List<Record> records = new LinkedList<>();

        Scanner scanner = new Scanner(result);
        while (scanner.hasNext()) {
            List<String> line = parseLine(scanner.nextLine(), SEPARATOR);
            Record rec = createRecord(line);
            records.add(rec);
        }
        scanner.close();

        for (int i = 0; i < records.size(); i++) {
            Record rec;
            PredictionEngine pred = new PredictionEngine();
            rec = records.get(i);

            long generated = rec.getGeneratedRandomNumber();

            //  
            long predected = pred.PredictNumber(rec.getSeed(), rec.getTS());

            // 
            long guessed[] = rec.getGuesses();

            // ScoreKeeper
            sc = AddPoints(generated, predected, guessed);

            // Write to log files
        }
        return sc;
    }

    /**
     * Separate message into lines
     * @param recordLine
     * @param separators
     * @return List of single lines
     */
    public static List<String> parseLine(String recordLine, String separators) {
        List<String> result = new ArrayList<>();

        //if empty -> return
        if (recordLine == null && recordLine.isEmpty()) {
            return result;
        }

        String[] values = recordLine.split(SEPARATOR);

        for (int i = 0; i < values.length; i++) {
            result.add(values[i]);
        }

        return result;
    }

    /**
     * Create custom Record data type that contains
     *  - random number
     *  - guesses [3]
     *  - seed
     *  - time stamp
     * @param values
     * @return Record
     */
    public static Record createRecord(List<String> values) {
        long prn = 0;
        long guess[] = new long[3];
        long seed = 0;
        long ts = 0;

        Record messageRecord = new Record();

        if(values.size() > 5){
            prn = Long.valueOf(values.get(RN_OFFSET));
            guess[0] = Long.valueOf(values.get(GUESS1_OFFSET));
            guess[1] = Long.valueOf(values.get(GUESS2_OFFSET));
            guess[2] = Long.valueOf(values.get(GUESS3_OFFSET));
            seed = Long.valueOf(values.get(SEED_OFFSET));
            ts = Long.valueOf(values.get(TS_OFFSET));
        }    
        messageRecord.SetRecord(prn, guess, seed, ts);

        return messageRecord;
    }

    /**
     * Keep the score
     * @param generated
     * @param predected
     * @param guessed
     * @return Score Keeper
     */
    ScoreKeeper AddPoints(long generated, long predected, long guessed[]) {
        //sc = new ScoreKeeper();

        if ((predected - generated) == 0) {
            sc.AddPointToPE();
        }
        if ((predected - guessed[0]) == 0) {
            sc.AddPointToPlayer1();
        }
        if ((predected - guessed[1]) == 0) {
            sc.AddPointToPlayer2();
        }
        if ((predected - guessed[2]) == 0) {
            sc.AddPointToPlayer3();
        }

        // Show score only if there is change
        if (Prev_Player1_Score != sc.Player1_Score
                || Prev_Player2_Score != sc.Player2_Score
                || Prev_Player2_Score != sc.Player3_Score
                || Prev_PredictionEngine_Score != sc.PredictionEngine_Score) {
            sc.ShowScore();

            // Update prevoius score
            Prev_Player1_Score = sc.Player1_Score;
            Prev_Player2_Score = sc.Player2_Score;
            Prev_Player3_Score = sc.Player3_Score;
            Prev_PredictionEngine_Score = sc.PredictionEngine_Score;
        }
        return sc;
    }
}

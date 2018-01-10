/*
 * @(#)ParserTest.java  1.0  Dec 29, 2017
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
import java.util.Scanner;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import prnconsumerdemo.ResultAnalyzer;
import prnconsumerdemo.ScoreKeeper;

public class ParserTest extends TestCase {

    public ParserTest(String testName) {
        super(testName);
    }

    public void testRecord1() {

        boolean result = true;

        String input = "20992,22686,22414,26783,82,17836644179450\n"
                + "864,36028,54540,32260,27,17836644163946\n"
                + "17836644143074,63893,6150,32747,47,17836644143027\n"
                + "17836644127468,8933,54061,60827,54,17836644127522\n"
                + "32768,3102,49067,31990,15,17836644111252\n"
                + "49,16206,9679,17594,7,17836644092413";

        ResultAnalyzer analyze = new ResultAnalyzer();

        ScoreKeeper sc = new ScoreKeeper();
        sc = analyze.AnalyzeRecord(input);

        // Impossibele result
        if (sc.getPlayer1Score() > 6
                || sc.getPlayer2Score() > 6
                || sc.getPlayer3Score() > 6
                || sc.getPredictionEngineScore() > 6) {
            result = false;
        }

        assertEquals(true, result);
    }

    public void testRecord2() {

        boolean result = true;

        String input = "12800,22751672466906,50,1250,50,22751672466956\n"
                + "1856,22751672455799,249108103168,1972,58,22751672455857\n"
                + "22751672444730,22751672444684,23,115,23,22751672444707\n"
                + "22751672432660,22751672432660,15872,248,62,22751672432722\n"
                + "1,22751672420445,0,0,0,22751672420445\n"
                + "324,22751672405582,18,630,18,22751672405600";

        ResultAnalyzer analyze = new ResultAnalyzer();

        ScoreKeeper sc = new ScoreKeeper();
        sc = analyze.AnalyzeRecord(input);

        // Impossibele result
        if (sc.getPlayer1Score() > 6
                || sc.getPlayer2Score() > 6
                || sc.getPlayer3Score() > 6
                || sc.getPredictionEngineScore() > 6) {
            result = false;
        }

        assertEquals(true, result);
    }

    public static void main(String[] args) {
        System.out.println("\n -------- Parser test --------\n\n");
        Scanner scanner = new Scanner(System.in);
        junit.textui.TestRunner.run(new TestSuite(ParserTest.class));
    }
}

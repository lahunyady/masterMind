package com.example.masterMind;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.masterMind.sixth_base.SixthBaseNumberGenerator.increment;

@Component
public class GameEngine {
    private static final int NUMBER_OF_CHARACTERS = 4;
    private String tip = "AAAA";
    private String availableChars = "ABCDEF";
    private List<History> history = new ArrayList<>();

    public boolean isWin(String score) {
        if (!isScoreWinner(score))
            generateGuess(score);
        return isScoreWinner(score);
    }

    public String guess() {
        return tip;
    }

    private void generateGuess(String score) {
        history.add(getCurrentTip(score));
        int[] ints = new int[4];

        while (!isCompatible(numToString(ints))) {
            increment(ints);
        }

        tip = numToString(ints);
    }

    private boolean isScoreWinner(String score) {
        return plusCount(score) == NUMBER_OF_CHARACTERS;
    }

    private History getCurrentTip(String score) {
        return History.builder()
                .score(score)
                .tip(tip)
                .build();
    }

    private boolean isCompatible(String tipCandidate) {
        return history.stream()
                .allMatch(historyElement -> isElementCompatible(historyElement, tipCandidate));
    }

    private String numToString(int[] ints) {
        return Arrays.stream(ints)
                .map(availableChars::charAt)
                .mapToObj(x -> (char) x)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private boolean isElementCompatible(History history, String tipCandidate) {
        StringComparer comparator = new StringComparer(history.getTip(), tipCandidate);
        String score = history.getScore();

        return isOnPosOk(score, comparator) && isOffPosOk(score, comparator);
    }

    private boolean isOffPosOk(String score, StringComparer comparer) {
        return minusCount(score) >= comparer.matchingCharOnDiffPos();
    }

    private boolean isOnPosOk(String score, StringComparer comparer) {
        return plusCount(score) >= comparer.matchingCharOnPos();
    }

    private long plusCount(String score) {
        return score.chars()
                .filter(x -> x == '+')
                .count();
    }

    private long minusCount(String score) {
        return score.chars()
                .filter(x -> x == '-')
                .count();
    }
}

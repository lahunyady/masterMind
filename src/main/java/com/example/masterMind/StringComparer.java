package com.example.masterMind;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.min;

@Getter
@AllArgsConstructor
public class StringComparer {
    private String s2;
    private String s1;

    public Long matchingCharOnDiffPos() {
        return matchingChars(charCount(getS1()), charCount(getS2())) - matchingCharOnPos();
    }

    private Long matchingChars(Map<Character, Long> charCountS1, Map<Character, Long> charCountS2) {
        return charCountS1.keySet()
                .stream()
                .filter(charCountS2::containsKey)
                .mapToLong(x -> getLeastOccurrenceCount(charCountS1, charCountS2, x))
                .sum();
    }

    private Long getLeastOccurrenceCount(Map<Character, Long> charCountS1, Map<Character, Long> charCountS2, Character x) {
        return min(charCountS1.get(x), charCountS2.get(x));
    }

    private Map<Character, Long> charCount(String s2) {
        return s2.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public Long matchingCharOnPos() {
        return IntStream.range(0, minLength())
                .filter(x -> getS1().charAt(x) == getS2().charAt(x))
                .count();

    }

    private int minLength() {
        return min(getS1().length(), getS2().length());
    }
}

package com.example.masterMind;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class StringComparerTest {

    @Test
    public void test_allDifferent() {
        StringComparer stringComparer = new StringComparer("AAAA", "BBBB");
        assertEquals(0, stringComparer.matchingCharOnDiffPos());
    }

    @Test
    public void test_oneMatchesOnDifferentPos() {
        StringComparer stringComparer = new StringComparer("ABCD", "DEFG");
        assertEquals(1, stringComparer.matchingCharOnDiffPos());
    }

    @Test
    public void test_allMatchOnPos() {
        StringComparer stringComparer = new StringComparer("ABCD", "ABCD");
        assertEquals(4, stringComparer.matchingCharOnPos());
    }

    @Test
    public void test_oneMatchOnPos() {
        StringComparer stringComparer = new StringComparer("AAAA", "ABCD");
        assertEquals(1, stringComparer.matchingCharOnPos());
    }

    @Test
    public void test_twoMatchOnPos() {
        StringComparer stringComparer = new StringComparer("AACA", "ABCD");
        assertEquals(2, stringComparer.matchingCharOnPos());
    }

    @Test
    public void test_oneMatchOnDifferentPosAndOneOnSamePos() {
        StringComparer stringComparer = new StringComparer("ABCD", "ADEF");
        assertEquals(1, stringComparer.matchingCharOnDiffPos());
    }

}
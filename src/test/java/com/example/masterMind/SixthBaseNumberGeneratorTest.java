package com.example.masterMind;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static com.example.masterMind.sixth_base.SixthBaseNumberGenerator.increment;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SixthBaseNumberGeneratorTest {

    @Test
    public void test_firstDigit() {
        int[] num = {0, 0, 0, 0};
        increment(num);
        assertEquals(1, num[0]);
    }

    @Test
    public void test_secondDigit() {
        int[] num = {5, 0, 0, 0};
        increment(num);

        assertEquals(0, num[0]);
        assertEquals(1, num[1]);
    }

    @Test
    public void test_thirdDigit() {
        int[] num = {5, 5, 0, 0};
        increment(num);

        assertEquals(0, num[0]);
        assertEquals(0, num[1]);
        assertEquals(1, num[2]);
    }

    @Test
    public void test_fourthDigit() {
        int[] num = {5, 5, 5, 0};
        increment(num);

        assertEquals(0, num[0]);
        assertEquals(0, num[1]);
        assertEquals(0, num[2]);
        assertEquals(1, num[3]);
    }

    @Test(expected = RuntimeException.class)
    public void test_overflow() {
        int[] num = {5, 5, 5, 5};
        increment(num);
    }
}
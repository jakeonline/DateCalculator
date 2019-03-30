package com.odsinada.qantas;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TheYearTest {

    @Test
    public void shouldIdentifyLeapYear() {
        // arrange
        TheYear yearA = new TheYear(2000);
        TheYear yearB = new TheYear(1900);
        TheYear yearC = new TheYear(1901);

        // act
        // assert
        assertThat(yearA.isLeapYear(), equalTo(true));
        assertThat(yearB.isLeapYear(), equalTo(false));
        assertThat(yearC.isLeapYear(), equalTo(false));
    }
}

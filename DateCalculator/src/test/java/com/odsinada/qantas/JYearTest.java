package com.odsinada.qantas;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class JYearTest {

    @Test
    public void shouldIdentifyLeapYear() {
        // arrange
        JYear yearA = new JYear(2000);
        JYear yearB = new JYear(1900);
        JYear yearC = new JYear(1901);

        // act
        // assert
        assertThat(yearA.isLeapYear(), equalTo(true));
        assertThat(yearB.isLeapYear(), equalTo(false));
        assertThat(yearC.isLeapYear(), equalTo(false));
    }
}

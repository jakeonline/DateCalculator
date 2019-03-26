package com.odsinada.qantas;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DateCalculatorTest {

    private DateCalculator calc;

    @Before
    public void setup(){
        calc = new DateCalculator();
    }

    @Test
    public void shouldCalcDaysSameMonthYear(){
        // arrange
        // act
        // assert
        assertThat(calc.getDaysBetween("1983-06-02", "1983-06-22"), equalTo(19));
        assertThat(calc.getDaysBetween("2001-01-01", "2001-01-30"), equalTo(28));
    }

    @Test
    public void shouldCalcDaysSameYearDifferentMonthsInNormalYear(){
        // arrange
        // act
        // assert
        assertThat(calc.getDaysBetween("2001-01-01", "2001-04-15"), equalTo(103));
        assertThat(calc.getDaysBetween("2001-06-01", "2001-12-10"), equalTo(191));
    }

    @Test
    public void shouldCalcDaysSameYearDifferentMonthsInLeapYear(){
        // arrange
        // act
        // assert
        assertThat(calc.getDaysBetween("2000-01-01", "2001-04-15"), equalTo(468));
    }

    @Test
    public void shouldCalcDaysDifferentYearMonthsInNormalYear(){
        // arrange
        // act
        // assert
        assertThat(calc.getDaysBetween("2001-01-01", "2001-04-15"), equalTo(73));
    }


}

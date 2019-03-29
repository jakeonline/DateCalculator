package com.odsinada.qantas;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DateCalculatorTest {

    private DateCalculator calc;

    @Before
    public void setup(){
        calc = new DateCalculator();
    }

//    @Test
//    public void shouldCalcDaysSameMonthYear(){
//        // arrange
//        // act
//        // assert
//        assertThat(calc.getDaysBetween("1983-06-02", "1983-06-22"), equalTo(19));
//        assertThat(calc.getDaysBetween("2001-01-01", "2001-01-30"), equalTo(28));
//    }
//
//    @Test
//    public void shouldCalcDaysSameYearDifferentMonthsInNormalYear(){
//        // arrange
//        // act
//        // assert
//        assertThat(calc.getDaysBetween("2001-01-01", "2001-04-15"), equalTo(103));
//        assertThat(calc.getDaysBetween("2001-06-01", "2001-12-10"), equalTo(191));
//    }
//
//    @Test
//    public void shouldCalcDaysSameYearDifferentMonthsInLeapYear(){
//        // arrange
//        // act
//        // assert
//        assertThat(calc.getDaysBetween("2000-01-01", "2001-04-15"), equalTo(468));
//    }
//
//    @Test
//    public void shouldCalcDaysDifferentYearMonthsInNormalYear(){
//        // arrange
//        // act
//        // assert
//        assertThat(calc.getDaysBetween("2001-01-01", "2001-04-15"), equalTo(73));
//    }

    @Test
    public void shouldCalcDaysBetweenSameMonthSameYear(){
        assertThat(calc.getDaysBetween("2001-01-01", "2001-01-15"), equalTo(13));
    }

    @Test
    public void shouldCalcDaysCrossing31DayMonthsSameYear(){
        assertThat(calc.getDaysBetween("2001-07-1", "2001-08-31"), equalTo(60));
        assertThat(calc.getDaysBetween("2001-07-1", "2001-09-15"), equalTo(75));
    }

    @Test
    public void shouldCalcDaysCrossing30DayMonthsSameYear(){
        assertThat(calc.getDaysBetween("2001-09-1", "2001-10-31"), equalTo(59));
        assertThat(calc.getDaysBetween("2001-02-1", "2001-3-31"), equalTo(57));
        assertThat(calc.getDaysBetween("2001-01-1", "2001-3-10"), equalTo(67));
    }

    @Test
    public void shouldCalcDaysCrossingFebruarySameLeapYear(){
        assertThat(calc.getDaysBetween("2000-02-1", "2000-3-31"), equalTo(58));
        assertThat(calc.getDaysBetween("2000-01-1", "2000-3-10"), equalTo(68));
    }

    @Test
    public void shouldCalcDaysCrossingAllMonthsOfYear(){
        assertThat(calc.getDaysBetween("2001-01-1", "2001-12-31"), equalTo(363));
    }

    @Test
    public void shouldCalcDaysCrossingAllMonthsOfLeapYear(){
        assertThat(calc.getDaysBetween("2000-01-1", "2000-12-31"), equalTo(364));
    }

    @Test
    @Ignore
    public void shouldCalcDaysCrossingMonthDifferentYear(){
        assertThat(calc.getDaysBetween("2001-12-01", "2002-01-31"), equalTo(60));
    }


}

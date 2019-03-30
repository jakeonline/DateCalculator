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
    public void shouldCalcSucceedingDays(){
        assertThat(calc.getDaysBetween("1972-11-07", "1972-11-08"), equalTo(0));
    }

    @Test
    public void shouldCalcSameDay(){
        assertThat(calc.getDaysBetween("1972-11-07", "1972-11-07"), equalTo(0));
    }

    @Test
    public void shouldCalcDaysBetweenSameMonthSameYear(){
        assertThat(calc.getDaysBetween("2001-01-01", "2001-01-15"), equalTo(13));

        // given test case
        assertThat(calc.getDaysBetween("1983-06-02", "1983-06-22"), equalTo(19));
    }

    @Test
    public void shouldCalcDaysCrossing31DayMonthsSameYear(){
        assertThat(calc.getDaysBetween("2001-07-1", "2001-08-31"), equalTo(60));
        assertThat(calc.getDaysBetween("2001-07-1", "2001-09-15"), equalTo(75));
    }

    @Test
    public void shouldCalcDaysCrossing30DayMonthsSameYear(){
        assertThat(calc.getDaysBetween("2001-09-1", "2001-10-31"), equalTo(59));
        assertThat(calc.getDaysBetween("2001-01-1", "2001-3-10"), equalTo(67));

        // given test case
        assertThat(calc.getDaysBetween("1984-07-04", "1984-12-25"), equalTo(173));
    }

    @Test
    public void shouldCalcDaysCrossingFebruarySameRegularYear(){
        assertThat(calc.getDaysBetween("2001-02-1", "2001-3-31"), equalTo(57));
        assertThat(calc.getDaysBetween("2001-01-1", "2001-3-10"), equalTo(67));
    }
    @Test
    public void shouldCalcDaysCrossingFebruarySameLeapYear(){
        assertThat(calc.getDaysBetween("2000-02-1", "2000-3-31"), equalTo(58));
        assertThat(calc.getDaysBetween("2000-01-1", "2000-3-10"), equalTo(68));
    }

    @Test
    public void shouldCalcDaysCrossingAllMonthsOfARegularYear(){
        assertThat(calc.getDaysBetween("2001-01-1", "2001-12-31"), equalTo(363));
    }

    @Test
    public void shouldCalcDaysCrossingAllMonthsOfALeapYear(){
        assertThat(calc.getDaysBetween("2000-01-1", "2000-12-31"), equalTo(364));
    }

    @Test
    public void shouldCalcDaysCrossingMonthOfDifferentYear(){
        assertThat(calc.getDaysBetween("2001-12-01", "2002-01-31"), equalTo(60));
        assertThat(calc.getDaysBetween("2001-11-01", "2002-02-28"), equalTo(118));
        assertThat(calc.getDaysBetween("2001-01-01", "2002-03-31"), equalTo(453));
    }

    @Test
    public void shouldCalcDaysRegardlessOfArgSequence(){
        assertThat(calc.getDaysBetween("2001-11-01", "2002-02-28")
                        == calc.getDaysBetween("2002-02-28", "2001-11-01")
                , equalTo(true));
    }

    @Test
    public void shouldCalcSpanningYearTypes(){
        assertThat(calc.getDaysBetween("1984-01-01", "1986-12-31"), equalTo(1094));

        // given test case
        assertThat(calc.getDaysBetween("1989-01-03", "1983-08-03"), equalTo(1979));
    }


}

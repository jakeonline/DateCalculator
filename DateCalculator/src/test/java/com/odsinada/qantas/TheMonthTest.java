package com.odsinada.qantas;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TheMonthTest {

    @Test
    public void shouldReturnEndDayOf31DayMonths(){
        // arrange
        TheMonth monthA = new TheMonth(1, 2001);
        TheMonth monthB = new TheMonth(12, 1901);

        // act
        // assert
        assertThat(monthA.getMonthEndDay(), equalTo(31));
        assertThat(monthB.getMonthEndDay(), equalTo(31));
    }

    @Test
    public void shouldReturnEndDayOf30DayMonths(){
        // arrange
        TheMonth monthA = new TheMonth(9, 2001);
        TheMonth monthB = new TheMonth(4, 1901);

        // act
        // assert
        assertThat(monthA.getMonthEndDay(), equalTo(30));
        assertThat(monthB.getMonthEndDay(), equalTo(30));
    }

    @Test
    public void shouldReturnEndDayOfFebruaryRegularYear(){
        // arrange
        TheMonth monthA = new TheMonth(2, 2001);
        TheMonth monthB = new TheMonth(2, 1901);

        // act
        // assert
        assertThat(monthA.getMonthEndDay(), equalTo(28));
        assertThat(monthB.getMonthEndDay(), equalTo(28));
    }

    @Test
    public void shouldReturnEndDayOfFebruaryLeapYear(){
        // arrange
        TheMonth monthA = new TheMonth(2, 2000);
        TheMonth monthB = new TheMonth(2, 1984);

        // act
        // assert
        assertThat(monthA.getMonthEndDay(), equalTo(29));
        assertThat(monthB.getMonthEndDay(), equalTo(29));
    }

}

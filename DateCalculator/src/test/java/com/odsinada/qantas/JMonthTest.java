package com.odsinada.qantas;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class JMonthTest {

    @Test
    public void shouldReturnEndDayOf31DayMonths(){
        // arrange
        JMonth monthA = new JMonth(1, 2001);
        JMonth monthB = new JMonth(12, 1901);

        // act
        // assert
        assertThat(monthA.getMonthEndDay(), equalTo(31));
        assertThat(monthB.getMonthEndDay(), equalTo(31));
    }

    @Test
    public void shouldReturnEndDayOf30DayMonths(){
        // arrange
        JMonth monthA = new JMonth(9, 2001);
        JMonth monthB = new JMonth(4, 1901);

        // act
        // assert
        assertThat(monthA.getMonthEndDay(), equalTo(30));
        assertThat(monthB.getMonthEndDay(), equalTo(30));
    }

    @Test
    public void shouldReturnEndDayOfFebruaryRegularYear(){
        // arrange
        JMonth monthA = new JMonth(2, 2001);
        JMonth monthB = new JMonth(2, 1901);

        // act
        // assert
        assertThat(monthA.getMonthEndDay(), equalTo(28));
        assertThat(monthB.getMonthEndDay(), equalTo(28));
    }

    @Test
    public void shouldReturnEndDayOfFebruaryLeapYear(){
        // arrange
        JMonth monthA = new JMonth(2, 2000);
        JMonth monthB = new JMonth(2, 1984);

        // act
        // assert
        assertThat(monthA.getMonthEndDay(), equalTo(29));
        assertThat(monthB.getMonthEndDay(), equalTo(29));
    }

}

package com.odsinada.qantas;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TheYearTest
{

    @Test
    public void shouldHaveZeroDaysBetweenSameYear()
    {
        // arrange
        TheYear yearA = new TheYear(2001);
        TheYear yearB = new TheYear(2001);

        // act
        int fullDaysBetween = TheYear.getDaysBetweenExclusive(yearA, yearB);

        // assert
        assertThat(fullDaysBetween, equalTo(0));
    }


    @Test
    public void shouldHaveZeroDaysBetweenSucceedingYears()
    {
        // arrange
        TheYear yearA = new TheYear(2001);
        TheYear yearB = new TheYear(2002);

        // act
        int fullDaysBetween = TheYear.getDaysBetweenExclusive(yearA, yearB);

        // assert
        assertThat(fullDaysBetween, equalTo(0));
    }

    @Test
    public void shouldCalcDaysBetweenNonConsecutiveYears()
    {
        // arrange
        TheYear yearA = new TheYear(2001);
        TheYear yearB = new TheYear(2003);

        // act
        int fullDaysBetween = TheYear.getDaysBetweenExclusive(yearA, yearB);

        // assert
        assertThat(fullDaysBetween, equalTo(365));
    }

    @Test
    public void shouldCalcDaysBetweenMultipleNormalYears()
    {
        // arrange
        TheYear yearA = new TheYear(2001);
        TheYear yearB = new TheYear(2004);

        // act
        int fullDaysBetween = TheYear.getDaysBetweenExclusive(yearA, yearB);

        // assert
        assertThat(fullDaysBetween, equalTo(730));
    }

    @Test
    public void shouldReturnNormalYearDayCount(){
        // arrange
        TheYear yearA = new TheYear(2001);

        // act
        // assert
        assertThat(yearA.getDays(), equalTo(365));
    }

    @Test
    public void shouldReturnLeapYearDayCount(){
        // arrange
        TheYear yearA = new TheYear(2004);

        // act
        // assert
        assertThat(yearA.getDays(), equalTo(366));
    }

    @Test
    public void shouldIdentifyLeapYear(){
        // arrange
        TheYear yearA = new TheYear(2000);
        TheYear yearB = new TheYear(1900);
        TheYear yearC = new TheYear(1901);

        // act
        // assert
        assertThat(yearA.isLeapYear(), equalTo(true));
        assertThat(yearB.isLeapYear(), equalTo(false));
        assertThat(yearB.isLeapYear(), equalTo(false));
    }

    @Test
    public void shouldCalcDaysBetweenMixedYearTypes()
    {
        // arrange
        TheYear yearA = new TheYear(2001);
        TheYear yearB = new TheYear(2005);

        // act
        int fullDaysBetween = TheYear.getDaysBetweenExclusive(yearA, yearB);

        // assert
        assertThat(fullDaysBetween, equalTo(1096));
    }
}

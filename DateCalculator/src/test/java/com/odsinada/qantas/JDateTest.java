package com.odsinada.qantas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

@RunWith(value = MockitoJUnitRunner.class)
public class JDateTest {

    @Mock
    private JDate modelDate;

    private JDate jDate;

    @Test
    public void isPastOnLaterYear() {
        // arrange
        jDate = new JDate(2000, 1, 1);

        // act
        // assert
        assertThat(jDate.isPast(new JDate(1999, 1, 1)), equalTo(true));
    }

    @Test
    public void isPastOnSameYearLaterMonth() {
        // arrange
        jDate = new JDate(2000, 2, 1);

        // act
        // assert
        assertThat(jDate.isPast(new JDate(2000, 1, 1)), equalTo(true));
    }

    @Test
    public void isNotPastOnSameYearEarlierMonth() {
        // arrange
        jDate = new JDate(2000, 1, 1);

        // act
        // assert
        assertThat(jDate.isPast(new JDate(2000, 2, 1)), equalTo(false));
    }

    @Test
    public void isPastOnSameYearSameMonthLaterDay() {
        // arrange
        jDate = new JDate(2000, 1, 2);

        // act
        // assert
        assertThat(jDate.isPast(new JDate(2000, 1, 1)), equalTo(true));
    }

    @Test
    public void isNotPastOnSameYearSameMonthEarlierOrSameDay() {
        // arrange
        jDate = new JDate(2000, 1, 2);

        // act
        // assert
        assertThat(jDate.isPast(new JDate(2000, 1, 2)), equalTo(false));
        assertThat(jDate.isPast(new JDate(2000, 1, 3)), equalTo(false));
    }


    @Test
    public void isSameMonthYearOnIdenticalMonthYear() {
        // arrange
        jDate = new JDate(2000, 1, 2);

        // act
        // assert
        assertThat(jDate.isSameMonthYear(new JDate(2000, 1, 1)), equalTo(true));
        assertThat(jDate.isSameMonthYear(new JDate(2000, 1, 31)), equalTo(true));
    }

    @Test
    public void isNotSameMonthYearOnDifferentYear() {
        // arrange
        jDate = new JDate(2000, 1, 2);

        // act
        // assert
        assertThat(jDate.isSameMonthYear(new JDate(1999, 1, 1)), equalTo(false));
    }

    @Test
    public void isNotSameMonthYearOnDifferentMonth() {
        // arrange
        jDate = new JDate(2000, 1, 2);

        // act
        // assert
        assertThat(jDate.isSameMonthYear(new JDate(2000, 2, 1)), equalTo(false));
    }

    @Test
    public void shouldReturnNextMonthStartNonYearEnd() {
        // arrange
        jDate = new JDate(2000, 1, 15);

        // act
        JDate nextMonthStart = JDate.getNextMonthStart(jDate);

        // assert
        assertThat(nextMonthStart.getYear(), equalTo(2000));
        assertThat(nextMonthStart.getMonth(), equalTo(2));
        assertThat(nextMonthStart.getDay(), equalTo(1));
    }

    @Test
    public void shouldReturnNextMonthStartYearEnd() {
        // arrange
        jDate = new JDate(2000, 12, 15);

        // act
        JDate nextMonthStart = JDate.getNextMonthStart(jDate);

        // assert
        assertThat(nextMonthStart.getYear(), equalTo(2001));
        assertThat(nextMonthStart.getMonth(), equalTo(1));
        assertThat(nextMonthStart.getDay(), equalTo(1));
    }

    @Test
    public void shouldReturnMonthEnd() {
        // arrange
        when(modelDate.getYear()).thenReturn(2000);
        when(modelDate.getMonth()).thenReturn(1);
        when(modelDate.getMonthEndDay()).thenReturn(31);

        // act
        JDate monthEnd = JDate.getMonthEnd(modelDate);

        // assert
        assertThat(monthEnd.getYear(), equalTo(2000));
        assertThat(monthEnd.getMonth(), equalTo(1));
        assertThat(monthEnd.getDay(), equalTo(31));
    }

    @Test
    public void shouldReturnClone() {
        // arrange
        jDate = new JDate(2000, 12, 15);

        // act
        JDate monthEnd = JDate.clone(jDate);

        // assert
        assertThat(monthEnd.getYear(), equalTo(2000));
        assertThat(monthEnd.getMonth(), equalTo(12));
        assertThat(monthEnd.getDay(), equalTo(15));
    }

}




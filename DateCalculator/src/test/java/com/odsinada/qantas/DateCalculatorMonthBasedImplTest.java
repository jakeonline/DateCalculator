package com.odsinada.qantas;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(value = MockitoJUnitRunner.class)
public class DateCalculatorMonthBasedImplTest {

    private DateCalculatorMonthBasedImpl calc;
    @Mock
    private JDateIdentifier jDateIdentifier;

    @Mock
    private JDateParams jDateParams;
    @Mock
    private JDate mockDateA, mockDateB;

    private JDate jDateA, jDateB;

    @Before
    public void setup() {
        calc = new DateCalculatorMonthBasedImpl(jDateIdentifier);
        when(jDateIdentifier.getDateParams(mockDateA, mockDateB)).thenReturn(jDateParams);
    }

    @Test
    public void shouldCalcSucceedingDays() {
        // arrange
        jDateA = new JDate(1972, 11, 7);
        jDateB = new JDate(1972, 11, 8);
        when(jDateParams.getStartDate()).thenReturn(jDateA);
        when(jDateParams.getEndDate()).thenReturn(jDateB);

        // act
        // assert
        assertThat(calc.getDaysBetween(mockDateA, mockDateB), equalTo(0));
    }

    @Test
    public void shouldCalcSameDay() {
        // arrange
        jDateA = new JDate(1972, 11, 7);
        jDateB = new JDate(1972, 11, 7);
        when(jDateParams.getStartDate()).thenReturn(jDateA);
        when(jDateParams.getEndDate()).thenReturn(jDateB);

        // act
        // assert
        assertThat(calc.getDaysBetween(mockDateA, mockDateB), equalTo(0));
    }

    @Test
    public void shouldCalcDaysBetweenSameMonthSameYear() {
        // given test case
        // arrange
        jDateA = new JDate(1983, 6, 2);
        jDateB = new JDate(1983, 6, 22);
        when(jDateParams.getStartDate()).thenReturn(jDateA);
        when(jDateParams.getEndDate()).thenReturn(jDateB);

        // act
        // assert
        assertThat(calc.getDaysBetween(mockDateA, mockDateB), equalTo(19));
    }

    @Test
    public void shouldCalcDaysCrossing31DayMonthsSameYear() {
        // arrange
        jDateA = new JDate(2001, 7, 1);
        jDateB = new JDate(2001, 8, 31);
        when(jDateParams.getStartDate()).thenReturn(jDateA);
        when(jDateParams.getEndDate()).thenReturn(jDateB);

        // act
        // assert
        assertThat(calc.getDaysBetween(mockDateA, mockDateB), equalTo(60));
    }

    @Test
    public void shouldCalcDaysCrossing30DayMonthsSameYear() {
        // given test case
        // arrange
        jDateA = new JDate(1984, 7, 4);
        jDateB = new JDate(1984, 12, 25);
        when(jDateParams.getStartDate()).thenReturn(jDateA);
        when(jDateParams.getEndDate()).thenReturn(jDateB);

        // act
        // assert
        assertThat(calc.getDaysBetween(mockDateA, mockDateB), equalTo(173));
    }

    @Test
    public void shouldCalcDaysCrossingFebruarySameRegularYear() {
        // arrange
        jDateA = new JDate(2001, 1, 1);
        jDateB = new JDate(2001, 3, 10);
        when(jDateParams.getStartDate()).thenReturn(jDateA);
        when(jDateParams.getEndDate()).thenReturn(jDateB);

        // act
        // assert
        assertThat(calc.getDaysBetween(mockDateA, mockDateB), equalTo(67));
    }

    @Test
    public void shouldCalcDaysCrossingFebruarySameLeapYear() {
        // arrange
        jDateA = new JDate(2000, 1, 1);
        jDateB = new JDate(2000, 3, 10);
        when(jDateParams.getStartDate()).thenReturn(jDateA);
        when(jDateParams.getEndDate()).thenReturn(jDateB);

        // act
        // assert
        assertThat(calc.getDaysBetween(mockDateA, mockDateB), equalTo(68));
    }

    @Test
    public void shouldCalcDaysCrossingAllMonthsOfARegularYear() {
        // arrange
        jDateA = new JDate(2001, 1, 1);
        jDateB = new JDate(2001, 12, 31);
        when(jDateParams.getStartDate()).thenReturn(jDateA);
        when(jDateParams.getEndDate()).thenReturn(jDateB);

        // act
        // assert
        assertThat(calc.getDaysBetween(mockDateA, mockDateB), equalTo(363));
    }

    @Test
    public void shouldCalcDaysCrossingAllMonthsOfALeapYear() {
        // arrange
        jDateA = new JDate(2000, 1, 1);
        jDateB = new JDate(2000, 12, 31);
        when(jDateParams.getStartDate()).thenReturn(jDateA);
        when(jDateParams.getEndDate()).thenReturn(jDateB);

        // act
        // assert
        assertThat(calc.getDaysBetween(mockDateA, mockDateB), equalTo(364));
    }

    @Test
    public void shouldCalcDaysCrossingMonthOfDifferentYear() {
        // arrange
        jDateA = new JDate(2001, 1, 1);
        jDateB = new JDate(2002, 3, 31);
        when(jDateParams.getStartDate()).thenReturn(jDateA);
        when(jDateParams.getEndDate()).thenReturn(jDateB);

        // act
        // assert
        assertThat(calc.getDaysBetween(mockDateA, mockDateB), equalTo(453));
    }


    @Test
    public void shouldCalcSpanningYearTypes() {
        // given test case
        // arrange
        jDateA = new JDate(1989, 1, 3);
        jDateB = new JDate(1983, 8, 3);
        when(jDateParams.getStartDate()).thenReturn(jDateB);
        when(jDateParams.getEndDate()).thenReturn(jDateA);

        // act
        // assert
        assertThat(calc.getDaysBetween(mockDateA, mockDateB), equalTo(1979));
    }

    @Test
    public void shouldCalcSpanningMaxDateInputs() {
        // given test case
        // arrange
        jDateA = new JDate(1901, 1, 1);
        jDateB = new JDate(2999, 12, 31);
        when(jDateParams.getStartDate()).thenReturn(jDateA);
        when(jDateParams.getEndDate()).thenReturn(jDateB);

        // act
        // assert
        assertThat(calc.getDaysBetween(mockDateA, mockDateB), equalTo(401400));
    }


}

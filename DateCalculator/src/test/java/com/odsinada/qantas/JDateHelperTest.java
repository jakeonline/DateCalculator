package com.odsinada.qantas;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class JDateHelperTest {

    private JDate dateA, dateB;
    private JDateHelper helper;

    @Test
    public void shouldArrangeWhenFirstDateIsEarlier(){

        // arrange
        dateA = new JDate(2001, 01, 01);
        dateB = new JDate(2002, 01, 01);

        // act
        JDateParams params = JDateHelper.getDateParams(dateA, dateB);

        // assert
        assertThat(params.getStartDate(), equalTo(dateA));
        assertThat(params.getEndDate(), equalTo(dateB));
    }

    @Test
    public void shouldArrangeWhenSecondDateIsEarlier(){

        // arrange
        dateA = new JDate(2002, 01, 01);
        dateB = new JDate(2001, 01, 01);

        // act
        JDateParams params = JDateHelper.getDateParams(dateA, dateB);

        // assert
        assertThat(params.getStartDate(), equalTo(dateB));
        assertThat(params.getEndDate(), equalTo(dateA));
    }
}

package com.odsinada.qantas;

public class JDateHelper {

    public static JDateParams getDateParams(JDate dateA, JDate dateB){
        JDateParams params = new JDateParams();

        JDate startDate = null;
        JDate endDate = null;
        if(dateA.isBeyond(dateB)){
            startDate = dateB;
            endDate = dateA;
        } else {
            startDate = dateA;
            endDate = dateB;
        }

        params.setStartDate(startDate);
        params.setEndDate(endDate);

        return params;

    }
}

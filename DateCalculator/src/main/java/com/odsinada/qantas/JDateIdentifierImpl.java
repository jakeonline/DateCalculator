package com.odsinada.qantas;

import com.odsinada.qantas.JDate;
import com.odsinada.qantas.JDateIdentifier;
import com.odsinada.qantas.JDateParams;

public class JDateIdentifierImpl implements JDateIdentifier {

    @Override
    public JDateParams getDateParams(JDate dateA, JDate dateB) {
        JDateParams params = new JDateParams();

        JDate startDate = dateA;
        JDate endDate = dateB;

        if (dateA.isPast(dateB)) {
            startDate = dateB;
            endDate = dateA;
        }

        params.setStartDate(startDate);
        params.setEndDate(endDate);

        return params;

    }
}

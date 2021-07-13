package model.common;

import java.math.BigDecimal;


import java.sql.Timestamp;

import oracle.jbo.server.DBTransaction;
import oracle.jbo.server.SequenceImpl;

public class ModelUtil 
{
    public static BigDecimal getSequaenceNextVal(DBTransaction transaction)
    {
         SequenceImpl seq = new SequenceImpl("ID_SEQ", transaction);
         return new BigDecimal(seq.getSequenceNumber().toString());
    }
    
    public static Timestamp getCurrentDate()
    {
        java.util.Date today = new java.util.Date();
        return new Timestamp(today.getTime());
    }
}

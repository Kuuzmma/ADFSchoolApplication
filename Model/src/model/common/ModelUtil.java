package model.common;

import java.math.BigDecimal;

import oracle.jbo.server.DBTransaction;
import oracle.jbo.server.SequenceImpl;


public class ModelUtil 
{
    public static BigDecimal getSequanceNextVal(DBTransaction transaction)
    {
        SequenceImpl seq = new SequenceImpl("ID_SEQ", transaction);
        return new BigDecimal(seq.getSequenceNumber().toString());
    }
}

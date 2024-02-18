

/**
 * Сделал только для сложения. Для других оперций будет тоже самое, нет смысла копипастить.
 */
public class Calculator {

    public static <T1, T2, T3 extends Number> T1 sum(T2 val1, T3 val2) throws ClassCastException{
        if(val1 instanceof Byte) return (T1)byteAdd((Byte)val1, val2);
        if(val1 instanceof Double) return (T1)doubleAdd((Double)val1, val2);
        if(val1 instanceof Float) return (T1)floatAdd((Float)val1, val2);
        if(val1 instanceof Integer) return (T1)intAdd((Integer)val1, val2);
        if(val1 instanceof Long) return (T1)longAdd((Long)val1, val2);
        if(val1 instanceof Short) return (T1)shortAdd((Short)val1, val2);
  

        throw new ClassCastException("Unknown type");
    }

    public static <T extends Number> void multiply(T val1, T val2) throws ClassCastException{
        // if(val1 instanceof Byte) return (T1)byteMult((Byte)val1, val2);
        // if(val1 instanceof Double) return (T1)doubleMult((Double)val1, val2);
        // if(val1 instanceof Float) return (T1)floatMult((Float)val1, val2);
        // if(val1 instanceof Integer) return (T1)intMult((Integer)val1, val2);
        // if(val1 instanceof Long) return (T1)longMult((Long)val1, val2);
        // if(val1 instanceof Short) return (T1)shortMult((Short)val1, val2);
  
        throw new ClassCastException("Unknown type");
    }


    private static <T extends Number> Number byteAdd(Byte number, T adder){
        if(adder instanceof Byte) return number + (Byte)adder;
        if(adder instanceof Double) return number + (Double)adder;
        if(adder instanceof Float) return number + (Float)adder;
        if(adder instanceof Integer) return number + (Integer)adder;
        if(adder instanceof Long) return number + (Long)adder;
        if(adder instanceof Short) return number + (Short)adder;
        throw new ClassCastException("Unknown type");
    }

    private static <T extends Number> Number doubleAdd(Double number, T adder){
        if(adder instanceof Byte) return number + (Byte)adder;
        if(adder instanceof Double) return number + (Double)adder;
        if(adder instanceof Float) return number + (Float)adder;
        if(adder instanceof Integer) return number + (Integer)adder;
        if(adder instanceof Long) return number + (Long)adder;
        if(adder instanceof Short) return number + (Short)adder;
        throw new ClassCastException("Unknown type");
    }

    private static <T extends Number> Number floatAdd(Float number, T adder){
        if(adder instanceof Byte) return number + (Byte)adder;
        if(adder instanceof Double) return number + (Double)adder;
        if(adder instanceof Float) return number + (Float)adder;
        if(adder instanceof Integer) return number + (Integer)adder;
        if(adder instanceof Long) return number + (Long)adder;
        if(adder instanceof Short) return number + (Short)adder;
        throw new ClassCastException("Unknown type");
    }

    private static <T extends Number> Number intAdd(Integer number, T adder){
        if(adder instanceof Byte) return number + (Byte)adder;
        if(adder instanceof Double) return number + (Double)adder;
        if(adder instanceof Float) return number + (Float)adder;
        if(adder instanceof Integer) return number + (Integer)adder;
        if(adder instanceof Long) return number + (Long)adder;
        if(adder instanceof Short) return number + (Short)adder;
        throw new ClassCastException("Unknown type");
    }

    private static <T extends Number> Number longAdd(Long number, T adder){
        if(adder instanceof Byte) return number + (Byte)adder;
        if(adder instanceof Double) return number + (Double)adder;
        if(adder instanceof Float) return number + (Float)adder;
        if(adder instanceof Integer) return number + (Integer)adder;
        if(adder instanceof Long) return number + (Long)adder;
        if(adder instanceof Short) return number + (Short)adder;
        throw new ClassCastException("Unknown type");
    }

    private static <T extends Number> Number shortAdd(Short number, T adder){
        if(adder instanceof Byte) return number + (Byte)adder;
        if(adder instanceof Double) return number + (Double)adder;
        if(adder instanceof Float) return number + (Float)adder;
        if(adder instanceof Integer) return number + (Integer)adder;
        if(adder instanceof Long) return number + (Long)adder;
        if(adder instanceof Short) return number + (Short)adder;
        throw new ClassCastException("Unknown type");
    }



}
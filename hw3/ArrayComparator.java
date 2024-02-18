

public class ArrayComparator {
    public static <T1, T2> Boolean CompareArrays(T1[] array1, T2[] array2){
        if(array1.length != array2.length) return false;
        for (int i = 0; i<array1.length; i++) {
            if(array1[i].getClass() != array2[i].getClass()) return false;
        }
        

        return true;
    }
}

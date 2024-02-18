

public class Main {
    public static void main(String[] args) {
        Integer i = 123;
        Float f = 6.55f;
        Number n;

        n = Calculator.sum(i, f);
        System.out.printf("n=%s, type: \"%s\"\n", n, n.getClass().getSimpleName());

        Float f2 = Calculator.sum(i, f);
        System.out.printf("f2=%s, type: \"%s\"\n", f2, f2.getClass().getSimpleName());

        //Integer i2 = Calculator.sum(i, f);    // CastException






        Object[] arr1 = new Object[]{12, 22f, true};
        Object[] arr2 = new Object[]{27, 5.5f, false};
        Object[] arr3 = new Object[]{33, 44, 55};
        String[] arr4 = new String[]{"asd", "sdf", "dfg"};
        Integer[] arr5 = new Integer[]{1,2,3};

        System.out.printf("arr1 = arr2 is %s\n", ArrayComparator.CompareArrays(arr1, arr2));
        System.out.printf("arr1 = arr3 is %s\n", ArrayComparator.CompareArrays(arr1, arr3));
        System.out.printf("arr4 = arr5 is %s\n", ArrayComparator.CompareArrays(arr4, arr5));




        
        
        Pair<Double, String> pair = new Pair<>(125.6332,"AAAAAA");
        Double d = pair.getFirst();
        String s = pair.getSecond();
        System.out.println(pair);

        Pair<Boolean, Integer[]> pair2 = new Pair<Boolean,Integer[]>(true, new Integer[]{1,2,3});
        System.out.println(pair2);


    }

}

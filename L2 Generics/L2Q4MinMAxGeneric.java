public class L2Q4MinMAxGeneric {

    public static <T extends Comparable<T>> String minMax(T[] array){
        T min = array[0];
        T max = array[0];
        for(T t : array){
            if(t.compareTo(min) < 0){
                min = t;
            }
            if(t.compareTo(max) > 0){
                max = t;
            }
        }
        return "Min: " + min + " Max: " + max;
    }

    public static void main(String[] args){
        Integer[] intArray = {5,3,7,1,4,9,8,2};
        String[] strArray = {"red", "blue", "orange", "tan"};

        System.out.println(minMax(intArray));
        System.out.println(minMax(strArray));
    }
}

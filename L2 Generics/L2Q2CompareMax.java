public class L2Q2CompareMax<T>{
    public static <T extends Comparable<T>> T maximum (T x, T y, T z){
        T max = x;

        if(y.compareTo(max) > 0){
            max = y;
        }

        if(z.compareTo(max) > 0){
            max = z;
        }

        return max;
    }

    public static void main (String[] args){
        System.out.println("Maximum (3,2,4): " + maximum(3,2,4));
        System.out.println("Maximum of 'apple', 'banana', 'cherry': " + maximum("apple", "banana", "cherry"));
    }
}
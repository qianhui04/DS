public class L2Q5FindMax {
    public static <E extends Comparable<E>> E max(E[] list){
        E max = list[0];
        for(E e : list){
            if(e.compareTo(max) > 0){
                max = e;
            }
        }
        return max;
    }

    public static void main(String[] args){
        Integer[] intList = {1,2,3};
        String[] strList = { "red", "green", "blue" };
        L2Q5Circle[] circleList = {new L2Q5Circle(3), new L2Q5Circle(2.9), new L2Q5Circle(5.9)};
        System.out.println("Max = " + max(intList));
        System.out.println("Max = " + max(strList));
        System.out.println("Max = " + max(circleList));
    }
}

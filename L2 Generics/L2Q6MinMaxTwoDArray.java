public class L2Q6MinMaxTwoDArray {

    public static <E extends Comparable<E>> E min(E[][] list){
        E min = list[0][0];
        for(E[] e : list){
            for(E f : e){
                if(f.compareTo(min) < 0){
                    min = f;
                }
            }
        }
        return min;
    }
    
    public static <E extends Comparable<E>> E max(E[][] list){
        E max = list[0][0];
        for(E[] row : list){
            for(E element : row){
                if(element.compareTo(max) > 0){
                    max = element;
                }
            }
        }
        return max;
    }

    public static void main (String[] args){
        Integer[][] numbers = {{4,5,6}, {1,2,3}};
        System.out.println("Min:" + min(numbers));
        System.out.println("Max:" + max(numbers));
    }
    // public static <E extends Comparable<E>> E max(E[][] list){
    //     E max = list[0][0];
    //     for(int i=0;i<list.length;i++){
    //         for(int j=0;j<list[i].length;j++){
                
    //         }
    //     }
    // }
}

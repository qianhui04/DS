public class L2Q3StorePairGeneric<T extends Comparable<T>> implements Comparable <L2Q3StorePairGeneric<T>> {
    private T first, second;

    public L2Q3StorePairGeneric(T first, T second){
        this.first = first;
        this.second = second;
    }

    public T getFirst(){
        return first;
    }

    public T getSecond(){
        return second;
    }

    public void setFirst(T first){
        this.first = first;
    }

    public void setSecond(T second){
        this.second = second;
    }

    public void setPair(T first, T second){
        this.first = first;
        this.second = second;
    }

    public String toString(){
        return "first = " + first + " second = " + second;
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        L2Q3StorePairGeneric<?> other = (L2Q3StorePairGeneric<?>) obj;
        return first.equals(other.first);
    }

    public int compareTo(L2Q3StorePairGeneric<T> other){
        return this.first.compareTo(other.first);
    }

    public static void main (String[] args){
        L2Q3StorePairGeneric<Integer> a = new L2Q3StorePairGeneric<>(6, 4);
        L2Q3StorePairGeneric<Integer> b = new L2Q3StorePairGeneric<>(2, 2);
        L2Q3StorePairGeneric<Integer> c = new L2Q3StorePairGeneric<>(6, 3);

        System.out.println(a.compareTo(c));
        System.out.println(a.compareTo(b));
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
    }
}
public class L2Q1myGeneric<T>{
    private T e;

    public L2Q1myGeneric(){
        this.e = null;
    }

    public L2Q1myGeneric(T e){
        this.e = e;
    }

    public T getE(){
        return e;
    }

    public void setE(T e){
        this.e = e;
    }

    public static void main(String[] args){
        L2Q1myGeneric<String> strObj = new L2Q1myGeneric<>("ABC");
        System.out.println("String value: " + strObj.getE());

        L2Q1myGeneric<Integer> intObj = new L2Q1myGeneric<>(24);
        System.out.println("Integer value: " + intObj.getE());

    }
}
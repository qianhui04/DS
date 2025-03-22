import java.util.Arrays;

public class L3Q1BagArray<T> implements L3Q1BagInterface<T>{
    private T[] bag;
    private int DEFAULT_CAPACITY = 25;
    private int numberOfEnteries;

    @SuppressWarnings("unchecked")
    public L3Q1BagArray(){
        bag = (T[]) new Object[DEFAULT_CAPACITY];
        numberOfEnteries = 0;
    }

    public int getCurrentSize(){
        return numberOfEnteries;
    }

    public boolean isFull(){
        if(numberOfEnteries == DEFAULT_CAPACITY){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if(numberOfEnteries == 0)
        return true;

        return false;
    }

    public boolean add(T newEntry){
        if(numberOfEnteries < DEFAULT_CAPACITY){
            bag[numberOfEnteries] = newEntry;
            numberOfEnteries++;
            return true;
        }
        return false;
    }

    public T remove(){
        if(isEmpty()){
            return null;
        }
        T result = bag[numberOfEnteries - 1];
        bag[numberOfEnteries - 1] = null;
        numberOfEnteries --;
        return result;
    }

    public boolean remove(T anEntry){
        for(int i=0;i<numberOfEnteries;i++){
            if(bag[i].equals(anEntry)){
                bag[i] = bag[numberOfEnteries - 1];
                bag[numberOfEnteries - 1] = null;
                return true;
            }
        }
        return false;
    }

    public void clear(){
        while(!isEmpty()){
            remove();
        }
    }

    public int getFrequencyOf(T anEntry){
        for(int i=0;i<numberOfEnteries;i++){
            if(bag[i].equals(anEntry)){
                return i+1;
            }
        }
        return -1;
    }

    public boolean contains(T anEntry){
        for(int i=0;i<numberOfEnteries;i++){
            if(bag[i].equals(anEntry)){
                return true;
            }
        }
        return false;
    }

    public T[] toArray(){
        return Arrays.copyOf(bag, numberOfEnteries);
        //Arrays.copyOf(where, length);
    }

        public static void main(String[] args) {
            L3Q1BagArray<String> bag = new L3Q1BagArray<>();
    
            // Adding items to the bag
            bag.add("Apple");
            bag.add("Banana");
            bag.add("Orange");
            
            // Displaying contents
            System.out.println("Bag contains: " + Arrays.toString(bag.toArray()));
            System.out.println("Bag size: " + bag.getCurrentSize());
    
            // Removing an item
            bag.remove("Banana");
            System.out.println("After removing 'Banana': " + Arrays.toString(bag.toArray()));
    
            // Checking if an item exists
            System.out.println("Bag contains 'Apple': " + bag.contains("Apple"));
    
            // Removing an item randomly
            System.out.println("Removing random item: " + bag.remove());
    
            // Checking if the bag is empty
            System.out.println("Bag is empty: " + bag.isEmpty());
        }
}

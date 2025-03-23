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

    public T[] union(T[] bag2){
        int arraySize = this.numberOfEnteries + bag2.length;
        T[] result = (T[]) new Object[arraySize];
        System.arraycopy(this.bag, 0, result, 0, this.numberOfEnteries);
        System.arraycopy(bag2, 0, result, this.numberOfEnteries, bag2.length);

        return result;
    }

    public T[] intersection(T[] bag2){
        int maxSize = Math.max(this.numberOfEnteries, bag2.length);
        T[] result = (T[]) new Object[maxSize];
        int resultIndex = 0;
        for(int i=0;i<bag2.length;i++){
            for(int j=0;j<this.numberOfEnteries;j++){
                if(bag2[i].equals(bag[j])){
                    result[resultIndex++] = bag2[i];
                    break;
                }
            }
        }
        return Arrays.copyOf(result, resultIndex);
    }

    public T[] difference(T[] bag2){
        int maxSize = this.numberOfEnteries;
        T[] result = (T[]) new Object[maxSize];
        System.arraycopy(bag, 0, result, 0, this.numberOfEnteries);
        for(int i=0;i<bag2.length;i++){
            for(int j=0;j<maxSize;j++){
                if(bag2[i] != null && result[j] != null && bag2[i].equals(bag[j])){
                    for(int k=j;k<maxSize-1;k++){
                        result[k] = result[k+1];
                    }
                    result[--maxSize] = null;
                    break;
                }
            }
        }
        return Arrays.copyOf(result, maxSize);
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

            String[] bag2 = {"Banana"};
            System.out.println("Union of bags: " + Arrays.toString(bag.union(bag2)));

            String[] bag3 = {"Banana", "Grapes", "Apple"};
            System.out.println("Intersections of bags: " + Arrays.toString(bag.intersection(bag3)));

            String[] bag4 = {"Apple", "Banana", "Grapes"};
            System.out.println("Difference of bags: " + Arrays.toString(bag.difference(bag4)));
        }
}

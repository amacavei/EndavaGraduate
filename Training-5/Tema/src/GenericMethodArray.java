/**
 * Created by amacavei on 7/23/2015.
 */
public class GenericMethodArray {

    public static <E> void printArray(E[] inputArray){
        for(E element : inputArray){
            System.out.printf("%s",element);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {1,2,3,4,5};
        Double[] doubleArray = {1.1,2.2,3.3,4.4,5.5};
        Character[] charArray = {'H','E','L','L','O'};

        printArray(intArray);
        printArray(doubleArray);
        printArray(charArray);
    }
}

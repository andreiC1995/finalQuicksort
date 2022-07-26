import java.util.Random;

public class FinalQuicksort {

    public static void main(String[] args){
        Random rand = new Random();

        int[] array = new int[10];
        for(int i=0;i<array.length;i++){
            array[i] = rand.nextInt(50);
        }

        System.out.println("Array inainte de quicksort : ");
        printArray(array);

        quicksort(array,0,array.length-1);

        System.out.println("Array dupa quicksort: ");
        printArray(array);

    }

    private static void printArray(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i] + " ");
        }
    }

    private static void quicksort(int[] array,int lowIndex, int highIndex){

        if(lowIndex > highIndex){
            return;
        }

        int pivot = array[highIndex];

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer < rightPointer){
            while(leftPointer < rightPointer && array[leftPointer] <= pivot){
                leftPointer++;
            }

            while(leftPointer < rightPointer && array[rightPointer] >= pivot){
                rightPointer--;
            }

            swap(array,leftPointer,rightPointer);
        }
        swap(array, leftPointer, highIndex);

        quicksort(array, lowIndex, leftPointer - 1);
        quicksort(array, leftPointer+1 , highIndex);

    }

    private static void swap(int[] array,int leftPointer,int rightPointer){
        int aux = array[leftPointer];
        array[leftPointer] = array[rightPointer];
        array[rightPointer] = aux;
    }
}

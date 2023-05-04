import java.util.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] unsortedArray = new int[20];
        Random random = new Random();
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = random.nextInt(100);
        }
        System.out.println("Неотсортированный массив: ");
        print(unsortedArray);


        int[] sortedArrayBySelectionSort = selectionSort(unsortedArray);
        System.out.println("Сортировка выбором: ");
        print(sortedArrayBySelectionSort);
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = random.nextInt(100);
        }


        System.out.println("Неотсортированный массив: ");
        print(unsortedArray);
        int[] sortedArrayByBubbleSort = bubbleSort(unsortedArray);
        System.out.println("Сортировка пузырьком: ");
        print(sortedArrayByBubbleSort);


        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = random.nextInt(100);
        }
        System.out.println("Неотсортированный массив: ");
        print(unsortedArray);
        quicksort(unsortedArray,0,unsortedArray.length-1);
        System.out.println("Быстрая сортировка: ");
        print(unsortedArray);

    }
    public static void quicksort(int[] array, int low, int high){
        if (array.length==0)
            return;
        if (array.length==1)
            return;
        if (low>=high)
            return;

        int middle = low+(high-low)/2;
        int pivot = array[middle];

        int i = low;
        int j = high;
        while(i<=j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }


        if (low<j)
            quicksort(array,low,j);
        if (high>i)
            quicksort(array,i,high);
    }
    public static void swap(int[] array, int i, int j){
        int z = array[i];
        array[i] = array[j];
        array[j] = z;
    }

    public static int[] selectionSort(int[] array){

        for (int i = 0; i < array.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = i; j < array.length; j++) {
                if (array[j]<min) {
                    min = array[j];
                    index = j;
                }
            }
            if (index>-1) {
                int z = array[i];
                array[i] = array[index];
                array[index] = z;
            }
        }
        return array;
    }

    public static int[] bubbleSort(int[] array){
        for (int j = 0; j<array.length ; j++) {
            for (int i = array.length-1; i > j; i--) {
                if (array[i] < array[i - 1]) {
                    int z = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = z;
                }
            }
        }
        return array;
    }
    public static int binarySearch(int[] array, int pattern){
        int leftBoarder = 0;
        int rightBorder = array.length-1;
        while (rightBorder>=leftBoarder){
            int midIndex = (leftBoarder+rightBorder)/2;
            if (array[midIndex]==pattern)
                return midIndex;
            else if (array[midIndex]<pattern)
                leftBoarder = midIndex+1;
            else {
                rightBorder = midIndex-1;
            }

        }
        return -1;
    }

    public static int binarySearchRecursion(int[] array,int leftBoarder, int rightBoarder, int pattern) {
        int midIndex = (rightBoarder+leftBoarder)/2;
        if (leftBoarder>rightBoarder)
            return -1;
        if (array[midIndex]>pattern)
            return binarySearchRecursion(array,0,midIndex-1,pattern);
        if (array[midIndex]<pattern)
            return binarySearchRecursion(array,midIndex+1,rightBoarder,pattern);
        if (array[midIndex]==pattern)
            return midIndex;
        return -1;
    }
    public static int countElementsInList(List<Integer> list){
        if (list.size()==0)
            return 0;
        if (list.size()==1)
            return 1;
        list.remove(0);
        return 1+countElementsInList(list);
    }
    public static Integer maxElementInList(List<Integer> list){
        if (list.size()==0)
            return null;
        if (list.size()==1)
            return list.get(0);
        int a = list.get(0);
        list.remove(0);
        return a>maxElementInList(list) ? a : maxElementInList(list);

    }
    public static void print(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println("");
    }



}
package sorters;

import java.util.Arrays;

public class Sorters {
  
  public static void swap (int [] arr, int ind1, int ind2) {
    int temp = arr [ind1];
    arr [ind1] = arr [ind2];
    arr [ind2] = temp;
  }
  
  public static void printArray (int [] arr) {
	  for (int k = 0; k < arr.length; k ++) {
          System.out.print(arr[k]+" ");
        }
      System.out.println(); 
  }
  
  public static void bubbleSortAsc (int arr []) {
    for (int i = 0; i < arr.length; i ++) {
      for (int j = 0; j < arr.length-1-i; j ++) {
        if (arr[j] > arr[j+1]) {
          swap (arr, j+1, j);
        }
      }
    }
  }
  
  public static void bubbleSortDesc (int [] arr) {
    for (int i = 0; i <= arr.length; i ++) {
      for (int j = arr.length-1; j >= i+1; j --) {
        if (arr[j-1] > arr [j]) {
          swap (arr, j-1, j);
        }
      }
    }
  }
  
  public static void arraySort (int arr []) {
	  Arrays.sort(arr);
  }
  
  public static void quickSort (int arr [], int low, int high) {
	  int left = low;
	  int right = high;
	  int piv = arr [(low+high) / 2];
	  
	  while (left <= right) {
		  while (arr [left] < piv) {
			  left ++;
		  }
		  while (arr [right] > piv) {
			  right --;
		  }
		  if (left <= right) {
			  Sorters.swap (arr, left, right);
			  left ++;
			  right --;
		  }
	  }
	  if (low < right) {
		  Sorters.quickSort(arr, low, right);
	  }
	  if (high > left) {
		  Sorters.quickSort(arr, left, high);
	  }
  }
  
  public static int [] merge (int [] arr1, int [] arr2) {
	  int ind1 = 0;
	  int ind2 = 0;
	  int [] arr = new int [arr1.length + arr2.length];
	  int ind = 0;
	  for (; ind < arr.length; ind ++) {
		  if (ind1 >= arr1.length || ind2 >= arr2.length) {
			  	break;
			  }
		  if (arr1 [ind1] <= arr2 [ind2]) {
			  arr [ind] = arr1 [ind1];
			  ind1 ++;
		  }
		  else {
			  arr [ind] = arr2 [ind2];
			  ind2 ++;
		  }
	  }
	  if (ind1 < arr1.length) {
		  for (int i = ind1; i < arr1.length; i ++, ind ++) {
			  arr [ind] = arr1 [i];
		  }
	  }
	  else if (ind2 < arr2.length) {
		  for (int i = ind2; i < arr2.length; i ++, ind ++) {
			  arr [ind] = arr2 [i];
		  }
	  }
	  return arr;
  }
  
  public static void mergeBubbleSortAsc (int [] arr) {
	  int [] arr1 = Arrays.copyOfRange(arr, 0, arr.length / 2);
	  int [] arr2 = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
	  Sorters.bubbleSortAsc(arr1);
	  Sorters.bubbleSortAsc(arr2);
	  arr = Sorters.merge(arr1, arr2);
  }
  
  public static void mergeBubbleSortDesc (int [] arr) {
	  int [] arr1 = Arrays.copyOfRange (arr, 0, arr.length / 2);
	  int [] arr2 = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
	  Sorters.bubbleSortDesc(arr1);
	  Sorters.bubbleSortDesc(arr2);
	  arr = Sorters.merge (arr1, arr2);
  }
  
  public static void mergeArraySort (int [] arr) {
	  int [] arr1 = Arrays.copyOfRange (arr, 0, arr.length / 2);
	  int [] arr2 = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
	  Sorters.arraySort(arr1);
	  Sorters.arraySort(arr2);
	  arr = Sorters.merge (arr1, arr2);
  }
  
  public static void mergeQuickSort (int [] arr) {
	  int [] arr1 = Arrays.copyOfRange (arr, 0, arr.length/ 2);
	  int [] arr2 = Arrays.copyOfRange (arr, arr.length / 2, arr.length);
	  Sorters.quickSort (arr1, 0, arr1.length - 1);
	  Sorters.quickSort (arr2, 0, arr2.length - 1);
	  arr = Sorters.merge (arr1, arr2);
  }
  
  
  
  public static void main(String[] args) {
	/*
	int [] a = {4,3,2,1};
	Sorters.bubbleSortAsc(a);
	Sorters.printArray(a);
    
    int [] a1 = {4,3,2,1};
    Sorters.bubbleSortDesc(a1);
    Sorters.printArray(a1);
    
    int [] a2 = {4,3,2,1};
    Sorters.arraySort (a2);
    Sorters.printArray(a2);
	
	int [] a3 = {4,3,2,1};
    Sorters.quickSort (a3, 0, a3.length - 1);
    Sorters.printArray(a3);
	 */
  }

}
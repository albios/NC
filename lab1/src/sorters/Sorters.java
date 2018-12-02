package sorters;

import java.util.Arrays;
import sorters.BubbleSorter;

public class Sorters extends AbstractSorter {
	@Sorter
  public void arraySort (int arr []) {
	  Arrays.sort(arr);
  }

  @Sorter
  public void quickSort (int arr [], int low, int high) {
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
		  quickSort(arr, low, right);
	  }
	  if (high > left) {
		  quickSort(arr, left, high);
	  }
  }

  @Sorter
  public void mergebubbleSortForth (int [] arr) {
	  int [] arr1 = Arrays.copyOfRange(arr, 0, arr.length / 2);
	  int [] arr2 = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
	  BubbleSorter s = new BubbleSorter ();
	  s.bubbleSortForth(arr1);
      s.bubbleSortForth(arr2);
	  arr = s.merge(arr1, arr2);
  }

  @Sorter
  public void mergebubbleSortBack (int [] arr) {
	  int [] arr1 = Arrays.copyOfRange (arr, 0, arr.length / 2);
	  int [] arr2 = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
	  BubbleSorter s = new BubbleSorter ();
	  s.bubbleSortBack(arr1);
	  s.bubbleSortBack(arr2);
	  arr = s.merge (arr1, arr2);
  }

  @Sorter
  public void mergeArraySort (int [] arr) {
	  int [] arr1 = Arrays.copyOfRange (arr, 0, arr.length / 2);
	  int [] arr2 = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
      Sorters s = new Sorters ();
	  s.arraySort(arr1);
	  s.arraySort(arr2);
	  arr = s.merge (arr1, arr2);
  }

  @Sorter
  public void mergeQuickSort (int [] arr) {
	  int [] arr1 = Arrays.copyOfRange (arr, 0, arr.length/ 2);
	  int [] arr2 = Arrays.copyOfRange (arr, arr.length / 2, arr.length);
      Sorters s = new Sorters ();
	  s.quickSort (arr1, 0, arr1.length - 1);
	  s.quickSort (arr2, 0, arr2.length - 1);
	  arr = s.merge (arr1, arr2);
  }
  
  
  
  public static void main(String[] args) {
	/*
	int [] a = {4,3,2,1};
	Sorters.bubbleSortForth(a);
	Sorters.printArray(a);
    
    int [] a1 = {4,3,2,1};
    Sorters.bubbleSortFBack(a1);
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

//
// QuickSort algorithm
//
// Author - Joe Celi
//
// Date completed - 7/4/18
//
// Notes - 


import java.util.Arrays;

public class QuickSort {
	
	public static int iterations = 0;
	public static boolean fFirst = true;
	private static int iPrintCount = 0;
	
	public QuickSort() {
		// System.out.println("QuickSort::Constructor");
	}
	
	private void swap(int[] a, int low, int high) {
		int tmp = a[low];
		a[low] = a[high];
		a[high] = tmp;
	}
	
	private int partition(int[] a, int low, int high) {
		
		// System.out.println("left == " + low + " - right == " + high);
		int pivot = high;
		
		while(low < high) {
			
			//
			// Work the left side - numbers should be less then the pivot
			//
			while(low < high) {
				if(a[low] > a[pivot]) {
					break;
				}
				++low;
			}
			
			while(high > low) {	
				if(a[high] < a[pivot]) {
					break;
				}
				--high;
			}
			
			if(low < high) {
			   swap(a, low, high);
			   ++low;
			   --high;
			   // printArray(a);
			}
		}
		
		//
		// high and low are either equal or have crossed by this point
		//
		swap(a, low, pivot);
		// printArray(a);
		++iterations;
		return low;
	}
	
	private void sortInner(int[] a, int left, int right) {
		//System.out.println("Left == " + left + " Right == " + right);
		
		if(left < right -1) {
			int pivotIndex = partition(a, left, right);
			// System.out.println("Returned pivot == " + pivotIndex);
			sortInner(a, left, pivotIndex-1);
			sortInner(a, pivotIndex+1, right);
		}
		else if(left < right && a[left] > a[right])
			swap(a, left, right);
	}
	
	private boolean adjustForWorseCase(int[] a) {
		boolean fMin = true;
		boolean fMax = true;
		int iPivot = a.length - 1;
		int i = 0;
		
		// 
		// Ensure min or the max values are not in last position
		//
		while(i < iPivot) {
			
			if(fMin == true) {
				if(a[i] < a[iPivot]) {
					fMin = false;
				}
			}
			
			if(fMax == true) {
				if(a[i] > a[iPivot]) {
					fMax = false;
				}
			}
			
			if(fMin == false && fMax == false)
				return false;
			
			i++;
		}
		
		//
		// If we reach this point the last position is either the max or the min
		// so we just swap it with whatever is in the middle position
		//
		swap(a, iPivot/2, iPivot);
		return true;
	}
	
	public void sort(int[] a) {
		// System.out.println("QuickSort::sort - entering");
		printArray(a);
		
		if(adjustForWorseCase(a))
		{
			System.out.println("Adjusted - " + Arrays.toString(a));
		}
		
		sortInner(a, 0, a.length-1);
		printArray(a);
		System.out.println(iterations + " iterations");
	}
	
	private void printArray(int[] a) {
		
		String sOut  = "" + iPrintCount + " " + Arrays.toString(a);
		++iPrintCount;
		System.out.println(sOut + "\n");
	}
	
	public static void main(String args[]) {
		
		// System.out.println("Entering main");
		// int[] arr = { 17, 41, 5, 22, 54, 6, 29, 3, 13 };
		// int[] arr = { 54, 41, 29, 22, 17, 13, 6, 5, 3 };
		//int[] arr = { 54, 41, 29, 22, 3, 13, 6, 5, 17 };
		// int[] arr = { 22, 11 };
		// int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		
		//
		//
		//
		QuickSort app = new QuickSort();
		app.sort(arr);
	}

} // end of the QuickSort class

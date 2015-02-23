package Sorting;

public class QuickSort<T extends Comparable>{
	public static void main(String[] args){
		String[] names = new String[]{"aditya", "bhavya", "akshat", "prativa", "anuprita", 
				"madan"};
		QuickSort<String> qss = new QuickSort<String>();
		qss.quickSort(names, 0, names.length-1);
		qss.printArray(names, 0, names.length-1);
	}
	
	public void printArray(T[] arr, int low, int high){
		for(int i=low;i<=high;i++){
			System.out.print(arr[i]+",");
		}
		System.out.println();
	}
	
	/**
	 * Sort the input integer
	 * @param arr	-	the 
	 * @param low	-	the starting indix of the subarray to sort	
	 * @param high	-	the ending indix of the subarray to sort
	 */
	public void quickSort(T[] arr, int low, int high){
		if(low>=high){
			//Nothing to do
			return;
		}
//		Partition the arr[low..high] into 2 parts arr[low..k-1] and arr[k+1..high] such 
//		that:
//		1. every element in arr[low..k-1] is less than or equal to arr[k]
//		2. every element in arr[k+1..high] is greater than or equal to arr[k]
//		return k.	
		int k = partition(arr, low, high);
			//recursive call to sort arr[low..k-1]
		quickSort(arr, low, k-1);
		
		//recursive call to sort arr[k+1..high]
		quickSort(arr, k+1, high);
		
		//at the end of these, the entire array will be sorted
	}
	
	/**
	 * Partition the arr[low..high] into 2 parts arr[low..k-1] and arr[k+1..high] such 
	 * that:
	 * 1. every element in arr[low..k-1] is less than or equal to arr[k]
	 * 2. every element in arr[k+1..high] is greater than or equal to arr[k]
	 * return k.
	 *  
	 * @param arr		-	the array to sort
	 * @param low		-	the starting index of the subarray to partition
	 * @param high		-	the ending index of the subarray to partition
	 * @return			- 	k as described above
	 */
	public int partition(T[] arr, int low, int high){
		//What would the value be at the end of this iteration
		T pivot = arr[(low+high)/2];
//		printArray(arr, low, high);
//		System.out.println("pivot is:"+pivot);
		
		//We shall maintain these loop invariants - 
		//1. Every element in arr[low..i] shall be less than or equal the pivot
		//2. Every element in arr[j..high] shall be greater than or equal the pivot
		int i= low, j = high;
		
		while(i<j){
			//Why are we doing that?
			//arr[low..i] must contain elements which are only less than or equal to pivot.
			//when it finds an element greater than or equal to the pivot, 
			//we have found an element suitable for exchange with arr[j], because j
			//will contain an element which is less than or equal to pivot, which is ideal for 
			//the subarray a[low..i]!!
			while((i<=high) && (arr[i].compareTo(pivot)<0)){
				i++;
			}
			while((j>=low) && (arr[j].compareTo(pivot)>0)){
				j--;
			}
			//we need to do the swapping only if i<=j.   
			if(i<j){
				//Why swap? Because i and j contain elements which are perfect for 
				//satisfying each other's loop invariants.
				swap(arr, i, j);
			}
		}
		//Why return i? 
		//Every element in arr[low..i] shall be less than or equal to the pivot.
		//But what if the element arr[i] is less than the pivot? 
		//Then the partition may not be valid.
		//No. We also have that arr[j..high] must have every element greater than the pivot.
		//When the loop breaks i>j. Therefore, i can only be equal to arr[j]!!
		
		System.out.println(arr[i].equals(pivot));
		return i;
	}
	
	public void swap(T[] arr, int i, int j){
//		System.out.println("About to swap "+arr[i]+" with "+arr[j]);
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
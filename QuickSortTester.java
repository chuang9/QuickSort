/*
QuickSortTester contains the methods timerW, timerA, and timerB, representing the tests for worst, average, and best case.

The methods have two inputs: array size and number of trials to run. In each trial, for input number of trials, a new array of input size is constructed. The quicksort algorithm is then ran and timed. The average time for all the trials is returned.

The three methods only differ in the way the algorithms are constructed and the pivot position:
timerW: array is sorted in reverse, pivot choice is the right bound
timerA: array is randomized, pivot choice is the right bound
timerB: array is sorted, pivot choice is the middle index
*/

public class QuickSortTester {

    public static int[] orderedArr(int len){
	int[] newArr = new int[len];
	for(int i = 0; i < len; i++){
	    newArr[i] = i;
	}
	return newArr;
    }

    public static int[] backwardArr(int len){
	int[] newArr = new int[len];
	for(int i = len-1; i > 0; i--){
	    newArr[len-i-1] = i;
	}
	return newArr;
    }
    
    public static long timerA(int lengthArr, int numRuns) {
	long totalTime = 0;

	for (int i = 0; i < numRuns; i++) {
	    int[] arr = QuickSort.buildArray(lengthArr, lengthArr);

	    long startTime = System.nanoTime();
	    QuickSort.qsort(arr);
	    long endTime = System.nanoTime();

	    totalTime += endTime - startTime;   

	}

	return totalTime / numRuns;
    }

    public static long timerB(int lengthArr, int numRuns) {
	long totalTime = 0;

	for (int i = 0; i < numRuns; i++) {
	    int[] arr = orderedArr(lengthArr);

	    long startTime = System.nanoTime();
	    QuickSort.qsort2(arr); // qsort2 has middle index as pivot
	    long endTime = System.nanoTime();

	    totalTime += endTime - startTime;   

	}

	return totalTime / numRuns;
    }

    public static long timerW(int lengthArr, int numRuns) {
	long totalTime = 0;

	for (int i = 0; i < numRuns; i++) {
	    int[] arr = backwardArr(lengthArr);

	    long startTime = System.nanoTime();
	    QuickSort.qsort(arr);
	    long endTime = System.nanoTime();

	    totalTime += endTime - startTime;   

	}

	return totalTime / numRuns;
    }


    public static void main(String[] args) {
        
        timerA(10, 10); // run JVM once
        System.out.println("Average Case");
	System.out.println("n = 100: " + timerA(100, 10));
	System.out.println("n = 1000: " + timerA(1000, 10));
	System.out.println("n = 10000: " + timerA(10000, 10));
	System.out.println("n = 100000: " + timerA(100000, 10));
	System.out.println("n = 1000000: " + timerA(1000000, 10));
        System.out.println("n = 2500000: " + timerA(2500000, 10));
        System.out.println("n = 5000000: " + timerA(5000000, 10));
        System.out.println("n = 7500000: " + timerA(7500000, 10));
	System.out.println("n = 10000000: " + timerA(10000000, 10));

        
        timerB(10, 10); // run JVM once
	System.out.println("Best Case");
	System.out.println("n = 100: " + timerB(100, 10));
	System.out.println("n = 1000: " + timerB(1000, 10));
	System.out.println("n = 10000: " + timerB(10000, 10));
	System.out.println("n = 100000: " + timerB(100000, 10));
	System.out.println("n = 1000000: " + timerB(1000000, 10));
        System.out.println("n = 2500000: " + timerB(2500000, 10));
        System.out.println("n = 5000000: " + timerB(5000000, 10));
        System.out.println("n = 7500000: " + timerB(7500000, 10));
	System.out.println("n = 10000000: " + timerB(10000000, 10));
        
        
        timerW(10, 10); // run JVM once
	System.out.println("Worst Case");
	System.out.println("n = 100: " + timerW(100, 10));
	System.out.println("n = 1000: " + timerW(1000, 10));
	System.out.println("n = 10000: " + timerW(10000, 10));;
        // larger n causes stack overflow error
        
    }

} 

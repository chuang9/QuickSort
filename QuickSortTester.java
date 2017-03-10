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
	System.out.println("n = 10000000: " + timerA(10000000, 10));
        

        
        timerB(10, 10); // run JVM once
	System.out.println("Best Case");
	System.out.println("n = 100: " + timerB(100, 10));
	System.out.println("n = 1000: " + timerB(1000, 10));
	System.out.println("n = 10000: " + timerB(10000, 10));
	System.out.println("n = 100000: " + timerB(100000, 10));
	System.out.println("n = 1000000: " + timerB(1000000, 10));
	System.out.println("n = 10000000: " + timerB(10000000, 10));
        
      
        timerW(10, 10); // run JVM once
	System.out.println("Worst Case");
	System.out.println("n = 100: " + timerW(100, 10));
	System.out.println("n = 1000: " + timerW(1000, 10));
	System.out.println("n = 10000: " + timerW(10000, 10));
	System.out.println("n = 100000: " + timerW(100000, 10));
	System.out.println("n = 1000000: " + timerW(1000000, 10));
	System.out.println("n = 10000000: " + timerW(10000000, 10));
        
    }

} 

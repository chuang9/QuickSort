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
    
    public static long timer(int lengthArr, int numRuns) {
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

      public static long bestTimer(int lengthArr, int numRuns) {
	long totalTime = 0;

	for (int i = 0; i < numRuns; i++) {
	    int[] arr = orderedArr(lengthArr);

	    long startTime = System.nanoTime();
	    QuickSort.qsort(arr);
	    long endTime = System.nanoTime();

	    totalTime += endTime - startTime;   

	}

	return totalTime / numRuns;
    }

      public static long worstTimer(int lengthArr, int numRuns) {
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
        timer(10, 10); // run JVM once
	
	System.out.println("Average Case");
	System.out.println("n = 100: " + timer(100, 10));
	System.out.println("n = 1000: " + timer(1000, 10));
	System.out.println("n = 10000: " + timer(10000, 10));
	System.out.println("n = 100000: " + timer(100000, 10));
	System.out.println("n = 1000000: " + timer(1000000, 10));
	System.out.println("n = 10000000: " + timer(10000000, 10));
	
	System.out.println("Best Case");
	System.out.println("n = 100: " + bestTimer(100, 10));
	System.out.println("n = 1000: " + bestTimer(1000, 10));
	System.out.println("n = 10000: " + bestTimer(10000, 10));
	System.out.println("n = 100000: " + bestTimer(100000, 10));
	System.out.println("n = 1000000: " + bestTimer(1000000, 10));
	System.out.println("n = 10000000: " + bestTimer(10000000, 10));
	
	System.out.println("Worst Case");
	System.out.println("n = 100: " + worstTimer(100, 10));
	System.out.println("n = 1000: " + worstTimer(1000, 10));
	System.out.println("n = 10000: " + worstTimer(10000, 10));
	System.out.println("n = 100000: " + worstTimer(100000, 10));
	System.out.println("n = 1000000: " + worstTimer(1000000, 10));
	System.out.println("n = 10000000: " + worstTimer(10000000, 10));
    }

} 

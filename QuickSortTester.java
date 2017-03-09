public class QuickSortTester {

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

    public static void main(String[] args) {
        timer(10, 10); // run JVM once
	System.out.println("n = 100: " + timer(100, 10));
	System.out.println("n = 1000: " + timer(1000, 10));
	System.out.println("n = 10000: " + timer(10000, 10));
	System.out.println("n = 100000: " + timer(100000, 10));
        System.out.println("n = 1000000: " + timer(1000000, 10));
        System.out.println("n = 10000000: " + timer(10000000, 10));
    }

} 

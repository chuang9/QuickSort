/*****************************************************
 * class QuickSort
 *
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): Apply the partition method, starting with (0, array.length - 1)
 *             as the left and right bounds, respectively.
 *             Keep track of the pivot point as returned by the partition method.
 *             Recursively apply the partition method on the two created partitions,
 *             using the new bounds (left, pivot - 1) and (pivot + 1, right).
 *             All partitions will be sorted, the exit case being !(left < right).
 * 
 * 2a.  Worst pivot choice / array state and associated runtime:
 *      A pivot point such that the value at that point is either the max or min value.
 *      Runtime O(n^2): n partitions needed, with n comparisons/swaps in each.
 *
 * 2b.  Best pivot choice / array state and associated runtime:
 *      A pivot point such that the value at that point is the median value.
 *      Runtime O(nlogn): log n partitions needed, with n comparisons/swaps in each.
 *
 * 3.   Approach to handling duplicate values in array:
 *      The partition method puts values to the the left of the pivot only if they are
 *      strictly less than the pivotVal. Duplicate values will be partitioned to the right.
 *****************************************************/

/***
    PROTIP: Assume no duplicates during initial development phase.
    Once you have a working implementation, test against arrays 
    with duplicate values, and revise if necessary. (Backup first.)
***/

public class QuickSort {
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
        int tmp = o[x];
        o[x] = o[y];
        o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
        for ( int o : a )
            System.out.print( o + " " );
        System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
        int tmp;
        int swapPos;
        for( int i = 0; i < d.length; i++ ) {
            tmp = d[i];
            swapPos = i + (int)( (d.length - i) * Math.random() );
            swap( i, swapPos, d );
        }
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
        int[] retArr = new int[s];
        for( int i = 0; i < retArr.length; i++ )
            retArr[i] = (int)( maxVal * Math.random() );
        return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------


    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d ) {
        qsortHelper(0, d.length - 1, d);
    }

    public static void qsortHelper(int left, int right, int[] d) {
        if (left < right) {
            int pivot = partition(left, right, d);
            qsortHelper(left, pivot - 1, d);
            qsortHelper(pivot + 1, right, d);
        }
    }

    public static int partition(int left, int right, int[] arr) {
        int pivotVal = arr[right];   
        int indexCount = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivotVal) {
                swap(i, indexCount, arr);
                indexCount += 1;
            }
        }
        swap(right, indexCount, arr);
        return indexCount;
    }


    //main method for testing
    public static void main( String[] args ) {
        
        //get-it-up-and-running, static test case:
        int [] arr1 = {7,1,5,12,3};
        System.out.println("\narr1 init'd to: " );
        printArr(arr1);

        qsort( arr1 );  
        System.out.println("arr1 after qsort: " );
        printArr(arr1);

        
        // randomly-generated arrays of n distinct vals
        int[] arrN = new int[10];
        for( int i = 0; i < arrN.length; i++ )
            arrN[i] = i;
       
        System.out.println("\narrN init'd to: " );
        printArr(arrN);

        shuffle(arrN);
        System.out.println("arrN post-shuffle: " );
        printArr(arrN);

        qsort( arrN );
        System.out.println("arrN after sort: " );
        printArr(arrN);

        
        //get-it-up-and-running, static test case w/ dupes:
        int [] arr2 = {7,1,5,12,3,7};
        System.out.println("\narr2 init'd to: " );
        printArr(arr2);

        qsort( arr2 );  
        System.out.println("arr2 after qsort: " );
        printArr(arr2);

        
        // arrays of randomly generated ints
        int[] arrMatey = new int[20];
        for( int i = 0; i < arrMatey.length; i++ )
            arrMatey[i] = (int)( 48 * Math.random() );
       
        System.out.println("\narrMatey init'd to: " );
        printArr(arrMatey);

        shuffle(arrMatey);
        System.out.println("arrMatey post-shuffle: " );
        printArr(arrMatey);

        qsort( arrMatey );
        System.out.println("arrMatey after sort: " );
        printArr(arrMatey);

    }//end main

}//end class QuickSort

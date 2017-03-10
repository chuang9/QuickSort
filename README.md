# QuickSort Runtime Analysis
by Chester Huang, Shaikat Islam, Levi Olevsky

## Methodology:
QuickSortTester contains the methods timerW, timerA, and timerB, representing the tests for worst, average, and best case.

The methods have two inputs: array size and number of trials to run. In each trial, for input number of trials, a new array of input size is constructed. The quicksort algorithm is then ran and timed. The average time for all the trials is returned.

The three methods only differ in the way the arrays are constructed and the pivot position chosen:

* timerW: array is sorted in reverse, pivot choice is the right bound
* timerA: array is randomized, pivot choice is the right bound
* timerB: array is sorted, pivot choice is the middle index

## Time Measurements:
```
n = <array size>: <time in nanoseconds>
```

### Worst Case
* n = 100: 17296
* n = 1000: 1308738
* n = 10000: 126675898
* n = 100000: causes a stackoverflow error

### Average Case
* n = 100: 134165
* n = 1000: 250484
* n = 10000: 1137477
* n = 100000: 13832703
* n = 1000000: 165026992
* n = 2500000: 437045297
* n = 5000000: 910934631
* n = 7500000: 1400579807
* n = 10000000: 1898512658

### Best Case
* n = 100: 46032
* n = 1000: 113349
* n = 10000: 760912
* n = 100000: 4049600
* n = 1000000: 41455789
* n = 2500000: 112631511
* n = 5000000: 243812442
* n = 7500000: 383603634
* n = 10000000: 499487454

## Runtime Assessment:
The worst case runs in time O(n^2). In terms of data arrangement and pivot choice, this makes sense because the worst case has data arranged in reverse order and it always chooses the rightmost value as the pivot. This means that the smallest value is always chosen and each run of partition creates one partition of size 0 and the other of maximum size. As a result, n partitions are required, with each partition call running in linear time, totaling O(n^2).

The average case runs in time O(nlog n). Since the data is randomly generated, on average the value at the rightmost index will be some number near the median value. As a result, if the data is being approximately halved after each run of partition, the number of partitions needed will be in the form (log n). Each partition call runs in linear time, totaling O(nlog n).

The best case runs in time O(nlog n). Since the data is already sorted and the exact middle value is selected each time as the pivot, this results in the minimum number of partitions needed. This number will, however, still be in the form (log n) with each partition running in linear time, totaling O(nlog n).

## Graphic Representation
[Link to graph](https://docs.google.com/spreadsheets/d/1j7jMffK3nL-nwmuBM56YSJswrpNnBSWGJRFUY1LYwgk/pubchart?oid=1756849084&format=image)

As seen from the graph of worst, average, and best cases, the worst case is closest to the curve y = x^2 while the average and best cases, both lie between y = x^2 and y = x. Additionally, the worst case has no data for large n because it was too inefficient to be testable.

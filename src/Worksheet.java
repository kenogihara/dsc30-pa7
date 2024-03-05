/**
 * PA7 Part 1 worksheet (style not required)
 */
public class Worksheet {

    /**
     * method that stores the result of Q1 in PA7 worksheet
     * @return heap's array representation after insertions
     */
    public static int[] insertionResult(){
        /*
        TODO: replace the values with the heap's array representations
         */
        int[] output =  new int[]{104, 95, 79, 51, 90, 25, 36, 22, 50, 45, 87, 5};
        return output;
    }

    /**
     * method that stores the result of Q2 in PA7 worksheet
     * @return heap's array representations for each iteration of element removal, 5 iterations in total
     */
    public static int[][] removalResult(){
        /*
        TODO: store the values with the heap's array representations for each removal iteration
         */
        int[][] output = new int[][]{{37, 56, 42, 59, 62, 90, 50, 67, 70, 75, 64, 0}, {42, 56, 50, 59, 62, 90, 64, 67, 70, 75, 0, 0},
                {50, 56, 64, 59, 62, 90, 75, 67, 70, 0, 0, 0}, {56, 59, 64, 67, 62, 90, 75, 70, 0, 0, 0, 0}, {59, 62, 64, 67, 70, 90, 75, 0, 0, 0, 0, 0}};
        return output;
    }

    /**
     * method that stores the result of Q3 in PA7 worksheet
     * @return heap's array representations for d-ary heaps, where d = 3,4
     */
    public static int[][] dResult(){
        /*
        TODO: store 3-ary heap's array representation output[0] and store 4-ary representation in output[1]
         */
        int[][] output = new int[][] {{92, 61, 85, 43, 47, 53, 56, 55, 79, 31, 20}, {92, 85, 55, 43, 47, 53, 56, 61, 79, 31, 20}};
        return output;
    }

    /**
     * method that stores the result of Q4 in PA7 worksheet
     * @return array representations
     */
    public static int[][] heapOperations(){
        /*
        TODO: store heap's array status after multiples operations - operation i will be stored at index i-1
         */
        int[][] output = new int[][]{{71, 70, 55, 59, 65, 36, 37, 26, 35, 0, 0, 0}, {100, 70, 55, 71, 65, 36, 37, 26, 35, 15, 59, 0},
                {71, 70, 55, 59, 65, 36, 37, 26, 35, 15, 0, 0}, {88, 70, 55, 72, 65, 36, 37, 26, 35, 15, 59, 71}, {59, 37, 55, 26, 15, 36, 35, 0, 0, 0, 0, 0}};
        return output;
    }
}
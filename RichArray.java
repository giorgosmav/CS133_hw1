package hw1;

import java.util.Arrays;

/**
 * This class implements RichArrays
 *
 * @author George Mavronicolas
 * @since 22/02/2024
 */
public class RichArray {

    private int[] arr;
    private int[][] arr2D;
    private int numOfColumns;
    private int numOfRows;
    private boolean is2D;

    /**
     * This constructor creates a 1D {@link RichArray}.
     * @param arr   The given array to initialize the 1D {@link RichArray}
     */
    public RichArray(int[] arr){
        this.numOfColumns = arr.length;
        this.arr = new int[numOfColumns];
        for(int i = 0; i< numOfColumns; i++)
            this.arr[i] = arr[i];
        is2D = false;
        numOfRows = 1;
    }

    /**
     * This constructor created a 2D {@link RichArray}.
     * @param arr2D The given array to initialize the 2D {@link RichArray}
     */
    public RichArray(int[][] arr2D){
        this.numOfColumns = arr2D[0].length;
        this.numOfRows = arr2D.length;
        this.arr2D = new int [numOfRows][numOfColumns];
        for(int i = 0; i< numOfRows; i++)
            for(int j = 0; j< numOfColumns; j++)
                this.arr2D[i][j] = arr2D[i][j];
        is2D = true;
    }

    /**
     * This method creates a new reverse {@link RichArray}.
     * @return  The reverse RichArray
     */
    public RichArray reverse() {
        if(!is2D){
            int[] newArr = new int [this.numOfColumns];
            for(int i = 0; i < this.numOfColumns; i++){
                newArr[i] = this.arr[numOfColumns - i -1];
            }
            return new RichArray(newArr);
        }
        else{
            int[][] newArr = new int [this.numOfRows][this.numOfColumns];
            for(int i = 0; i < numOfRows; i++)
                for(int j = 0; j< numOfColumns; j++) {
                    newArr[i][j] = this.arr2D[i][numOfColumns - 1 - j];
                }
            return new RichArray(newArr);
        }

    }

    /**
     * This method rotates a {@link RichArray} clockwise.
     * @return  A new {@link RichArray} but rotated clockwise
     */
    public RichArray rotateRight(){
        int[][] rotArr = new int [numOfColumns][numOfRows];
        int nI = 0;
        int nJ = numOfRows - 1;
        for(int i=0;i<numOfRows;i++){
            for(int j=0;j<numOfColumns;j++)
                rotArr[nI++][nJ] = this.arr2D[i][j];
            nI = 0;
            nJ--;
        }
        return new RichArray(rotArr);
    }

    /**
     * This method rotates a {@link RichArray} anti-clockwise.
     * @return  A new {@link RichArray} but rotated anti-clockwise
     */
    public RichArray rotateLeft(){
        int[][] rotArr = new int [numOfColumns][numOfRows];
        int nI = numOfColumns - 1;
        int nJ = 0;
        for(int i=0;i<numOfRows;i++){
            for(int j=0;j<numOfColumns;j++)
                rotArr[nI--][nJ] = this.arr2D[i][j];
            nI = numOfColumns - 1;
            nJ++;
        }
        return new RichArray(rotArr);
    }

    /**
     * This method creates a new {@link RichArray} with dimensions (numOfRows x numOfRows) of this {@link RichArray}. The new array at [i][j] has the [j][i] value of this.
      * @return A transposed {@link RichArray}
     */
    public RichArray transpose() {
        if (is2D) {
            int[][] transposedArray = new int[arr2D[0].length][arr2D.length];
            for (int i = 0; i < arr2D.length; i++) {
                for (int j = 0; j < arr2D[0].length; j++) {
                    transposedArray[j][i] = arr2D[i][j];
                }
            }
            return new RichArray(transposedArray);
        } else {
            return null;
        }
    }

    /**
     * This method takes a 1D {@link RichArray} and creates a new 2D {@link RichArray} with numOrRows equal with n and numOfColumns equal with the 1D length over n.
     * @param n The number of columns that the enw 2D {@link RichArray} will have
     * @return  A new 2D {@link RichArray}
     */
    public RichArray ravel(int n){
       int m = arr.length/n;
       int nI = 0;
       int[][] newArr = new int [m][n];
       for(int i=0;i<m;i++)
           for(int j=0;j<n;j++)
               newArr[i][j] = arr[nI++];
       return new RichArray(newArr);
    }

    /**
     * This method takes a 2D {@link RichArray} and turns it into a 1D {@link RichArray}
     * @return  A 1D {@link RichArray}
     */
    public RichArray unravel(){
        int[] newArr = new int [numOfColumns*numOfRows];
        int nI = 0;
        for(int i=0;i<numOfRows;i++){
            for(int j = 0; j < numOfColumns; j++){
                newArr[nI++] = this.arr2D[i][j];
            }
        }
        return new RichArray(newArr);
    }

    /**
     * This method reshapes the given 2D {@link RichArray} to a new 2D{@link RichArray} with numOfColumns equal with n.
     * @param n The new number of Columns
     * @return  A reshaped 2D {@link RichArray}
     */
    public RichArray reshape(int n){
        int m = numOfRows*numOfColumns/n;
        int[][] newArr = new int [m][n];
        int nI = 0;
        int nJ = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                newArr[i][j] = arr2D[nI][nJ++];
                if(nJ == numOfColumns){
                    nJ = 0;
                    nI++;
                }
            }
        }
        return new RichArray(newArr);
    }

    /**
     * This method puts a given 2D {@link RichArray} next to this {@link RichArray}.
     * @param array The given {@link RichArray} to put next to this {@link RichArray}
     * @return  A new {@link RichArray} with numOfRows the sum of the given {@link RichArray} plus this {@link RichArray} and numOfColumns the smallest numOfRows of the two {@link RichArray}
     */
    public RichArray join(RichArray array){
        if(this.numOfRows != array.numOfRows)
            System.out.println("The two given RichArrays have different number of rows. The returned RichArray's number of rows is equal with the smallest one.");
        int n = this.numOfColumns + array.numOfColumns;
        int m = Math.min(this.numOfRows, array.numOfRows);
        int[][] newArr = new int [m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<Math.min(this.numOfColumns, array.numOfColumns);j++) {
                newArr[i][j] = this.arr2D[i][j];
                newArr[i][j+this.numOfColumns] = array.arr2D[i][j];
            }
        }
        if(array.numOfColumns>this.numOfColumns)
            for(int i=0;i<m;i++)
                for(int j=2*this.numOfColumns;j<n;j++)
                    newArr[i][j] = array.arr2D[i][j-this.numOfColumns];
        return new RichArray(newArr);
    }

    /**
     * This method stacks this {@link RichArray} on top of the given {@link RichArray}.
     * @param array The {@link RichArray} to put below this {@link RichArray}
     * @return  A new {@link RichArray} with numOfRows equal with the sum of the two {@link RichArray}.
     */
    public RichArray stack(RichArray array){
        if (this.numOfColumns != array.numOfColumns)
            throw new IllegalArgumentException("RichArrays must have the same number of columns");
        int rows = arr2D.length + 1;
        int cols = arr2D[0].length;

        int[][] stack = new int[rows][cols];

        for (int i = 0; i < arr2D.length; i++) {
            System.arraycopy(arr2D[i], 0, stack[i], 0, arr2D[0].length);
        }

        System.arraycopy(array.arr, 0, stack[arr2D.length], 0, array.arr.length);

        return new RichArray(stack);
    }

    /**
     * This method returns the part of this {@link RichArray} that is given from the parameters.
     * @param firstRow  The first row that the user wants to get
     * @param lastRow   The last row that the user wants to get
     * @param firstColumn   The first column that the user wants to get
     * @param lastColumn    The last column that the user wants to get
     * @return  A part of this {@link RichArray}
     */
    public RichArray slice(int firstRow,int lastRow, int firstColumn, int lastColumn){
        int n = lastColumn - firstColumn + 1;
        int m = lastRow - firstRow + 1;
        int[][] newArr = new int [m][n];
        int nI = 0;
        int nJ = 0;
        for(int i=firstRow;i<=lastRow;i++) {
            for (int j = firstColumn; j <= lastColumn; j++)
                newArr[nI][nJ++] = arr2D[i][j];
            nJ = 0;
            nI++;
        }
        return new RichArray(newArr);
    }

    /**
     * This method replace a part of this {@link RichArray} at the given row and column with the given {@link RichArray}.
     * @param array The {@link RichArray} to replace this {@link RichArray}
     * @param row   The first row to replace
     * @param column The first column to replace
     * @return  A new {@link RichArray} with a part replaced with the given {@link RichArray}
     */
    public RichArray replace(RichArray array, int row, int column){
        int[][] newArr = new int [this.numOfRows][this.numOfColumns];
        for(int i=0;i<this.numOfRows;i++)
            for(int j=0;j<this.numOfColumns;j++)
                newArr[i][j] = this.arr2D[i][j];
        int lastRow = array.numOfRows + row - 1;
        int lastCol = array.numOfColumns + column - 1;
        if(lastCol > this.numOfColumns) {
            System.out.println("The given RichArray if put at the given column is longer than this RichArray. The result will not contain any out of bounds values.");
            lastCol = this.numOfColumns - 1;
        }
        if(lastRow > this.numOfRows) {
            System.out.println("The given RichArray if put at the given row is bigger than this RichArray's rows. The result will not contain any out of bounds values.");
            lastRow = this.numOfRows - 1;
        }
        int nI = 0;
        int nJ = 0;
        for(int i = row; i <= lastRow; i++) {
            for (int j = column; j <= lastCol; j++)
                newArr[i][j] = array.arr2D[nI][nJ++];
            nI++;
            nJ = 0;
        }
        return new RichArray(newArr);
    }

    /**
     * This method returns a String representation of the {@link RichArray}.
     * @return  A string representation of the {@link RichArray}
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!is2D) {
            sb.append(Arrays.toString(arr)).append("\n");
        } else if (is2D) {
            for (int[] row : arr2D) {
                sb.append(Arrays.toString(row)).append("\n");
            }
        }
        return sb.toString();
    }
}

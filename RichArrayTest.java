package hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RichArrayTest {

	@Test
	void testReplace() {
		// Initialize two RichArrays
		int[][] replaceOriginal = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 19, 20 } };
		int[][] replaceAt = { { 55, 66, 77 }, { 88, 99, 100 } };
		int row = 1, column = 2;
		RichArray replaceTestOriginal = new RichArray(replaceOriginal);
		RichArray replaceTestAt = new RichArray(replaceAt);

		// Call replace method
		RichArray replaceTest = replaceTestOriginal.replace(replaceTestAt, row, column);

		// Expected result
		int[][] expected = { { 1, 2, 3, 4, 5 }, { 6, 7, 55, 66, 77 }, { 11, 12, 88, 99, 100 },
				{ 16, 17, 18, 19, 20 } };
		RichArray expectedRichArray = new RichArray(expected);

		// Assert the result
		assertEquals(expectedRichArray.toString(), replaceTest.toString());
	}

	@Test
	void testRotateRight() {
		// Initialize a RichArray
		int[][] original = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		RichArray originalArray = new RichArray(original);

		// Call rotateRight method
		RichArray rotatedArray = originalArray.rotateRight();

		// Expected result
		int[][] expected = { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };
		RichArray expectedRichArray = new RichArray(expected);

		// Assert the result
		assertEquals(expectedRichArray.toString(), rotatedArray.toString());
	}

	@Test
	void testRotateLeft() {
		// Initialize a RichArray
		int[][] original = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		RichArray originalArray = new RichArray(original);

		// Call rotateLeft method
		RichArray rotatedArray = originalArray.rotateLeft();

		// Expected result
		int[][] expected = { { 3, 6, 9 }, { 2, 5, 8 }, { 1, 4, 7 } };
		RichArray expectedRichArray = new RichArray(expected);

		// Assert the result
		assertEquals(expectedRichArray.toString(), rotatedArray.toString());
	}

	@Test
	void testReverse() {
		// Initialize a RichArray
		int[][] original = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		RichArray originalArray = new RichArray(original);

		// Call reverse method
		RichArray reversedArray = originalArray.reverse();

		// Expected result
		int[][] expected = { { 3, 2, 1 }, { 6, 5, 4 }, { 9, 8, 7 } };
		RichArray expectedRichArray = new RichArray(expected);

		// Assert the result
		assertEquals(expectedRichArray.toString(), reversedArray.toString());
	}

	@Test
	void testRavel() {
		// Initialize a RichArray
		int[] original = { 1, 2, 3, 4, 5, 6 };
		RichArray originalArray = new RichArray(original);

		// Call ravel method
		RichArray raveledArray = originalArray.ravel(2);

		// Expected result
		int[][] expected = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		RichArray expectedRichArray = new RichArray(expected);

		// Assert the result
		assertEquals(expectedRichArray.toString(), raveledArray.toString());
	}

	@Test
	void testUnravel() {
		// Initialize a RichArray
		int[][] original = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		RichArray originalArray = new RichArray(original);

		// Call unravel method
		RichArray unraveledArray = originalArray.unravel();

		// Expected result
		int[] expected = { 1, 2, 3, 4, 5, 6 };
		RichArray expectedRichArray = new RichArray(expected);

		// Assert the result
		assertEquals(expectedRichArray.toString(), unraveledArray.toString());
	}

	@Test
	void testTranspose() {
		// Initialize a RichArray
		int[][] original = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		RichArray originalArray = new RichArray(original);

		// Call transpose method
		RichArray transposedArray = originalArray.transpose();

		// Expected result
		int[][] expected = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };
		RichArray expectedRichArray = new RichArray(expected);

		// Assert the result
		assertEquals(expectedRichArray.toString(), transposedArray.toString());
	}

	@Test
	void testReshapeNoException() {
		// Initialize a RichArray
		int[][] original = {
				{ 1, 2, 3, 4, 5, 6 },
				{ 7, 8, 9, 10, 11, 12 },
				{ 13, 14, 15, 16, 17, 18 },
				{ 19, 20, 21, 22, 23, 24 },
				{ 25, 26, 27, 28, 29, 30 }
		};
		RichArray originalArray = new RichArray(original);

		// Call reshape method
		RichArray reshapedArray = originalArray.reshape(2);

		// Expected result
		int[][] expected = {
				{ 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 }, { 9, 10 },
				{ 11, 12 }, { 13, 14 }, { 15, 16 }, { 17, 18 }, { 19, 20 },
				{ 21, 22 }, { 23, 24 }, { 25, 26 }, { 27, 28 }, { 29, 30 }
		};
		RichArray expectedRichArray = new RichArray(expected);

		// Assert the result
		assertEquals(expectedRichArray.toString(), reshapedArray.toString());
	}

	@Test
	void testJoin() {
		// Initialize two RichArrays
		int[][] original1 = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] original2 = { { 7, 8, 9 }, { 10, 11, 12 } };
		RichArray originalArray1 = new RichArray(original1);
		RichArray originalArray2 = new RichArray(original2);

		// Call join method
		RichArray joinedArray = originalArray1.join(originalArray2);

		// Expected result
		int[][] expected = { { 1, 2, 3, 7, 8, 9 }, { 4, 5, 6, 10, 11, 12 } };
		RichArray expectedRichArray = new RichArray(expected);

		// Assert the result
		assertEquals(expectedRichArray.toString(), joinedArray.toString());
	}

	@Test
	void testStack() {
		// Initialize two RichArrays
		int[][] original1 = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[] original2 = { 7, 8, 9 };
		RichArray originalArray1 = new RichArray(original1);
		RichArray originalArray2 = new RichArray(original2);

		// Call stack method
		RichArray stackedArray = originalArray1.stack(originalArray2);

		// Expected result
		int[][] expected = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		RichArray expectedRichArray = new RichArray(expected);

		// Assert the result
		assertEquals(expectedRichArray.toString(), stackedArray.toString());
	}

	@Test
	void testSlice() {
		// Initialize a RichArray
		int[][] original = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 19, 20 } };
		RichArray originalArray = new RichArray(original);

		// Call slice method
		RichArray slicedArray = originalArray.slice(1, 2, 1, 3);

		// Expected result
		int[][] expected = { { 7, 8, 9 }, { 12, 13, 14 } };
		RichArray expectedRichArray = new RichArray(expected);

		// Assert the result
		assertEquals(expectedRichArray.toString(), slicedArray.toString());
	}

	@Test
	void testReplaceDifferentSize() {
		// Initialize two RichArrays
		int[][] replaceOriginal = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] replaceAt = { { 55, 66 }, { 88, 99 } };
		int row = 0, column = 1;
		RichArray replaceTestOriginal = new RichArray(replaceOriginal);
		RichArray replaceTestAt = new RichArray(replaceAt);

		// Call replace method
		RichArray replaceTest = replaceTestOriginal.replace(replaceTestAt, row, column);

		// Expected result
		int[][] expected = { { 1, 55, 66 }, { 4, 88, 99 } };
		RichArray expectedRichArray = new RichArray(expected);

		// Assert the result
		assertEquals(expectedRichArray.toString(), replaceTest.toString());
	}

	@Test
	void testRotateRightDifferentSize() {
		// Initialize a RichArray
		int[][] original = { { 1, 2, 3, 4 }, {5, 6, 7, 8 }, {9,10, 11, 12} };
		RichArray originalArray = new RichArray(original);

		// Call rotateRight method
		RichArray rotatedArray = originalArray.rotateRight();

		// Expected result
		int[][] expected = {{9, 5, 1}, {10, 6, 2}, {11, 7, 3}, {12, 8, 4}};
		RichArray expectedRichArray = new RichArray(expected);

		// Assert the result
		assertEquals(expectedRichArray.toString(), rotatedArray.toString());
	}

	@Test
	void testRotateLeftDifferentSize() {
		// Initialize a RichArray
		int[][] original = { { 1, 2 }, { 3, 4 } };
		RichArray originalArray = new RichArray(original);

		// Call rotateLeft method
		RichArray rotatedArray = originalArray.rotateLeft();

		// Expected result
		int[][] expected = { { 2, 4 }, { 1, 3 } };
		RichArray expectedRichArray = new RichArray(expected);

		// Assert the result
		assertEquals(expectedRichArray.toString(), rotatedArray.toString());
	}

	@Test
	void testReverseDifferentSize() {
		// Initialize a RichArray
		int[][] original = { { 1, 2, 3, 4 } };
		RichArray originalArray = new RichArray(original);

		// Call reverse method
		RichArray reversedArray = originalArray.reverse();

		// Expected result
		int[][] expected = { { 4, 3, 2, 1 } };
		RichArray expectedRichArray = new RichArray(expected);

		// Assert the result
		assertEquals(expectedRichArray.toString(), reversedArray.toString());
	}

	@Test
	void testRavelDifferentSize() {
		// Initialize a RichArray
		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8 };
		RichArray originalArray = new RichArray(original);

		// Call ravel method
		RichArray raveledArray = originalArray.ravel(4);

		// Expected result
		int[][] expected = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
		RichArray expectedRichArray = new RichArray(expected);

		// Assert the result
		assertEquals(expectedRichArray.toString(), raveledArray.toString());
	}

	@Test
	void testUnravelDifferentSize() {
		// Initialize a RichArray
		int[][] original = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
		RichArray originalArray = new RichArray(original);

		// Call unravel method
		RichArray unraveledArray = originalArray.unravel();

		// Expected result
		int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8 };
		RichArray expectedRichArray = new RichArray(expected);

		// Assert the result
		assertEquals(expectedRichArray.toString(), unraveledArray.toString());
	}

	@Test
	void testTransposeDifferentSize() {
		// Initialize a RichArray
		int[][] original = { { 1, 2, 3 }, { 4, 5, 6 } };
		RichArray originalArray = new RichArray(original);

		// Call transpose method
		RichArray transposedArray = originalArray.transpose();

		// Expected result
		int[][] expected = { { 1, 4 }, { 2, 5 }, { 3, 6 } };
		RichArray expectedRichArray = new RichArray(expected);

		// Assert the result
		assertEquals(expectedRichArray.toString(), transposedArray.toString());
	}

	@Test
	void testReshapeDifferentSize() {
		// Initialize a RichArray
		int[][] original = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
		RichArray originalArray = new RichArray(original);

		// Call reshape method
		RichArray reshapedArray = originalArray.reshape(2);

		// Expected result
		int[][] expected = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };
		RichArray expectedRichArray = new RichArray(expected);

		// Assert the result
		assertEquals(expectedRichArray.toString(), reshapedArray.toString());
	}

	@Test
	void testJoinDifferentSize() {
		// Initialize two RichArrays
		int[][] original1 = { { 1, 2 }, { 3, 4 } };
		int[][] original2 = { { 5, 6 }, { 7, 8 } };
		RichArray originalArray1 = new RichArray(original1);
		RichArray originalArray2 = new RichArray(original2);

		// Call join method
		RichArray joinedArray = originalArray1.join(originalArray2);

		// Expected result
		int[][] expected = { { 1, 2, 5, 6 }, { 3, 4, 7, 8 } };
		RichArray expectedRichArray = new RichArray(expected);

		// Assert the result
		assertEquals(expectedRichArray.toString(), joinedArray.toString());
	}

	@Test
	void testStackDifferentSize() {
		// Initialize two RichArrays
		int[][] original1 = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[] original2 = { 7, 8, 9 };
		RichArray originalArray1 = new RichArray(original1);
		RichArray originalArray2 = new RichArray(original2);

		// Call stack method
		RichArray stackedArray = originalArray1.stack(originalArray2);

		// Expected result
		int[][] expected = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		RichArray expectedRichArray = new RichArray(expected);

		// Assert the result
		assertEquals(expectedRichArray.toString(), stackedArray.toString());
	}

	@Test
	void testSliceDifferentSize() {
		// Initialize a RichArray
		int[][] original = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		RichArray originalArray = new RichArray(original);

		// Call slice method
		RichArray slicedArray = originalArray.slice(1, 2, 1, 2);

		// Expected result
		int[][] expected = { { 6, 7 }, { 10, 11 } };
		RichArray expectedRichArray = new RichArray(expected);

		// Assert the result
		assertEquals(expectedRichArray.toString(), slicedArray.toString());
	}
}
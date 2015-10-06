package techshare.benchmarks;

import static java.lang.Math.max;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

@Fork(value = 1)
@Warmup(iterations = 2, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 3, timeUnit = TimeUnit.SECONDS)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public abstract class AbstractBenchmark {
	private static final int NUMBER_OF_ELEMENTS = 500_000;
	private static final int NUMBER_OF_RANDOM_ELEMENTS = 500_000;
	
	public final int[] intArray;
	public final ArrayList<Integer> intList;
	
	public AbstractBenchmark() {
		intArray = createIntArray();
		intList = copyIntArray(intArray);
	}
	
	private static int[] createIntArray() {
		return createRandomIntArray(NUMBER_OF_ELEMENTS, NUMBER_OF_RANDOM_ELEMENTS);
	}
	
	private static int[] createRandomIntArray(int numberOfElements, int numberOfRandomElements) {
		Random random = new Random();
		int[] array = new int[numberOfElements];
		for (int i = 0; i < numberOfElements; i++)
			if (i < numberOfRandomElements)
				array[i] = random.nextInt();
			else
				array[i] = array[i % numberOfRandomElements];
		return array;
	}
		
	private static ArrayList<Integer> copyIntArray(int[] array) {
		ArrayList<Integer> list = new ArrayList<>(array.length);
		for (int i = 0; i < array.length; i++)
			list.add(array[i]);
		return list;
	}
		
	protected String stringOperation(String string, int intValue) {
		return stringOperation(string, "" + intValue);
	}

	protected String stringOperation(String string, String intString) {
		return xor(string, intString);
	}

	private String xor(String a, String b) {
		if (a.length() == 0)
			return b;
		if (b.length() == 0)
			return a;

		char[] xor = new char[max(a.length(), b.length())];
		for (int i = 0; i < xor.length; i++) {
			xor[i] = (char) (a.charAt(i % a.length()) ^ b.charAt(i % b.length()));
		}
		return new String(xor);
	}
}

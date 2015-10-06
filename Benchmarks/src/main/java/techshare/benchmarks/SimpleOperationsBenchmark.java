package techshare.benchmarks;

import java.util.Arrays;

import org.openjdk.jmh.annotations.Benchmark;

public class SimpleOperationsBenchmark extends AbstractBenchmark {
	
	@Benchmark
	public int array_max_for() {
		int m = Integer.MIN_VALUE;
		for (int i = 0; i < intArray.length; i++)
		    if (intArray[i] > m)
		        m = intArray[i];
		return m;
	}
	
	@Benchmark
	public int array_max_stream() {
		return Arrays.stream(intArray).max().getAsInt();
	}
}
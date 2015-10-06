package techshare.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;

public class ComplexOperationsBenchmark extends AbstractBenchmark {
	@Benchmark
	public String list_for() {
		String result = "";
		for (int i = 0; i < intList.size(); i++)
			result = stringOperation(result, intArray[i]);
		return result;
	}

	@Benchmark
	public String list_forEach() {
		String result = "";
		for (int intValue : intList)
			result = stringOperation(result, intValue);
		return result;
	}

	@Benchmark
	public String list_stream() {
		return intList
				.stream()
				.map(i -> i + "")
				.reduce("", this::stringOperation);
	}

	@Benchmark
	public String list_stream_parallel() {
		return intList
				.stream()
				.parallel()
				.map(i -> i + "")
				.reduce("", this::stringOperation);
	}
}
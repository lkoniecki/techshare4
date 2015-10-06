package techshare;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SomeClassJdk8 {
	
	
	public Map<String, Long> groupBy(List<String> elements) {
		return elements.stream().collect(
				Collectors.groupingBy(o->o, Collectors.counting()));
	}
	
	
}

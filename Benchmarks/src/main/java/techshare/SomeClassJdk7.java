package techshare;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SomeClassJdk7 {

	public Map<String, Integer> itDoesSomething(List<String> elements) {
		Map<String, Integer> results = new HashMap<>();

		int i = 0;
		while (i < elements.size()) {
			String key = elements.get(i);
			Integer value = results.get(key);
			if (value != null) {
				results.put(key, value++);
			} else {
				results.put(key, 1);
			}
			i++;
		}

		return results;
	}
}

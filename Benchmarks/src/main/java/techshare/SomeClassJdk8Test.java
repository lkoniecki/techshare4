package techshare;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Stopwatch;

public class SomeClassJdk8Test {
	private static final int NO_ELEMENTS = 100_000;
	//object to be tested
	private SomeClassJdk8 testClass;
	
	//random ArrayList
	private ArrayList<String> arrayList;
	//random LinkedList
	private LinkedList<String> linkedList;
	
	@Before
	public void before() {
		testClass = new SomeClassJdk8();
		arrayList = createArrayList(NO_ELEMENTS);
		linkedList = createLinkedList(NO_ELEMENTS);
	}
	
	@Test
	public void testArrayList() {
		Stopwatch st = Stopwatch.createStarted();
		testClass.groupBy(arrayList);
		System.out.println("ArrayList: " + st.elapsed(TimeUnit.MILLISECONDS) + "ms");
	}
	
	@Test
	public void testLinkedList() {
		Stopwatch st = Stopwatch.createStarted();
		testClass.groupBy(linkedList);
		System.out.println("LinkedList: " + st.elapsed(TimeUnit.MILLISECONDS) + "ms");
	}
	
	private ArrayList<String> createArrayList(int noElements) {		
		ArrayList<String> list = new ArrayList<>(noElements);
		fillWithRandomElements(NO_ELEMENTS, list);
		return list;
	}
	
	private LinkedList<String> createLinkedList(int noElements) {
		LinkedList<String> list = new LinkedList<>();
		fillWithRandomElements(NO_ELEMENTS, list);
		return list;
	}
	
	private void fillWithRandomElements(int noElements, List<String> list) {
		Random rnd = new Random();
		for (int idx = 0; idx < noElements; idx++) {
			list.add(Integer.toString(rnd.nextInt(noElements)));
		}
	}
}
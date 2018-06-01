package canoeRacer9007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test {

	public static void main(String[] args) {
		Integer numArray[] = {111,116,117,122,123,129,136,142,156,161,168,181};
		ArrayList <Integer> testList = new ArrayList<>(Arrays.asList(numArray));
		int find = Collections.binarySearch(testList, 115);
		System.out.println(testList.size());
		System.out.println("find = " + find + " reFind = " + ((-1*find)-1));
	}

}

package queue_10845;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		try {
			ArrayList<Integer> myList = new ArrayList<>();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st = new StringTokenizer(br.readLine());

			Queue<Integer> myQ = new LinkedList<Integer>();
			int last = 0;
			int N = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String temp = st.nextToken();
				if (temp.equals("push")) {
					last = Integer.parseInt(st.nextToken());
					myQ.add(last);
				} else if (temp.equals("pop")) {	
					if (myQ.isEmpty()) {
						bw.write(-1 + "\n");
						bw.flush();
					} else {
						bw.write(myQ.poll() + "\n");
						bw.flush();
					}
				} else if (temp.equals("size")) {
					Iterator it = myQ.iterator();
					int number = 0;
					while(it.hasNext()) {
						Object node =  it.next();
						number++;
					}
					bw.write(number + "\n");
					bw.flush();
				} else if(temp.equals("empty")){
					if(myQ.isEmpty()) {
						bw.write(1 + "\n");
						bw.flush();
					} else {
						bw.write(0 + "\n");
						bw.flush();
					}
				} else if(temp.equals("front")) {
					if(!myQ.isEmpty()) {
					bw.write(myQ.peek() + "\n");
					bw.flush();
					} else {
						bw.write(-1 + "\n");
						bw.flush();
					}
				} else if(temp.equals("back")) {
					if(!myQ.isEmpty()) {
					bw.write(last + "\n");
					bw.flush();
					} else {
						bw.write(-1 + "\n");
						bw.flush();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

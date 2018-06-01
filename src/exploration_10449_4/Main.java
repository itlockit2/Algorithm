package exploration_10449_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      try {
         // Scanner를 통해 파일을 읽는다.
         Scanner sc = new Scanner(new File(Main.class.getResource("760_project5_input.txt").getFile()));
         // TestCase 수
         int T = sc.nextInt();
         // 시작되는 밀리 세컨드를 계산하기 위한 변수
         long st = System.currentTimeMillis();
         for (int i = 0; i < T; i++) {
            int nodeNumber = sc.nextInt();
            int k = sc.nextInt();
            int edgeNumber = sc.nextInt();

            int graphArray[][] = new int[nodeNumber + 1][nodeNumber + 1];
            int count[] = new int[nodeNumber + 1];

            for (int j = 0; j < edgeNumber; j++) {
               int rowNumber = sc.nextInt();
               int columnNumber = sc.nextInt();
               graphArray[rowNumber][columnNumber]++;
               graphArray[columnNumber][rowNumber]++;
               count[rowNumber]++;
               count[columnNumber]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int q = 1; q < count.length; q++) {
               if (count[q] < k) {
                  queue.add(q);
               }
            }

            while (!queue.isEmpty()) {
               int popNumber = queue.poll();
               for (int j = 1; j <= nodeNumber; j++) {
                  if (graphArray[popNumber][j] != 0) {
                     graphArray[popNumber][j]--;
                     graphArray[j][popNumber]--;
                     count[popNumber]--;
                     count[j]--;
                     if (count[j] < k) {
                        queue.add(j);
                     }

                  }
               }
            }

            int counting = 0;
            for (int t = 1; t <= nodeNumber; t++) {
               if (count[t] != 0) {
                  counting++;
               }
            }

            if (counting < k) {
               System.out.println(0);
            } else {
               System.out.println(counting);
            }
         }

      // 모든 코드가 실행되었을 때의 밀리 세컨드를 계산하기 위한 변수
      long et = System.currentTimeMillis();
      // 출력되는 차이가 실행시간이다.
      // 650 ~ 800 ms 즉, 0.65 ~ 0.8초 사이라는 것을 볼 수 있었다. 
      System.out.println((et - st) + " ms");
      // 파일을 닫는다.
      sc.close();
   } catch (FileNotFoundException e) {
      e.printStackTrace();
   }
}
}
package exploration_10449_3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int T = sc.nextInt();
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
            for (int j = 1; j < nodeNumber; j++) {
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
               System.out.println(Arrays.toString(count));
            }
         }

         if (counting < k) {
            System.out.println(0);
         } else {
            System.out.println(counting);
         }
      }

   }

}
package threePrime11502;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			//test case ������ �Է�
			int T = sc.nextInt();
			long st = System.currentTimeMillis();
			//�Ҽ� ���ϱ�
			int numArray[] = new int [1001];
			for(int i = 2 ; i < numArray.length ; i++) {
				numArray[i] = i;
			}
			//2���� ������ Ž��
			for(int i = 2 ; i < numArray.length; i++) {
				// �̹� Ž���� �Ǿ����� �������� �Ѿ��.
				if(numArray[i] == 0)
					continue;
				for(int k = i*2 ; k < numArray.length ; k = k + i) {
					numArray[k] = 0;
				}
			}
			//test case ����ŭ ����
			for(int i = 0 ; i < T ; i++) {
				int num = sc.nextInt();
				int first = 0;
				int second = 0;
				int third = 0;
				// 3���� ���� num�� �ɶ����� �ݺ�
					for(int a = 0 ; a<numArray.length ; a++) {
						if(numArray[a] == 0)
							continue;
						if(first + second + third == num)
							break;
						first = numArray[a];
						
						for(int b= 0 ; b<numArray.length; b++) {
							if(numArray[b] == 0)
								continue;
							if(first + second + third == num)
								break;
							second = numArray[b];
							
							for(int c=0; c<numArray.length; c++) {
								if(numArray[c] == 0)
									continue;
								if(first + second + third == num)
									break;
								third = numArray[c];
							}
						}
					}
					System.out.println(first + " " + second + " " + third);
				}
			
			long et = System.currentTimeMillis();
			System.out.println((et-st) + "ms");
			sc.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}

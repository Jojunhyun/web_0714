package Day03;

import java.util.Scanner;

public class Day03_3 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
			//����3 : �ϳ��� ������ �Է¹޾� 7�� ������� ���[ true , false ]
		System.out.print("�����Է� : "); int ����3 = scanner.nextInt();
		// ���ã�� : ��%�� == 0 	[ �������� 0 �̸� ���� �׼��� ��� ]
		System.out.println("�Է��Ͻ� ���� 7�ǹ�� : " + (����3%7==0) );
		
			//����4 : �ϳ��� ������ �Է¹޾� Ȧ�� ���� Ȯ�� [ true , false ]
		System.out.print("�����Է� : "); int ����4 = scanner.nextInt();
		// Ȧ��/¦��ã�� : ��%2 == 0  [ ��%2 ������ �������� 0�̸� ���� ¦�� �������� 1 �̸� ���� Ȧ�� ]
		System.out.println("�Է��Ͻ� ���� Ȧ�� : " + (����4%2==1) );
		
			//����5 : �ϳ��� ������ �Է¹޾� 7�� ��� �̸鼭 ¦�� ���� Ȯ�� [ true , false ]
		System.out.print("�����Է� : "); int ����5 = scanner.nextInt();
		System.out.println("�Է��Ͻ� ���� 7�� ��� �̸鼭 ¦�� : " + ( ����5%7==0 && ����5%2==0 ) );
		
			//����6 : �ΰ��� ������ �Է¹޾� �� ū�� ���  [ true , false ]
		System.out.print("����1�Է� : "); int ����6_1 = scanner.nextInt();
		System.out.print("����2�Է� : "); int ����6_2 = scanner.nextInt();
		System.out.println("�� ������ ����1 �� ũ�� : " + (����6_1>����6_2) );
		
			//����7 : �������� �Է¹޾� �� ���� ����ϱ� 
				// �� ���� ���� => ������ * ������ * ������[3.14]
		System.out.print("������ : "); int ����7 = scanner.nextInt();
		double ������ = ����7 * ����7 * 3.14;
		System.out.println("�Է��� �������� �����̴� : " + ������ );
		
			//����8 : �� �Ǽ��� �Է¹޾� �սǼ��� ���� ���� ���� ��% ���� ����ϱ�
				// ��) 54.5   84.3 �̸�    64.285714%
		System.out.print("�Ǽ�1 : "); double ����8_1 = scanner.nextDouble();
		System.out.print("�Ǽ�2 : "); double ����8_2 = scanner.nextDouble();
		double ���� = (����8_1/����8_2) * 100 ;	
		System.out.println("�Ǽ�1�� �Ǽ�2�� ����� : " + (����) + "%");
		System.out.printf("�Ǽ�1�� �Ǽ�2�� ����� : %.2f%%", ���� );
							// ���Ĺ��� : %f [ �Ǽ� ]
								// %.����f [���� : �Ҽ��� �ڸ��� ]
									// %.2f [ �Ҽ��� 2�ڸ��� ] 


	}

}
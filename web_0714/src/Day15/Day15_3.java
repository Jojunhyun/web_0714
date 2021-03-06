package Day15;

public class Day15_3 {

	// 스레드의 우선순위 
		// 여러개의 스레드는 운영체제로부터 스케줄링[ 자원할당 순서 ]랜덤으로 지정 
	
	public static void main(String[] args) {
		
		for( int i = 0 ; i<10 ;i++) {
			
			Thread thread = new Print("스레드번호"+i);
			
			// 우선순위
			if( i !=9 ) {
				thread.setPriority( Thread.MIN_PRIORITY);
									// 낮은 우선순위 설정 
			}else {
				thread.setPriority( Thread.MAX_PRIORITY );
									// 높은 우순선위 설정 
			}
			
			
			thread.start();
		}
	}

}

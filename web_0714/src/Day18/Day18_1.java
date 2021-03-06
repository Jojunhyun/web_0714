package Day18;

import java.util.HashMap;
import java.util.Iterator;

public class Day18_1 {
	
	public static void main(String[] args) {
		
		// Map : 
			// 1.HashMap : 동기화x  [ 단일스레드 사용시 ]
			// 2.HashTable : 동기화o [ 멀티스레드 사용시 ]
				// 메소드 
					// 1. .put( 키 , 값 ) : 키와 값 => 엔트리 [ 키값은 중복불가 ] 
					// 2. .get( 키 ) : 키에 해당하는 값 
					// 3. .keyset() : 모든 키 출력 
					// 4. .values() : 모든 값 출력 
					// 5. .size() : 엔트리 전체 수 
					// 6. .remove(키) : 키에 해당하는 엔트리 삭제 
					// 7. .clear() : 모든 엔트리 삭제 
					
		HashMap< String , Integer > hashMap = new HashMap<>();
			// 멀티제네릭 [ k : 키  / v : 값 ] : 객체내 매개타입[자료형] 
		// 저장 
		hashMap.put("유재석", 80 );
		hashMap.put("강호동", 70 );
		hashMap.put("신동엽", 60 );
		hashMap.put("유재석", 80 ); // key => 해시[ 데이터=>주소값 ]
		hashMap.put("서장훈", 80 ); // value => 중복값 허용 
		
		// 출력 
		System.out.println(" hashmap : " + hashMap );
		// 호출 
		System.out.println(" hashmap key : " + hashMap.get("유재석"));
		// 키 호출 
		System.out.println(" hashmap total key : " + hashMap.keySet() );
		// 값 호출 
		System.out.println(" hashmap total value : " + hashMap.values() );
		// 엔트리(키,값)
		System.out.println(" hashmap size : " + hashMap.size() );
		// 삭제( 키 ) 
		System.out.println(" hashmap remove : " + hashMap.remove("유재석") );
		
		// 전체 출력 
		for( String key : hashMap.keySet() ) {
			System.out.println( hashMap.get(key) );
		}
		// 전체 출력 [ Iterator 인터페이스 : 컬렉션 메모리 순회 ] 
		Iterator< String > iterator = hashMap.keySet().iterator();
		while( iterator.hasNext() ) {
			String key = iterator.next();
			System.out.println( key +"/"+ hashMap.get( key ));
		}
		// 전체 삭제 
		hashMap.clear();
		System.out.println(" hashmap : " + hashMap );
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

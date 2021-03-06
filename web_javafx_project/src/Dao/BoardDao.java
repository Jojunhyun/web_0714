package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Domain.BoardDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BoardDao {
	
	// 1. Connection 인터페이스 
	Connection connection;
	// 2. ResultSet 인터페이스  
	ResultSet resultSet;	
	// 3. 현재 클래스의 DB객체 
	private static BoardDao boardDao = new BoardDao(); // DB 와 연결 객체 
	// 4. DB객체 호출 
	public static BoardDao getboarddao() {
		return boardDao;
	}
	public BoardDao() {
		try {
			// 1. mysql 드라이버 가져오기 
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx_2?serverTime=UTC","root","NERTH1078");
			System.out.println("board db 연동 ");
		}
		catch (Exception e) {}
	}

		// CRUD : 쓰기읽기수정삭제 [ insert select update , delete ] 
		
	// 1. 글쓰기 메소드 [ 인수 : BoardDto ( 화면에 입력받은 값을 컨트롤에서 dao로 넘기기 ) ]  
	public boolean boardwrite( BoardDto boardDto ) {
		
		//1. SQL 작성 => SQL <-- DB 연결 => SQL 조작 -> SQL 실행 => SQL 결과 
		String sql = "insert into board( btitle , bcountents , bwriter ) values(?,?,?)";
		try {
		
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			// ? 에 대응하는 값 넣기 
			preparedStatement.setString( 1 , boardDto.getBtitle() );
			preparedStatement.setString( 2 , boardDto.getBcountents() );
			preparedStatement.setString( 3 , boardDto.getBwriter() );
			preparedStatement.executeUpdate(); // insert , update , delete
			return true;
			
		}catch (Exception e) {}
		return false; 
	}
	
	// 2. 글목록[ 모든 글 호출 ] 메소드 
	public ObservableList<BoardDto> boardlist(){
		
		ObservableList< BoardDto > boardDtos = FXCollections.observableArrayList();
		// 1. SQL 작성 
		String sql = "select * from board";
		
		try {
			// 2. SQL 연결 
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			// 3. SQL 실행결과 [ 쿼리 = 검색 결과 ]
			// 3. 결과 연결 
			resultSet = preparedStatement.executeQuery();
			
			// 결과가 다수일경우 반복문 
			while( resultSet.next() ) {
				// resultSet.next() : 다음 레코드
				// 1. dto 객체 선언
				BoardDto boardDto = new BoardDto(resultSet.getInt(1) 
						, resultSet.getString(2), resultSet.getString(3)
						, resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6));
						// resultSet.get자료형( 필드순서번호 )
				
				// 2. dto 객체를 리스트 저장
				boardDtos.add(boardDto);
			} // 반복문 종료 
			return boardDtos;
			
		}catch (Exception e) {}
		return null;
	}
	// 3. 글상세[ 특정 글 호출 ] 메소드 
	
	// 4. 글수정[ 특정 글 수정 ] 메소드 
	public boolean boardupdate( String title , String contents , int bno ) {
		String sql ="update board set btitle=? , bcountents = ? where bno = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString( 1 , title );
			preparedStatement.setString( 2 , contents );
			preparedStatement.setInt( 3 , bno );
			
			preparedStatement.executeUpdate();
			return true;
		}catch (Exception e) {}
		return false;
	}
	
	// 5. 글삭제[ 특정 글 삭제 ] 메소드 
	public boolean boarddelete( int bno ) {
		String sql = "delete from board where bno =? ";	
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, bno);
			preparedStatement.executeUpdate();
			return true;
		}catch (Exception e) {}
		return false;
	}
	
	// 6. 조회수증가 메소드 
	public boolean boardcount(  int bcount , int bno ) {
		
		String sql = "update board set bcount = ?  where bno =? ";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, bcount);
			preparedStatement.setInt(2, bno);
			
			preparedStatement.executeUpdate();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	
	
	
	
	
	
	
}

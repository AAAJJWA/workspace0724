package File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileCreate {

	public static void main(String[] args) {
		// Properties
		// Properties클래스는 Map계열의 컬렉션으로, key-value형식으로 데이터를 저장/읽기할 수 있음.
		// 특히 외부파일(.properties / .xml)을 통해 데이터를 쉽게 관리하고 불러올 수 있음.
		// DB연결정보, 프로그램 설정정보(port, 환경변수...), sql쿼리문등을 코드와 분리해서 관리할 때 주로 사용.

		//파일로 출력
		Properties prop = new Properties();
		Properties propXml = new Properties();
		prop.setProperty("driver", "oracle.jdbc.driver.OracleDriver"); //데이터 생성
		prop.setProperty("url", "jdbc:oracle:thin:@localhost:1521:xe"); //데이터 조회
		prop.setProperty("username", "c##JDBC"); //데이터 수정
		prop.setProperty("password", "JDBC"); //데이터 삭제
		
		propXml.setProperty("insertMember",  "INSERT INTO APPLE_MEMBER VALUES( SEQ_TNO.NEXTVAL, ?, ?, SYSDATE )");
		propXml.setProperty("selectMemberList", "SELECT * FROM APPLE_MEMBER");
		propXml.setProperty("selectRanking","SELECT * FROM APPLE_MEMBER ORDER BY TPOINT DESC, TDATE ASC");
		try {
			//prop.store() -> .properties파일로 객체의 정보를 저장하겠다.
			//.properties파일 -> 단순 텍스트 파일(key-value형식)
			prop.store(new FileOutputStream("resources/driver.properties"), "properties test");
			
			//prop.storeToXML() .xml파일로 객체의 정보를 저장하겠다.
			//.xml 파일 -> xml형식 문서(태그구조)
			// -> dtd : xml 문서의 구조와 규칙을 정의한 문서
			propXml.storeToXML(new FileOutputStream("resources/query.xml"), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//파일로부터 값을 읽어오기
		
		try {
			
			System.err.println("======================================");
			
			propXml.loadFromXML(new FileInputStream("resources/query.xml"));
			
			System.out.println(propXml.getProperty("insertMember"));
			System.out.println(propXml.getProperty("selectMemberList"));
			System.out.println(propXml.getProperty("updateMember"));
			System.out.println(propXml.getProperty("deleteMember"));
			System.out.println(propXml.getProperty("memberSearchByName"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}


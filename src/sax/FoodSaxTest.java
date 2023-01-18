package sax;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class FoodSaxTest {

	public static void main(String[] args) {
		File file = new File("d:/d_other/XML_Sample.xml");
		
		// ParserFactory 생성
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		try {
			// Parser 생성
			SAXParser parser = factory.newSAXParser();
			
			// Handler 객체 생성
			FoodSaxHandler handler = new FoodSaxHandler();
			
			// parser 객체를 통해 xml파일을 읽어와 handler 객체에 할당
			parser.parse(file, handler);
			
			// handler 로 할당된 xml 파일의 자료를 Food 클래스의 list 에 저장
			List<Food> list = handler.getFoodList();
			
			
			// 출력
			for (Food food : list) {
				System.out.println(food);
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

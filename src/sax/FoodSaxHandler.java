package sax;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

// startElement() : 태그를 처음 만나면, 발생하는 이벤트

// endElement() : 닫힌 태그를 만나면 발생하는 이벤트

// characters() : 태그와 태그 사이의 text(내용)을 처리하기 위한 이벤트


public class FoodSaxHandler extends DefaultHandler{

	// 파싱한 음식 객체를 넣을 리스트
	private List<Food> foodList;
	// 파싱한 음식 객체
	private Food food;
	// character() 메서드에서 저장할 문자열 변수
	private String str;
	
	
	public FoodSaxHandler() {
		foodList = new ArrayList<>();
	}
	
	@Override
	public void startElement(String uri, String localName, String name, Attributes att) throws SAXException {
		// 시작 태그를 만났을 때 발생하는 이벤트
		if (name.equals("food")) {
			food = new Food();
			foodList.add(food);
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String name) throws SAXException {
		// 끝 태그를 만났을 때 발생하는 이벤트
		if (name.equals("name")) {
			food.setName(str);
		}else if(name.equals("sort")) {
			food.setSort(str);
		}else if(name.equals("cost")) {
			food.setCost(Integer.parseInt(str));
		}
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// 태그와 태그 사이의 내용을 처리
		str = new String(ch, start, length);
	}
	
	public List<Food> getFoodList() {
		return foodList;
	}
	
	public void setFoodList(List<Food> foodList) {
		this.foodList = foodList;
	}
	
	
}

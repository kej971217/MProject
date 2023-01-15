package sax;

public class Food {
	// XML_Sample.xml 을 파싱하여 저장할 Food 클래스 생성
	// setter와 getter를 통해 작성
	
	
	private String food;
	private String name;
	private String sort;
	private int cost;
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "[음식 - 이름 : " + name + ", 종류 : " + sort + ", 가격 : " + cost + "]";
	}
	
	
	
}

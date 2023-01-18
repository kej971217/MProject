package dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOM01 {
	// 하이 고은지? 
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		
		//XML 문서 파싱
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse("D:/D_Other/XML_Sample.xml");
		
		//root 가져오기 getDocumentElement() : 가장 첫번째 요소(root)를 가져옴
		Element root = document.getDocumentElement();
		
		System.out.println("Root name : " + root.getNodeName());
		System.out.println();
		
		for(int i = 0; i<root.getAttributes().getLength(); i++) {
			System.out.println("Root Attr : " + root.getAttributes()); // 주소값이 나옴..
		}
		
		System.out.println("----------------------------------");
		System.out.println();
		
		// child node 목록 가져오기
		NodeList children = root.getChildNodes();
		for(int i = 0; i < children.getLength(); i++) {
			
			// item(index) 메서드를 이용해서 각각의 요소들을 가져올 수 있음
			Node node = children.item(i);
			
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				// xml 파일의 빈 공백을 노드로 인식하기 때문에 Element인지 빈 공백인지 가리는 작업이 필요함.
				
				Element ele = (Element)node;
				String nodeName = ele.getNodeName();
				
				System.out.println("Node name : " + nodeName);
				
				NodeList children2 = ele.getChildNodes();
				
				for(int j = 0; j<children2.getLength(); j++) {
					Node node2 = children2.item(j);
					if(node2.getNodeType() == Node.ELEMENT_NODE) {
						Element ele2 = (Element)node2;
						String nodeName2 = ele2.getNodeName();
						
						
						// getTextContent() : 태그 안 텍스트 가져오기
						System.out.println(nodeName2 +" : "+ ele2.getTextContent());
					}
				}
				System.out.println();
				
			}
			
			
			
		}
		
		
		
	}

}

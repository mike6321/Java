package me.choi.inheritance.visitorpattern;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Project : IntoJAVA
 *
 * @author : jwdeveloper
 * @comment : xml을 전부 메모리에 적재하는 방식 - Dom 방식
 * Time : 6:26 오후
 */
public class Domparser {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse("src/main/resources/members.xml");
        NodeList member = document.getElementsByTagName("member");
        for (int i = 0; i < member.getLength(); i++) {
            Node node = member.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String id = element.getAttribute("id");
                System.out.println(id);

                NodeList childNodes = element.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node childNode = childNodes.item(j);
                    if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element childElemnets = (Element) childNode;
                        String textContent = childElemnets.getTextContent();
                        System.out.println(childNode.getNodeName() + " " +textContent);
                    }
                }
            }
        }
    }
}


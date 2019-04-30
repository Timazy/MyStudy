package com.timazy.learn.javaSE.dom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/*
*	@author : Rick
*	@date : 2019年4月24日
*	
*/
public class XmlParser {

	
	public static void main(String[] args) throws SAXException, IOException {
		
		
		
		String path = Thread.currentThread().getContextClassLoader().getResource(".").getPath();
		String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory factory = SchemaFactory.newInstance(language);
		Schema schema = factory.newSchema(new File(path+"ab.xsd"));
		Validator validator= schema.newValidator();
		
//		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder builder = null;
//		try {
//		    builder = builderFactory.newDocumentBuilder();
//		} catch (ParserConfigurationException e) {
//		    e.printStackTrace();  
//		}
//		
//		FileInputStream inputStream = new FileInputStream(new File(path + "search.xml"));
//		Document dom  = builder.parse(inputStream);
//		
//		DOMSource source = new DOMSource(dom);	
		
		Source source = new StreamSource(path + "search.xml");
		validator.validate(source);
		//validator.validate(source);
		
		System.out.println(path);
	}
}

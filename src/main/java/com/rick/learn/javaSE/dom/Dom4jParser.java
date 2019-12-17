package com.rick.learn.javaSE.dom;

import java.io.File;
import java.util.Iterator;
import org.apache.tomcat.util.descriptor.XmlErrorHandler;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.SAXValidator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

/*
*	@author : Rick
*	@date : 2019年4月24日
*	
*/
public class Dom4jParser {

	public static void main(String[] args) throws DocumentException, SAXException {
		String path = Thread.currentThread().getContextClassLoader().getResource(".").getPath() ;
		

		XmlErrorHandler errorHandler = new XmlErrorHandler();
		
		SAXReader reader = new SAXReader();
		reader.setValidation(true);
		reader.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage","http://www.w3.org/2001/XMLSchema");
		reader.setProperty("http://java.sun.com/xml/jaxp/properties/schemaSource", path + "ab.xsd");
		
		
		SAXValidator validator = new SAXValidator(reader.getXMLReader());
		validator.setErrorHandler(errorHandler);
		
		
		Document document = reader.read(new File(path + "search.xml"));
		try {
			validator.validate(document);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (!errorHandler.getErrors().isEmpty()) {
			Iterator<SAXParseException> errors = errorHandler.getErrors().iterator();
			while(errors.hasNext()){
				System.out.println(errors.next().getMessage());
			}
		}
		
		Element element = document.getRootElement();
		System.out.println(element.getName());
		System.out.println(element.getText());
		
	}
	
}

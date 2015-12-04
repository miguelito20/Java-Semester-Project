package media_managment_system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Title_Sort {
	public static void main(String[] args) {
		 
        try {
        	//Loading XML File
            FileInputStream file = new FileInputStream(new File("MP3s.xml"));
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder =  builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(file);
            XPath xPath =  XPathFactory.newInstance().newXPath();
            
            //
            String expression = "/MP3s/MP3[@mp3id='1']/Title";
            //
            
            //Print All Titles
            ArrayList<String> SongNames = new ArrayList<String>();
            System.out.println("*************************");
            expression = "/MP3s/MP3/Title";
            System.out.println(expression);
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
               SongNames.add(nodeList.item(i).getFirstChild().getNodeValue());
            }
            
            System.out.println("*************************");

             //SORT Song Names
              
	   			Collections.sort(SongNames);
	   			
	   			System.out.println("After Sorting Titles:");
	   			for(String counter: SongNames){
				System.out.println(counter);  					
	   			}
	   	
	   		//End Sort
	   		
        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }       
    }
}


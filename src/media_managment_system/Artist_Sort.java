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

public class Artist_Sort {
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
            
          //Print All Artists
            ArrayList<String> ArtistNames = new ArrayList<String>();
            System.out.println("*************************");
            expression = "/MP3s/MP3/Artist";
            System.out.println(expression);
            NodeList artistnodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
            for (int i = 0; i < artistnodeList.getLength(); i++) {
                ArtistNames.add(artistnodeList.item(i).getFirstChild().getNodeValue());
            }
             
	   			System.out.println("*************************");
	   		
	   		//SORT Artist Names
	              
	   			Collections.sort(ArtistNames);
	   			
	   			System.out.println("After Sorting Artists:");
	   			for(String counter: ArtistNames){
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
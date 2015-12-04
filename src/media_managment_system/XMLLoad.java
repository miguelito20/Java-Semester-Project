package media_managment_system;

//File IO
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

//using XML
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

//Getting values from XML
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLLoad {
	public static String[] Title = new String[10];

	public static void Pull() {
		 
      try {
      	//Loading XML File
          FileInputStream file = new FileInputStream(new File("MP3s.xml"));
          DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
          DocumentBuilder builder =  builderFactory.newDocumentBuilder();
          Document xmlDocument = builder.parse(file);
          XPath xPath =  XPathFactory.newInstance().newXPath();
          
          //Title of associated id number
          String expression = "/MP3s/MP3[@mp3id]";
          System.out.println(expression);
          NodeList MP3 = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
          for (int i = 0; i < MP3.getLength(); i++){
        	  Title[i] = MP3.item(i).getFirstChild().getNodeValue();
          }
          System.out.println(MP3);
          
          
          //Print All Titles
          ArrayList<String> SongNames = new ArrayList<String>();
   
          expression = "/MP3s/MP3/Title";
          System.out.println(expression);
          NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
          for (int i = 0; i < nodeList.getLength(); i++) {
              System.out.println(nodeList.item(i).getFirstChild().getNodeValue()); 
             SongNames.add(nodeList.item(i).getFirstChild().getNodeValue());
          }
        
         
        //Print All Artists
          ArrayList<String> ArtistNames = new ArrayList<String>();
          System.out.println("*************************");
          expression = "/MP3s/MP3/Artist";
          System.out.println(expression);
          NodeList artistnodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
          for (int i = 0; i < artistnodeList.getLength(); i++) {
              System.out.println(artistnodeList.item(i).getFirstChild().getNodeValue()); 
              ArtistNames.add(artistnodeList.item(i).getFirstChild().getNodeValue());
          }
      
        //Print All Albums
          ArrayList<String> AlbumNames = new ArrayList<String>();
          System.out.println("*************************");
          expression = "/MP3s/MP3/Album";
          System.out.println(expression);
          NodeList albumnodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
          for (int i = 0; i < albumnodeList.getLength(); i++) {
              System.out.println(albumnodeList.item(i).getFirstChild().getNodeValue()); 
              AlbumNames.add(albumnodeList.item(i).getFirstChild().getNodeValue());
          }
          
          //All Values of certain ID number
          System.out.println("*************************");
          expression = "/MP3s/MP3[@mp3id='3']";
          System.out.println(expression);
          Node node = (Node) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
          if(null != node) {
              nodeList = node.getChildNodes();
              for (int i = 0;null!=nodeList && i < nodeList.getLength(); i++) {
                  Node nod = nodeList.item(i);
                  if(nod.getNodeType() == Node.ELEMENT_NODE)
                      System.out.println(nodeList.item(i).getNodeName() + " : " + nod.getFirstChild().getNodeValue()); 
              }
          }
           
          System.out.println("*************************");
          
          
           //SORT Song Names
            
	   			Collections.sort(SongNames);
	   			
	   			System.out.println("After Sorting Titles:");
	   			for(String counter: SongNames){
				System.out.println(counter);  					
	   			}
	   	
	   		//End Sort
	   		
	   			System.out.println("*************************");
	   		
	   		//SORT Artist Names
	              
	   			Collections.sort(ArtistNames);
	   			
	   			System.out.println("After Sorting Artists:");
	   			for(String counter: ArtistNames){
				System.out.println(counter);  					
	   			}
	   	
	   		//End Sort
	   		
	   			System.out.println("*************************");
		   	
	   		//SORT Album Names
		              
		   			Collections.sort(AlbumNames);
		   			
		   			System.out.println("After Sorting Artists:");
		   			for(String counter: AlbumNames){
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


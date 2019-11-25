package fr.afcepf.al34.tp.xml;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AnalyserXml {
	public static void main(String[] args) {
		analyserFichierXml("src/main/resources/produit.xml");
	}
	public static void analyserFichierXml(String fileName) {
		try {
			DocumentBuilderFactory DocBuilderFactory =  
					DocumentBuilderFactory.newInstance(); 
			//DocBuilderFactory.setValidating(true); //valider en tenant compte d'un dtd ou xsd
			/* Fabriquer un parseur DOM: */ 
			DocumentBuilder docBuilder = DocBuilderFactory.newDocumentBuilder();
			/* Déclencher le parsing et récupérer une référence sur l'arbre DOM: */ 
			Document xmlDoc = docBuilder.parse(fileName);
			Element docElement = xmlDoc.getDocumentElement();//accès  à la balise principale
			String valeurAttributRef = docElement.getAttribute("ref");
			System.out.println("valeurAttributRef="+valeurAttributRef);
			NodeList nodeList = docElement.getChildNodes();
			for(int i=0;i<nodeList.getLength();i++) {
				Node n = nodeList.item(i); 
				//attention Node = noeud quelconque (Comment , Text , Element)
				if(n.getNodeType()==Node.ELEMENT_NODE) {
					Element elt = (Element) n;
					System.out.println(elt.getNodeName()+":"+elt.getTextContent());
				}
			}
			//acces direct au prix:
			String sPrix= ((Element)docElement.getElementsByTagName("prix").item(0)).getTextContent();
			System.out.println("prix="+sPrix);
			
			//ajouter <caracteristique>bonne qualite</caracteristique>
			//en dessous docElement reférençant ici le noeud principal <produit> : 
			Element eltCar = xmlDoc.createElement("caracteristique"); //à rattacher
			docElement.appendChild(eltCar);
			eltCar.appendChild(xmlDoc.createTextNode("bonne qualite"));
			
			//générer un fichier produit2.xml à partir de l'arbre modifié/agrandi:
			TransformerFactory trFactory = TransformerFactory.newInstance();  
			Transformer tr = trFactory.newTransformer();   
			tr.transform(new DOMSource(xmlDoc),
					   new StreamResult(new FileOutputStream("src/main/resources/f2.xml") )); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

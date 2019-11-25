package fr.afcepf.al34.tp.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import fr.afcepf.al34.tp.data.Produit;

public class AnalyserXmlViaJaxb2 {

	public static void main(String[] args) {
		analyserXmlViaJaxb2("src/main/resources/produit.xml");
	}

	private static void analyserXmlViaJaxb2(String fileName) {
		try {
			JAXBContext jctx =     
					JAXBContext.newInstance(Produit.class);
			Unmarshaller um = jctx.createUnmarshaller(); 
			// pour remonter des objets en mémoire // suite à la lecture d'un flux xml 
			// Marshaller m = jctx.createMarshaller();// pour ecrire
			Produit p = (Produit) um.unmarshal( new File( fileName ) );
			System.out.println(p);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		
	}

}

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
			
			Produit p = (Produit) um.unmarshal( new File( fileName ) );
			System.out.println(p);
			
			Marshaller m = jctx.createMarshaller();// pour ecrire
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			p.setLabel(p.getLabel().toUpperCase());//modif en mémoire
			
			//écriture dans nouveau fichier f3:
			m.marshal(p, new File("src/main/resources/f3.xml"));//+Refresh eclipse
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		
	}

}

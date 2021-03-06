
package fr.afcepf.al34.itf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import fr.afcepf.al34.dto.ResCalculTva;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.afcepf.al34.itf package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Ttc_QNAME = new QName("http://itf.al34.afcepf.fr/", "ttc");
    private final static QName _GetAuteurResponse_QNAME = new QName("http://itf.al34.afcepf.fr/", "getAuteurResponse");
    private final static QName _ResCalculTva_QNAME = new QName("http://itf.al34.afcepf.fr/", "resCalculTva");
    private final static QName _TtcResponse_QNAME = new QName("http://itf.al34.afcepf.fr/", "ttcResponse");
    private final static QName _TvaEtTtc_QNAME = new QName("http://itf.al34.afcepf.fr/", "tvaEtTtc");
    private final static QName _TvaResponse_QNAME = new QName("http://itf.al34.afcepf.fr/", "tvaResponse");
    private final static QName _TvaEtTtcResponse_QNAME = new QName("http://itf.al34.afcepf.fr/", "tvaEtTtcResponse");
    private final static QName _Tva_QNAME = new QName("http://itf.al34.afcepf.fr/", "tva");
    private final static QName _GetAuteur_QNAME = new QName("http://itf.al34.afcepf.fr/", "getAuteur");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf.al34.itf
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAuteurResponse }
     * 
     */
    public GetAuteurResponse createGetAuteurResponse() {
        return new GetAuteurResponse();
    }

    /**
     * Create an instance of {@link Ttc }
     * 
     */
    public Ttc createTtc() {
        return new Ttc();
    }

    /**
     * Create an instance of {@link TtcResponse }
     * 
     */
    public TtcResponse createTtcResponse() {
        return new TtcResponse();
    }

    /**
     * Create an instance of {@link TvaEtTtc }
     * 
     */
    public TvaEtTtc createTvaEtTtc() {
        return new TvaEtTtc();
    }

    /**
     * Create an instance of {@link TvaEtTtcResponse }
     * 
     */
    public TvaEtTtcResponse createTvaEtTtcResponse() {
        return new TvaEtTtcResponse();
    }

    /**
     * Create an instance of {@link TvaResponse }
     * 
     */
    public TvaResponse createTvaResponse() {
        return new TvaResponse();
    }

    /**
     * Create an instance of {@link GetAuteur }
     * 
     */
    public GetAuteur createGetAuteur() {
        return new GetAuteur();
    }

    /**
     * Create an instance of {@link Tva }
     * 
     */
    public Tva createTva() {
        return new Tva();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ttc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itf.al34.afcepf.fr/", name = "ttc")
    public JAXBElement<Ttc> createTtc(Ttc value) {
        return new JAXBElement<Ttc>(_Ttc_QNAME, Ttc.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuteurResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itf.al34.afcepf.fr/", name = "getAuteurResponse")
    public JAXBElement<GetAuteurResponse> createGetAuteurResponse(GetAuteurResponse value) {
        return new JAXBElement<GetAuteurResponse>(_GetAuteurResponse_QNAME, GetAuteurResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResCalculTva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itf.al34.afcepf.fr/", name = "resCalculTva")
    public JAXBElement<ResCalculTva> createResCalculTva(ResCalculTva value) {
        return new JAXBElement<ResCalculTva>(_ResCalculTva_QNAME, ResCalculTva.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TtcResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itf.al34.afcepf.fr/", name = "ttcResponse")
    public JAXBElement<TtcResponse> createTtcResponse(TtcResponse value) {
        return new JAXBElement<TtcResponse>(_TtcResponse_QNAME, TtcResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TvaEtTtc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itf.al34.afcepf.fr/", name = "tvaEtTtc")
    public JAXBElement<TvaEtTtc> createTvaEtTtc(TvaEtTtc value) {
        return new JAXBElement<TvaEtTtc>(_TvaEtTtc_QNAME, TvaEtTtc.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TvaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itf.al34.afcepf.fr/", name = "tvaResponse")
    public JAXBElement<TvaResponse> createTvaResponse(TvaResponse value) {
        return new JAXBElement<TvaResponse>(_TvaResponse_QNAME, TvaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TvaEtTtcResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itf.al34.afcepf.fr/", name = "tvaEtTtcResponse")
    public JAXBElement<TvaEtTtcResponse> createTvaEtTtcResponse(TvaEtTtcResponse value) {
        return new JAXBElement<TvaEtTtcResponse>(_TvaEtTtcResponse_QNAME, TvaEtTtcResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itf.al34.afcepf.fr/", name = "tva")
    public JAXBElement<Tva> createTva(Tva value) {
        return new JAXBElement<Tva>(_Tva_QNAME, Tva.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAuteur }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://itf.al34.afcepf.fr/", name = "getAuteur")
    public JAXBElement<GetAuteur> createGetAuteur(GetAuteur value) {
        return new JAXBElement<GetAuteur>(_GetAuteur_QNAME, GetAuteur.class, null, value);
    }

}

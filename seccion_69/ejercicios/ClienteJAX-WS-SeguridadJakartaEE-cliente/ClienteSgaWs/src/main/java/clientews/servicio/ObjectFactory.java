
package clientews.servicio;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the clientews.servicio package. 
 * <p>An ObjectFactory allows you to programmatically 
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

    private static final QName _ListarPersonas_QNAME = new QName("http://servicio.sga/", "listarPersonas");
    private static final QName _ListarPersonasResponse_QNAME = new QName("http://servicio.sga/", "listarPersonasResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clientews.servicio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListarPersonas }
     * 
     * @return
     *     the new instance of {@link ListarPersonas }
     */
    public ListarPersonas createListarPersonas() {
        return new ListarPersonas();
    }

    /**
     * Create an instance of {@link ListarPersonasResponse }
     * 
     * @return
     *     the new instance of {@link ListarPersonasResponse }
     */
    public ListarPersonasResponse createListarPersonasResponse() {
        return new ListarPersonasResponse();
    }

    /**
     * Create an instance of {@link Persona }
     * 
     * @return
     *     the new instance of {@link Persona }
     */
    public Persona createPersona() {
        return new Persona();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarPersonas }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarPersonas }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.sga/", name = "listarPersonas")
    public JAXBElement<ListarPersonas> createListarPersonas(ListarPersonas value) {
        return new JAXBElement<>(_ListarPersonas_QNAME, ListarPersonas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarPersonasResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarPersonasResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.sga/", name = "listarPersonasResponse")
    public JAXBElement<ListarPersonasResponse> createListarPersonasResponse(ListarPersonasResponse value) {
        return new JAXBElement<>(_ListarPersonasResponse_QNAME, ListarPersonasResponse.class, null, value);
    }

}

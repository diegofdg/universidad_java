package mx.com.gm.peliculas.negocio;

/**
 *
 * Interface para administrar el catalogo de peliculas
 *
 * @author Ing. Ubaldo Acosta
 */
public interface CatalogoPeliculas {

    public void agregarPelicula(String nombrePelicula, String nombreArchivo);

    public void listarPeliculas(String nombreArchivo);

    public void buscarPelicula(String nombreArchivo, String buscar);

    public void iniciarArchivo(String nombreArchivo);

}

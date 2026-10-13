package controladores;

import java.io.File;

public class FileController implements Controlador{
    protected final File dataDirectory;

    public FileController(String dataDirectory) {
        this.dataDirectory = new File(dataDirectory);
        this.dataDirectory.mkdir();
    }

    @Override
    public void anadirLibro(String isbn, String titulo, float precio, String autor, int anopublicacion) {

    }

    @Override
    public void mostrarLibros() {

    }

    @Override
    public void buscarLibro(String isbn) {

    }

    @Override
    public void eliminarLibro(String isbn) {

    }
}

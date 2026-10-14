package controladores;

import java.io.File;
import java.io.IOException;

public class FileController implements Controlador{
    protected final File dataDirectory;
    protected final File dataFile;
    private MemoryController c;

    public FileController(String dataDirectory, MemoryController c) {
        this.dataDirectory = new File(dataDirectory);
        this.c = c;
        this.dataFile = new File(dataDirectory, "libros.txt");

        if (!this.dataDirectory.exists()) {
            this.dataDirectory.mkdirs();
        }

        try {
            if (!this.dataFile.exists()) {
                this.dataFile.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void cargarLibros () {
        c.getId()

    }

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

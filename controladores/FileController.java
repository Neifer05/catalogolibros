package controladores;

import models.Libro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileController extends MemoryController {
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
                FileWriter wr = new FileWriter(this.dataFile);
                wr.write("ID;ISBN;TITULO;PRECIO;AUTOR;AÑOPUBLICACION");
                wr.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.cargarLibros();
    }

    public void cargarLibros () {

    }

    public Libro anadirLibro(String isbn, String titulo, float precio, String autor, int anopublicacion) {
        Libro l = super.anadirLibro(isbn, titulo, precio, autor, anopublicacion);

        try {
            FileWriter wr = new FileWriter(this.dataFile);
            wr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return l;
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

package controladores;

import models.Libro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileController extends MemoryController {
    protected final File dataDirectory;
    protected final File dataFile;

    public FileController() {
        this.dataDirectory = new File("data");
        this.dataFile = new File(dataDirectory, "libros.txt");

        if (!this.dataDirectory.exists()) {
            this.dataDirectory.mkdirs();
        }

        try {
            if (!this.dataFile.exists()) {
                this.dataFile.createNewFile();
                FileWriter wr = new FileWriter(this.dataFile);
                wr.write("ID;ISBN;TITULO;PRECIO;AUTOR;AÑOPUBLICACION\n");
                wr.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.cargarLibros();
    }

    public void cargarLibros () {
        if (this.dataFile.exists()) {
            try (Scanner reader = new Scanner(this.dataFile)){

                // 1. Saltar la primera línea (cabecera)
                if (reader.hasNextLine()) {
                    reader.nextLine();
                }

                while (reader.hasNextLine()) {
                    String linea = reader.nextLine();
                    if (linea.trim().isEmpty()) continue;

                    String[] datos = linea.split(";");

                    int id = Integer.parseInt(datos[0]);
                    String isbn = datos[1];
                    String titulo = datos[2];
                    float precio = Float.parseFloat(datos[3]);
                    String autor = datos[4];
                    int anopubli = Integer.parseInt(datos[5]);

                    Libro l = new Libro(id, isbn, titulo, precio, autor, anopubli);
                    super.anadirLibro(l.getIsbn(), l.getTitulo(), l.getPrecio(), l.getAutor(), l.getAnopublicacion());
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Libro anadirLibro(String isbn, String titulo, float precio, String autor, int anopublicacion) {
        Libro l = super.anadirLibro(isbn, titulo, precio, autor, anopublicacion);

        try {
            // parámetro 'true' activa el modo de escritura incremental
            FileWriter wr = new FileWriter(this.dataFile, true);
            wr.write(l.getId() + ";"
                    + l.getIsbn() + ";"
                    + l.getTitulo() + ";"
                    + l.getPrecio() + ";"
                    + l.getAutor() + ";"
                    + l.getAnopublicacion() + "\n");
            wr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return l;
    }

    @Override
    public void mostrarLibros() {
        super.mostrarLibros();
    }

    @Override
    public void buscarLibro(String isbn) {
        super.buscarLibro(isbn);
    }

    @Override
    public void eliminarLibro(String isbn) {
        super.eliminarLibro(isbn);
    }
}

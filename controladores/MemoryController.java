package controladores;

import models.Libro;

import java.util.HashMap;
import java.util.Map;

public class MemoryController implements Controlador {
    private int id = 0;
    private final Map<String, Libro>listaLibros = new HashMap<>();

    public void anadirLibroTest () {
        Libro l = new Libro(1, "151081805", "Libro1", 10.00F, "Novela", "Neifer", 1900);
        Libro l2 = new Libro(2, "215081805", "Libro2", 20.00F, "Ciencia ficcion", "Neifer", 1900);

        listaLibros.put(l.getIsbn(), l);
        listaLibros.put(l2.getIsbn(), l2);
    }

    public Libro anadirLibro (String isbn, String titulo, float precio, String genero, String autor, int anopublicacion) {
        id++;
        Libro l = new Libro(id, isbn, titulo, precio, genero, autor, anopublicacion);
        listaLibros.put(l.getIsbn(), l);
        return l;
    }

    public void mostrarLibros () {
        if (listaLibros.isEmpty()) {
            System.out.println("No hay ningún libro registrado en el catálogo.");
        }

        listaLibros.forEach((clave, valor) -> {
            System.out.println(valor);
        });
    }

    public void buscarLibro (String isbn) {
        if (listaLibros.containsKey(isbn)) {
            System.out.println(listaLibros.get(isbn));
        } else {
            System.out.println("No se encontró ningún libro con ISBN: " + isbn);
        }
    }

    public void eliminarLibro (String isbn) {
        if (listaLibros.containsKey(isbn)) {
            listaLibros.remove(isbn);
            System.out.println("El libro \"" + isbn + "\" ha sido eliminado satisfactoriamente.");
        } else {
            System.out.println("No se encontró ningún libro con ISBN: " + isbn);
        }
    }

    public int getId() {
        return id;
    }
    public Map<String, Libro> getListaLibros() {
        return listaLibros;
    }
}

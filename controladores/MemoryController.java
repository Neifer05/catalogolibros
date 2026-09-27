package controladores;

import models.Libro;

import java.util.HashMap;
import java.util.Map;

public class MemoryController {
    private int id = 0;
    private final Map<String, Libro>listaLibros = new HashMap<>();

    public void anadirLibroTest () {
        Libro l = new Libro(1, "151081805", "Libro1", 10.00F, "Neifer", 1900);
        Libro l2 = new Libro(2, "215081805", "Libro2", 20.00F, "Neifer", 1900);
        Libro l3 = new Libro(3, "521181805", "Libro3", 9.99F, "Neifer", 1900);

        listaLibros.put(l.getIsbn(), l);
        listaLibros.put(l2.getIsbn(), l2);
        listaLibros.put(l3.getIsbn(), l3);
    }

    public void anadirLibro (String isbn, String titulo, float precio, String autor, int anopublicacion) {
        id++;
        Libro l = new Libro(id, isbn, titulo, precio, autor, anopublicacion);
        listaLibros.put(l.getIsbn(), l);
    }

    public void mostrarLibros () {
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

    public int getId() {
        return id;
    }
}

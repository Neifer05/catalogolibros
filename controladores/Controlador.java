package controladores;

import models.Libro;

public interface Controlador {
    void anadirLibro (String isbn, String titulo, float precio, String autor, int anopublicacion);
    void mostrarLibros ();
    void buscarLibro (String isbn);
    void eliminarLibro (String isbn);
}

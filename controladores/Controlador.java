package controladores;

import models.Libro;

public interface Controlador {
    Libro anadirLibro (String isbn, String titulo, float precio, String genero, String autor, int anopublicacion);
    void mostrarLibros ();
    void buscarLibro (String isbn);
    void modificarLibro (String isbn);
    void eliminarLibro (String isbn);
}

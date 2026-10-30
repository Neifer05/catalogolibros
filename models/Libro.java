package models;

import excepciones.InvalidCampException;

public class Libro {
    private int id;
    private String isbn;
    private String titulo;
    private float precio;
    private String autor;
    private int anopublicacion;

    public Libro(int id, String isbn, String titulo, float precio, String autor, int anopublicacion) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.precio = precio;
        this.autor = autor;
        this.anopublicacion = anopublicacion;
    }

    @Override
    public String toString() {
        return "Libro {" +
                "  ID: " + id +
                "  ISBN: " + isbn +
                "  Título: " + titulo +
                "  Precio: " + precio +
                "  Autor: " + autor +
                "  Año de publicación: " + anopublicacion +
                " }";
    }

    public void setIsbn(String isbn) throws InvalidCampException {
        if (isbn.isEmpty() || isbn.equals(" ") || isbn.contains(";")) {
            throw new InvalidCampException("El campo no puede estar vacío o contener caracteres especiales.");
        } else if (isbn.length() > 13) {
            throw new InvalidCampException("La longitud del ISBN no puede sobrepasar los 13 caracteres.");
        }
        this.isbn = isbn;
    }
    public void setTitulo(String titulo) {
        if (titulo.isEmpty() || titulo.equals(" ") || titulo.contains(";")) {
            throw new InvalidCampException("El campo no puede estar vacío o contener caracteres especiales.");
        } else if (titulo.length() > 30) {
            throw new InvalidCampException("La longitud del título no puede sobrepasar los 13 caracteres.");
        }
        this.titulo = titulo;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public void setAutor(String autor) {
        if (autor.isEmpty() || autor.equals(" ") || autor.contains(";")) {
            throw new InvalidCampException("El campo no puede estar vacío o contener caracteres especiales.");
        } else if (autor.length() > 50) {
            throw new InvalidCampException("La longitud del título no puede sobrepasar los 13 caracteres.");
        }

        this.autor = autor;
    }
    public void setAnopublicacion(int anopublicacion) {
        if (anopublicacion < 1900) {
            throw new InvalidCampException("El año de publicación no puede ser menor a 1900.");
        }
        this.anopublicacion = anopublicacion;
    }

    public int getId() {
        return id;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public float getPrecio() {
        return precio;
    }
    public int getAnopublicacion() {
        return anopublicacion;
    }
}

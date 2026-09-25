package models;

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

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setAnopublicacion(int anopublicacion) {
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

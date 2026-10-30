package controladores;

import excepciones.InvalidCampException;
import models.Libro;

import java.util.Scanner;

public class FormController {
    public void formularioAnadirLibro (FileController c, Scanner sc) throws InvalidCampException {
        Libro prototipo = new Libro(0, "ABCDEFG123", "Proto", 0.00f, "ProtoAutor", 1900);

        boolean intento = false;
        while (!intento) {
            try {
                System.out.println(" > ISBN del libro: ");
                String isbn = sc.nextLine();
                prototipo.setIsbn(isbn);
                intento = true;
            } catch (InvalidCampException e) {
                System.out.println(e.getMessage());
            }
        }

        intento = false;
        while (!intento) {
            try {
                System.out.println(" > Título del libro: ");
                String tituloLibro = sc.nextLine();
                prototipo.setTitulo(tituloLibro);
                intento = true;
            } catch (InvalidCampException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(" > Precio del libro: ");
        float precioLibro = Float.parseFloat(sc.nextLine());


        intento = false;
        while (!intento) {
            try {
                System.out.println(" > Autor del libro: ");
                String nombreAutor = sc.nextLine();
                prototipo.setAutor(nombreAutor);
                intento = true;
            } catch (InvalidCampException e) {
                System.out.println(e.getMessage());
            }
        }

        intento = false;
        while (!intento) {
            try {
                System.out.println(" > Año de publicación: ");
                int anoPublicacion = Integer.parseInt(sc.nextLine());
                prototipo.setAnopublicacion(anoPublicacion);
                intento = true;
            } catch (InvalidCampException e) {
                System.out.println(e.getMessage());
            }
        }

        c.anadirLibro(prototipo.getIsbn(), prototipo.getTitulo(), precioLibro, prototipo.getAutor(), prototipo.getAnopublicacion());
    }
}

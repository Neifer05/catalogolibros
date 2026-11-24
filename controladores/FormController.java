package controladores;

import excepciones.InvalidCampException;
import models.Libro;

import java.util.Scanner;

public class FormController {
    private Scanner sc;

    public FormController() {
        this.sc = new Scanner(System.in);
    }

    public void formularioAnadirLibro (FileController c, Scanner sc) throws InvalidCampException {
        Libro prototipo = new Libro(0, "ABCDEFG123", "Proto", 0.00f, "ProtoGene", "ProtoAutor", 1900);

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

        intento = false;
        while (!intento) {
            try {
                System.out.println(" > Precio del libro: ");
                float precioLibro = Float.parseFloat(sc.nextLine());
                prototipo.setPrecio(precioLibro);
                intento = true;
            } catch (NumberFormatException e) {
                System.out.println("Solo se aceptan caracteres de valor numérico.");
            }
        }

        intento = false;
        while (!intento) {
            try {
                System.out.println(" > Género del libro: ");
                String generoLibro = sc.nextLine();
                prototipo.setGenero(generoLibro);
                intento = true;
            } catch (InvalidCampException e) {
                System.out.println(e.getMessage());
            }
        }

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

        c.anadirLibro(prototipo.getIsbn(), prototipo.getTitulo(), prototipo.getPrecio(), prototipo.getGenero(), prototipo.getAutor(), prototipo.getAnopublicacion());
    }
    public int opcionElegir () {
        return sc.nextInt();
    }
}

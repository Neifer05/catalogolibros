package controladores;

import excepciones.InvalidCampException;
import models.Libro;

import java.util.Scanner;

public class FormController {
    public void formularioAnadirLibro (FileController c) throws InvalidCampException {
        Libro prototipo = new Libro(0, "ABCDEFG123", "Proto", 0.00f, "ProtoAutor", 1900);

        try (Scanner sc = new Scanner(System.in)) {
            int intentos = 0;
            while (intentos == 0) {
                try {
                    System.out.println(" > ISBN del libro: ");
                    String isbn = sc.nextLine();
                    prototipo.setIsbn(isbn);
                    intentos += 1;
                } catch (InvalidCampException e) {
                    System.out.println(e.getMessage());
                }
            }

            intentos = 0;
            while (intentos == 0) {
                try {
                    System.out.println(" > Título del libro: ");
                    String tituloLibro = sc.nextLine();
                    prototipo.setTitulo(tituloLibro);
                    intentos += 1;
                } catch (InvalidCampException e) {
                    System.out.println(e.getMessage());
                }
            }


            System.out.println(" > Precio del libro: ");
            float precioLibro = Float.parseFloat(sc.nextLine());


            intentos = 0;
            while (intentos == 0) {
                try {
                    System.out.println(" > Autor del libro: ");
                    String nombreAutor = sc.nextLine();
                    prototipo.setAutor(nombreAutor);
                    intentos += 1;
                } catch (InvalidCampException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println(" > Año de publicación: ");
            int anoPublicacion = Integer.parseInt(sc.nextLine());

            c.anadirLibro(prototipo.getIsbn(), prototipo.getTitulo(), precioLibro, prototipo.getAutor(), anoPublicacion);
        }


    }
}

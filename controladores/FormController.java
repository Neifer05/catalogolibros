package controladores;

import java.util.Scanner;

public class FormController {
    public void formularioAnadirLibro (MemoryController c, Scanner sc) {
        System.out.println("ISBN del libro: ");
        String isbn = sc.nextLine();

        System.out.println("Título del libro: ");
        String tituloLibro = sc.nextLine();

        System.out.println("Precio del libro: ");
        float precioLibro = Float.parseFloat(sc.nextLine());

        System.out.println("Autor del libro: ");
        String nombreAutor = sc.nextLine();

        System.out.println("Año de publicación: ");
        int anoPublicacion = Integer.parseInt(sc.nextLine());

        c.anadirLibro(isbn, tituloLibro, precioLibro, nombreAutor, anoPublicacion);
    }
}

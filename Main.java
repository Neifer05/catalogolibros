import controladores.FileController;
import controladores.FormController;
import controladores.MemoryController;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MemoryController c = new MemoryController();
        FormController fc = new FormController();
        FileController flc = new FileController("data");
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);

       while (true) {
            System.out.println(" == Catálogo de libros == ");
            String[] menuopciones = {
                    "Añadir un nuevo libro.",
                    "Ver lista de todos los libros.",
                    "Buscar un libro por ISBN.",
                    "Eliminar un libro.",
                    "Guardar y salir."};
            for (int i = 0; i < menuopciones.length; i++) {
                System.out.println(i + 1 + ". " + menuopciones[i]);
            }
            System.out.print(" > Seleccione una opción: ");
            int opcion = Integer.parseInt(sc.nextLine());

            if (opcion >= menuopciones.length || opcion < 1) { System.out.print("Saliendo del catálogo.."); break; }

            switch (opcion) {
                case 1:
                    fc.formularioAnadirLibro(c, sc);
                    break;
                case 2:
                    c.mostrarLibros();
                    break;
                case 3:
                    System.out.println(" > Inserte un ISBN para buscar: ");
                    String isbnLibroBuscar = sc.nextLine();
                    c.buscarLibro(isbnLibroBuscar);
                    break;
                case 4:
                    System.out.println(" > Inserte un ISBN para eliminar: ");
                    String isbnLibroEliminar = sc.nextLine();
                    c.eliminarLibro(isbnLibroEliminar);
                    break;
            }
        }
    }
}
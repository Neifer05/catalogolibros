import controladores.FormController;
import controladores.MemoryController;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MemoryController c = new MemoryController();
        FormController fc = new FormController();
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);

       while (true) {
            System.out.println(" == Catálogo de libros == ");
            String[] menuopciones = {
                    "Añadir un nuevo libro.",
                    "(Test) Añadir 3 libros",
                    "Ver lista de todos los libros.",
                    "Buscar un libro por ISBN.",
                    "Guardar y salir."};
            for (int i = 0; i < menuopciones.length; i++) {
                System.out.println(i + 1 + ". " + menuopciones[i]);
            }
            System.out.print(" > Seleccione una opción: ");
            int opcion = Integer.parseInt(sc.nextLine());

            if (opcion >= menuopciones.length) { System.out.print("Saliendo del catálogo.."); break; }

            switch (opcion) {
                case 1:
                    fc.formularioAnadirLibro(c, sc);
                    break;
                case 2:
                    System.out.println("Añadiste tres libros automáticamente..");
                    c.anadirLibroTest();
                    break;
                case 3:
                    c.mostrarLibros();
                    break;
                case 4:
                    c.buscarLibro("1f51081805");
                    break;
            }
        }
    }
}
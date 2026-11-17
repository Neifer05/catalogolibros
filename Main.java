import controladores.FileController;
import controladores.FormController;
import excepciones.InvalidCampException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidCampException {
        FileController c = new FileController("./data");
        FormController fc = new FormController();

        try (Scanner sc = new Scanner(System.in)){
            sc.useLocale(Locale.ENGLISH);
            while (true) {
                fc.mostrarMenu();
                int opcion = Integer.parseInt(sc.nextLine());
                if (opcion >= 5 || opcion < 1) { System.out.print("Saliendo del catálogo.."); break; }

                switch (opcion) {
                    case 1:
                        fc.formularioAnadirLibro(c, sc);
                        break;
                    case 2:
                        c.mostrarLibros();
                        break;
                    case 3:
                        System.out.print(" > Inserte un ISBN para buscar: ");
                        String isbnLibroBuscar = sc.nextLine();
                        c.buscarLibro(isbnLibroBuscar);
                        break;
                    case 4:
                        System.out.print(" > Inserte un ISBN para eliminar: ");
                        String isbnLibroEliminar = sc.nextLine();
                        c.eliminarLibro(isbnLibroEliminar);
                        break;
                }
            }
        }
    }
}
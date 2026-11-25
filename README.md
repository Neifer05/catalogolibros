# Catálogo de Libros

Aplicación de consola en Java para gestionar un catálogo de libros. Permite añadir, listar, buscar, modificar y eliminar libros, y guarda los datos en un archivo de texto para que se conserven entre ejecuciones.

Proyecto de clase desarrollado en Java puro, sin dependencias externas.

## Características

- Menú interactivo por consola.
- Operaciones CRUD sobre libros: añadir, ver, buscar por ISBN, modificar y eliminar.
- Validación de campos con excepción propia (`InvalidCampException`).
- Persistencia en disco en `data/libros.txt` (formato separado por `;`).
- Arquitectura basada en controladores intercambiables (memoria o archivo).
- Integración continua con GitHub Actions (compilación y prueba automática).

## Estructura del proyecto

```
catalogolibros/
├── Main.java                      # Punto de entrada y menú principal
├── controladores/
│   ├── Controlador.java           # Interfaz con las operaciones del catálogo
│   ├── MemoryController.java      # Implementación en memoria (HashMap)
│   ├── FileController.java        # Persistencia en archivo (extiende MemoryController)
│   └── FormController.java        # Formularios y lectura de datos por consola
├── models/
│   └── Libro.java                 # Modelo con validaciones de campos
├── excepciones/
│   └── InvalidCampException.java  # Excepción de validación
├── data/
│   └── libros.txt                 # Datos persistidos
└── .github/workflows/ci.yml       # CI: compilación y prueba
```

## Requisitos

- JDK 21 o superior.

## Cómo ejecutar

Clona el repositorio y compila:

```bash
git clone https://github.com/Neifer05/catalogolibros.git
cd catalogolibros

mkdir -p out/main
javac -encoding UTF-8 -d out/main Main.java controladores/*.java excepciones/*.java models/*.java
```

Ejecuta la aplicación:

```bash
java -cp out/main Main
```

Los libros se guardan en `data/libros.txt`, que se crea automáticamente si no existe.

## Uso

Al iniciar se muestra el siguiente menú:

```
 == Catálogo de libros ==
1. Añadir un nuevo libro.
2. Ver lista de todos los libros.
3. Buscar un libro por ISBN.
4. Modificar un libro existente
5. Eliminar un libro.
6. Guardar y salir.
```

Cada libro contiene los campos: **ID**, **ISBN**, **Título**, **Precio**, **Género**, **Autor** y **Año de publicación**.

## Formato de datos

El archivo `data/libros.txt` usa una línea de cabecera y registros separados por `;`:

```
ID;ISBN;TITULO;PRECIO;GENERO;AUTOR;AÑOPUBLICACION
1;PPEE1231;Pepe;10.0;Novela;Neifer;2015
```

## Integración continua

El workflow `.github/workflows/ci.yml` se ejecuta en cada push o pull request a `main`. Compila el proyecto con JDK 21 y realiza una prueba automática que:

1. Añade un libro desde la entrada estándar.
2. Lista los libros y verifica la persistencia.
3. Comprueba la salida del programa.

## Autor

- [Neifer05]

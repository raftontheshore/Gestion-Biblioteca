# 📚 Sistema de Gestión de Biblioteca

Un sistema de escritorio desarrollado en Java Swing para la administración de socios, libros y préstamos de una biblioteca.

![Screenshot](Screenshot.jpg)

---

## 🚀 Características Principales

Este proyecto es una aplicación GUI que permite gestionar las operaciones básicas de una biblioteca:

* **Gestión de Socios:**
    * Añadir nuevos socios (diferenciando entre Docentes y Alumnos).
    * Eliminar socios existentes por DNI.
    * Listar todos los socios registrados.
    * Generar un reporte de "Docentes Responsables"

* **Gestión de Libros:**
    * Agregar nuevos libros al catálogo (con título, editorial, edición y año).
    * Quitar libros del catálogo (con validación para no eliminar libros que están actualmente prestados).
    * Listar todos los libros del catálogo.
    * Buscar un libro por título para verificar su disponibilidad e informar quién lo tiene en caso de estar prestado.

* **Gestión de Préstamos:**
    * Registrar nuevos préstamos, asociando un libro a un socio con una fecha de retiro.
    * Registrar devoluciones de libros.

---

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java
* **Interfaz Gráfica (GUI):** Java Swing
* **Gestión de Datos:** En memoria (utilizando `ArrayLists` y clases de modelo).

---

## 👨‍💻 Autores
* **[Aguirre Mauricio Alejandro](https://github.com/Diosito00)**
* **Escubilla Micaela Belén**
* **[Iturrieta Waldemar](https://github.com/raftontheshore)**
* **Gomez Perkovich Francisco Jose**
* **Gomez Ingrid Micaela Itati**
* **[Sanchez Rodriguez Enzo Nahuel](https://github.com/enzo2304)**

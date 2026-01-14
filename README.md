# Hospital-JPA
# 🏥 Hospital-JPA

Sistema de gestión de datos hospitalarios desarrollado en **Java**, enfocado en la implementación de la capa de persistencia utilizando **Jakarta Persistence API (JPA)** y **Hibernate**.

Este proyecto demuestra la arquitectura backend para administrar entidades y relaciones típicas de un entorno médico (como pacientes, doctores, turnos o historiales clínicos) mediante un Mapeo Objeto-Relacional (ORM) eficiente.

## 🚀 Tecnologías Utilizadas

El stack tecnológico está basado en estándares modernos de la industria:

* **Lenguaje:** Java 17 (LTS)
* **Persistencia (ORM):** Jakarta Persistence API 3.1 + Hibernate Core 6.3.0
* **Base de Datos:** H2 Database (Base de datos en memoria para desarrollo y testing rápido)
* **Utilitarios:**
    * Project Lombok (Reducción de código boilerplate como getters/setters)
    * Apache Commons Lang 3 (Validación de Strings y utilidades)
* **Testing:** JUnit 5 (Jupiter)
* **Gestor de Dependencias:** Gradle

## ⚙️ Características del Proyecto

* **Arquitectura JPA:** Implementación sólida de `EntityManager` y `PersistenceContext`.
* **Validaciones:** Uso de librerías externas para asegurar la integridad de los datos ingresados.
* **Entorno de Pruebas:** Configurado con H2 para ejecutar el proyecto sin necesidad de instalar servidores de bases de datos externos (MySQL/PostgreSQL) durante la fase de desarrollo.

## 🛠️ Instalación y Ejecución

1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/Matias3096/Hospital-JPA.git](https://github.com/Matias3096/Hospital-JPA.git)
    cd Hospital-JPA
    ```

2.  **Compilar el proyecto:**
    ```bash
    ./gradlew build
    ```

3.  **Ejecutar la aplicación:**
    ```bash
    ./gradlew run
    ```

## 📋 Requisitos Previos

* Tener instalado **Java JDK 17** o superior.
* Conexión a internet para descargar las dependencias de Gradle.

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.

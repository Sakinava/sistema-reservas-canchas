# 🎾 PadelApp

Sistema de Reservas de Canchas de Pádel

## &#x20;Descripción General

**PadelApp** es una aplicación web desarrollada en **Java** con el framework **Spring Boot**, orientada a la gestión integral de reservas de canchas de pádel. El sistema permite a los usuarios consultar la disponibilidad de canchas, realizar reservas, visualizar su historial personal de reservas y, a través de un panel administrativo, gestionar las canchas y el estado de las reservas registradas en el sistema.

El proyecto ha sido desarrollado como parte de un trabajo académico universitario, aplicando una arquitectura en capas (Controller – Service – Repository – Entity) sobre el patrón MVC, con persistencia de datos en una base de datos relacional MySQL.

## &#x20;Tecnologías Utilizadas

|Tecnología|Uso|
|-|-|
|**Java**|Lenguaje de programación principal|
|**Spring Boot**|Framework para el desarrollo del backend|
|**Thymeleaf**|Motor de plantillas para la capa de vistas|
|**Bootstrap 5**|Framework CSS para el diseño de la interfaz|
|**MySQL**|Sistema gestor de base de datos relacional|
|**JPA / Hibernate**|Mapeo objeto-relacional (ORM) y persistencia de datos|
|**Maven**|Gestión de dependencias y construcción del proyecto|

## 📁 Estructura del Proyecto

```
PadelApp/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/padelapp/
│   │   │       ├── controller/      # Controladores (manejo de rutas y peticiones)
│   │   │       ├── service/         # Lógica de negocio
│   │   │       ├── repository/      # Interfaces de acceso a datos (JPA Repositories)
│   │   │       ├── model/           # Entidades JPA
│   │   │       └── PadelAppApplication.java
│   │   │
│   │   └── resources/
│   │       ├── templates/           # Vistas Thymeleaf (.html)
│   │       │   ├── login.html
│   │       │   ├── menu.html
│   │       │   ├── canchasDisponibles.html
│   │       │   ├── reserva.html
│   │       │   ├── confirmacionReserva.html
│   │       │   ├── misReservas.html
│   │       │   └── panelAdministrativo.html
│   │       │
│   │       ├── static/              # Recursos estáticos (CSS, JS, imágenes)
│   │       └── application.properties
│   │
│   └── test/                        # Pruebas unitarias
│
├── pom.xml                          # Configuración de dependencias Maven
└── README.md
```

## &#x20;Funcionalidades Implementadas

* **Inicio de sesión:** acceso al sistema mediante usuario y contraseña.
* **Menú principal:** panel de navegación central hacia los distintos módulos del sistema.
* **Consulta de canchas disponibles:** listado de canchas con su estado (disponible / ocupada).
* **Reserva de canchas:** formulario para registrar una nueva reserva (fecha, hora y número de jugadores).
* **Confirmación de reserva:** resumen de la reserva realizada con su número, cancha, fecha, hora y estado.
* **Consulta de reservas personales:** historial de reservas del usuario (confirmadas, próximas, completadas y canceladas).
* **Panel administrativo:** gestión de canchas y administración del listado general de reservas del sistema.
* **Navegación entre pantallas:** flujo completo e integrado entre todas las vistas de la aplicación.
* **Persistencia con MySQL:** almacenamiento permanente de la información en base de datos relacional.
* **Repositories:** interfaces de acceso a datos basadas en Spring Data JPA.
* **Services:** capa de lógica de negocio que centraliza las operaciones del sistema.
* **Controllers:** manejo de las peticiones HTTP y enrutamiento de las vistas.
* **Entidades JPA:** modelado de las tablas del sistema mediante clases anotadas con JPA/Hibernate.

## &#x20;Requisitos de Instalación

Para ejecutar el proyecto correctamente, es necesario contar con:

* **Java 21** o superior
* **Maven** (gestor de dependencias)
* **MySQL** (servidor de base de datos)
* Un IDE compatible con proyectos Spring Boot (recomendado: IntelliJ IDEA, Eclipse o Visual Studio Code)

## &#x20;Configuración de la Base de Datos

1. Iniciar el servicio de MySQL en el equipo.
2. Crear la base de datos del proyecto ejecutando la siguiente sentencia SQL:

```sql
CREATE DATABASE padelapp;
```

3. Configurar las credenciales de conexión en el archivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/padelapp
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

> Ajustar `username` y `password` según la configuración local de MySQL.

## &#x20;Pasos para Ejecutar el Proyecto

1. Clonar o descargar el repositorio del proyecto.
2. Verificar que MySQL esté activo y que la base de datos `padelapp` haya sido creada.
3. Configurar las credenciales de conexión en `application.properties`.
4. Abrir el proyecto en el IDE de preferencia.
5. Ejecutar el proyecto mediante Maven:

```bash
mvn spring-boot:run
```

O bien, ejecutar directamente la clase principal `PadelAppApplication.java`.

6. Acceder a la aplicación desde el navegador en:

```
http://localhost:8080/login
```

## &#x20;Estado Actual del Proyecto

Este repositorio corresponde al **Avance 2** del proyecto académico **PadelApp**.

En esta etapa se implementó la integración completa entre el frontend (Thymeleaf + Bootstrap 5) y el backend (Spring Boot), incluyendo la capa de persistencia con **MySQL, JPA y Hibernate**, así como la totalidad de los controladores, servicios y repositorios necesarios para el funcionamiento del flujo principal del sistema: inicio de sesión, gestión de canchas, reservas, confirmación de reservas, historial personal y panel administrativo.

## 👥 Integrantes

* Stephanie Lucía Hernandez Morales
* &#x20;Isaac Navarro Mora
* Ashley Rojas Araya

\---

*Proyecto académico desarrollado como parte de la asignatura de Desarrollo de Software.*


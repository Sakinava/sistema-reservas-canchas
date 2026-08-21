# 🎾 PadelApp

Sistema de Reservas de Canchas de Pádel

## Descripción general

**PadelApp** es una aplicación web desarrollada en **Java** con el framework **Spring Boot**, orientada a la gestión integral de reservas de canchas de pádel. El sistema permite a los usuarios consultar la disponibilidad de canchas, realizar reservas, visualizar su historial personal y, mediante un panel administrativo, gestionar las canchas y el estado de las reservas registradas.

El proyecto se desarrolla como trabajo académico de la asignatura *Desarrollo de Software* (Universidad Fidélitas, Costa Rica), aplicando una arquitectura en capas (**Controller – Service – Repository – Model**) sobre el patrón **MVC**, con persistencia de datos en una base de datos relacional **MySQL** mediante **JPA/Hibernate**.

## Tecnologías utilizadas

Versiones tomadas directamente de `pom.xml`.

| Tecnología | Versión / Detalle | Uso |
|---|---|---|
| **Java** | 21 | Lenguaje de programación principal |
| **Spring Boot** | 3.5.4 (`spring-boot-starter-parent`) | Framework base del backend |
| **Spring Web** | `spring-boot-starter-web` | Controladores y capa MVC |
| **Thymeleaf** | `spring-boot-starter-thymeleaf` | Motor de plantillas de la capa de vistas |
| **Spring Data JPA** | `spring-boot-starter-data-jpa` | Persistencia y mapeo objeto-relacional |
| **Hibernate** | (incluido vía Spring Data JPA) | Proveedor de JPA |
| **Bean Validation** | `spring-boot-starter-validation` | Validaciones (`@NotBlank`, `@NotNull`, `@Email`, etc.) |
| **Lombok** | `optional` | Generación de getters/setters y boilerplate |
| **MySQL Connector/J** | `com.mysql:mysql-connector-j` (runtime) | Driver de conexión a MySQL |
| **Spring Boot DevTools** | runtime, opcional | Recarga en caliente durante el desarrollo |
| **Bootstrap** | 5.3.3 (vía CDN) | Framework CSS para el diseño de la interfaz |
| **Maven** | — | Gestión de dependencias y construcción del proyecto |
| **JUnit / Spring Boot Test** | `spring-boot-starter-test` | Pruebas |

## Funcionalidades implementadas

- **Inicio de sesión:** acceso al sistema mediante usuario y contraseña (prototipo: cualquier combinación es válida).
- **Menú principal:** panel de navegación central hacia los distintos módulos del sistema, con contenido adaptado al rol de la sesión (`ADMIN` / cliente).
- **Consulta de canchas disponibles:** listado de canchas con su estado (disponible / ocupada).
- **Reserva de canchas:** formulario para registrar una nueva reserva (fecha, hora y número de jugadores).
- **Confirmación de reserva:** resumen de la reserva realizada con su número, cancha, fecha, hora y estado.
- **Consulta de reservas personales:** historial de reservas del usuario (confirmadas, próximas, completadas y canceladas).
- **Panel administrativo:** gestión de canchas y administración del listado general de reservas del sistema.
- **Internacionalización (i18n):** todas las vistas soportan español (idioma por defecto) e inglés, con cambio de idioma en tiempo real desde la interfaz.
- **Persistencia con MySQL:** almacenamiento de la información en base de datos relacional mediante JPA/Hibernate.
- **Arquitectura en capas:** `controller` → `service` → `repository` → `model`, siguiendo el patrón MVC.

## Internacionalización (ES / EN)

El proyecto usa el mecanismo estándar de i18n de Spring:

- `SessionLocaleResolver` con idioma por defecto `es` (`ConfiguracionIdioma.java`, paquete `config`).
- `LocaleChangeInterceptor` con el parámetro `lang` (por ejemplo `/menu?lang=en`).
- Archivos de mensajes en `src/main/resources`:
  - `messages.properties` — español (por defecto).
  - `messages_en.properties` — inglés.
- Todas las vistas Thymeleaf (`login`, `menu`, `canchasDisponibles`, `reserva`, `confirmacionReserva`, `misReservas`, `panelAdministrativo`) resuelven sus textos fijos con `th:text="#{clave}"` y exponen un selector **ES | EN** en la esquina superior derecha.

## Estructura del proyecto

Estructura real de paquetes (`com.mycompany.avance1`):

```
Avance1/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/mycompany/avance1/
│   │   │       ├── config/           # Configuración de Spring (i18n, MVC, etc.)
│   │   │       ├── controller/       # Controladores (manejo de rutas y peticiones)
│   │   │       ├── service/          # Lógica de negocio
│   │   │       ├── repository/       # Interfaces de acceso a datos (Spring Data JPA)
│   │   │       ├── model/            # Entidades JPA
│   │   │       └── Avance1.java      # Clase principal (@SpringBootApplication)
│   │   │
│   │   └── resources/
│   │       ├── templates/            # Vistas Thymeleaf (.html)
│   │       │   ├── login.html
│   │       │   ├── menu.html
│   │       │   ├── canchasDisponibles.html
│   │       │   ├── reserva.html
│   │       │   ├── confirmacionReserva.html
│   │       │   ├── misReservas.html
│   │       │   └── panelAdministrativo.html
│   │       │
│   │       ├── static/               # Recursos estáticos (CSS, JS, imágenes)
│   │       ├── application.properties
│   │       ├── messages.properties    # Mensajes i18n (ES)
│   │       └── messages_en.properties # Mensajes i18n (EN)
│   │
│   └── test/                         # Pruebas unitarias
│
├── mvnw / mvnw.cmd                   # Maven Wrapper
├── pom.xml                           # Configuración de dependencias Maven
├── README.md
└── MANUAL_INSTALACION.md
```

## Requisitos e instalación

Los pasos detallados de instalación, configuración de base de datos y ejecución del proyecto se encuentran en **[MANUAL_INSTALACION.md](./MANUAL_INSTALACION.md)**.

## Estado actual del proyecto

Este repositorio corresponde a un avance del proyecto académico **PadelApp**. Se implementó la integración completa entre el frontend (Thymeleaf + Bootstrap 5) y el backend (Spring Boot), incluyendo la capa de persistencia con **MySQL, JPA y Hibernate**, los controladores, servicios y repositorios del flujo principal (inicio de sesión, gestión de canchas, reservas, confirmación de reservas, historial personal y panel administrativo), y la internacionalización completa de todas las vistas.

## 👥 Integrantes

- Ashley Rojas Araya
- Isaac Navarro Mora
- Stephanie Lucía Hernández Morales

---

*Proyecto académico desarrollado como parte de la asignatura de Desarrollo de Software — Universidad Fidélitas, Costa Rica.*

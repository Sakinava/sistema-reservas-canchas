# Manual de Instalación — PadelApp

Este manual describe cómo instalar, configurar y ejecutar **PadelApp** en un entorno local de desarrollo.

## 1. Requisitos previos

Antes de comenzar, asegurate de tener instalado:

| Requisito | Versión mínima | Notas |
|---|---|---|
| **Java (JDK)** | 21 | Definido en `pom.xml` (`java.version=21`) |
| **MySQL Server** | 8.x | Base de datos relacional del proyecto |
| **Maven** | — | No es obligatorio instalarlo aparte: el proyecto incluye el Maven Wrapper (`mvnw` / `mvnw.cmd`) |
| **IDE (opcional)** | — | Recomendado: IntelliJ IDEA, Eclipse o Visual Studio Code, con soporte para proyectos Spring Boot |
| **Git (opcional)** | — | Para clonar el repositorio |

> El proyecto usa Spring Boot 3.5.4, por lo que **Java 21 es obligatorio** (no funciona con versiones anteriores como Java 17 u 11).

## 2. Obtener el proyecto

Cloná el repositorio o descargá el código fuente:

```bash
git clone https://github.com/Sakinava/sistema-reservas-cancha.git
cd sistema-reservas-cancha
```

Si descargaste un `.zip`, simplemente descomprimilo y ubicate en la carpeta raíz del proyecto (la que contiene `pom.xml`, `mvnw` y `src`).

## 3. Configurar la base de datos MySQL

### 3.1 Iniciar el servicio de MySQL

Asegurate de que el servicio de MySQL esté activo en tu equipo.

### 3.2 Crear la base de datos

Conectate a MySQL y ejecutá:

```sql
CREATE DATABASE padelapp;
```

### 3.3 Configurar las credenciales de conexión

Editá el archivo `src/main/resources/application.properties` con los datos de tu instalación local de MySQL:

```properties
spring.application.name=PadelApp

spring.datasource.url=jdbc:mysql://localhost:3306/padelapp
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.messages.basename=messages
spring.messages.encoding=UTF-8
```

- `spring.jpa.hibernate.ddl-auto=update` hace que Hibernate cree o actualice automáticamente las tablas necesarias al iniciar la aplicación — **no es necesario crear las tablas manualmente**.
- `spring.jpa.show-sql=true` imprime en consola las sentencias SQL generadas, útil para depuración.
- `spring.messages.basename=messages` y `spring.messages.encoding=UTF-8` habilitan la internacionalización (español/inglés) a partir de `messages.properties` y `messages_en.properties`.

> ⚠️ **No subas credenciales reales a un repositorio público.** Si vas a versionar tus cambios, considerá usar variables de entorno o un archivo `application-local.properties` ignorado por Git para tus credenciales de MySQL.

## 4. Ejecutar el proyecto

### Opción A — Usando el Maven Wrapper (recomendado, no requiere instalar Maven)

En Linux/macOS:

```bash
./mvnw spring-boot:run
```

En Windows:

```bat
mvnw.cmd spring-boot:run
```

### Opción B — Usando Maven instalado localmente

```bash
mvn spring-boot:run
```

### Opción C — Desde el IDE

Abrí el proyecto en tu IDE y ejecutá directamente la clase principal:

```
com.mycompany.avance1.Avance1
```

## 5. Acceder a la aplicación

Una vez iniciado el servidor (por defecto en el puerto `8080`), accedé desde el navegador a:

```
http://localhost:8080/login
```

En la pantalla de inicio de sesión, este es un **prototipo académico**: cualquier combinación de usuario y contraseña permite ingresar.

## 6. Cambio de idioma (ES / EN)

Todas las vistas incluyen un selector de idioma en la esquina superior derecha (**ES | EN**). El cambio se realiza mediante el parámetro de consulta `lang`, por ejemplo:

```
http://localhost:8080/menu?lang=en
http://localhost:8080/menu?lang=es
```

El idioma seleccionado se guarda en la sesión (`SessionLocaleResolver`), por lo que se mantiene mientras se navega entre pantallas. El idioma por defecto es **español**.

## 7. Solución de problemas comunes

| Problema | Posible causa / solución |
|---|---|
| `Communications link failure` o `Connection refused` al iniciar | MySQL no está corriendo, o la URL/puerto en `spring.datasource.url` no coincide con tu instalación. |
| `Access denied for user` | Usuario o contraseña incorrectos en `application.properties`. |
| `Unknown database 'padelapp'` | No se creó la base de datos (ver paso 3.2). |
| `Port 8080 already in use` | Otro proceso está usando el puerto 8080. Cerralo o cambiá el puerto agregando `server.port=8081` en `application.properties`. |
| Error de compilación relacionado con Java version | Verificá que el JDK activo (`java -version`) sea la versión 21. |
| Los textos no cambian de idioma | Verificá que la URL incluya `?lang=en` o `?lang=es`, y que `messages.properties` / `messages_en.properties` estén en `src/main/resources`. |

## 8. Detener la aplicación

Si la ejecutaste desde la terminal, simplemente presioná `Ctrl + C` en la ventana donde corre el proceso.

---

*Para información general del proyecto, funcionalidades y estructura, consultá el [README.md](./README.md).*

# CRUD de Empleados — Spring Boot MVC (POO2)

Aplicación web simple para gestionar empleados usando Spring Boot MVC, Thymeleaf, JPA/Hibernate y base de datos en memoria H2. Proyecto pensado para la evidencia de la Unidad 3 (POO2).

Simple web app to manage employees with Spring Boot MVC, Thymeleaf, JPA/Hibernate and in-memory H2 database. Built for the POO2 Unit 3 assignment.

---

## 🚀 Características / Features

- Listar, crear, editar y eliminar empleados (CRUD)
- Vistas con Thymeleaf
- Persistencia con Spring Data JPA (Hibernate)
- Base de datos H2 en memoria con `schema.sql` y `data.sql`
- Servidor embebido (Tomcat) vía Spring Boot

---

## 🧰 Tecnologías / Tech Stack

- Java 17 (ajusta en `pom.xml` si usas 8/11)
- Spring Boot 3.x (web, thymeleaf, data-jpa)
- H2 Database
- Maven

---

## 📂 Estructura / Project Structure

```
src/
 ├─ main/
 │   ├─ java/com/example/demo/
 │   │   ├─ DemoApplication.java
 │   │   ├─ controller/
 │   │   │   ├─ EmployeeMvcController.java
 │   │   │   └─ RootController.java
 │   │   ├─ model/EmployeeEntity.java
 │   │   ├─ repository/EmployeeRepository.java
 │   │   └─ service/EmployeeService.java
 │   └─ resources/
 │       ├─ application.properties
 │       ├─ templates/
 │       │   ├─ list-employees.html
 │       │   └─ add-edit-employee.html
 │       ├─ schema.sql
 │       └─ data.sql
 └─ test/...
```

---

## ⚙️ Configuración rápida / Quick Setup

1. Requisitos / Requirements:
   - JDK 17 (o ajusta `java.version` en `pom.xml`)
   - Maven 3.8+
2. Construir / Build:
   ```bash
   mvn clean install
   ```
3. Ejecutar / Run:
   ```bash
   mvn spring-boot:run
   ```
4. Abrir / Open:
   - App: `http://localhost:8080` (redirige a `/employees`)
   - H2 Console (opcional): `http://localhost:8080/h2-console`
     - JDBC URL: `jdbc:h2:mem:demo_db`
     - User: `sa` Password: (vacío)

---

## 🌐 Endpoints (MVC)

- `GET /employees` — Lista de empleados
- `GET /employees/new` — Formulario crear
- `POST /employees` — Crear/Actualizar
- `GET /employees/{id}/edit` — Formulario editar
- `POST /employees/{id}/delete` — Borrar

---

## 🗃️ Datos de ejemplo / Seed Data

- Creados mediante `schema.sql` y `data.sql` al iniciar la app.
- Puedes editar `src/main/resources/data.sql` para cambiar los registros iniciales.

---

## ✅ Checklist de la guía

- `pom.xml` con starters Web, Thymeleaf, Data JPA y H2
- `application.properties` para H2/JPA/Thymeleaf
- `schema.sql` y `data.sql` en `resources/`
- `EmployeeEntity` con anotaciones JPA
- `EmployeeRepository` (CrudRepository)
- `EmployeeService` con `createOrUpdate` y CRUD
- `EmployeeMvcController` con rutas listar/crear/editar/borrar
- Vistas Thymeleaf `list-employees.html` y `add-edit-employee.html`
- Corre en `http://localhost:8080`

---

## 🧪 Consejos / Tips

- Si cambias el paquete base, actualiza la anotación `@SpringBootApplication` para el escaneo.
- Para ver SQL en consola: ya está `spring.jpa.show-sql=true`.
- Si usas Java 8/11, ajusta `java.version` y la versión de Spring Boot acorde.

---

## 📝 Licencia / License

Uso académico/educativo.

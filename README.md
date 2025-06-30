
# 🎬 Backend – Will Vila Portfolio

Este repositorio contiene el backend del proyecto final individual: una aplicación web profesional para el filmmaker **Will Vila**. Desarrollado con **Spring Boot**, proporciona una API REST que permite gestionar los proyectos audiovisuales mostrados en el frontend.

---

## ⚙️ Tecnologías utilizadas

- Java 17  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- PostgreSQL    
- Maven  

---

## 📦 Estructura del proyecto

El backend está diseñado bajo una arquitectura **MVC** organizada en capas:

- **Controller** → Expone los endpoints de la API REST  
- **Service** → Contiene la lógica de negocio  
- **Repository** → Accede a los datos utilizando JPA  
- **Model** → Define las entidades del dominio (por ejemplo, `Proyecto`)  

---

## 📊 Base de datos

- **Gestor**: PostgreSQL  
- **Configuración**: archivo `application.properties`  

La entidad principal es `Proyecto`, que representa cada trabajo audiovisual realizado por Will.

### 🧱 Ejemplo de entidad (en desarrollo):

```java
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int id;
    private String title;
    private String data;
    private String url;
}
```

---

## 🧪 Testing

Aún no implementado. El plan de testing incluye:

- **JUnit + Mockito** para pruebas unitarias  
- **Postman** para testeo manual de endpoints  

---

## 🚀 Cómo ejecutar el proyecto

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/tuusuario/nombre-backend.git
   ```

2. **Configura la base de datos**  
   Edita el archivo `src/main/resources/application.properties` con tus datos de conexión:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/willportfolio
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Ejecuta el proyecto**  
   Desde tu IDE (IntelliJ, Eclipse) o terminal:

   ```bash
   ./mvnw spring-boot:run
   ```

---

## 🔜 Funcionalidades pendientes

- [ ] CRUD completo de proyectos (`GET`, `POST`, `PUT`, `DELETE`)  
- [ ] Conexión con el frontend  
- [ ] Validación de formularios  
- [ ] Seguridad (autenticación básica o JWT)  
- [ ] Tests unitarios y de integración  

---

## 📁 Enlace al frontend

👉 [Repositorio del frontend](https://github.com/Carocitta/WILL_VILA_FE.git) 

---

## 👨‍💻 Autor

Proyecto desarrollado por Carolina Mas como entrega final del bootcamp de desarrollo web full-stack.

---

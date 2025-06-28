# Random Number Guessing System

Este proyecto es un sistema de microservicios en Java Spring Boot, compuesto por dos servicios principales:

- **random-number-guessing-provider**: Servicio que genera y valida el número aleatorio.
- **random-number-guessing-consumer**: Servicio que expone una API y una interfaz web para que el usuario adivine el número.



## Requisitos previos

### **Java 17** (Para linux )
- **En Ubuntu/Debian:**
    ```bash
   sudo apt update
   sudo apt install openjdk-17-jdk
    ```
###  **Maven 3.8+**
- **En Ubuntu/Debian:**
    ```bash
   sudo apt update
   sudo apt install maven
    ```
### **Nacos**
    - descargar archivo **nacos-server-2.5.1.tar.gz** en la siguiente url https://github.com/alibaba/nacos/releases/tag/2.5.1 (Esta al final del sitio web)
    En Ubuntu/Debian:
    ```bash
   tar -zxvf nacos-server-*.tar.gz
   cd nacos/bin
   bash startup.sh -m standalone
    ```
###  **MySQL 8+**

## 1. Instalación y configuración de MySQL

1. **Instala MySQL**  
   En Ubuntu/Debian:
   ```bash
   sudo apt update
   sudo apt install mysql-server
   ```

2. **Configura la seguridad de mysql**
    En Ubuntu/Debian:
    ```bash
    sudo mysql_secure_installation
    ```
    - Completa los datos como mas le guste. Sugiero para desarrollo, un password LOW y lo demas escojer la opcion No
  

3. **Configura el usuario root para autenticación por contraseña**  
   ```bash
   sudo mysql
   ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'TuPasswordSegura';
   FLUSH PRIVILEGES;
   EXIT;
   ```

4. **Crea la base de datos y las tablas necesarias**  
  Usando el script dentro de la carpeta scripts, ejecutalo de la siguiente manera:
   ```bash
   mysql -u root -p < /ruta/al/archivo/db-script.sql
   ```
   Tambien puedes estando en la raiz del proyecto navegar a la carpeta scripts, y aho ejecutar el mismo comando, pero solo escribiendo el nombre del archivo, en lugar de toda la ruta.

---

## 2. Configuración del proyecto

1. **Clona el repositorio o descarga el código fuente**  
   ```bash
   git clone https://github.com/Corxo91/random-number-guessing-system.git
   cd random-number-guessing-system
   ```

2. **Configura el archivo `application.yml` del provider**  
   Edita `/random-number-guessing-provider/src/main/resources/application.yml` y pon tus datos de conexión:
   ```yaml
   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/guessing_game?useSSL=false&serverTimezone=UTC
       username: root
       password: TuPasswordSegura
       driver-class-name: com.mysql.cj.jdbc.Driver
   ```

---

## 3. Compilación

Desde la raíz del proyecto:
```bash
mvn clean install
```

---

## 4. Ejecución de los servicios

### 4.1. Inicia el provider

```bash
cd random-number-guessing-provider
mvn spring-boot:run
```

### 4.2. Inicia el consumer (en otra terminal)

```bash
cd random-number-guessing-consumer
mvn spring-boot:run
```

---

## 5. Uso del sistema

### 5.1. API REST

Puedes hacer peticiones POST al endpoint del consumer:
```bash
curl -X POST "http://localhost:8082/guess?number=50"
```

### 5.2. Interfaz Web

Abre en tu navegador:
```
http://localhost:8082/
```
Allí podrás ingresar un número, hacer clic en "Guess" y ver el resultado.

---

## 6. Notas adicionales

- Si usas Nacos, asegúrate de que esté corriendo antes de iniciar los servicios.
- Si cambias el puerto, usuario o contraseña de MySQL, actualiza el `application.yml` del provider.
- Si tienes problemas de conexión a la base de datos, revisa los logs del provider.

---

## 7. Créditos

Desarrollado por msantana_dev.

---

¿Dudas?  
Revisa los logs de cada servicio o abre un issue.
# EmergenciasCore

## Intro
 
EmergenciasCore is a Java-based emergency management system.

The goal of the project is to quickly collect user information, generate emergencies, and create alert information in the event of an emergency, so as to help users deal with emergencies more efficiently.

This project is the development result of Proyecto Intermodular in the first academic year.

---

## Objeto

* Detectar emergencias

* Gestionar la información básica de los usuarios

* Generar una alarma de emergencia

* Realizar la persistencia de los datos

* Sentar las bases para la posterior expansión del sistema

---

## Funciones que se han realizado

### Núcleo 1: Detección de emergencia

* Active manualmente las emergencias

* Entrada de información del usuario

* Creación de datos de emergencia

* Mecanismo de verificación básico

### Core 2: Gestión de alarmas

* Generar información de alarma

* Simular el envío de alertas

* Guardar la alarma en el archivo

* Consultas de seguimiento de soporte

---

## Persistencia de datos

En la actualidad, el proyecto utiliza archivos de texto para la persistencia de datos:

Alertas.txt

Todas las alertas generadas se guardarán en el archivo.

---

## Parte de la base de datos

* El proyecto ha aprendido y practicado el uso de MySQL y JDBC.

* El contenido completado incluye:

* Crear una base de datos

* Crear una tabla de datos

* Insertar datos

* Consulta SQL

* Java se conecta a MySQL

---

## Usar la tecnología

* Java

* Programación orientada a objetos (OOP)

* GitHub

* Experto

* MySQL

* JDBC

* intelliJ IDEA

*Lectura y escritura de archivos (FileWriter / BufferedReader)

---

## Estructura

com.emergencias.model
│
├── EmergencyEvent
└── UserData

com.emergencias.detector
│
└── EmergencyDetector

com.emergencias.alert
│
└── AlertSender

com.emergencias.controller
│
└── EmergencyManager

com.emergencias.bd
│
├── AlertaDAO
├── EmergenciasBD
├── EjercicioInstituto
└── EjercicioInstitutoConsultas

com.emergencias.main
│
└── Main

---

## Problemas encontrados en el proceso de desarrollo

#### Durante el proceso de desarrollo, se encontraron principalmente los siguientes problemas:

* Dificultad para entender el código Java

* La relación entre las clases no es lo suficientemente familiar.

* El proceso de lectura y escritura de documentos es relativamente complicado.

* Configuración de la conexión de la base de datos JDBC

* Problema de configuración de la interfaz gráfica de JavaFX

* Problema de gestión de dependencias de Maven

* Estos problemas se han resuelto paso a paso mediante la consulta de materiales, la lectura de códigos de muestra y las pruebas constantes.

---

## Dirección de mejora futura

#### Está previsto añadir en versiones posteriores:

* #### Interfaz gráfica de JavaFX

* Sistema de gestión de usuarios

* Historial de emergencia

* Función de notificación automática

* Función de posicionamiento GPS

---
## GitHub

El proyecto está gestionado por versiones y el código se mantiene a través de GitHub.

### Autor

Shuting Wu

### Link

https://gvaedu-my.sharepoint.com/:p:/r/personal/shuwu_alu_edu_gva_es/Documents/PPT.pptx?d=w4ea5c28f12f4469bb6834ff0ea2c6b43&csf=1&web=1&e=gDQgVv
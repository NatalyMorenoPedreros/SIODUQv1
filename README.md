# SIODUQ

SIODUQ es el prototipo de Sistema de Información de la Oficina Docente de la Universidad del Quindío. 
Este prototipo permite a la secretaría de la oficina docente organizar las solicitudes que realizará a través de la misma aplicación, docentes que estén registrados
y quieran entregar su productividad académica y/o bonificaciones.

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._


### Pre-requisitos 📋

1. Se debe contar con un motor de base de datos, la configuración del proyecto esta determinada con Posgresql y PgAdmin para IDE
2. Se debe contar con Java 11 instalado
3. Opcionalmente la IDE de gusto, sin embargo el proyecto se desarrollo en el IDE NetBeans, aunque se sugiere cambiar a IntellijIDea

### Instalación 🔧

1. Descargue el proyecto por medio de git 

Comando: 
```
git clone https://github.com/NatalyMorenoPedreros/SIODUQ.git
```

Si se encuentra en NetBeans, se da click derecho en el proyecto y le realiza _clean and build_

Dentro del IDE de base de datos puede generar la base de datos con el siguiente script
```
https://drive.google.com/file/d/13j18Y2SWXQ36KmwYn0QNxS60wRPyur5u/view?usp=sharing
```

Si su motor de base de datos es diferente, dirijase a la carpeta resources del proyecto en el archivo _application.properties_ y haga los ajustes en la sección 
base de datos

## Despliegue 📦

El despliegue de la aplicación en local se da por medio del servidor TomCat que utiliza Spring Framework

## Construido con 🛠️

_Herramientas utilizadas en el proyecto_

* [Spring Boot](https://spring.io/) - El framework web usado
* [Gradle](https://gradle.org/) - Manejador de dependencias
* [Thymeleaf](https://www.thymeleaf.org/) - Herramientas para visualización de front
* [Hibernate](https://hibernate.org/) - Implementación para mapeo de clases Java a tablas de motor Posgresql
* [Firebase](https://firebase.google.com/?hl=es-419&gclid=Cj0KCQiAyMKbBhD1ARIsANs7rEEA522QwAhyiWiPlP67dgyFa1EI8lvW_469O_YSd4Biu2_BGHPvgSwaAiE-EALw_wcB&gclsrc=aw.ds)
  Se implemente firebase para cargar archivos en la herramienta Storage
* [NetBeans](https://netbeans.apache.org/) - IDE para desarrollo
* [Postgresql](https://www.postgresql.org/) - Motor de base de datos
* [Java](https://www.java.com/es/) - Lenguaje base del proyecto

## Autores ✒️

_Menciona a todos aquellos que ayudaron a levantar el proyecto desde sus inicios_

* **Nataly Moreno Pedreros** - *Desarrollo* - [NatalyMorenoPedreros](https://github.com/NatalyMorenoPedreros)
* **Denilson Andre Agudelo** - *Desarrollo*


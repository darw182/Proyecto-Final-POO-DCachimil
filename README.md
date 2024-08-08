#Proyecto Final de Programacion

#link del video: https://youtu.be/7K0V4yysxbI

#Minmarket

El presente proyecto tiene como objetivo desarrollar un sistema de gestión integral para un minimarket utilizando los principios de la Programación Orientada a Objetos (POO). 

##objeitvo

Crear un software que me pemita la automatización de tareas rutinarias como el registro de productos, control de inventario, procesamiento de ventas y generación de reportes.

##Conformacion del proyecto

Para este proyecto se use el patron modelo-vista-controlador porque nos permite mantener un mejor orden de las clases, pero principalmente este modelo nos permite poner en practica todo lo relacinado a la programacion orientada a objetos como el encapsulamiento, instanciacion, herencia, etc.

Aqui muestro la estructura del proyecto:

<img src="src/img/conformacion.png" alt="Captura proyecto" width="400" height="400">

Estructura del controlador:

<img src="src/img/controlador.png" alt="Captura" width="400" height="400">

Estructura del modelo:

<img src="src/img/Modelo.png" alt="Captura" width="400" height="400">

Estructura de la vista:

<img src="src/img/vista.png" alt="Captura" width="400" height="400">

Aqui se muestran las librerias usadas en este proyecto

<img src="src/img/librerias.png" alt="Captura Login" width="400" height="400">

##Conexion

Se uso mongoDB una base de datos no sql para almacenar los datos generados en el proyecto. Se uso un pool de Conexiones para administrar de mejor manera cada una de las transacciones; mongodb cuenta con su propio pool a diferencia de las bases de datos sql en la cuales es necesario incorporar la libreria externa de apache. 

<img src="src/img/conexion.png" alt="Captura Login" width="400" height="600">

Estas son las colecciones en mongoDb:

<img src="src/img/colecciones.png" alt="Captura Login" width="400" height="400">


##Vistas del proyecto

Login:

<img src="src/img/loginCaptura.png" alt="Captura Login" width="400" height="400">

Panel de control:

<img src="src/img/panelControl.png" alt="Captura Login" width="400" height="500">

Panel de administracion de cajeros:

<img src="src/img/adminCajero.png" alt="Captura Login" width="400" height="500">

Panel de administracion de stock:

<img src="src/img/adminVendedor.png" alt="Captura Login" width="400" height="500">

Pantalla de stock:

<img src="src/img/stock.png" alt="Captura Login" width="400" height="500">

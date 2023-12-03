# Flash Shop
Integrantes: Miguel Ángel Cebrián, Iván García-Diego, Jorge Sánchez


# Explicación del trabajo (Clases implicadas)
En este trabajo desarrollaremos una programa para la gestión de una tienda online. Se busca que el cliente pueda realizar acciones como añadir o eliminar productos a su carrito, comprar dichos productos, cancelar sus pedidos o actualizar sus datos. También se busca que el gerente de la tienda pueda realizar acciones como añadir un nuevo producto a la tienda, eliminar uno ya existente, modificar sus precios o ver que productos está vendiendo.

En dicho programa hacemos uso de diferentes clases, las cuales son "Producto", "Pedido", "Carrito" y "Tienda". También hay tenemos la interfaz "Persona", de la que derivan la clase "Cliente" y la clase "Gerente". Por último se ha creado una clase, "ProductoNoEncontradoException", la cual es una excepción que se lanza cuando no se ha encontrado el producto que se estaba buscando.

La clase "Producto" tiene como atributos privados un nombre, un ID y un precio. Como métodos públicos tiene 4 constructores, uno por defecto y el resto por parámetros; y los métodos Getter y Setter de cada uno de los atributos privados.

La clase "Pedido" tiene como atributos privados un ID, un Array con los productos comprados, una fecha de entrega y el importe del pedido. Como métodos públicos tiene un constructor, dos métodos para añadir productos al pedido y los métodos Getter y Setter de cada uno de los atributos privados.

La clase "Carrito" tiene como atributos privados una instancia del Carrito, un Array con los productos que se van a comprar y el precio provisional de lo que de se va a comprar. Como métodos públicos tiene un constructor, métodos para añadir, eliminar un producto del carrito, un método para vaciar el carrito y los métodos Getter y Setter de cada uno de los atributos privados, además de una función para obtener una instancia del Carrito.

La clase "Tienda" tiene como atributos privados un nombre, una contraseña y un Array con los productos que se venden. Como métodos públicos tiene tres constructores, uno por defecto y dos por parámetros; un método para eliminar un producto existente; un método para añadir un producto nuevo; un método para liquidar todos los productos que se venden; dos métodos para modificar los precios, uno para modificar de forma individual el precio de un producto y otro para establecer rebajas en todos los productos; y los métodos Getters y Setters de cada uno de los atributos privados.

La interfaz "Persona" tiene como métodos públicos abstractos los métodos Getter y Setter de cada uno de los atributos privados que tienen en común la clase "Cliente" y la clase "Gerente". También tiene como métodos abstractos la actualización de los datos, así como la inserción o eliminación de un producto del carrito o de la tienda respectivamente.

Las clases "Cliente" y "Gerente", que heredan de la interfaz "Persona" y tienen como atributos privados comunes un nombre, unos apellidos, un correo y una contraseña, además de los métodos Getter y Setter de cada uno de los atributos privados y los metodos sobreescritos de la interfaz. 

La clase "Cliente", además de lo anteriormente mencionado, tiene como atributos privados una dirección, un saldo, un carrito de la compra y un Array con los pedidos pendientes, así como los métodos públicos Getter y Setter para estos atributos. Como métodos públicos tiene tres constructores y métodos sobreescritos para comprar, añadir un pedido al Array, cancelar un pedido, para añadir dinero al saldo, para vaciar el carrito y para verificar si alguna entrega se ha realizado ya.

La clase "Gerente", además de lo ya mencionado, tiene como atributo privado una tienda y métodos públicos Getter y Setter para dicho atributo. Como métodos tiene 6 constructores, un método para liquidar todos los productos que se venden, otro para modificar el precio de un producto y otro para establecer rebajas en todos los productos.

# Explicación del trabajo (Patrón de diseño)
Se usa un patrón creacional, el "Factory Method" para poder crear gerentes y cliente con los inicializar el ArrayList que hace de "base de datos". Para ello se hace uso de la clase abstracta llamada "Factory", que tiene dos métodos, uno para crear a una persona y otro que llama al método anterior y que, además, muestra el tipo de persona que está creando, es decir, crea a la persona y nos dice si es un cliente o un gerente.

También usamos el patrón "Singleton" para la gestión del carrito de la compra mediante una única instancia.

# Explicación del trabajo (Interfaces Gráficas implicadas)

Para poder hacer uso de las clases anteriormente mencionadas, se han creado varias interfaces gráficas, entre las que destacan la interfaz para hacer login, para registrarse o las que muestran menus para los gerentes, a los clintes o uno anterior a hacer login.

La interfaz gráfica para el menú general consta de un constructor y de una función capaz de gestionar los eventos que ocurren tras pulsar alguno de los botones que tiene el constructor. El constructor tiene una etiqueta encargada de preguntarle al usuario que acción desea hacer y 3 botones, los cuales sirven para registrar a un persona, loguearse o salir del programa. En caso de pulsar alguno de los dos primeros botones, se redirigirá al usuario a la interfaz correspondiente, mediante la función "actionListener()".

La interfaz gráfica para seleccionar el tipo de persona que se va a registrar tiene un constructor y una función capaz de gestionar los eventos que ocurren tras pulsar alguno de los botones que tiene el constructor. El constructor tiene una etiqueta que pregunta al usuario si va a registrar a un cliente o a un gerente, además de 3 botones, dos de ellos para redirigir a la interfaz para registrar a una persona y otro para volver al menu general. Cuando se pulse un botón, la función "actionListener()" redigirá al usuario a la interfaz deseada.

La interfaz gráfica para registrar a una persona consta de un constructor, al que hay que pasarle un input para diferenciar si lo que se va a registrar es un gerente o un cliente, además de una función capaz de gestionar los eventos que ocurren al presionar alguno de los botones que del constructor. El constructor consta de varios campos en los que tienes que ingresar tu nombre, tus apellidos, tu dirección (en caso de ser un cliente), el nombre de tu tienda (en caso de ser un gerente), tu correo y tu contraseña, además de una verificación de que la contraseñla es correcta. También tiene dos botones, uno con para registrar a la persona y otro para volver a la selección de persona. Al pulsar el botón de registrar la persona, la función "actionListener()" redirige a la persona a su menú correspondiente, ya sea cliente o gerente. Hay que destacar que cuando hay algún campo incompleto o cuando la contraseña y su comprobación no son iguales, el sistema envía una señal de ello.

La interfaz gráfica para loguear a una persona consta de un constructor y de una función capaz de gestionar los eventos que ocurren tras presionar alguno de los botones del constructor. El constructor tiene dos campos para escribir el correo de la persona y su correo, y dos botones, uno para registrarse y otro para volver al menú. Si se pulsa alguno de los botones anteriormente mencionados, la función "actionListener()" les redirigirá a la interfaz correspondiente. Hay que destacar que tanto si no se encuentra al usuario deseado o alguno de los campos está vacio, el sistema informará al usuario.

La interfaz gráfica para el menu del cliente consta de un constructor y de una función capaz de gestionar los eventos que ocurren tras pulsar alguno de los botones que tiene el constructor. El constructor tiene una etiqueta que le pregunta al cliente que acción desea hacer y 10 botones con los que puede, entre otras cosas, insertar y eliminar un producto del carito, comprar, cancelar un pedido o cerrar su sesión. Tras haber pulsado un botón, la función "actionListener()" redirige al usuario a la interfaz deseada.

La interfaz gráfica para insertar un producto en el carrito del cliente consta de un constructor y de una función para gestionar los eventos que tengan lugar tras haber pulsados alguno de los botones existentes en el constructor. El constructor tiene un panel de desplazamiento en el que se muestra una lista con el nombre, el ID y el precio de los productos en venta en la tienda existente, así como una etiqueta preguntado por el ID del producto que quería insertar en su carrito y un spinner para la selección del ID del producto. También tiene dos botones, uno para insertar el producto en el carrito y otro para volver al menu sin insertar ningún producto. La función "actionListener()", será la encargada de actuar de una manera u otra dependiendo del botón presionado.

La interfaz gráfica para comprar los productos del carrito tiene un constructor y una función capaz de gestionar los eventos que tengan lugar después de pulsar algún botón del constructor. El constructor tiene un panel de desplazamiento que muestra una lista con los productos que estan en el carrito, un mensaje en el que te muestra el precio actual del carrito y otro que te pregunta si quieres comprar los productos exitentes en el carrito, y dos botones, uno para aceptar la compra y otro para volver al menú sin comprar los productos del carrito. La función "actionListener()", será la encargada de actuar de una manera u otra dependiendo del botón presionado.

La interfaz gráfica para cancelar un pedido realizado por el cliente consta de un constructor y de una función capaz de gestionar los eventos que ocurren tras pulsar un boton del constructor. El constructor tiene un panel de deslizamiento con el que mostramos una lista con los pedidos que el cliente ha comprado, un mensaje que pregunta por la posición del pedido que se va a cancelar y un spinner para la selección de la posición del pedido, además de dos botones, uno para aceptar la cancelación del pedido y otro para volver al menú sin cancelar ningún pedido. La función "actionListener()" se encarga de cancelar el pedido y/o volver al menú dependiendo del botón presionado.

La interfaz gráfica para el menu del gerente consta de un constructor y de una función capaz de gestionar los evento que ocurren tras pulsar alguno de los botones que tiene el constructor. El constructor tiene una etiqueta que le pregunta al gerente que acción desea hacer y 9 botones con los que puede, entre otras cosas, insertar nuevos productos, eliminar productos existentes, rebajar el precio a toda la tienda, modificar el precio de alguno de los productos o cerrar su sesión. Tras haber pulsado un botón, la función "actionListener()" redirige al ususario a la interfaz deseada.

La interfaz gráfica para modificar el precio tiene un constructor, al que hay que pasarle un identificador para saber si estamos rebajando el precio de todos los productos de la tienda o modificando el precio de un producto, y una función para la gestión de los eventos que surjen al presionar alguno de los botones que tiene el constructor. El constructor tiene un panel de deslizamiento que muestra todos los productos en venta de los que se puede modificar su precio; dependiendo del tipo de modificación tendremos 1 o 2 spinners para aplicar un descuento o para seleccionar la posición del producto al que se le va a modificar el precio y su nuevo precio respectivamente; y dos botones, uno para aceptar la modificación del precio y otro para volver menú sin modificar ningún precio. La función "actionListener()" se encarga de volver al menú tras haber modificado el precio de uno de los productos, de todos o de ninguno, dependiendo del botón que se haya presionado.

La interfaz gráfica para inicializar un producto e insertarlo en la tienda consta de un constructor y de una función capaz de gestionar los eventos que surjen tras presionar alguno de los botones del constructor. El constructor tiene un campo para escribir el nombre del producto, un spinner para poder seleccionar el precio de un producto y dos botones, uno para insertar el producto a la tienda y otro para volver al menú sin insertar ningún producto en la tienda. En el caso de que el caso de que el campo del nombre del producto esté vacío, el sistema avisará al usuario de que debe rellenar el campo. La función "actionListener()" se encará de insertar el producto a la tienda y/o volver al menú dependiendo del botón presionado

La interfaz gráfica para actualizar la información de un usuario tiene dos constructores, uno por cada uno de los tipos de personas existentes en el programa y una función capaz de gestionar los eventos que ocurren tras pulsar los diferentes botones existentes en cada constructor. En cada constructor hay diferentes campos para poder modificar el nombre y los apellidos del usuario, así el correo, la contraseña, la dirección (en caso de ser un cliente) o el nombre de la tienda (en caso de ser un gerente). También tienen dos botones, uno para aceptar los cambios realizados y otro para volver a su respectivo menú sin realizar dichas modificaciones. Hay que destacar que en el caso de que haya un campo vacío y se intente guardar los cambios, el sistema avisará diciendo que debe rellenar ese campo para que se puedan guardar los cambios. Tras haber pulsado un botón, la función "actionListener()" actúa de una manera u otro, dependiendo de que botón haya sido pulsado.

La interfaz gráfica para eliminar un producto de un carrito de un cliente o de la tienda del gerente tiene dos constructores para eliminar un producto de cada uno de los lugares anteriormente mencionados y una función para gestionar los eventos que tengan lugar tras pulsar alguno de los botones del constructor. Los constructores tienen en común que tienen un panel de deslizamiento que muestra los productos que están en venta o que están guardadas en el carrito; un mensaje que le pregunta al usuario cual es la posición del producto que se quiere eliminar; un spinner para que el usuario pueda seleccionar la posición; y dos botones, uno para que se elimine el producto seleccionado y otro para volver sin llegar a eliminar ningún producto. La función "actionListener()" se encarga de volver al menú del cliente o del gerente tras haber eliminado un producto o ninguno.

La interfaz gráfica para mostrar los datos del cliente, los productos de su carrito, los pedidos que ha realizado, los datos de un gerente o los productos en venta de su tienda tiene 5 constructores, uno para cada uno de los tipos de datos a mostrar que se han mencionado anteriormente y una función para gestionar los eventos que tengan lugar tras pulsar alguno de los botones que tienen cada uno de los constructores. Los constructores para mostrar los datos del cliente y del gerente, tienen etiquetas que muestra el nombre, los apellidos y el correo del usuario, así como el saldo y la dirección del cliente o el nombre de la tienda del gerente, dependiendo de que tipo de usuario sea quién esté viendo sus datos. El resto de constructores tienen un panel de desplazamiento que muestran los productos en venta, los que están el carrito o los pedidos que el cliente haya realizado. Todos tienen en común que tienen un botón para volver a su menú. La función "actionListener()" hace que se vuelva a la interfaz del menú correspondiente dependiendo de si quién lo ha activado ha sido un cliente, su carrito, su ArrayList con sus pedidos, un cliente o su tienda.

# Interfaz de Usuario
<a href="https://postimg.cc/SXTHSVqp" target="_blank"><img src="https://i.postimg.cc/SXTHSVqp/Captura1.jpg" alt="Captura1"/></a>

<a href="https://postimg.cc/G86NY2H7" target="_blank"><img src="https://i.postimg.cc/G86NY2H7/Captura2.jpg" alt="Captura2"/></a>

<a href="https://postimg.cc/34kVdpJ0" target="_blank"><img src="https://i.postimg.cc/34kVdpJ0/Captura3.jpg" alt="Captura3"/></a>

# Interfaces Gráficas
Interfaz gráfica para mostrar un menu inicial:

<a href="https://postimg.cc/mt1VNDwT" target="_blank"><img src="https://i.postimg.cc/mt1VNDwT/Interfaz-menu.png" alt="Interfaz-menu"/></a><br/><br/>

Interfaz gráfica para seleccionar si eres un cliente o si eres un gerente

<a href="https://postimg.cc/VJ7fYZLR" target="_blank"><img src="https://i.postimg.cc/VJ7fYZLR/Interfaz-seleccion-persona.png"/></a><br/><br/>

Interfaz gráfica para actualizar la información del cliente

<a href="https://postimg.cc/FYFFXXmz" target="_blank"><img src="https://i.postimg.cc/FYFFXXmz/Interfaz-actualizar-informacion-cliente.png" alt="Interfaz-actualizar-informacion-cliente"/></a><br/><br/>

Interfaz gráfica para actualizar la información del gerente

<a href="https://postimg.cc/sBvV1PMR" target="_blank"><img src="https://i.postimg.cc/sBvV1PMR/Interfaz-actualizar-informacion-gerente.png" alt="Interfaz-actualizar-informacion-gerente"/></a><br/><br/>

Interfaz gráfica para loguearse:

<a href="https://postimg.cc/xqC68gNJ" target="_blank"><img src="https://i.postimg.cc/xqC68gNJ/Interfaz-login.png" alt="Interfaz-login"/></a><br/><br/>

Interfaz gráfica para registrar a un cliente:

<a href="https://postimg.cc/ts0krjSW" target="_blank"><img src="https://i.postimg.cc/ts0krjSW/Interfaz-registro-cliente.png" alt="Interfaz-registro-cliente"/></a><br/><br/>

Interfaz gráfica para mostrarle un menu al cliente:

<a href="https://postimg.cc/VSmR8FcN" target="_blank"><img src="https://i.postimg.cc/VSmR8FcN/Interfaz-menu-cliente.png" alt="Interfaz-menu-cliente"/></a><br/><br/>

Interfaz gráfica para registrar a un gerente:

<a href="https://postimg.cc/PLyMr8tQ" target="_blank"><img src="https://i.postimg.cc/PLyMr8tQ/Interfaz-registro-gerente.png" alt="Interfaz-registro-gerente"/></a><br/><br/>

Interfaz gráfica para mostrar un menu al gerente:

<a href="https://postimg.cc/bZQTWBWM" target="_blank"><img src="https://i.postimg.cc/bZQTWBWM/Interfaz-menu-gerente.png" alt="Interfaz-menu-gerente"/></a><br/><br/>

Interfaz gráfica para crear un producto:

<a href="https://postimg.cc/G83qkxMf" target="_blank"><img src="https://i.postimg.cc/G83qkxMf/Interfaz-crear-producto.png" alt="Interfaz-crear-producto"/></a><br/><br/>

Interfaz gráfica para insertar un producto a la tienda, a un pedido o al carrito:

<a href="https://postimg.cc/FdPGGk8H" target="_blank"><img src="https://i.postimg.cc/FdPGGk8H/Interfaz-insertar-producto.png" alt="Interfaz-insertar-producto"/></a><br/><br/>

Interfaz gráfica para eliminar un producto de la tienda, de un pedido o del carrito:

<a href="https://postimg.cc/4nSB9tp8" target="_blank"><img src="https://i.postimg.cc/4nSB9tp8/Interfaz-eliminar-producto.png" alt="Interfaz-eliminar-producto"/></a><br/><br/>

Interfaz gráfica para eliminar un pedido de la lista de pedidos de una persona:

<a href="https://postimg.cc/n9C2WcfY" target="_blank"><img src="https://i.postimg.cc/n9C2WcfY/Interfaz-eliminar-pedido.png" alt="Interfaz-eliminar-pedido"/></a><br/><br/>

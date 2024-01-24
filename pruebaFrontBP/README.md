# PruebaBancoPichincha
### A continuación se presentan las herramientas de automatización que fueron utilizadas en este proyecto:

- Java SDK version 11.0.15
- Gradle wrapper vesion 7.4.1
- Serenity BDD version 4.0.14
- Cucumber version 7.14.0
- Log4j version 2.17.2


### Se especifican los paquetes usados en el proyecto, teniendo en cuenta que se trabajó con el patrón de diseño screenplay:

- **Tasks:** Grupos de interacción para completar un objetivo implementado por un actor.
- **Interactions:** Acción individual ejecutada por un actor para realizar una tarea.
- **Models:** Clases base para mapear y transferir información según los requisitos.
- **Questions:** interacciones específicas para garantizar que los resultados de las pruebas sean correctos.
- **Utils:** Métodos y clases que no son proporcionados por Serenity para operar datos de prueba.
- **Runners:** Clases de comunicación entre las características de Cucumber y la definición de pasos donde se definen las
  reglas de comunicación
- **Step Definitions:** Donde se integran las tareas, preguntas y demás para ejecutar programáticamente una función determinada.
- **Features:** Descripciones funcionales en lenguaje Gherkin (desarrollo orientado al comportamiento)


### Datos sobre feature compra
 1. El username que debe usarse es standard_user
 2. El password que debe usarse es secret_sauce
 3. En el campo listaProductos, se recibe un string en el cual se enviaran separados por comas los productos de la tienda que se desean agregar al carrito. 
Tener en cuenta que no es necesario enviar el nombre completo del producto, basta con que el texto ingresado sea suficiente para identificar el producto y distinguirlo del resto de productos del listado o catalogo.
 4. Los campos nombreComprador y apellidoComprador pueden tener cualquier valor.

### Para ejecutar cada feature seguiremos los siguientes pasos:
1. ingresar la información o data de prueba en la feature de forma correspondiente en los DataTables según la necesidad de la prueba
2. comando de ejecución de gradle: clean build test --test *nombreRunner --info aggregate
   En la sección *nombreRunner debe especificarse el nombre del runner que deseamos correr teniendo en cuenta la feature respectiva.
3. El reporte de ejecución se encontrará en la raíz del proyecto en una carpeta llamada target, se debe buscar un archivo llamado index.html
# PruebaBancoPichincha
### A continuación se presentan las herramientas de automatización que fueron utilizadas en este proyecto:

- Java SDK version 11.0.15
- Gradle wrapper vesion 7.4.1
- Karate framework 1.4.1

### Para ejecutar cada feature seguiremos los siguientes pasos:
1. Crear o modificar el archivo .json en la carpeta test/resources/files de acuerdo a la feature objeto de prueba.
2. Ejecutar el comando de gradle: clean build test --test *nombreRunner
   En la sección *nombreRunner debe especificarse el nombre del runner que deseamos correr teniendo en cuenta la feature respectiva.
   Por ejemplo: clean build test --test *CreateUserTest.testCreateUserJson 
3. El reporte de ejecución se encontrará en la raíz del proyecto en el directorio build/karate-reports en un archivo llamado karate-summary.html
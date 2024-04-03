## Challenge despegar

### creamos una instancia con ubuntu y configuramos el par de claves para la conexión por ssh
![image](https://github.com/juansein/challenge-despegar/assets/78378680/18f93fff-cc1f-4627-ad7f-e384ad5295fe)

### creamos el security group para permitir el trafico por ssh desde nuestro equipo y por el puerto 9000 para la conexión de github con el servicio de sonarqube
![image](https://github.com/juansein/challenge-despegar/assets/78378680/853774be-dcff-4c83-8909-12817021981f)

### nos conectamos por ssh a la instancia y empezamos con la instalación de docker
![image](https://github.com/juansein/challenge-despegar/assets/78378680/c397111c-9eda-4148-90f4-c06fb6b32bf9)

### descargamos e instalamos docker-compose

![image](https://github.com/juansein/challenge-despegar/assets/78378680/9284c376-4633-4dc7-9b45-d606b6a02d46)

### descargamos nuestro archivo .yml y usamos el comando docker-compose up para el despliegue de nuestros contenedores
![image](https://github.com/juansein/challenge-despegar/assets/78378680/2807b787-d7b8-48fb-9664-f6ea2bd8f8aa)

### vemos que nuestro servicio sonarqube ya esta levantado
![image](https://github.com/juansein/challenge-despegar/assets/78378680/2adea65d-2e9a-4368-9fc4-4366fff6ad77)

### abrimos nuestra pagina de sonarqube en el puerto 9000 y configuramos las credenciales admin

### creamos nuestro repositorio de github con el codigo vulnerable asi como la app de github y sus respectivos permisos en el repo

### configuramos las credenciales de autenticación de github app en sonarqube

### ahora si importamos el proyecto

### configuramos los github secrets con los token SONAR_TOKEN y SONAR_HOST_URL  

### creamos el workflow y configuramos el build.gradle
![image](https://github.com/juansein/challenge-despegar/assets/78378680/3d85567f-c759-49ca-83c0-d714a32296d1)

### ya tenemos nuestro repositorio integrado con sonarqube y listo para analizar cambios
![image](https://github.com/juansein/challenge-despegar/assets/78378680/e6017a34-5bf7-46c2-9c50-f254dcc10b8e)

### habilitamos la protección de branches en el main para evitar merges cuando el quality gate falle
![image](https://github.com/juansein/challenge-despegar/assets/78378680/1e0334a6-67f2-4314-be3b-388b8285f86b)

### ahora cada vez que queramos hacer un commit tendremos que hacer una pull request

### asi quedaria un flujo completo: 

![image](https://github.com/juansein/challenge-despegar/assets/78378680/575fcf1f-59ef-433b-abb2-945b731d6e06)

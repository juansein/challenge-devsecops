## Challenge devsecops

[el servicio configurado de sonarqube esta apagado actualmente, de igual forma pueden ver el proceso, el codigo y si gustan hacer pruebas locales]

### Uso

Para poder probar el workflow hacer una contribución al repositorio realizando los siguientes pasos

### 1. clonar el repositorio
 ```sh
git clone https://github.com/juansein/challenge-devsecops.git
 ```
### 2. crear una nueva rama 
```sh
git checkout -b "nombre de la rama"
```
### 3. generar el commit
```sh
git add .
git commit -m "comentarios"
git push origin nombre de la rama
```
### 4. abrir el pull request desde github buscando la opción para contribuir en el repositorio

### 5. ya podemos ver el flujo en actions
![image](https://github.com/juansein/challenge-despegar/assets/78378680/10840be4-ded4-483b-9a16-8106636d5dc8)

### para usar el script de busqueda de keys
```sh
python ./keyfinder.py
```

## Proceso de Implementación

### para la implementación de sonarqube se llevaron a cabo los siguientes pasos:

### creamos una instancia con ubuntu y configuramos el par de claves para la conexión por ssh
![image](https://github.com/juansein/challenge-despegar/assets/78378680/18f93fff-cc1f-4627-ad7f-e384ad5295fe)

### creamos el security group para permitir el trafico por ssh desde nuestro equipo y por el puerto 9000 para la conexión de github con el servicio de sonarqube
![image](https://github.com/juansein/challenge-devsecops/assets/78378680/e47e93db-ddc5-4e24-91c9-5896e2a41d47)

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
![image](https://github.com/juansein/challenge-despegar/assets/78378680/5a58c0bf-7ed7-459b-9958-a76322ed4c07)

### configuramos las credenciales de autenticación de github app en sonarqube
![image](https://github.com/juansein/challenge-despegar/assets/78378680/0b453723-5898-4b30-b198-ce3b8bd213c0)

### ahora si importamos el proyecto
![image](https://github.com/juansein/challenge-despegar/assets/78378680/3046f59e-53a8-4740-8360-203bcf0d15ba)

### configuramos los github secrets con los token SONAR_TOKEN y SONAR_HOST_URL  
![image](https://github.com/juansein/challenge-despegar/assets/78378680/cc868b43-1279-4129-86be-1af8982fdfbd)

### creamos el workflow y configuramos el build.gradle
![image](https://github.com/juansein/challenge-devsecops/assets/78378680/2e5d4cd1-2eb2-4f4f-b655-fa7df4de5315)

### ya tenemos nuestro repositorio integrado con sonarqube y listo para analizar cambios
![image](https://github.com/juansein/challenge-despegar/assets/78378680/e6017a34-5bf7-46c2-9c50-f254dcc10b8e)

### habilitamos la protección de branches en el main para evitar merges cuando el quality gate falle
![image](https://github.com/juansein/challenge-despegar/assets/78378680/1e0334a6-67f2-4314-be3b-388b8285f86b)

### ahora cada vez que queramos hacer un commit tendremos que hacer una pull request

### asi quedaria un flujo completo: 

![image](https://github.com/juansein/challenge-devsecops/assets/78378680/68d9faeb-2edc-4687-af39-0db9cdd67e7a)

import os
import re

# iteramos recursivamente el directorio para buscar archivos y pasarle las rutas a nuestro buscador de keys
def escanearDirectorio(ruta):
    for elemento in os.scandir(ruta):
        if elemento.name != '.git':
            if elemento.is_dir():
                escanearDirectorio(elemento.path)
            elif elemento.is_file():
                buscarKeys(elemento.path)

# con la ruta del archivo lo abre y busca todos los strings que matcheen los patrones regex de las access key y secret key de AWS
def buscarKeys(archivo):
    with open(archivo, 'r', errors='ignore') as f:
        contenido = f.read()
        patrones = [r'AKIA[A-Z0-9]{16}', r'(?<![A-Za-z0-9/+=])[A-Za-z0-9/+=]{40}(?![A-Za-z0-9/+=])']
        for patron in patrones:
            busqueda = re.findall(patron, contenido)
            if busqueda:
                print(f"Potencial access key o secret key filtrado: {busqueda} en {archivo}\n")

ruta = "./"
escanearDirectorio(ruta)
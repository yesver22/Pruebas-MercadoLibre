# Pruebas-MercadoLibre
para montar y correr el proyecto, se debe descargar desde la rama Master.
1.Abrir Spring Booth Tools e importar el proyecto.
2.Crear una base de datos llamada mutantes en mysql, y despues ejecutar el archivo mutantes.sql

Ejecutar el proyecto.

La api tiene dos endpoint:
1. Ejemplo: http://localhost:8080/api/mutantes/mutant
  Metodo Post
  {
"dna":["ATGCGY","CAGTGY","TTATGY","AGAAGY","CCCCTY","TCACTG"]
}

2.Ejemplo: http://localhost:8080/api/mutantes/stats
metodo Get.

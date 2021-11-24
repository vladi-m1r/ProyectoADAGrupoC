## Descripcion y proposito del proyecto
El proyecto fue desarrollado para el curso de Analisis y Diseño de Algoritmos donde se implemento los algoritmos de depth-first-search y breadth-first-search. El proposito es separar en componentes en escala de grises un rango ingresado para una imagen usando los dos algoritmos implementados.

---
## Depth-First-Search
Algoritmo iterativo que usa stack y listas, cada stack representa una ejecucion de un lista que no ha terminado, cuando se saca una pila se obtiene una lista enlazada con Nodos que aun no han sido visitados que respresentan los vecinos de otro Nodo visitado anteriormente, por ello cada vez que se desencola se marca el Nodo desencolado como visitado y procede a buscar mas vecinos de ese nodo. 
- Si no se encuentra vecinos y la lista se vacia entonces se remueve ese stack.
- Si encuentra vecinos y la lista aun no esta vacia entonces el stack se mantiene y procede a buscar vecinos del Nodo vecino encontrado.

---
## Breadth-First-Search

Algoritmo iterativo que usa colas para encolar cada pixel vecino del pixel visitado que aun no haya sido visitado. Cada iteracion desencola el primer Nodo para luego encolar sus vecinos y marcarlos como visitados. En este caso se usa un rango para limitar los componentes y separarlos en componentes dentro de un arreglo bidimensional.

---
## Analisis de complejidad del algoritmo
- DFS

![DFS-1](https://github.com/vladi-m1r/img-repo/blob/master/DFSCA.png?raw=true)
![DFS-2](https://github.com/vladi-m1r/img-repo/blob/master/DFSCA2.png?raw=true)

Teniendo en cuenta solo el mejor de los casos en el cual linealmente se obtenga n stacks por busqueda en profundidad la complejidad algoritmica seria 7 + 7(N-1) + N = 8N -> O(N)

 BFS

![BFS-1](https://github.com/vladi-m1r/img-repo/blob/master/BFSCA1.png?raw=true)
![BFS-2](https://github.com/vladi-m1r/img-repo/blob/master/BFSCA2.png?raw=true)

La complejidad algoritmica es 4 + 6N -> O(N)

---
## Imagenes de prueba

#### Prueba con rango 25
- DFS
![dory](https://github.com/vladi-m1r/img-repo/blob/master/DFS25.png?raw=true)
![nemo](https://github.com/vladi-m1r/img-repo/blob/master/DFS25-2.png?raw=true)
- BFS
![dory](https://github.com/vladi-m1r/img-repo/blob/master/BFS25.png?raw=true)
![nemo](https://github.com/vladi-m1r/img-repo/blob/master/BFS25-2.png?raw=true)
#### Prueba con rango 50
- DFS
![dory](https://github.com/vladi-m1r/img-repo/blob/master/DFS50.png?raw=true)
![dory](https://github.com/vladi-m1r/img-repo/blob/master/DFS50-2.png?raw=true)
- BFS
#### Prueba con rango 100
- DFS
![dory](https://github.com/vladi-m1r/img-repo/blob/master/DFS100.png?raw=true)
![dory](https://github.com/vladi-m1r/img-repo/blob/master/DFS100-2.png?raw=true)
- BFS
![dory](https://github.com/vladi-m1r/img-repo/blob/master/BFS100.png?raw=true)
![dory](https://github.com/vladi-m1r/img-repo/blob/master/BFS100-2.png?raw=true)
---
## Como ejecutar el codigo
Crear un proyecto con el IDE Eclipse y clonar el repositorio dentro de src con el comando **git clone [url] .**
Para la ejecucion del codigo solo se debe ejecutar el archivo Main.java.
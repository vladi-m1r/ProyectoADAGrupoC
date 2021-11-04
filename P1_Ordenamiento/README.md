## HEAP SORT
#### Descripción:
El algoritmo consiste en almacenar los elementos en un arreglo o vector y ordenar emulando una estructura de tipo árbol binario, para que con cada iteración se intercambie el primer nodo con el ultimo del arreglo de esa precisa iteración para luego no tener en cuenta ese nodo para la siguiente iteración.

La idea de cada iteración es que siempre el nodo padre sea mayor a los nodos hijos, por lo que necesita reordenar una vez haya intercambiado el lugar del nodo hijo con el padre, pues el nodo hijo sea menor que sus propios hijos.

Este algoritmo tiene una versión recursiva, sin embargo para el desarrollo de este no se usó recursividad lo que genero algunos problemas para hallar su complejidad.

#### Análisis de complejidad:
Tiempo de la funcion que intercambia dos valores en un arreglo
![Tiempo de swap_keys](https://raw.githubusercontent.com/vladi-m1r/img-repo/master/HeapSort01.png)
Solo llega a tener un tiempo constante de 3.
![Tiempo de HeapSort](https://raw.githubusercontent.com/vladi-m1r/img-repo/master/HeapSort02.png)
![Complejidad](https://raw.githubusercontent.com/vladi-m1r/img-repo/master/HeapSort03.png)
## QUICK SORT
#### Descripción:
El Algoritmo fue diseñado para ser lo más eficiente posible sumando el algoritmo Quicksort e insertion sort convirtiéndolo en un algoritmo hibrido, el cual según https://www.geeksforgeeks.org/advanced-quick-sort-hybrid-algorithm/ el umbral para que se intercambie el uso de los algoritmos es 10. El algoritmo Quicksort común trata de ordenar los elementos dividiendo el arreglo a través de un pivote que mueve los elementos menores a la izquierda y los mayores a la derecha, cuando la variable i es menor o igual que j acaba este proceso y se particiona el arreglo llamando recursivamente a la función a ordenar cada partición creada.
#### Análisis de complejidad:
Tiempo por algoritmo quicksort:
![Quick Sort Complex Algorithm](https://raw.githubusercontent.com/vladi-m1r/img-repo/master/QuickSort01.png)
Solo se logro hallar la función T(n) para el algoritmo, al ser recursivo tiende a tener cierta dificutad para hallar su complejidad.
![](https://raw.githubusercontent.com/vladi-m1r/img-repo/master/QuickSort02.png)
El proceso puede seguir hasta hallar cierto patron donde el parametro de n de T(n) sea menor a 10.
## INSERTION SORT
#### Descripción:
El algoritmo de ordenamiento por inserción ordena los elementos empezando desde el segundo elemento y se compara con los elementos de la izquierda intercambiando su posición con los elementos que sean menores a él. Además, comparado con otros algoritmos de ordenación este es relativamente fácil de implementar.

#### Análisis de complejidad:
Tiempo por algoritmo de inserción:
![Insertion Sort Complex Algorithm](https://raw.githubusercontent.com/vladi-m1r/img-repo/master/InsertionSort01.png)
Para encontrar la complejidad se debe sumar todos los tiempos del algoritmo de insercion.
![Insertion Sort Complex Algorithm sum](https://raw.githubusercontent.com/vladi-m1r/img-repo/master/InsertionSort02.png)

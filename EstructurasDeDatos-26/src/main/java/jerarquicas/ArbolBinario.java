package jerarquicas;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;

/**
 * Implementación del TDA Árbol Binario.
 *
 * @author <a href="https://www.github.com/santinux">Santino Fuentes</a>
 * @version 3.0
 */
public class ArbolBinario implements Cloneable
{
        /**
         * Consideraciones ligadas a la implementación:
         * - Árbol vacío: raiz == null.
         */
        private NodoBinario raiz;
        
        /**
         * Constructor por defecto de la clase ArbolBinario.
         * Inicializa un árbol vacío estableciendo la raíz en null.
         */
        public ArbolBinario()
        {
                this.raiz = null;
        }
        
        /**
         * Inserta un nuevo elemento en el árbol como hijo del elemento padre
         * indicado, en la posición especificada ('I' para izquierda, 'D' para derecha).
         * Si el árbol está vacío, el elemento se convierte en la raíz.
         *
         * @param unElementoHijo  El elemento a insertar.
         * @param unElementoPadre El elemento padre bajo el cual se insertará.
         * @param unaPosicion     La posición del hijo: 'I' para izquierdo, 'D' para derecho.
         * @return true si la operación fue exitosa, false en caso contrario.
         */
        public boolean insertar(Object unElementoHijo, Object unElementoPadre, char unaPosicion)
        {
                boolean exito = false;
                if (this.raiz == null) {
                        this.raiz = new NodoBinario(unElementoHijo, null, null);
                        exito = true;
                } else {
                        NodoBinario nodoPadre = obtenerNodo(this.raiz, unElementoPadre);
                        if (nodoPadre != null) {
                                if (unaPosicion == 'I' && nodoPadre.getHijoIzquierdo() == null) {
                                        nodoPadre.setHijoIzquierdo(new NodoBinario(unElementoHijo, null, null));
                                        exito = true;
                                } else if (unaPosicion == 'D' && nodoPadre.getHijoDerecho() == null) {
                                        nodoPadre.setHijoDerecho(new NodoBinario(unElementoHijo, null, null));
                                        exito = true;
                                }
                        }
                }
                return (exito);
        }
        
        /**
         * Elimina el subárbol cuya raíz contiene el elemento indicado,
         * desconectándolo de su padre.
         *
         * @param unElemento El elemento a eliminar.
         */
        public void eliminar(Object unElemento)
        {
                Object elementoPadre = padre(unElemento);
                if (elementoPadre != null) {
                        NodoBinario nodoPadre = obtenerNodo(this.raiz, elementoPadre);
                        if (nodoPadre.getHijoIzquierdo().getElemento().equals(unElemento)) {
                                nodoPadre.setHijoIzquierdo(null);
                        } else if (nodoPadre.getHijoDerecho().getElemento().equals(unElemento)) {
                                nodoPadre.setHijoDerecho(null);
                        }
                }
        }
        
        /**
         * Retorna el nodo que contiene el elemento indicado, buscando desde
         * un nodo hacia abajo.
         *
         * @param unNodo Nodo desde el cual iniciar la búsqueda.
         * @param unElemento El elemento a buscar.
         * @return El nodo que contiene el elemento buscado, o null si no se encontró.
         */
        private NodoBinario obtenerNodo(NodoBinario unNodo, Object unElemento)
        {
                NodoBinario resultado = null;
                if (unNodo != null) {
                        if (unNodo.getElemento().equals(unElemento)) {
                                // Si el nodo se ha encontrado, se guarda para devolverlo
                                resultado = unNodo;
                        } else {
                                // Busca en el hijo izquierdo
                                resultado = obtenerNodo(unNodo.getHijoIzquierdo(), unElemento);
                                // Si el nodo no se ha encontrado, busca en el hijo derecho
                                if (resultado == null)
                                        resultado = obtenerNodo(unNodo.getHijoDerecho(), unElemento);
                        }
                }
                return (resultado);
        }
        
        /**
         * Retorna el elemento padre del elemento indicado en el árbol.
         *
         * @param unElemento El elemento cuyo padre se desea encontrar.
         * @return El elemento padre, null si el árbol está vacío o el elemento es la raíz.
         */
        public Object padre(Object unElemento)
        {
                Object elementoPadre = null;
                if (!this.esVacio())
                        elementoPadre = padreAux(this.raiz, unElemento);
                return (elementoPadre);
        }
        
        /**
         * Helper de padre().
         *
         * @param unNodo Nodo desde el cual iniciar la búsqueda.
         * @param unElemento El elemento cuyo padre se desea encontrar.
         * @return El elemento padre del nodo buscado, null si no se encuentra.
         */
        private Object padreAux(NodoBinario unNodo, Object unElemento)
        {
                Object elementoPadre = null;
                if (unNodo != null) {
                        if (unElemento == null && (unNodo.getHijoIzquierdo().getElemento() == null
                                || unNodo.getHijoDerecho().getElemento() == null)) {
                                // Se encontró el padre de un nodo con elemento null buscado
                                elementoPadre = unNodo.getElemento();
                        } else if ((unNodo.getHijoIzquierdo() != null && unNodo.getHijoIzquierdo().getElemento().equals(unElemento))
                                || (unNodo.getHijoDerecho() != null && unNodo.getHijoDerecho().getElemento().equals(unElemento))) {
                                // Se encontró el padre de un nodo con el elemento buscado
                                elementoPadre = unNodo.getElemento();
                        } else {
                                // Busca en el hijo izquierdo
                                elementoPadre = padreAux(unNodo.getHijoIzquierdo(), unElemento);
                                // Si no se encontró el padre, busca en el hijo derecho
                                if (elementoPadre == null)
                                        elementoPadre = padreAux(unNodo.getHijoDerecho(), unElemento);
                        }
                }
                return (elementoPadre);
        }
        
        /**
         * Retorna la altura del árbol, definida como la cantidad de arcos
         * en el camino más largo desde la raíz hasta una hoja.
         *
         * @return La altura del árbol, -1 si está vacío.
         */
        public int altura()
        {
                return (alturaAux(this.raiz));
        }
        
        /**
         * Helper de altura().
         *
         * @param unNodo Nodo desde el cual calcular la altura.
         * @return La altura del subárbol, -1 si el nodo es null.
         */
        private int alturaAux(NodoBinario unNodo)
        {
                int contador = -1;
                if (unNodo != null) {
                        int contadorHI = alturaAux(unNodo.getHijoIzquierdo()) + 1;
                        int contadorHD = alturaAux(unNodo.getHijoDerecho()) + 1;
                        contador = Math.max(contadorHI, contadorHD);
                }
                return (contador);
        }
        
        /**
         * Retorna el nivel del elemento indicado en el árbol,
         * siendo 0 el nivel de la raíz.
         *
         * @param unElemento El elemento cuyo nivel se desea conocer.
         * @return El nivel del elemento, -1 si no se encuentra.
         */
        public int nivel(Object unElemento)
        {
                return (nivelAux(this.raiz, unElemento));
        }
        
        /**
         * Helper de nivel().
         *
         * @param unNodo     Nodo desde el cual iniciar la búsqueda.
         * @param unElemento El elemento cuyo nivel se desea conocer.
         * @return El nivel del elemento dentro del subárbol, -1 si no se encuentra.
         */
        private int nivelAux(NodoBinario unNodo, Object unElemento)
        {
                int nivel = -1;
                if (unNodo != null) {
                        if (unElemento == null && unNodo.getElemento() == null) {
                                // Se encontró el nodo con elemento null
                                nivel = 0;
                        } else if (unNodo.getElemento() != null && unNodo.getElemento().equals(unElemento)) {
                                // Se encontró el nodo con el elemento buscado
                                nivel = 0;
                        } else {
                                // Busca en el hijo izquierdo
                                nivel = nivelAux(unNodo.getHijoIzquierdo(), unElemento);
                                // Si no se encontró el nodo, busca en el hijo derecho
                                if (nivel == -1)
                                        nivel = nivelAux(unNodo.getHijoDerecho(), unElemento);
                                if (nivel >= 0)
                                        nivel++;
                        }
                }
                return (nivel);
        }
        
        /**
         * Verifica si el árbol está vacío, sin elementos.
         *
         * @return true si el árbol no contiene elementos, false en caso contrario.
         */
        public boolean esVacio()
        {
                return (this.raiz == null);
        }
        
        /**
         * Vacía completamente el árbol, estableciendo su raíz en null.
         */
        public void vaciar()
        {
                this.raiz = null;
        }
        
        /**
         * Genera una lista con los elementos del árbol en recorrido preorden
         * (raíz, hijo izquierdo, hijo derecho).
         *
         * @return Una lista con los elementos en preorden.
         */
        public Lista listarPreorden()
        {
                Lista listaPreorden = new Lista();
                if (this.raiz != null)
                        listarPreordenAux(this.raiz, listaPreorden);
                return (listaPreorden);
        }
        
        /**
         * Helper de listarPreorden().
         *
         * @param unNodo   Nodo desde el cual iniciar el recorrido.
         * @param unaLista Lista en la que se almacenarán los elementos.
         */
        private void listarPreordenAux(NodoBinario unNodo, Lista unaLista)
        {
                if (unNodo != null) {
                        unaLista.insertar(unNodo.getElemento(), unaLista.longitud() + 1);
                        listarPreordenAux(unNodo.getHijoIzquierdo(), unaLista);
                        listarPreordenAux(unNodo.getHijoDerecho(), unaLista);
                }
        }
        
        /**
         * Genera una lista con los elementos del árbol en recorrido inorden
         * (hijo izquierdo, raíz, hijo derecho).
         *
         * @return Una lista con los elementos en inorden.
         */
        public Lista listarInorden()
        {
                Lista listaInorden = new Lista();
                if (this.raiz != null)
                        listarInordenAux(this.raiz, listaInorden);
                return (listaInorden);
        }
        
        /**
         * Helper de listarInorden().
         *
         * @param unNodo   Nodo desde el cual iniciar el recorrido.
         * @param unaLista Lista en la que se almacenarán los elementos.
         */
        public void listarInordenAux(NodoBinario unNodo, Lista unaLista)
        {
                if (unNodo != null) {
                        listarInordenAux(unNodo.getHijoIzquierdo(), unaLista);
                        unaLista.insertar(unNodo.getElemento(), unaLista.longitud() + 1);
                        listarInordenAux(unNodo.getHijoDerecho(), unaLista);
                }
        }
        
        /**
         * Genera una lista con los elementos del árbol en recorrido posorden
         * (hijo izquierdo, hijo derecho, raíz).
         *
         * @return Una lista con los elementos en posorden.
         */
        public Lista listarPosorden()
        {
                Lista listaPosorden = new Lista();
                if (this.raiz != null)
                        listarPosordenAux(this.raiz, listaPosorden);
                return (listaPosorden);
        }
        
        /**
         * Helper de listarPosorden().
         *
         * @param unNodo   Nodo desde el cual iniciar el recorrido.
         * @param unaLista Lista en la que se almacenarán los elementos.
         */
        private void listarPosordenAux(NodoBinario unNodo, Lista unaLista)
        {
                if (unNodo != null) {
                        listarPosordenAux(unNodo.getHijoIzquierdo(), unaLista);
                        listarPosordenAux(unNodo.getHijoDerecho(), unaLista);
                        unaLista.insertar(unNodo.getElemento(), unaLista.longitud() + 1);
                }
        }
        
        /**
         * Genera una lista con los elementos del árbol recorridos por niveles
         * (de arriba hacia abajo, de izquierda a derecha).
         *
         * @return Una lista con los elementos ordenados por niveles.
         */
        public Lista listarPorNiveles()
        {
                Lista listaNiveles = new Lista();
                if (this.raiz != null) {
                        Cola cola = new Cola();
                        cola.poner(this.raiz);
                        while (!cola.esVacia()) {
                                NodoBinario nodoActual = (NodoBinario) cola.obtenerFrente();
                                listaNiveles.insertar(nodoActual.getElemento(), listaNiveles.longitud() + 1);
                                cola.sacar();
                                if (nodoActual.getHijoIzquierdo() != null)
                                        cola.poner(nodoActual.getHijoIzquierdo());
                                if (nodoActual.getHijoDerecho() != null)
                                        cola.poner(nodoActual.getHijoDerecho());
                        }
                }
                return (listaNiveles);
        }
        
        /**
         * Retorna una copia exacta de los datos en la estructura original y
         * respetando la jerarquía de los mismos, en otra estructura del mismo tipo.
         *
         * @return Un clon del árbol original (como la oveja Dolly).
         */
        @Override
        public ArbolBinario clone()
        {
                ArbolBinario dolly = new ArbolBinario();
                if (this.raiz != null)
                        cloneAux(this.raiz, dolly.raiz);
                return (dolly);
        }
        
        /**
         * Helper de clone().
         *
         * @param unNodo      Nodo que recorrerá la estructura original.
         * @param unNodoDolly Nodo correspondiente en la estructura clonada.
         */
        private void cloneAux(NodoBinario unNodo, NodoBinario unNodoDolly)
        {
                if (unNodo != null) {
                        unNodoDolly.setElemento(unNodo.getElemento());
                        cloneAux(unNodo.getHijoIzquierdo(), unNodoDolly.getHijoIzquierdo());
                        cloneAux(unNodo.getHijoDerecho(), unNodoDolly.getHijoDerecho());
                }
        }
        
        /**
         * Genera una cadena de caracteres formada por todos los nodos del árbol,
         * mostrando para cada uno su elemento, hijo izquierdo e hijo derecho.
         *
         * @return Cadena con los nodos del árbol.
         */
        @Override
        public String toString()
        {
                StringBuilder arbolString = new StringBuilder("[");
                if (this.raiz != null)
                        toStringAux(this.raiz, arbolString);
                return (arbolString.append("]").toString());
        }
        
        /**
         * Helper de toString().
         *
         * @param unNodo   Nodo que recorrerá la estructura.
         * @param unString Cadena en la que se escribirán los nodos encontrados.
         */
        private void toStringAux(NodoBinario unNodo, StringBuilder unString)
        {
                if (unNodo != null) {
                        unString.append("[ ")
                                .append(unNodo.getElemento())
                                .append(" | HI: ")
                                .append(unNodo.getHijoIzquierdo() != null ? unNodo.getHijoIzquierdo().getElemento() : "null")
                                .append(" | HD: ")
                                .append(unNodo.getHijoDerecho() != null ? unNodo.getHijoDerecho().getElemento() : "null")
                                .append(" ]");
                        toStringAux(unNodo.getHijoIzquierdo(), unString);
                        toStringAux(unNodo.getHijoDerecho(), unString);
                }
        }
        
        /*
         * Métodos correspondientes a ejercicios del apunte o parciales.
         */
        
        /**
         * Genera una lista con todos los elementos almacenados en las hojas
         * del árbol listadas de izquierda a derecha.
         *
         * @return Una lista
         */
        public Lista frontera()
        {
                Lista listaFrontera = new Lista();
                if (this.raiz != null)
                        fronteraAux(this.raiz, listaFrontera);
                return (listaFrontera);
        }
        
        /**
         * Helper de frontera().
         *
         * @param unNodo Nodo desde el cual iniciar el recorrido.
         * @param unaLista Lista en la que se almacenarán los elementos de las hojas.
         */
        private void fronteraAux(NodoBinario unNodo, Lista unaLista)
        {
                if (unNodo != null) {
                        if (unNodo.getHijoIzquierdo() == null && unNodo.getHijoDerecho() == null) {
                                unaLista.insertar(unNodo.getElemento(), 1);
                        } else {
                                fronteraAux(unNodo.getHijoDerecho(), unaLista);
                                fronteraAux(unNodo.getHijoIzquierdo(), unaLista);
                        }
                }
        }
        
        /**
         * Genera una lista con todos los ancestros del elemento pasado por
         * parámetro (si el elemento no está, devuelve la lista vacía).
         *
         * @param unElemento El elemento cuyos ancestros se desean obtener.
         * @return Una lista con los ancestros del elemento, del más cercano al más lejano.
         */
        public Lista obtenerAncestros(Object unElemento)
        {
                Lista listaAncestros = new Lista();
                if (this.raiz != null)
                        obtenerAncestrosAux(this.raiz, unElemento, listaAncestros);
                return (listaAncestros);
        }
        
        /**
         * Helper de obtenerAncestros().
         * Nótese cómo se inserta siempre en la primera posición para aprovechar
         * que el recorrido inverso nos dejará así una lista en orden.
         *
         * @param unNodo     Nodo desde el cual iniciar la búsqueda.
         * @param unElemento El elemento cuyos ancestros se desean obtener.
         * @param unaLista   Lista en la que se almacenarán los ancestros encontrados.
         * @return true si el elemento fue encontrado en el subárbol, false en caso contrario.
         */
        private boolean obtenerAncestrosAux(NodoBinario unNodo, Object unElemento, Lista unaLista)
        {
                boolean encontrado = false;
                if (unNodo != null) {
                        if (unNodo.getElemento() != null && unNodo.getElemento().equals(unElemento)) {
                                // Se encontró el elemento
                                encontrado = true;
                        } else {
                                // Busca en el hijo izquierdo y almacena el retorno
                                encontrado = obtenerAncestrosAux(unNodo.getHijoIzquierdo(), unElemento, unaLista);
                                if (encontrado) {
                                        // Si se encontró, se inserta el elemento del nodo actual
                                        unaLista.insertar(unNodo.getElemento(), 1);
                                } else {
                                        // Busca en el hijo derecho y almacena el retorno
                                        encontrado = obtenerAncestrosAux(unNodo.getHijoDerecho(), unElemento, unaLista);
                                        if (encontrado) {
                                                // Si se encontró, se inserta el elemento del nodo actual
                                                unaLista.insertar(unNodo.getElemento(), 1);
                                        }
                                }
                        }
                }
                return (encontrado);
        }
        
        /**
         * Genera una lista con todos los descendientes del elemento indicado
         * (si el elemento no está, devuelve la lista vacía).
         *
         * @param unElemento El elemento cuyos descendientes se desean obtener.
         * @return Una lista con los descendientes del elemento en inorden.
         */
        public Lista obtenerDescendientes(Object unElemento)
        {
                Lista listaDescendientes = new Lista();
                if (this.raiz != null)
                        obtenerDescendientesAux(this.raiz, unElemento, listaDescendientes);
                return (listaDescendientes);
        }
        
        /**
         * Helper de obtenerDescendientes().
         *
         * @param unNodo Nodo desde el cual iniciar la búsqueda.
         * @param unElemento El elemento cuyos descendientes se desean obtener.
         * @param unaLista Lista en la que se almacenarán los descendientes encontrados.
         */
        private void obtenerDescendientesAux(NodoBinario unNodo, Object unElemento, Lista unaLista)
        {
                if (unNodo != null) {
                        if (unNodo.getElemento() != null && unNodo.getElemento().equals(unElemento)) {
                                listarInordenAux(unNodo, unaLista);
                        } else {
                                obtenerDescendientesAux(unNodo.getHijoIzquierdo(), unElemento, unaLista);
                                obtenerDescendientesAux(unNodo.getHijoDerecho(), unElemento, unaLista);
                        }
                }
        }
        
        /**
         * Recibe por parámetro una lista y determina si dicha lista coincide
         * exactamente con al menos un camino del árbol que comience en la raíz
         * y termine en una hoja.
         *
         * @param unaLista La lista que representa el patrón a verificar.
         * @return true si la lista coincide con algún camino raíz-hoja, false en caso contrario.
         */
        public boolean verificarPatron(Lista unaLista)
        {
                //TODO
                return false;
        }
        
        /**
         * Genera una lista de elementos que es el camino que comienza en la raíz
         * y termina en la hoja más lejana.
         * Es una modificación de altura() que en lugar de solo incrementar un
         * contador, almacena el último nodo con el que incrementó.
         *
         * @return Una lista con los elementos del camino más largo desde la raíz.
         */
        public Lista listaQueJustificaLaAltura()
        {
                int[] altura = new int[1];
                Lista listaAltura = new Lista();
                if (this.raiz != null)
                        listaQueJustificaLaAlturaAux(this.raiz, listaAltura);
                return (listaAltura);
        }
        
        /**
         * Helper de listaQueJustificaLaAltura().
         *
         * @param unNodo Nodo desde el cual calcular el camino más largo.
         * @param unaLista Lista en la que se almacenará el camino más largo encontrado.
         * @return La altura del subárbol analizado.
         */
        private int listaQueJustificaLaAlturaAux(NodoBinario unNodo, Lista unaLista)
        {
                int contador = -1;
                if (unNodo != null) {
                        Lista listaHI = new Lista();
                        Lista listaHD = new Lista();
                        int contadorHI = listaQueJustificaLaAlturaAux(unNodo.getHijoIzquierdo(), listaHI) + 1;
                        int contadorHD = listaQueJustificaLaAlturaAux(unNodo.getHijoDerecho(), listaHD) + 1;
                        // Se guarda la lista del camino más largo
                        Lista caminoMasLargo = (contadorHI >= contadorHD)? listaHI: listaHD;
                        // Se actualiza el contador con la cuenta mas alta
                        contador = Math.max(contadorHI, contadorHD);
                        // Se insertan los elementos del camino más largo en la lista
                        for (int i = 1; i < caminoMasLargo.longitud(); i++) {
                                unaLista.insertar(caminoMasLargo.recuperar(i), unaLista.longitud() + 1);
                        }
                        // Se inserta el elemento del nodo actual en la lista
                        unaLista.insertar(unNodo.getElemento(), 1);
                }
                return (contador);
        }
        
        /**
         * Verifica si un elemento aparece por lo menos 2 veces en el árbol.
         *
         * @param unElemento El elemento a buscar.
         * @return true si el elemento aparece más de una vez, false en caso contrario.
         */
        public boolean estaRepetido(Object unElemento)
        {
                int[] contador = new int[1];
                estaRepetidoAux(this.raiz, unElemento, contador);
                return (contador[0] > 1);
        }
        
        /**
         * Helper de estaRepetido().
         * Detiene la búsqueda en cuanto el contador alcanza 2.
         *
         * @param unNodo Nodo desde el cual iniciar la búsqueda.
         * @param unElemento El elemento a contar.
         * @param unContador Arreglo de un elemento que actúa como contador compartido.
         */
        private void estaRepetidoAux(NodoBinario unNodo, Object unElemento, int[] unContador)
        {
                if (unNodo != null && unContador[0] < 2) {
                        if (unNodo.getElemento() != null && unNodo.getElemento().equals(unElemento)) {
                                unContador[0]++;
                        }
                        if (unContador[0] < 2)
                                estaRepetidoAux(unNodo.getHijoIzquierdo(), unElemento, unContador);
                        if (unContador[0] < 2)
                                estaRepetidoAux(unNodo.getHijoDerecho(), unElemento, unContador);
                }
        }
        
        /**
         * Busca un número en el árbol y en caso de encontrarlo, retorna una lista
         * con los elementos del subárbol recorrido en inorden.
         *
         * @param unNumero El número a buscar en el árbol.
         * @return Una lista con los descendientes del número encontrado en inorden.
         */
        public Lista armarListaInorden(int unNumero)
        {
                return (obtenerDescendientes(unNumero));
        }
}

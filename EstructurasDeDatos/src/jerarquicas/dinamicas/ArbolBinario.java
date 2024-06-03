package jerarquicas.dinamicas;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;

/**
 * Implementación del TDA Árbol Binario.
 * 
 * @author santino.fuentes
 * @version 1.0
 */
public class ArbolBinario
{
        private NodoBinario raiz;
        
        public ArbolBinario()
        {
                this.raiz = null;
        }
        
        public boolean insertar(Object unElemento, Object elementoPadre, char unaPosicion)
        {
                boolean exito = false;
                if (this.raiz == null) {
                        // Si el árbol está vacío, insertar unElemento como raíz
                        this.raiz = new NodoBinario(unElemento, null, null);
                } else {
                        // Sino, intentar insertar unElemento en unaPosicion del
                        // nodo que posea el elementoPadre, buscando en preorden
                        exito = insertarRecursivo(this.raiz, unElemento, elementoPadre, unaPosicion);
                }
                return (exito);
        }
        
        private boolean insertarRecursivo(NodoBinario raizSubArbol, Object elementoHijo, Object elementoPadre, char unaPosicion)
        {
                boolean exito = false;
                if (raizSubArbol.getElemento().equals(elementoPadre)) {
                        // Si el elemento en la raíz del subárbol coincide con
                        // el elemento padre y la posición a insertar está
                        // libre, insertar el elemento como hijo del subárbol
                        if (unaPosicion == 'I' && raizSubArbol.getIzquierdo() == null) {
                                raizSubArbol.setIzquierdo(new NodoBinario(elementoHijo, null, null));
                                exito = true;
                        } else if (unaPosicion == 'D' && raizSubArbol.getDerecho() == null) {
                                raizSubArbol.setDerecho(new NodoBinario(elementoHijo, null, null));
                                exito = true;
                        }
                } else {
                        // Si el elemento en la raíz del subárbol no coincide con
                        // el elemento padre, continuar la búsqueda en preorden
                        if (raizSubArbol.getIzquierdo() != null) {
                                exito = insertarRecursivo(raizSubArbol.getIzquierdo(), elementoHijo, elementoPadre, unaPosicion);
                        }
                        if (raizSubArbol.getDerecho() != null) {
                                exito = insertarRecursivo(raizSubArbol.getDerecho(), elementoHijo, elementoPadre, unaPosicion);
                        }
                }
                return (exito);
        }
        
        public boolean esVacio()
        {
                return (this.raiz == null);
        }
        
        public void vaciar()
        {
                this.raiz = null;
        }
        
        public Object padre(Object unElemento)
        {
                //TODO
        }
        
        public int altura()
        {
                //TODO
        }
        
        public int nivel(Object unElemento)
        {
                //TODO
        }
        
        public ArbolBinario clonar()
        {
                //TODO
        }
        
        public Lista listarPreorden()
        {
                Lista listaElementos = new Lista();
                listarPreordenRecursivo(this.raiz, listaElementos);
                return (listaElementos);
        }
        
        private void listarPreordenRecursivo(NodoBinario raizSubarbol, Lista unaLista)
        {
                if (raizSubarbol != null) {
                        // Agregar el elemento del nodo actual a la lista
                        unaLista.insertar(raizSubarbol.getElemento(), unaLista.longitud() + 1);
                        // Recorrer al subárbol izquierdo
                        listarPreordenRecursivo(raizSubarbol.getIzquierdo(), unaLista);
                        // Recorrer al subárbol derecho
                        listarPreordenRecursivo(raizSubarbol.getDerecho(), unaLista);
                }
        }

        public Lista listarInorden()
        {
                Lista listaElementos = new Lista();
                listarInordenRecursivo(this.raiz, listaElementos);
                return (listaElementos);
        }

        private void listarInordenRecursivo(NodoBinario raizSubarbol, Lista unaLista)
        {
                if (raizSubarbol != null) {
                        // Recorrer al subárbol izquierdo
                        listarInordenRecursivo(raizSubarbol.getIzquierdo(), unaLista);
                        // Agregar el elemento del nodo actual a la lista
                        unaLista.insertar(raizSubarbol.getElemento(), unaLista.longitud() + 1);
                        // Recorrer al subárbol derecho
                        listarInordenRecursivo(raizSubarbol.getDerecho(), unaLista);
                }
        }
        
        public Lista listarPostorden()
        {
                Lista listaElementos = new Lista();
                listarPostordenRecursivo(this.raiz, listaElementos);
                return (listaElementos);
        }
        
        public void listarPostordenRecursivo(NodoBinario raizSubarbol, Lista unaLista)
        {
                if (raizSubarbol != null) {
                        // Recorrer el subárbol izquierdo
                        listarPostordenRecursivo(raizSubarbol.getIzquierdo(), unaLista);
                        // Recorrer el subárbol derecho
                        listarPostordenRecursivo(raizSubarbol.getDerecho(), unaLista);
                        // Agregar el elemento del nodo actual a la lista
                        unaLista.insertar(raizSubarbol.getElemento(), unaLista.longitud() + 1);
                }
        }
        
        public Lista listarPorNiveles()
        {
                // Cola para almacenar los nodos
                Cola colaNodos = new Cola();
                // Lista para almacenar los elementos de los nodos
                Lista listaElementos = new Lista();
                // Iniciar con la raíz del árbol
                colaNodos.poner(this.raiz);
                while (!colaNodos.esVacia()) {
                        // Almacenar individualmente el nodo del frente de la cola
                        NodoBinario nodoActual = (NodoBinario) colaNodos.obtenerFrente();
                        // Almacenar en la lista el elemento del nodo
                        listaElementos.insertar(nodoActual.getElemento(), listaElementos.longitud() + 1);
                        // Sacar el nodo del frente de la cola
                        colaNodos.sacar();
                        // Si el nodo tiene hijos, ponerlos en la cola
                        if (nodoActual.getIzquierdo() != null)
                                colaNodos.poner(nodoActual.getIzquierdo());
                        if (nodoActual.getDerecho() != null)
                                colaNodos.poner(nodoActual.getDerecho());
                }
                return (listaElementos);
        }
        
        @Override
        public String toString()
        {
                //TODO
        }
}

package jerarquicas.dinamicas;

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
        
        public boolean vaciar()
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
        
        public Lista listarInorden()
        {
                Lista listaElementos = new Lista();
                listarInOrdenRecursivo(this.raiz, listaElementos);
                return (listaElementos);
        }

        private void listarInordenRecursivo(NodoBinario raizSubarbol, Lista unaLista)
        {
                if (raizSubarbol != null) {
                        // Agregar el elemento del nodo actual a la lista
                        unaLista.insertar(raizSubarbol.getElemento(), unaLista.longitud() + 1);
                        // Recorrer a sus hijos en inorden
                        listarInOrdenRecursivo(raizSubarbol.getIzquierdo(), unaLista);
                        listarInOrdenRecursivo(raizSubarbol.getDerecho(), unaLista);

        }
        
        public Lista listarPreorden()
        {
                Lista listaElementos = new Lista();
                listarPreOrdenRecursivo(this.raiz, listaElementos);
                return (listaElementos);
        }
        
        private void listarPreordenRecursivo(NodoBinario raizSubarbol, Lista unaLista)
        {
                //FIXME
                if (raizSubarbol != null) {
                        // Agregar el elemento del nodo actual a la lista
                        unaLista.insertar(raizSubArbol.getElemento(), unaLista.longitud() + 1);
                        // Recorrer a sus hijos en preorden
                        listarPreordenRecursivo(raizSubarbol.getIzquierdo(), unaLista);
                        listarPreordenRecursivo(raizSubarbol.getDerecho(), unaLista);
                }
        }

        public Lista listarPostorden()
        {
                //TODO
        }
        
        public Lista listarPorNiveles()
        {
                //TODO
        }
        
        @Override
        public String toString()
        {
                //TODO
        }
}

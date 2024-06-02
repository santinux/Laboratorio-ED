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
                        // Si el árbol está vacío, insertar el elemento como raíz
                        this.raiz = new NodoBinario(unElemento, null, null);
                } else {
                        // Sino, insertarlo bajo su padre, buscando en preorden
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
                        }
                        if (unaPosicion == 'D' && raizSubArbol.getDerecho() == null) {
                                raizSubArbol.setDerecho(new NodoBinario(elementoHijo, null, null));
                                exito = true;
                        }
                } else {
                        // Si el elemento en la raíz del subárbol no coincide con
                        // el elemento padre, continuar la búsqueda en preorden
                        if (raizSubArbol.getIzquierdo() != null) {
                                exito = insertarRecursivo(raizSubArbol.getIzquierdo(), elementoHijo, elementoPadre, unaPosicion);
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
                //TODO
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
                //TODO
        }
        
        public Lista listarPreorden()
        {
                //TODO
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

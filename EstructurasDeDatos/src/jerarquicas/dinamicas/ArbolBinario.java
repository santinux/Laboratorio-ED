package jerarquicas.dinamicas;

/**
 * Implementación del TDA Árbol Binario.
 * @author santino.fuentes
 * @version 1.0
 */
public class ArbolBinario
{
        private NodoArbol raiz;
        
        public ArbolBinario()
        {
                this.raiz = null;
        }
        
        public boolean insertar(Object unElemento, Object elementoPadre, char unaPosicion)
        {
                boolean exito = false;
                if (this.raiz == null) {
                        // Si el árbol está vacío, insertar el elemento como raíz
                        this.raiz = new NodoArbol(unElemento, null, null);
                } else {
                        // Sino, insertarlo bajo su padre, buscando en preorden
                        exito = insertarRecursivo(this.raiz, unElemento, elementoPadre, unaPosicion);
                }
                return (exito);
        }
        
        private boolean insertarRecursivo(NodoArbol raizSubArbol, Object elementoHijo, Object elementoPadre, char unaPosicion)
        {
                boolean exito = false;
                if (raizSubArbol.getElemento().equals(elementoPadre)) {
                        // Si el elemento en la raíz del subárbol coincide con
                        // el elemento padre y la posición a insertar está
                        // libre, insertar el elemento como hijo del subárbol
                        if (unaPosicion == 'I' && raizSubArbol.getIzquierdo() == null) {
                                raizSubArbol.setIzquierdo(new NodoArbol(elementoHijo, null, null));
                                exito = true;
                        }
                        if (unaPosicion == 'D' && raizSubArbol.getDerecho() == null) {
                                raizSubArbol.setDerecho(new NodoArbol(elementoHijo, null, null));
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
}

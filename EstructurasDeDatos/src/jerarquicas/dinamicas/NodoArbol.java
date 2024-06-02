package jerarquicas.dinamicas;

/**
 * Implementación del TDA Nodo para Árbol Binario.
 * 
 * @author santino.fuentes
 * @version 1.0
 */
public class NodoArbol
{
        private Object elemento;
        private NodoArbol izquierdo;
        private NodoArbol derecho;
        
        /**
         * Crea un nodo de árbol.
         * 
         * @param unElemento
         * @param izq
         * @param der
         */
        public NodoArbol(Object unElemento, NodoArbol izq, NodoArbol der)
        {
                this.elemento = unElemento;
                this.izquierdo = izq;
                this.derecho = der;
        }
        
        /**
         * Devuelve el elemento almacenado en el nodo.
         * 
         * @return El elemento
         */
        public Object getElemento()
        {
                return (this.elemento);
        }
        
        /**
         * Devuelve el nodo izquierdo.
         * 
         * @return El nodo
         */
        public NodoArbol getIzquierdo()
        {
                return (this.izquierdo);
        }
        
        /**
         * Devuelve el nodo derecho.
         * 
         * @return El nodo
         */
        public NodoArbol getDerecho()
        {
                return (this.derecho);
        }
        
        /**
         * Modifica el elemento almacenado.
         * 
         * @param unElemento
         */
        public void setElemento(Object unElemento)
        {
                this.elemento = unElemento;
        }
        
        /**
         * Modifica el nodo izquierdo.
         * 
         * @param unNodo
         */
        public void setIzquierdo(NodoArbol unNodo)
        {
                this.izquierdo = unNodo;
        }
        
        /**
         * Modifica el nodo derecho.
         * 
         * @param unNodo
         */
        public void setDerecho(NodoArbol unNodo)
        {
                this.derecho = unNodo;
        }
}

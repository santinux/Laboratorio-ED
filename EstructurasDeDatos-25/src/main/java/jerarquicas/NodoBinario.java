package jerarquicas;

/**
 * Implementación de nodo para Árbol Binario.
 * 
 * @author santinux
 * @version 1.0
 */
public class NodoArbol
{
        private Object elemento;
        private NodoArbol hijoIzquierdo;
        private NodoArbol hijoDerecho;
        
        public NodoArbol(Object unElemento, NodoArbol unHijoIzqierdo, NodoArbol unHijoDerecho)
        {
                this.elemento = unElemento;
                this.hijoIzquierdo = unHijoIzqierdo;
                this.hijoDerecho = unHijoDerecho;
        }
        
        public Object getElem()
        {
                return this.elemento;
        }
        
        public NodoArbol getIzquierdo()
        {
                return this.hijoIzquierdo;
        }
        
        public NodoArbol getDerecho()
        {
                return this.hijoDerecho;
        }
        
        public void setElemento(Object unElemento)
        {
                this.elemento = unElemento;
        }
        
        public void setIzquierdo(NodoArbol unHijoIzquierdo)
        {
                this.hijoIzquierdo = unHijoIzquierdo;
        }
        
        public void setDerecho(NodoArbol unHijoDerecho)
        {
                this.hijoDerecho = unHijoDerecho;
        }
}

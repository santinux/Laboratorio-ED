package lineales.dinamicas;

/**
 * Implementación del TDA Nodo
 * @author santino.fuentes
 * @version 2.0
 */
public class Nodo {
        private Object elem;
        private Nodo enlace;
        
        /**
         * Crea y devuelve un nodo.
         * @param unElemento
         * @param unEnlace
         */
        public Nodo(Object unElemento, Nodo unEnlace)
        {
                this.elem = unElemento;
                this.enlace = unEnlace;
        }
        
        /**
         * Modifica el elemento del nodo.
         * @param unElemento
         */
        public void setElem(Object unElemento)
        {
                this.elem = unElemento;
        }
        
        /**
         * Modifica el enlace del nodo.
         * @param unEnlace
         */
        public void setEnlace(Nodo unEnlace)
        {
                this.enlace = unEnlace;
        }
        
        /**
         * Devuelve el elemento del nodo.
         * @return Object
         */
        public Object getElem()
        {
                return (this.elem);
        }
        
        /**
         * Devuelve el nodo enlace del nodo.
         * @return Nodo
         */
        public Nodo getEnlace()
        {
                return (this.enlace);
        }
}

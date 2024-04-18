package lineales.dinamicas;

/**
 * Implementación del TDA Nodo
 * @author santino.fuentes
 * @version 1.0
 */
public class Lista {
        private Nodo cabecera;
        
        /**
         * Crea una lista vacía.
         */
        public Lista()
        {
                this.cabecera = null;
        }
        
        /**
         * Agrega un elemento en una posición.
         * @param unElemento
         * @param unaPosicion
         * @return Si pudo o no insertar en la posición dada.
         */
        public boolean insertar(Object unElemento, int unaPosicion)
        {
                boolean exito = true;
                if (unaPosicion < 1 || unaPosicion > this.longitud() + 1) {
                        exito = false;
                } else {
                        if (unaPosicion == 1) {
                                this.cabecera = new Nodo(unElemento, this.cabecera);
                        } else {
                                Nodo aux = this.cabecera;
                                int i = 1;
                                while (i < unaPosicion - 1) {
                                        aux = aux.getEnlace();
                                }
                        }
                }
        }
        
        public boolean eliminar(int unaPosicion)
        {
                //TODO
        }
        
        public Object recuperar(int unaPosicion)
        {
                //TODO
        }
        
        public int localizar(Object unElemento)
        {
                //TODO
        }
        
        public int longitud()
        {
                //TODO
        }
        
        public boolean esVacia()
        {
                //TODO
        }
        
        public void vaciar()
        {
                //TODO
        }
        
        public Lista clonar()
        {
                //TODO
        }
        
        @Override
        public String toString()
        {
                //TODO
        }
}

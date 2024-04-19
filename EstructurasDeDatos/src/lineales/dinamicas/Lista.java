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
                // Verifica que la posición a insertar sea válida
                if (unaPosicion < 1 || unaPosicion > this.longitud() + 1) {
                        exito = false;
                } else {
                        if (unaPosicion == 1) {
                                // Crea el nodo y lo enlaza
                                this.cabecera = new Nodo(unElemento, this.cabecera);
                        } else {
                                // Crea un nodo auxiliar para recorrer la lista
                                Nodo aux = this.cabecera;
                                int i = 1;
                                // Recorre hasta la posición anterior a la deseada
                                while (i < unaPosicion - 1) {
                                        aux = aux.getEnlace();
                                        i++;
                                }
                                // Crea el nodo y lo enlaza
                                Nodo nuevo = new Nodo(unElemento, aux.getEnlace());
                                aux.setEnlace(nuevo);
                        }
                }
                return (exito);
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

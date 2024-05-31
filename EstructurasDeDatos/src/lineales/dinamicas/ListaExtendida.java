package lineales.dinamicas;

/**
 * Implementación de métodos extra del TDA Lista.
 * 
 * @author santino.fuentes
 */
public class ListaExtendida extends Lista
{
        private Nodo kabecera = this.getCabecera();
        /**
         * Parcial 1, Ejercicio 1-a.
         * @return Una lista nueva con todos los elementos de las posiciones
         * múltiplos de num, en el mismo orden encontrado
         */
        public Lista obtenerMultiplos(int num)
        {
                Lista multiplos = new Lista();
                if (this.kabecera != null) {
                        obtenerMultiplosRecursivo(this.kabecera, multiplos.kabecera, num, 1);
                }
                return (multiplos);
        }
//        private void obtenerMultiplosRecursivo(Nodo unNodo, Lista losMultiplos, int unNum, int unaPosicion)
//        {
//                if (unNodo != null) {
//                        // Mientras no se llegue al final de la lista
//                        if (unaPosicion % unNum == 0) {
//                                // Si la posición es múltiplo del número, agregar
//                                // su elemento a la nueva lista
//                                losMultiplos.insertar(unNodo.getElem(), losMultiplos.longitud() + 1);
//                                obtenerMultiplosRecursivo(unNodo.getEnlace(), losMultiplos, unNum, unaPosicion + 1);
//                        } else {
//                                obtenerMultiplosRecursivo(unNodo.getEnlace(), losMultiplos, unNum, unaPosicion + 1);
//                        }
//                }
//        }
        private void obtenerMultiplosRecursivo(Nodo unNodo, Nodo unNodoMultiplo, int unNum, int unaPosicion)
        {
                if (unNodo != null) {
                        // Mientras no se llegue al final de la lista
                        if (unaPosicion % unNum == 0) {
                                // Si la posición es múltiplo del número, agregar
                                // su elemento a la nueva lista
                                unNodoMultiplo.setEnlace(new Nodo(unNodo.getElem(), null));
                                obtenerMultiplosRecursivo(unNodo.getEnlace(), unNodoMultiplo, unNum, unaPosicion + 1);
                        } else {
                                obtenerMultiplosRecursivo(unNodo.getEnlace(), unNodoMultiplo, unNum, unaPosicion + 1);
                        }
                }
        }
}

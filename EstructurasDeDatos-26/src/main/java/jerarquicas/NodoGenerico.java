package jerarquicas;

/**
 *
 *
 * @author <a href="https://www.github.com/santinux">Santino Fuentes</a>
 * @version
 */
public class NodoGenerico
{
        private Object elemento;
        private NodoGenerico hijoIzquierdo;
        private NodoGenerico hermanoDerecho;
        
        public NodoGenerico(Object unElemento, NodoGenerico unHijoIzquierdo,
                NodoGenerico unHermanoDerecho)
        {
                this.elemento = unElemento;
                this.hijoIzquierdo = unHijoIzquierdo;
                this.hermanoDerecho = unHermanoDerecho;
        }
        
        public Object getElemento()
        {
                return this.elemento;
        }

        public NodoGenerico getHijoIzquierdo()
        {
                return this.hijoIzquierdo;
        }

        public NodoGenerico getHermanoDerecho()
        {
                return this.hermanoDerecho;
        }

        public void setElemento(Object unElemento)
        {
                this.elemento = unElemento;
        }

        public void setHijoIzquierdo(NodoGenerico unHijoIzquierdo)
        {
                this.hijoIzquierdo = unHijoIzquierdo;
        }

        public void setHermanoDerecho(NodoGenerico unHermanoDerecho)
        {
                this.hermanoDerecho = unHermanoDerecho;
        }
}

package jerarquicas;

public class NodoGenerico
{
        private Object elemento;
        private NodoGenerico hijoIzquierdo;
        private NodoGenerico hermanoDerecho;
        
        public NodoGenerico(Object unElemento, NodoGenerico unHijoIzq, NodoGenerico unHermanoDer)
        {
                this.elemento = unElemento;
                this.hijoIzquierdo = unHijoIzq;
                this.hermanoDerecho = unHermanoDer;
        }
        
        public Object getElemento()
        {
                return (this.elemento);
        }
        
        public NodoGenerico getHijoIzquierdo()
        {
                return (this.hijoIzquierdo);
        }
        
        public NodoGenerico getHermanoDerecho()
        {
                return (this.hermanoDerecho);
        }
        
        public void setElemento(Object unElemento)
        {
                this.elemento = unElemento;
        }
        
        public void setHijoIzquierdo(NodoGenerico unNodo)
        {
                this.hijoIzquierdo = unNodo;
        }
        
        public void setHermanoDerecho(NodoGenerico unNodo)
        {
                this.hermanoDerecho = unNodo;
        }
}

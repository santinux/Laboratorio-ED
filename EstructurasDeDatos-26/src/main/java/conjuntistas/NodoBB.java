package conjuntistas;

public class NodoBB
{
    private Comparable elemento;
    private NodoBB hijoIzquierdo;
    private NodoBB hijoDerecho;

    public NodoBB(Comparable unElemento)
    {
        this.elemento = unElemento;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    public NodoBB(Comparable unElemento, NodoBB hijoIzq, NodoBB hijoDer)
    {
        this.elemento = unElemento;
        this.hijoIzquierdo = hijoIzq;
        this.hijoDerecho = hijoDer;
    }

    public Comparable getElemento()
    {
        return (this.elemento);
    }

    public NodoBB getHijoIzquierdo()
    {
        return (this.hijoIzquierdo);
    }

    public NodoBB getHijoDerecho()
    {
        return (this.hijoDerecho);
    }

    public void setElemento(Comparable unElemento)
    {
        this.elemento = unElemento;
    }

    public void setHijoIzquierdo(NodoBB unNodo)
    {
        this.hijoIzquierdo = unNodo;
    }

    public void setHijoDerecho(NodoBB unNodo)
    {
        this.hijoDerecho = unNodo;
    }
}

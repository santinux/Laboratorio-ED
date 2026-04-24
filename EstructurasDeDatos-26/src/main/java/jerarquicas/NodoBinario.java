package jerarquicas;

public class NodoBinario
{
    private Object elemento;
    private NodoBinario hijoIzquierdo;
    private NodoBinario hijoDerecho;

    public NodoBinario(Object unElemento, NodoBinario unNodoIzq, NodoBinario unNodoDer)
    {
        this.elemento = unElemento;
        this.hijoIzquierdo = unNodoIzq;
        this.hijoDerecho = unNodoDer;
    }

    public Object getElemento()
    {
        return (this.elemento);
    }

    public NodoBinario getHijoIzquierdo()
    {
        return (this.hijoIzquierdo);
    }

    public NodoBinario getHijoDerecho()
    {
        return (this.hijoDerecho);
    }

    public void setElemento(Object unElemento)
    {
        this.elemento = unElemento;
    }

    public void setHijoIzquierdo(NodoBinario unNodo)
    {
        this.hijoIzquierdo = unNodo;
    }

    public void setHijoDerecho(NodoBinario unNodo)
    {
        this.hijoDerecho = unNodo;
    }
}

public class Clan {

    private String nombre;
    private String lider;
    private int cantidadMiembros;

    public Clan(String nombre, String lider, int cantidadMiembros) {
        this.nombre = nombre;
        this.lider = lider;
        this.cantidadMiembros = cantidadMiembros;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLider() {
        return lider;
    }

    public int getCantidadMiembros() {
        return cantidadMiembros;
    }

    @Override
    public String toString() {
        return "Clan: " + nombre +
               ", Lider: " + lider +
               ", Miembros: " + cantidadMiembros;
    }
}
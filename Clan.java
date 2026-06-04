import java.util.Objects;

public class Clan {
    private String nombre;
    private String lider;
    private int numeroMiembros;

    public Clan(String nombre, String lider, int numeroMiembros) {
        this.nombre = nombre;
        this.lider = lider;
        this.numeroMiembros = numeroMiembros;

    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getLider() {
        return lider;
    }
    public void setLider(String lider) {
        this.lider = lider;
    }
    public int getNumeroMiembros() {
        return numeroMiembros;
    }
    public void setNumeroMiembros(int numeroMiembros) {
        this.numeroMiembros = numeroMiembros;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;


        if (o == null || getClass() != o.getClass()) return false;


        Clan clan = (Clan) o;
        return Objects.equals(nombre, clan.nombre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }
}

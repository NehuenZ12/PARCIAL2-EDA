import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public class GrafoClanes {
    
    public Map<Clan, List<Clan>> listaAdyacencia;

    public GrafoClanes() {
        this.listaAdyacencia = new HashMap<>();
    }

    public void agregarClan(Clan clan) {
        listaAdyacencia.putIfAbsent(clan, new ArrayList<>());
    }

    // Método para conectar dos clanes (ej. una Alianza)
    public void agregarAlianza(Clan clanA, Clan clanB) {
        agregarClan(clanA);
        agregarClan(clanB);
        
        listaAdyacencia.get(clanA).add(clanB);
        listaAdyacencia.get(clanB).add(clanA); // Alianza bidireccional

        System.out.println("Alianza agregada entre " + clanA.getNombre() + " y " + clanB.getNombre());

    }

    public void mostrarClanes() {
        for (Clan clan : listaAdyacencia.keySet()) {
            System.out.println("Clan: " + clan.getNombre() + ", Líder: " + clan.getLider() + ", Miembros: " + clan.getNumeroMiembros());
        }
    }

    public void mostrarAlianzasDelClan(Clan clan) {

        List<Clan> c = listaAdyacencia.getOrDefault(clan, new ArrayList<>());
        
        for (Clan clan2 : c) {
            System.out.println("Las alianzas del clan " + clan + " son: " + clan2.getNombre());
        }
    }


    public void mostrarAlianzas() {
        for (Map.Entry<Clan, List<Clan>> entrada : listaAdyacencia.entrySet()) {
            System.out.print("El clan " + entrada.getKey().getNombre() + " está aliado con: ");
            List<String> nombresAliados = new ArrayList<>();
            for (Clan aliado : entrada.getValue()) {
                nombresAliados.add(aliado.getNombre());
            }
            System.out.println(nombresAliados);
        }
    }

}


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class Grafo {

    private HashMap<String, Clan> clanes;
    private HashMap<String, LinkedList<String>> alianzas;

    public Grafo() {

        clanes = new HashMap<>();
        alianzas = new HashMap<>();

    }

    public void agregarClan(Clan clan) {

        if (!clanes.containsKey(clan.getNombre())) {

            clanes.put(clan.getNombre(), clan);

            alianzas.put(
                    clan.getNombre(),
                    new LinkedList<>());

        }

    }

    public boolean existeClan(String nombre) {

        return clanes.containsKey(nombre);

    }

    public void registrarClanSiNoExiste(
            String nombre,
            String lider,
            int miembros) {

        if (!existeClan(nombre)) {

            Clan clan =
                    new Clan(nombre,
                            lider,
                            miembros);

            agregarClan(clan);

        }

    }

    public void agregarAlianza(String clan1, String clan2) {

        if (!alianzas.get(clan1).contains(clan2)) {

            alianzas.get(clan1).add(clan2);

        }

        if (!alianzas.get(clan2).contains(clan1)) {

            alianzas.get(clan2).add(clan1);

        }

    }

    public void mostrarGrafo() {

        for (Map.Entry<String, LinkedList<String>> entrada
                : alianzas.entrySet()) {

            System.out.print(
                    entrada.getKey() + " -> ");

            System.out.println(
                    entrada.getValue());

        }

    }

    public void aliadosEnComun(
            String clan1,
            String clan2) {

        LinkedList<String> lista1 =
                alianzas.get(clan1);

        LinkedList<String> lista2 =
                alianzas.get(clan2);

        System.out.println(
                "Aliados en comun:");

        for (String aliado : lista1) {

            if (lista2.contains(aliado)) {

                System.out.println(aliado);

            }

        }

    }

    public void recomendarClanes(
            String clan) {

        LinkedList<String> aliados =
                alianzas.get(clan);

        HashSet<String> sugeridos =
                new HashSet<>();

        for (String aliado : aliados) {

            LinkedList<String> aliadosDelAliado =
                    alianzas.get(aliado);

            for (String posible : aliadosDelAliado) {

                if (!posible.equals(clan)
                        && !aliados.contains(posible)) {

                    sugeridos.add(posible);

                }

            }

        }

        System.out.println(
                "Clanes recomendados:");

        for (String sugerido : sugeridos) {

            System.out.println(sugerido);

        }

    }

}
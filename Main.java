import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Clan clan1 = new Clan("Clan A", "Líder A", 10);
        Clan clan2 = new Clan("Clan B", "Líder B", 15);
        Clan clan3 = new Clan("Clan C", "Líder C", 20);

        
        GrafoClanes grafo = new GrafoClanes();
        int opcion = 0;

        do{

            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar Clanes");
            System.out.println("2. Agregar Alianza");
            System.out.println("3. Mostrar Alianzas");
            System.out.println("4. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Agrege el nombre del clan: ");
                    String nombreClan = sc.nextLine();
                    System.out.println("Agrege el nombre del líder: ");
                    String nombreLider = sc.nextLine();
                    System.out.println("Agrege el número de miembros: ");
                    int numeroMiembros = sc.nextInt();
                    sc.nextLine();
                    Clan clan = new Clan(nombreClan, nombreLider, numeroMiembros);   
                    if(grafo.listaAdyacencia.containsKey(clan)){
                        System.out.println("El clan ya existe.");
                        break;
                    }
                    
                    if(grafo.listaAdyacencia.isEmpty()){

                        grafo.agregarClan(clan);
                        System.out.println("Clan agregado.");

                    }else{

                        System.out.println("------------------------------------------------");
                        System.out.println("Agregue una alianza con los clanes disponibles: ");
                        grafo.mostrarClanes();
                        System.out.println("------------------------------------------------");
                        System.out.println("Ingrese el nombre del clan con el que desea aliarse: ");

                        String nombreClanAliado = sc.nextLine();
                        Clan clanAliado = null;

                        for (Clan c : grafo.listaAdyacencia.keySet()) {
                            if (c.getNombre().equalsIgnoreCase(nombreClanAliado)) {
                                clanAliado = c;
                                break;
                            }
                        }

                        if (clanAliado == null) {
                            System.out.println("El clan aliado no existe. No se ha agregado la alianza.");
                            break;
                        }

                        grafo.agregarClan(clan);
                        grafo.agregarAlianza(clan, clanAliado); 
                        System.out.println("Clan agregado y alianza creada.");

                    }

                    break;
                case 2:

                    System.out.println("Ingrese el nombre del primer clan para la alianza: ");
                    String nombreClan1 = sc.nextLine();
                    Clan clanA = null;

                    for (Clan c : grafo.listaAdyacencia.keySet()) {
                        if (c.getNombre().equalsIgnoreCase(nombreClan1)) {
                            clanA = c;
                            break;
                        }
                    }

                    System.out.println("Ingrese el nombre del segundo clan para la alianza: ");
                    String nombreClan2 = sc.nextLine();
                    Clan clanB = null;
                    for (Clan c : grafo.listaAdyacencia.keySet()) {
                        if (c.getNombre().equalsIgnoreCase(nombreClan2)) {
                            clanB = c;
                            break;
                        }
                    }
                    System.out.println("------------------------------------------------");
                    System.out.println("Le recomendamos agregar a su coalicion a los aliados de su nuevo aliado: ");
                    grafo.mostrarAlianzasDelClan(clanB);
                    
                    grafo.agregarAlianza(clanA, clanB);
                    System.out.println("------------------------------------------------");
                    System.out.println("Alianza agregada.");
                    break;
                case 3:
                    grafo.mostrarAlianzas();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        }while(opcion != 4);
    }
}

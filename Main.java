import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Grafo grafo = new Grafo();

        Scanner teclado = new Scanner(System.in);

        int opcion;

        do {

            System.out.println("\n--- MENU ---");
            System.out.println("1. Registrar clan y alianza");
            System.out.println("2. Forjar nueva alianza");
            System.out.println("3. Buscar aliados en comun");
            System.out.println("4. Recomendar clanes");
            System.out.println("5. Mostrar grafo");
            System.out.println("0. Salir");

            System.out.print("Opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Nombre clan 1: ");
                    String nombre1 = teclado.nextLine();

                    System.out.print("Lider clan 1: ");
                    String lider1 = teclado.nextLine();

                    System.out.print("Cantidad miembros clan 1: ");
                    int miembros1 = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Nombre clan 2: ");
                    String nombre2 = teclado.nextLine();

                    System.out.print("Lider clan 2: ");
                    String lider2 = teclado.nextLine();

                    System.out.print("Cantidad miembros clan 2: ");
                    int miembros2 = teclado.nextInt();
                    teclado.nextLine();

                    grafo.registrarClanSiNoExiste(
                            nombre1,
                            lider1,
                            miembros1);

                    grafo.registrarClanSiNoExiste(
                            nombre2,
                            lider2,
                            miembros2);

                    grafo.agregarAlianza(
                            nombre1,
                            nombre2);

                    System.out.println("Alianza registrada");

                    break;

                case 2:

                    System.out.print("Primer clan: ");
                    String clanA = teclado.nextLine();

                    System.out.print("Segundo clan: ");
                    String clanB = teclado.nextLine();

                    if (grafo.existeClan(clanA)
                            && grafo.existeClan(clanB)) {

                        grafo.agregarAlianza(clanA, clanB);

                    System.out.println(
                        "Alianza creada");

                    } else {

                        System.out.println(
                            "Uno o ambos clanes no existen");

                    }

                    break;

                case 3:

                    System.out.print("Primer clan: ");
                    String clan1 = teclado.nextLine();

                    System.out.print("Segundo clan: ");
                    String clan2 = teclado.nextLine();

                    if (grafo.existeClan(clan1)
                            && grafo.existeClan(clan2)) {

                        grafo.aliadosEnComun(
                                clan1,
                                clan2);

                    } else {

                        System.out.println(
                            "Uno o ambos clanes no existen");

                    }

                    break;

                case 4:

                    System.out.print(
                        "Nombre del clan: ");

                    String clan =
                            teclado.nextLine();

                    if (grafo.existeClan(clan)) {

                        grafo.recomendarClanes(clan);

                    } else {

                        System.out.println(
                                "El clan no existe");

                    }

                    break;

                case 5:

                    grafo.mostrarGrafo();

                    break;

                case 0:

                    System.out.println("Fin del programa");

                    break;

                default:

                    System.out.println("Opcion invalida");

            }

        } while (opcion != 0);

        teclado.close();

    }

}
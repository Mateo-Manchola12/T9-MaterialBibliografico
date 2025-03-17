package app.views;

public class Menu {
    public static int showMenu() {
        String[] options = {
                "Agregar Material",
                "Mostrar Materiales",
                "Prestar Material",
                "Renovar Préstamo",
                "Ordenar por año publicación",
                "Buscar todos los materiales de un mismo autor" };

        System.out.println("Menu");

        for (int i = 0; i < options.length; i++) {
            System.out.printf("\t%d - %s%n", i + 1, options[i]);
        }

        System.out.printf("\t%d - Salir%n", options.length + 1);

        return options.length + 1;
    }

    public static void clearMenu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static Integer showCreateMaterialMenu() {
        String[] options = {
                "Registrar Libro",
                "Registrar Revista" };

        System.out.println("Registrar Material");

        for (int i = 0; i < options.length; i++) {
            System.out.printf("\t%d - %s%n", i + 1, options[i]);
        }

        System.out.printf("\t%d - Volver%n", options.length + 1);

        return options.length + 1;
    }
}

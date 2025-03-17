package app.controllers;

import java.util.ArrayList;

import app.models.material.Book;
import app.models.material.IRenew;
import app.models.material.Journal;
import app.models.material.Material;
import app.utils.Input;
import app.views.Menu;

public class MenuController {
    private Integer option;
    private Integer options;
    private Library library;

    public MenuController() {
        this.option = 0;
        this.options = 0;
        this.library = new Library();
    }

    public void start() {
        do {
            options = Menu.showMenu();
            option = Input.getInt("Indique una opción", 1, options);
            handleMenu();
        } while (option != options);
    }

    private void handleMenu() {
        Menu.clearMenu();
        if (!checkMaterial() && option != 1)
            return;

        switch (option) {
            case 1 -> addMaterial();
            case 2 -> library.showMaterial();
            case 3 -> lendMaterial();
            case 4 -> renewLend();
            case 5 -> {
                Menu.clearMenu();
                library.orderMaterial();
                library.showMaterial();
            }
            case 6 -> findAllByAuthor();
        }
    }

    private void addMaterial() {
        Menu.clearMenu();
        System.out.println("Agregar Material");

        Integer _options = Menu.showCreateMaterialMenu();
        Integer _option = Input.getInt("Indique una opción", 1, _options);

        if (_option == _options)
            return;

        String title = Input.getString("Indique el titulo").toUpperCase();
        String author = Input.getString("Indique el autor").toUpperCase();
        int published = Input.getInt("Indique el año de publicación", 1900, 2025);

        Material material = switch (_option) {
            case 1 -> new Book(title, author, published, Input.getString("Indique el genero"));
            case 2 -> new Journal(title, author, published, Input.getInt("Indique el número de edición", 1, null));
            default -> null;
        };

        if (material != null) {
            library.addMaterial(material);
            Menu.clearMenu();
            System.out.println("Material registrado correctamente");
            System.out.println(material);
        } else {
            System.out.println("Error al registrar el material");
        }
    }

    private void lendMaterial() {
        Menu.clearMenu();
        library.showMaterial();
        System.out.println("Prestar Material");

        Material _material = library.findMaterial(Input.getString("Indique el titulo a buscar").toUpperCase());

        if (_material == null) {
            System.out.println("No se ha encontrado el material");
        } else {
            _material.lend();
            System.out.println(_material);
        }
    }

    private void renewLend() {
        Menu.clearMenu();
        library.showMaterial();
        System.out.println("Renovar Préstamo");

        Material _material = library.findMaterial(Input.getString("Indique el autor a buscar").toUpperCase());

        Menu.clearMenu();

        if (_material == null) {
            System.out.println("No se ha encontrado el material");
        } else if (!(_material instanceof IRenew)) {
            System.out.println("El material seleccionado no permite renovar su préstamo");
        } else if (!((IRenew) _material).renew()) {
            System.out.println("El material no se encuentra prestado");
        }
    }

    private void findAllByAuthor() {
        Menu.clearMenu();
        library.showMaterial();
        System.out.println("Buscar todos los materiales de un mismo autor");

        ArrayList<Material> _materials = library
                .findMaterialsByAuthor(Input.getString("Indique el autor a buscar").toUpperCase());

        Menu.clearMenu();

        if (_materials.isEmpty()) {
            System.out.println("No se ha encontrado ningún material");
        } else {
            _materials.forEach(System.out::println);
        }
    }

    private boolean checkMaterial() {
        boolean hasMaterial = library.hasMaterial();
        if (!hasMaterial) {
            System.out.println("No hay material en la biblioteca");
        }
        return hasMaterial;
    }
}

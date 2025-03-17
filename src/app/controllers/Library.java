package app.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

import app.models.material.Material;

public class Library {
    ArrayList<Material> materials;

    public Library() {
        this.materials = new ArrayList<Material>();
    }

    public boolean addMaterial(Material material) {
        if (material == null)
            return false;
        this.materials.add(material);
        return true;
    }

    public boolean showMaterial() {
        if (materials.size() == 0)
            return false;
        for (Material material : materials)
            System.out.println(material);
        return true;
    }

    public boolean lendMaterial(Material material) {
        return material.lend();
    }

    public Material findMaterial(String title) {
        if (materials.size() == 0)
            return null;
        return materials.stream()
                .filter(material -> material.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    public ArrayList<Material> findMaterialsByAuthor(String author) {
        if (materials.size() == 0)
            return null;
        return materials.stream()
                .filter(material -> material.getAuthor().equals(author))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean orderMaterial() {
        if (materials.size() == 0)
            return false;
        Collections.sort(materials, Comparator.comparing(Material::getPublished));
        return true;
    }

    public boolean hasMaterial() {
        return !materials.isEmpty();
    }
}
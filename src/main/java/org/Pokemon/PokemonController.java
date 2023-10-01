package org.Pokemon;


import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.Models.Pokedex;
import org.Models.Pokemon;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PokemonController {
    private static PokemonController instance;
    public Pokedex pokedex;

    private PokemonController() {
        loadPokedex();
    }

    public static PokemonController getInstance() {
        if (instance == null) {
            instance = new PokemonController();
        }
        return instance;
    }

    private void loadPokedex() {
        Path currentRelativePath = Paths.get("");
        String ruta = currentRelativePath.toAbsolutePath().toString();
        String dir = ruta + File.separator + "data";
        String archivo = dir + File.separator + "pokemon.json";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Actualizar a try-with-resources
        try (Reader reader = Files.newBufferedReader(Paths.get(archivo))) {
            this.pokedex = gson.fromJson(reader, new TypeToken<Pokedex>() {}.getType());
            System.out.println("Pokedex loaded! There are: " + pokedex.pokemon.size());
        } catch (Exception e) {
            System.out.println("Error loading Pokedex!");
            System.out.println("Error: " + e.getMessage());
        }
    }



}

package org;



import org.Pokemon.PokemonController;


import java.util.Comparator;
import java.util.OptionalDouble;

public class MainConsultas {
    public static void main(String[] args) {


        System.out.println("Hello Pokedex!");
        //Obtener el nombre los 10 primeros pokemons.
        System.out.printf("Obtener el nombre los 10 primeros pokemons.");
        var pokeController = PokemonController.getInstance();

        pokeController.pokedex.pokemon.stream()
                .limit(10) // Limitar a los primeros 10 Pokémon
                .map(pokemon -> "Nombre del Pokémon: " + pokemon.name)
                .forEach(System.out::println);
    //Obtener el nombre de los 5 últimos pokemons.
        System.out.printf("Obtener el nombre de los 5 últimos pokemons.");
        pokeController.pokedex.pokemon.stream()
                .skip(pokeController.pokedex.pokemon.size() - 5) // Saltar los 5 últimos Pokémon
                .map(pokemon -> "Nombre del Pokémon: " + pokemon.name)
                .forEach(System.out::println);
        // Obtener los datos de Pikachu.
        System.out.println("Obtener los datos de Pikachu.");
        pokeController.pokedex.pokemon.stream()
                .filter(pokemon -> pokemon.name.equalsIgnoreCase("Pikachu")) // Ignora la capitalización
                .forEach(pokemon -> System.out.println(pokemon));
        //Obtener el nombre de los pokemons de tipo fire.
        System.out.println("Obtener el nombre de los pokemons de tipo fire.");
        pokeController.pokedex.pokemon.stream()
                .filter(pokemon -> pokemon.type.contains("Fire"))
                .map(pokemon -> "Nombre del Pokémon: " + pokemon.name)
                .forEach(System.out::println);
        //Obtener el nombre de los pokemons con debilidad water o electric.
        System.out.println("Obtener el nombre de los pokemons con debilidad water o electric.");
        pokeController.pokedex.pokemon.stream()
                .filter(pokemon -> pokemon.weaknesses.contains("Water") || pokemon.weaknesses.contains("Electric"))
                .map(pokemon -> "Nombre del Pokémon: " + pokemon.name)
                .forEach(System.out::println);
        //Numero de pokemons con solo una debilidad.
        System.out.printf("Numero de pokemons con solo una debilidad.");
        pokeController.pokedex.pokemon.stream()
                .filter(pokemon -> pokemon.weaknesses.size() == 1)
                .map(pokemon -> "Nombre del Pokémon: " + pokemon.name+" Sus habilidades son --> "+pokemon.weaknesses.size())
                .forEach(System.out::println);
        //Pokemon con más debilidades.
        System.out.printf("Pokemon con más debilidades.");
        pokeController.pokedex.pokemon.stream()
                .sorted((pokemon1, pokemon2) -> pokemon2.weaknesses.size() - pokemon1.weaknesses.size())
                .limit(1)
                .forEach(pokemon -> System.out.println(pokemon.name + " tiene " + pokemon.weaknesses.size() + " debilidades"));
        //Pokemon con menos evoluciones.
        System.out.printf("Pokemon con menos evoluciones.");
        pokeController.pokedex.pokemon.stream()
                .sorted(Comparator.comparingInt(pokemon -> pokemon.next_evolution == null ? 0 : pokemon.next_evolution.size()))
                .limit(1)
                .forEach(pokemon -> System.out.println(pokemon.name + " tiene " + (pokemon.next_evolution == null ? 0 : pokemon.next_evolution.size()) + " evoluciones"));
        //Pokemon con una evolución que no es de tipo fire.
                            //sin colucion opctima encontrada
        // Pokemon con más peso.
                        // posiblemnte este mal asi que revisar
        System.out.printf("Pokemon con más peso.");
        pokeController.pokedex.pokemon.stream()
                .sorted((pokemon1, pokemon2) -> pokemon2.weight.compareTo(pokemon1.weight))
                .limit(1)
                .forEach(pokemon -> System.out.println(pokemon.name + " tiene " + pokemon.weight + " de peso"));
        //Pokemon más alto.
                        //posiblemnte este mal asi que revisar
        System.out.printf("Pokemon más alto.");
        pokeController.pokedex.pokemon.stream()
                .sorted((pokemon1, pokemon2) -> pokemon2.height.compareTo(pokemon1.height))
                .limit(1)
                .forEach(pokemon -> System.out.println(pokemon.name + " tiene " + pokemon.height + " de altura"));
        //Pokemon con el nombre mas largo.
                        //preguntar por este resultado esta raro
        System.out.printf("Pokemon con el nombre mas largo.");
        pokeController.pokedex.pokemon.stream()
                .sorted((pokemon1, pokemon2) -> pokemon2.name.length() - pokemon1.name.length())
                .limit(1)
                .forEach(pokemon -> System.out.println(pokemon.name + " tiene " + pokemon.name.length() + " letras " + pokemon.id));
        //Media de peso de los pokemons.
                        //complicado , se tiene que hacer es leer los pesos y solo quedarse con los numeros y hacer la media y dejar de lado el kg

        //Media de altura de los pokemons.
                        //complicado , se tiene que hacer es leer las alturas y solo quedarse con los numeros y hacer la media y dejar de lado el la medida

        //Media de evoluciones de los pokemons.
        System.out.printf("Media de evoluciones de los pokemons.");
                /// esto esta mal
        OptionalDouble media = pokeController.pokedex.pokemon.stream()
                .mapToInt(pokemon -> pokemon.next_evolution == null ? 0 : pokemon.next_evolution.size())
                .average();
        System.out.println("La media de evoluciones es: " + media.getAsDouble());
        //Media de debilidades de los pokemons.
        System.out.printf("Media de debilidades de los pokemons.");
       //buscar la debilidad que mas se repite
/*
        //Pokemon con más evoluciones.
        System.out.printf("Pokemon con más evoluciones.");
        pokeController.pokedex.pokemon.stream()
                 .sorted((pokemon1, pokemon2) -> pokemon2.next_evolution.size() - pokemon1.next_evolution.size())
                .limit(1)
                .forEach(pokemon -> System.out.println(pokemon.name + " tiene " + pokemon.next_evolution.size() + " evoluciones"));
*/
        /*
        //Pokemon con más evoluciones.
        System.out.printf("Pokemon con más evoluciones.");
        pokeController.pokedex.pokemon.stream()
                .sorted((pokemon1, pokemon2) -> pokemon2.next_evolution.size() - pokemon1.next_evolution.size())
                .limit(1)
                .forEach(pokemon -> System.out.println(pokemon.name + " tiene " + pokemon.next_evolution.size() + " evoluciones"));
*/
        //Pokemon con más evoluciones.
/*
        System.out.printf("Pokemon con más evoluciones.");
        pokeController.pokedex.pokemon.stream()
                .sorted((pokemon1, pokemon2) -> pokemon2.next_evolution.size() - pokemon1.next_evolution.size())
                .limit(1)
                .forEach(pokemon -> System.out.println(pokemon.name + " tiene " + pokemon.next_evolution.size() + " evoluciones"));

        //Pokemon con más evoluciones.
 */
   /*
        System.out.printf("Pokemon con más evoluciones.");
        pokeController.pokedex.pokemon.stream()
                .sorted((pokemon1, pokemon2) -> pokemon2.next_evolution.size() - pokemon1.next_evolution.size())
                .limit(1)
                .forEach(pokemon -> System.out.println(pokemon.name + " tiene " + pokemon.next_evolution.size() + " evoluciones"));
    */
        /*
        //Pokemon con más evoluciones.
        System.out.printf("Pokemon con más evoluciones.");
        pokeController.pokedex.pokemon.stream()
                .sorted((pokemon1, pokemon2) -> pokemon2.next_evolution.size() - pokemon1.next_evolution.size())
                .limit(1)
                .forEach(pokemon -> System.out.println(pokemon.name + " tiene " + pokemon.next_evolution.size() + " evoluciones"));
       */
        //Pokemon con más evoluciones.

            // esta mallllllll


        //Pokemons agrupados por tipo.
        // revisarrrr muy dificil

        //Numero de pokemons agrupados por debilidad.
                //revisarrr
        //Pokemons agrupados por número de evoluciones.
                //revisarrr
         /*
        //Sacar la debilidad más común.
        System.out.printf("Sacar la debilidad más común.");
        pokeController.pokedex.pokemon.stream()
                .flatMap(pokemon -> pokemon.weaknesses.stream())
                .sorted()
                .forEach(System.out::println);

*/


    }

}

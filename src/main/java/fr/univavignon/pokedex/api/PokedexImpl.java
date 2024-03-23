package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PokedexImpl implements IPokedex {

    IPokemonMetadataProvider pokemonMetadataProvider;
    IPokemonFactory pokemonFactory;

    // Liste des Pokemons enregistrés
    private List<Pokemon> pokemonsRegistered = new ArrayList<>();

    public PokedexImpl(IPokemonMetadataProvider pokemonMetadataProvider, IPokemonFactory pokemonFactory) {
        this.pokemonMetadataProvider = pokemonMetadataProvider;
        this.pokemonFactory = pokemonFactory;

        pokemonsRegistered.add(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
        pokemonsRegistered.add(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100));
    }

    @Override
    public int size() {
        return pokemonsRegistered.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemonsRegistered.add(pokemon);
        return pokemonsRegistered.size();
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        try {
            return pokemonsRegistered.get(id);
        } catch (IndexOutOfBoundsException e) {
            throw new PokedexException("Error : The pokemon is not in the list");
        }
    }

    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemonsRegistered);
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List sorted = new ArrayList(pokemonsRegistered);
        sorted.sort(order);
        return Collections.unmodifiableList(sorted);
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }
}

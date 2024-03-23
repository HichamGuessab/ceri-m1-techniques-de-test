package fr.univavignon.pokedex.api;

public class PokemonTrainerImpl implements IPokemonTrainerFactory {
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        return new PokemonTrainer(name, team, null);
    }
}

package fr.univavignon.pokedex.api;

public class PokemonTrainerFactoryImpl implements IPokemonTrainerFactory {
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        IPokemonFactory pokemonFactory = new PokemonFactoryImpl();
        IPokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProviderImpl();
        return new PokemonTrainer(name, team, pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory));
    }
}

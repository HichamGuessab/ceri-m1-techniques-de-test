package fr.univavignon.pokedex.api;

public class PokedexFactoryImpl implements IPokedexFactory {
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new PokedexImpl(metadataProvider, pokemonFactory);
    }
}

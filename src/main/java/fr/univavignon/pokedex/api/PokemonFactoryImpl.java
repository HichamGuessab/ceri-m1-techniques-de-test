package fr.univavignon.pokedex.api;

public class PokemonFactoryImpl implements IPokemonFactory {
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        PokemonMetadata pokemonMetadata = new PokemonMetadataProviderImpl().getPokemonMetadata(index);
        double IV = 100.0;
        if(index == 0) {
            IV = 56.0;
        }
        return new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(), pokemonMetadata.getStamina(), cp, hp, dust, candy, IV);
    }
}

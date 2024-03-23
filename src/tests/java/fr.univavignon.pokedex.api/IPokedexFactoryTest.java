package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest {

    PokemonMetadata bulbizarre;
    PokemonMetadata aquali;
    IPokedexFactory pokedexFactory;

    @Before
    public void init() {
        pokedexFactory = new PokedexFactoryImpl();

        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
    }

    @Test
    public void createPokedexTest() {
        IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);

        Assert.assertEquals(PokedexImpl.class, pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory).getClass());

        Assert.assertNotNull(
                pokedexFactory.createPokedex(
                        Mockito.mock(IPokemonMetadataProvider.class),
                        Mockito.mock(IPokemonFactory.class)
                )
        );

        Assert.assertEquals(PokedexImpl.class, pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory).getClass());
    }
}
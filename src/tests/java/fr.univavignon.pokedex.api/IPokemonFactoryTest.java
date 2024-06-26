package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {
    IPokemonFactory pokemonFactory;
//    IPokemonFactory rocketPokemonFactory;
    Pokemon bulbizarre;
    Pokemon aquali ;


    @Before
    public void init() {
//        pokemonFactory = Mockito.mock(IPokemonFactory.class);
        pokemonFactory = new PokemonFactoryImpl();
//        rocketPokemonFactory = new RocketPokemonFactory();

        bulbizarre =  new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100);
    }

//    @Test
//    public void rocketCreatePokemonTest() throws PokedexException {
//        Assert.assertEquals(bulbizarre.getHp(), rocketPokemonFactory.createPokemon(0, 613, 64, 4000, 4).getHp());
//        Assert.assertEquals(aquali.getHp(), rocketPokemonFactory.createPokemon(133,2729, 202, 5000, 4).getHp());
//
//        Assert.assertEquals(bulbizarre.getIv(), rocketPokemonFactory.createPokemon(0, 613, 64, 4000, 4).getCp(), 0.0);
//        Assert.assertEquals(aquali.getIv(), rocketPokemonFactory.createPokemon(133,2729, 202, 5000, 4).getCp(), 0.0);
//
//        Assert.assertThrows(PokedexException.class, () -> {
//            rocketPokemonFactory.createPokemon(-19, 2863, 202, 5000, 4);
//        });
//
//        Assert.assertThrows(PokedexException.class, () -> {
//            rocketPokemonFactory.createPokemon(187, 2863, 202, 5000, 4);
//        });
//    }

    @Test
    public void createPokemonTest() throws PokedexException {
//        Mockito.when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);
//        Mockito.when(pokemonFactory.createPokemon(133,2729, 202, 5000, 4)).thenReturn(aquali);

//        Assert.assertEquals(bulbizarre, pokemonFactory.createPokemon(0, 613, 64, 4000, 4));
//        Assert.assertEquals(aquali, pokemonFactory.createPokemon(133,2729, 202, 5000, 4));

        Assert.assertEquals(bulbizarre.getCp(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getCp());
        Assert.assertEquals(aquali.getCp(), pokemonFactory.createPokemon(133,2729, 202, 5000, 4).getCp());

        Assert.assertEquals(bulbizarre.getHp(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getHp());
        Assert.assertEquals(aquali.getHp(), pokemonFactory.createPokemon(133,2729, 202, 5000, 4).getHp());

        Assert.assertEquals(bulbizarre.getDust(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getDust());
        Assert.assertEquals(aquali.getDust(), pokemonFactory.createPokemon(133,2729, 202, 5000, 4).getDust());

        Assert.assertEquals(bulbizarre.getCandy(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getCandy());
        Assert.assertEquals(aquali.getCandy(), pokemonFactory.createPokemon(133,2729, 202, 5000, 4).getCandy());

        Assert.assertEquals(bulbizarre.getIv(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getIv(), 0.0);
        Assert.assertEquals(aquali.getIv(), pokemonFactory.createPokemon(133,2729, 202, 5000, 4).getIv(), 0.0);
    }
}
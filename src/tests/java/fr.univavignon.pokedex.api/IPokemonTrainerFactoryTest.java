package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {

    PokedexImpl pokedex;
    IPokemonTrainerFactory trainerFactory; ;
    PokedexFactoryImpl factory;
    IPokemonMetadataProvider pokemonMetadataProvider;
    IPokemonFactory pokemonFactory;
    PokemonTrainer trainer;

    @Before
    public void init() {
//        pokedex = Mockito.mock(IPokedex.class);
//        trainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
//        factory = Mockito.mock(IPokedexFactory.class);

        pokedex = new PokedexImpl(pokemonMetadataProvider, pokemonFactory);
        trainerFactory = new PokemonTrainerFactoryImpl();
        factory = new PokedexFactoryImpl();

        trainer = new PokemonTrainer("Hicham", Team.INSTINCT, pokedex);
    }

    @Test
    public void createTrainerTest() {
        // Hicham is a very good trainer
//        Mockito.doReturn(trainer).when(trainerFactory).createTrainer("Hicham", Team.INSTINCT, factory);

        Assert.assertEquals(
                trainer.getClass(),
                trainerFactory.createTrainer("Hicham", Team.INSTINCT, factory).getClass()
        );

        // Comparaison de deux objets différents en mémoire (donc ça sert à rien)
//        Assert.assertEquals(
//                trainer,
//                trainerFactory.createTrainer("Hicham", Team.INSTINCT, factory)
//        );

        Assert.assertEquals(
                "Hicham",
                trainerFactory.createTrainer("Hicham", Team.INSTINCT, factory).getName()
        );

        Assert.assertEquals(
                Team.INSTINCT,
                trainerFactory.createTrainer("Hicham", Team.INSTINCT, factory).getTeam()
        );

        Assert.assertEquals(Team.INSTINCT, new PokemonTrainerImpl().createTrainer("Hicham", Team.INSTINCT, factory).getTeam());

        // Comparaison de deux objets différents en mémoire (donc ça sert à rien)
//        Assert.assertEquals(
//                pokedex,
//                trainerFactory.createTrainer("Hicham", Team.INSTINCT, factory).getPokedex()
//        );

        Assert.assertEquals(
                pokedex.size(),
                trainerFactory.createTrainer("Hicham", Team.INSTINCT, factory).getPokedex().size()
        );
    }
}
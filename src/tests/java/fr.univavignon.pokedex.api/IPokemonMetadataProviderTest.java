package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {
    IPokemonMetadataProvider provider;

    PokemonMetadata aquali;
    PokemonMetadata bulbizarre;


    @Before
    public void init() {
        provider = Mockito.mock(IPokemonMetadataProvider.class);

        bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        aquali = new PokemonMetadata(133, "Aquali", 186, 186, 260);
    }

    @Test
    public void getPokemonMetadataTest() throws PokedexException {
        Mockito.doReturn(bulbizarre).when(provider).getPokemonMetadata(0);
        Mockito.doReturn(aquali).when(provider).getPokemonMetadata(133);

        Assert.assertEquals(bulbizarre, provider.getPokemonMetadata(0));
        Assert.assertEquals(aquali, provider.getPokemonMetadata(133));

        Assert.assertEquals(bulbizarre.getAttack(), provider.getPokemonMetadata(0).getAttack());
        Assert.assertEquals(aquali.getAttack(), provider.getPokemonMetadata(133).getAttack());

        Assert.assertEquals(bulbizarre.getDefense(), provider.getPokemonMetadata(0).getDefense());
        Assert.assertEquals(aquali.getDefense(), provider.getPokemonMetadata(133).getDefense());

        Assert.assertEquals(bulbizarre.getStamina(), provider.getPokemonMetadata(0).getStamina());
        Assert.assertEquals(aquali.getStamina(), provider.getPokemonMetadata(133).getStamina());

        // Exception if index < 0 or index > 150
        Mockito.doThrow(new PokedexException("Error : index must be between 0 and 150"))
                        .when(provider).getPokemonMetadata(
                                Mockito.intThat(i -> i < 0 || i > 150)
                        );

        // Exceptions tests
        Assert.assertThrows(PokedexException.class, () -> provider.getPokemonMetadata(-7));
        Assert.assertThrows(PokedexException.class, () -> provider.getPokemonMetadata(151));
        Assert.assertThrows(PokedexException.class, () -> provider.getPokemonMetadata(-1));

        // Verify that the exception is not thrown
//        Assert.assertThrows(PokedexException.class, () -> provider.getPokemonMetadata(0));
    }
}
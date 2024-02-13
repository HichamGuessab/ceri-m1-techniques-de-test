package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IPokedexTest {

    IPokedex pokedex;
    PokemonMetadata aquali;
    PokemonMetadata bulbizarre;
    ArrayList<Pokemon> listPokemons = new ArrayList<>();


    @Before
    public void init() {
        pokedex = Mockito.mock(IPokedex.class);

        aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100);
        bulbizarre =  new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

        listPokemons.add((Pokemon)aquali);
        listPokemons.add((Pokemon)bulbizarre);
    }

    @Test
    public void getSizeTest(){
        Mockito.doReturn(listPokemons.size()).when(pokedex).size();
        Assert.assertEquals(2, pokedex.size());
    }

    @Test
    public void addPokemonTest(){
        Mockito.doReturn(listPokemons.size() + 1).when(pokedex).addPokemon(Mockito.any(Pokemon.class));
        Assert.assertEquals(3, pokedex.addPokemon(new Pokemon(0, "Carapuce",0,0,0,0,0,0,0,0)));
    }

    @Test
    public void getPokemonTest() throws PokedexException {
        Mockito.doReturn(bulbizarre).when(pokedex).getPokemon(0);
        Mockito.doReturn(aquali).when(pokedex).getPokemon(1);
        Mockito.doThrow(new PokedexException("Error : The pokemon is not in the list")).when(pokedex).getPokemon(Mockito.intThat(i -> i < 0 || i > 1));

        // Verify that the Pokémon is returned when the index is in the list
        Assert.assertEquals(bulbizarre, pokedex.getPokemon(0));
        Assert.assertEquals(aquali, pokedex.getPokemon(1));

        // Verify that the exception is thrown when the index is not in the list
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(-769));
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(-1));
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(7));
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(86));
    }

    @Test
    public void getPokemonsTest() {
        // Not obligatory to render the list unmodifiable in these cases, but it's a good practice
        List<Pokemon> unmodifiablePokemonList = Collections.unmodifiableList(listPokemons);

        Mockito.doReturn(unmodifiablePokemonList).when(pokedex).getPokemons();

        Assert.assertEquals(unmodifiablePokemonList.getClass(), pokedex.getPokemons().getClass());
        Assert.assertEquals(listPokemons.size(), pokedex.getPokemons().size());
        Assert.assertEquals(listPokemons.get(0), pokedex.getPokemons().get(0));
    }

    @Test
    public void getPokemonsSortedTest() {
        PokemonComparators name = PokemonComparators.NAME;
        PokemonComparators index = PokemonComparators.INDEX;
        PokemonComparators cp = PokemonComparators.CP;

        List<Pokemon> pokemonsSortedByName = new ArrayList<>(listPokemons);
        pokemonsSortedByName.sort(name);
        // pokemonSortedByName = [aquali, bulbizarre]

        List<Pokemon> pokemonsSortedByIndex = new ArrayList<>(listPokemons);
        pokemonsSortedByIndex.sort(index);
        // pokemonSortedByIndex = [bulbizarre, aquali]

        List<Pokemon> pokemonsSortedByCP = new ArrayList<>(listPokemons);
        pokemonsSortedByCP.sort(cp);
        // pokemonSortedByCP = [bulbizarre, aquali]

        // Verify that the Pokémon list is returned when the index is in the list
        Mockito.doReturn(pokemonsSortedByName).when(pokedex).getPokemons(name);
        Mockito.doReturn(pokemonsSortedByIndex).when(pokedex).getPokemons(index);
        Mockito.doReturn(pokemonsSortedByCP).when(pokedex).getPokemons(cp);

        Assert.assertEquals(
                "Bulbizarre",
                pokedex.getPokemons(name).get(1).getName()
        );

        Assert.assertEquals(0, pokedex.getPokemons(index).get(0).getIndex());
        Assert.assertEquals(613, pokedex.getPokemons(cp).get(0).getCp());

        Assert.assertEquals(
                ArrayList.class,
                pokedex.getPokemons(name).getClass()
        );

        Assert.assertEquals(
                listPokemons.size(),
                pokedex.getPokemons(name).size()
        );
    }
}
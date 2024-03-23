package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PokemonMetadataProviderImpl implements IPokemonMetadataProvider {
    public List<PokemonMetadata> pokemonsMetadata = new ArrayList<>();

    public PokemonMetadataProviderImpl() {
        pokemonsMetadata.add(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        pokemonsMetadata.add(new PokemonMetadata(133, "Aquali", 186, 186, 260));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        try {
            ArrayList<PokemonMetadata> filtered = (ArrayList<PokemonMetadata>) pokemonsMetadata.stream()
                    .filter(metadata -> (metadata.getIndex() == index))
                    .collect(Collectors.toList());
            return filtered.get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new PokedexException("Error : The pokemon is not in the list");
        }
    }
}

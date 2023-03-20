package mk.finki.ukim.libraryemtlab.service;

import mk.finki.ukim.libraryemtlab.model.Country;
import mk.finki.ukim.libraryemtlab.model.dto.CountryDto;

import java.util.List;

public interface CountryService {
    List<Country> findAllCountries();

    Country findCountryById(Long country);

    Country addCountry(CountryDto country);

    Country editCountry(Long id, CountryDto country);

    void deleteCountry(Long id);
}

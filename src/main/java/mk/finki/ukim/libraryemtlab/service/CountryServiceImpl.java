package mk.finki.ukim.libraryemtlab.service;

import mk.finki.ukim.libraryemtlab.model.Country;
import mk.finki.ukim.libraryemtlab.model.dto.CountryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{
    @Override
    public List<Country> findAllCountries() {
        return null;
    }

    @Override
    public Country findCountryById(Long country) {
        return null;
    }

    @Override
    public Country addCountry(CountryDto country) {
        return null;
    }

    @Override
    public Country editCountry(Long id, CountryDto country) {
        return null;
    }

    @Override
    public void deleteCountry(Long id) {

    }
}

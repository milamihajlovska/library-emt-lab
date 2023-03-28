package mk.finki.ukim.libraryemtlab.service;

import mk.finki.ukim.libraryemtlab.model.Country;
import mk.finki.ukim.libraryemtlab.model.dto.CountryDto;
import mk.finki.ukim.libraryemtlab.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{
   private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Country> findAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country findCountryById(Long country) {
        return countryRepository.findById(country).orElseThrow(()->new RuntimeException());
    }

    @Override
    public Country addCountry(CountryDto country) {
        Country country1=new Country();
        country1.setContinent(country.getContinent());
        country1.setName(country.getName());

        return this.countryRepository.save(country1);
    }

    @Override
    public Country editCountry(Long id, CountryDto country) {

        Country country1=countryRepository.findById(id).orElseThrow(()-> new RuntimeException());
        country1.setContinent(country.getContinent());
        country1.setName(country.getName());
        return this.countryRepository.save(country1);
    }

    @Override
    public void deleteCountry(Long id) {
        this.countryRepository.deleteById(id);
    }
}

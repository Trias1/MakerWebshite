/**
 * This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.
 */
package com.tugas_trias.services.countryinfoservice.controller;

import com.tugas_trias.services.countryinfoservice.services.CountryInfoServiceService;
import com.tugas_trias.services.countryinfoservice.CapitalCity;
import java.lang.String;
import com.tugas_trias.services.countryinfoservice.CapitalCityResponse;
import com.tugas_trias.services.countryinfoservice.CountriesUsingCurrency;
import com.tugas_trias.services.countryinfoservice.CountriesUsingCurrencyResponse;
import com.tugas_trias.services.countryinfoservice.CountryCurrency;
import com.tugas_trias.services.countryinfoservice.CountryCurrencyResponse;
import com.tugas_trias.services.countryinfoservice.CountryFlag;
import com.tugas_trias.services.countryinfoservice.CountryFlagResponse;
import com.tugas_trias.services.countryinfoservice.CountryISOCode;
import com.tugas_trias.services.countryinfoservice.CountryISOCodeResponse;
import com.tugas_trias.services.countryinfoservice.CountryIntPhoneCode;
import com.tugas_trias.services.countryinfoservice.CountryIntPhoneCodeResponse;
import com.tugas_trias.services.countryinfoservice.CountryName;
import com.tugas_trias.services.countryinfoservice.CountryNameResponse;
import com.tugas_trias.services.countryinfoservice.CurrencyName;
import com.tugas_trias.services.countryinfoservice.CurrencyNameResponse;
import com.tugas_trias.services.countryinfoservice.FullCountryInfo;
import com.tugas_trias.services.countryinfoservice.FullCountryInfoResponse;
import com.tugas_trias.services.countryinfoservice.FullCountryInfoAllCountries;
import com.tugas_trias.services.countryinfoservice.FullCountryInfoAllCountriesResponse;
import com.tugas_trias.services.countryinfoservice.LanguageISOCode;
import com.tugas_trias.services.countryinfoservice.LanguageISOCodeResponse;
import com.tugas_trias.services.countryinfoservice.LanguageName;
import com.tugas_trias.services.countryinfoservice.LanguageNameResponse;
import com.tugas_trias.services.countryinfoservice.ListOfContinentsByCode;
import com.tugas_trias.services.countryinfoservice.ListOfContinentsByCodeResponse;
import com.tugas_trias.services.countryinfoservice.ListOfContinentsByName;
import com.tugas_trias.services.countryinfoservice.ListOfContinentsByNameResponse;
import com.tugas_trias.services.countryinfoservice.ListOfCountryNamesByCode;
import com.tugas_trias.services.countryinfoservice.ListOfCountryNamesByCodeResponse;
import com.tugas_trias.services.countryinfoservice.ListOfCountryNamesByName;
import com.tugas_trias.services.countryinfoservice.ListOfCountryNamesByNameResponse;
import com.tugas_trias.services.countryinfoservice.ListOfCountryNamesGroupedByContinent;
import com.tugas_trias.services.countryinfoservice.ListOfCountryNamesGroupedByContinentResponse;
import com.tugas_trias.services.countryinfoservice.ListOfCurrenciesByCode;
import com.tugas_trias.services.countryinfoservice.ListOfCurrenciesByCodeResponse;
import com.tugas_trias.services.countryinfoservice.ListOfCurrenciesByName;
import com.tugas_trias.services.countryinfoservice.ListOfCurrenciesByNameResponse;
import com.tugas_trias.services.countryinfoservice.ListOfLanguagesByCode;
import com.tugas_trias.services.countryinfoservice.ListOfLanguagesByCodeResponse;
import com.tugas_trias.services.countryinfoservice.ListOfLanguagesByName;
import com.tugas_trias.services.countryinfoservice.ListOfLanguagesByNameResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(value = "/countryInfo")
public class CountryInfoServiceController {

    @Autowired
    private CountryInfoServiceService countryInfoServiceService;

    @RequestMapping(value = "/capitalCity", method = RequestMethod.GET)
    public CapitalCityResponse capitalCity(@RequestParam(value = "SCountryISOCode", required = false) String SCountryISOCode) {
        CapitalCity parameters = new CapitalCity();
        parameters.setSCountryISOCode(SCountryISOCode);
        return countryInfoServiceService.capitalCity(parameters);
    }

    @RequestMapping(value = "/countriesUsingCurrency", method = RequestMethod.GET)
    public CountriesUsingCurrencyResponse countriesUsingCurrency(@RequestParam(value = "SISOCurrencyCode", required = false) String SISOCurrencyCode) {
        CountriesUsingCurrency parameters = new CountriesUsingCurrency();
        parameters.setSISOCurrencyCode(SISOCurrencyCode);
        return countryInfoServiceService.countriesUsingCurrency(parameters);
    }

    @RequestMapping(value = "/countryCurrency", method = RequestMethod.GET)
    public CountryCurrencyResponse countryCurrency(@RequestParam(value = "SCountryISOCode", required = false) String SCountryISOCode) {
        CountryCurrency parameters = new CountryCurrency();
        parameters.setSCountryISOCode(SCountryISOCode);
        return countryInfoServiceService.countryCurrency(parameters);
    }

    @RequestMapping(value = "/countryFlag", method = RequestMethod.GET)
    public CountryFlagResponse countryFlag(@RequestParam(value = "SCountryISOCode", required = false) String SCountryISOCode) {
        CountryFlag parameters = new CountryFlag();
        parameters.setSCountryISOCode(SCountryISOCode);
        return countryInfoServiceService.countryFlag(parameters);
    }

    @RequestMapping(value = "/countryISOCode", method = RequestMethod.GET)
    public CountryISOCodeResponse countryISOCode(@RequestParam(value = "SCountryName", required = false) String SCountryName) {
        CountryISOCode parameters = new CountryISOCode();
        parameters.setSCountryName(SCountryName);
        return countryInfoServiceService.countryISOCode(parameters);
    }

    @RequestMapping(value = "/countryIntPhoneCode", method = RequestMethod.GET)
    public CountryIntPhoneCodeResponse countryIntPhoneCode(@RequestParam(value = "SCountryISOCode", required = false) String SCountryISOCode) {
        CountryIntPhoneCode parameters = new CountryIntPhoneCode();
        parameters.setSCountryISOCode(SCountryISOCode);
        return countryInfoServiceService.countryIntPhoneCode(parameters);
    }

    @RequestMapping(value = "/countryName", method = RequestMethod.GET)
    public CountryNameResponse countryName(@RequestParam(value = "SCountryISOCode", required = false) String SCountryISOCode) {
        CountryName parameters = new CountryName();
        parameters.setSCountryISOCode(SCountryISOCode);
        return countryInfoServiceService.countryName(parameters);
    }

    @RequestMapping(value = "/currencyName", method = RequestMethod.GET)
    public CurrencyNameResponse currencyName(@RequestParam(value = "SCurrencyISOCode", required = false) String SCurrencyISOCode) {
        CurrencyName parameters = new CurrencyName();
        parameters.setSCurrencyISOCode(SCurrencyISOCode);
        return countryInfoServiceService.currencyName(parameters);
    }

    @RequestMapping(value = "/fullCountryInfo", method = RequestMethod.GET)
    public FullCountryInfoResponse fullCountryInfo(@RequestParam(value = "SCountryISOCode", required = false) String SCountryISOCode) {
        FullCountryInfo parameters = new FullCountryInfo();
        parameters.setSCountryISOCode(SCountryISOCode);
        return countryInfoServiceService.fullCountryInfo(parameters);
    }

    @RequestMapping(value = "/fullCountryInfoAllCountries", method = RequestMethod.GET)
    public FullCountryInfoAllCountriesResponse fullCountryInfoAllCountries() {
        FullCountryInfoAllCountries parameters = new FullCountryInfoAllCountries();
        return countryInfoServiceService.fullCountryInfoAllCountries(parameters);
    }

    @RequestMapping(value = "/languageISOCode", method = RequestMethod.GET)
    public LanguageISOCodeResponse languageISOCode(@RequestParam(value = "SLanguageName", required = false) String SLanguageName) {
        LanguageISOCode parameters = new LanguageISOCode();
        parameters.setSLanguageName(SLanguageName);
        return countryInfoServiceService.languageISOCode(parameters);
    }

    @RequestMapping(value = "/languageName", method = RequestMethod.GET)
    public LanguageNameResponse languageName(@RequestParam(value = "SISOCode", required = false) String SISOCode) {
        LanguageName parameters = new LanguageName();
        parameters.setSISOCode(SISOCode);
        return countryInfoServiceService.languageName(parameters);
    }

    @RequestMapping(value = "/ofContinentsByCode", method = RequestMethod.GET)
    public ListOfContinentsByCodeResponse listOfContinentsByCode() {
        ListOfContinentsByCode parameters = new ListOfContinentsByCode();
        return countryInfoServiceService.listOfContinentsByCode(parameters);
    }

    @RequestMapping(value = "/ofContinentsByName", method = RequestMethod.GET)
    public ListOfContinentsByNameResponse listOfContinentsByName() {
        ListOfContinentsByName parameters = new ListOfContinentsByName();
        return countryInfoServiceService.listOfContinentsByName(parameters);
    }

    @RequestMapping(value = "/ofCountryNamesByCode", method = RequestMethod.GET)
    public ListOfCountryNamesByCodeResponse listOfCountryNamesByCode() {
        ListOfCountryNamesByCode parameters = new ListOfCountryNamesByCode();
        return countryInfoServiceService.listOfCountryNamesByCode(parameters);
    }

    @RequestMapping(value = "/ofCountryNamesByName", method = RequestMethod.GET)
    public ListOfCountryNamesByNameResponse listOfCountryNamesByName() {
        ListOfCountryNamesByName parameters = new ListOfCountryNamesByName();
        return countryInfoServiceService.listOfCountryNamesByName(parameters);
    }

    @RequestMapping(value = "/ofCountryNamesGroupedByContinent", method = RequestMethod.GET)
    public ListOfCountryNamesGroupedByContinentResponse listOfCountryNamesGroupedByContinent() {
        ListOfCountryNamesGroupedByContinent parameters = new ListOfCountryNamesGroupedByContinent();
        return countryInfoServiceService.listOfCountryNamesGroupedByContinent(parameters);
    }

    @RequestMapping(value = "/ofCurrenciesByCode", method = RequestMethod.GET)
    public ListOfCurrenciesByCodeResponse listOfCurrenciesByCode() {
        ListOfCurrenciesByCode parameters = new ListOfCurrenciesByCode();
        return countryInfoServiceService.listOfCurrenciesByCode(parameters);
    }

    @RequestMapping(value = "/ofCurrenciesByName", method = RequestMethod.GET)
    public ListOfCurrenciesByNameResponse listOfCurrenciesByName() {
        ListOfCurrenciesByName parameters = new ListOfCurrenciesByName();
        return countryInfoServiceService.listOfCurrenciesByName(parameters);
    }

    @RequestMapping(value = "/ofLanguagesByCode", method = RequestMethod.GET)
    public ListOfLanguagesByCodeResponse listOfLanguagesByCode() {
        ListOfLanguagesByCode parameters = new ListOfLanguagesByCode();
        return countryInfoServiceService.listOfLanguagesByCode(parameters);
    }

    @RequestMapping(value = "/ofLanguagesByName", method = RequestMethod.GET)
    public ListOfLanguagesByNameResponse listOfLanguagesByName() {
        ListOfLanguagesByName parameters = new ListOfLanguagesByName();
        return countryInfoServiceService.listOfLanguagesByName(parameters);
    }
}
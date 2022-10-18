/*Copyright (c) 2022-2023 i-3.co.id All Rights Reserved.
 This software is the confidential and proprietary information of i-3.co.id You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with i-3.co.id*/
package com.tugas_trias.services.countryinfoservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.5.3
 * 2022-10-12T04:39:59.003Z
 * Generated source version: 3.5.3
 *
 */
@WebService(targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", name = "CountryInfoServiceSoapType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface CountryInfoServiceSoapType {

    /**
     * Returns a struct with all the stored country information. Pass the ISO country code
     */
    @WebMethod(operationName = "FullCountryInfo")
    @WebResult(name = "FullCountryInfoResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", partName = "parameters")
    public FullCountryInfoResponse fullCountryInfo(

        @WebParam(partName = "parameters", name = "FullCountryInfo", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        FullCountryInfo parameters
    );

    /**
     * Returns a link to a picture of the country flag
     */
    @WebMethod(operationName = "CountryFlag")
    @WebResult(name = "CountryFlagResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", partName = "parameters")
    public CountryFlagResponse countryFlag(

        @WebParam(partName = "parameters", name = "CountryFlag", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        CountryFlag parameters
    );

    /**
     * Searches the database for a country by the passed ISO country code
     */
    @WebMethod(operationName = "CountryName")
    @WebResult(name = "CountryNameResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", partName = "parameters")
    public CountryNameResponse countryName(

        @WebParam(partName = "parameters", name = "CountryName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        CountryName parameters
    );

    /**
     * Returns the currency ISO code and name for the passed country ISO code
     */
    @WebMethod(operationName = "CountryCurrency")
    @WebResult(name = "CountryCurrencyResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", partName = "parameters")
    public CountryCurrencyResponse countryCurrency(

        @WebParam(partName = "parameters", name = "CountryCurrency", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        CountryCurrency parameters
    );

    /**
     * Returns a list of all stored counties ordered by ISO code
     */
    @WebMethod(operationName = "ListOfCountryNamesByCode")
    @WebResult(name = "ListOfCountryNamesByCodeResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", partName = "parameters")
    public ListOfCountryNamesByCodeResponse listOfCountryNamesByCode(

        @WebParam(partName = "parameters", name = "ListOfCountryNamesByCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        ListOfCountryNamesByCode parameters
    );

    /**
     * Returns a list of currencies ordered by name.
     */
    @WebMethod(operationName = "ListOfCurrenciesByName")
    @WebResult(name = "ListOfCurrenciesByNameResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", partName = "parameters")
    public ListOfCurrenciesByNameResponse listOfCurrenciesByName(

        @WebParam(partName = "parameters", name = "ListOfCurrenciesByName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        ListOfCurrenciesByName parameters
    );

    /**
     * Returns the internation phone code for the passed ISO country code
     */
    @WebMethod(operationName = "CountryIntPhoneCode")
    @WebResult(name = "CountryIntPhoneCodeResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", partName = "parameters")
    public CountryIntPhoneCodeResponse countryIntPhoneCode(

        @WebParam(partName = "parameters", name = "CountryIntPhoneCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        CountryIntPhoneCode parameters
    );

    /**
     * Returns the name of the currency (if found)
     */
    @WebMethod(operationName = "CurrencyName")
    @WebResult(name = "CurrencyNameResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", partName = "parameters")
    public CurrencyNameResponse currencyName(

        @WebParam(partName = "parameters", name = "CurrencyName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        CurrencyName parameters
    );

    /**
     * Returns a list of currencies ordered by code.
     */
    @WebMethod(operationName = "ListOfCurrenciesByCode")
    @WebResult(name = "ListOfCurrenciesByCodeResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", partName = "parameters")
    public ListOfCurrenciesByCodeResponse listOfCurrenciesByCode(

        @WebParam(partName = "parameters", name = "ListOfCurrenciesByCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        ListOfCurrenciesByCode parameters
    );

    /**
     * Returns an array of languages ordered by code
     */
    @WebMethod(operationName = "ListOfLanguagesByCode")
    @WebResult(name = "ListOfLanguagesByCodeResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", partName = "parameters")
    public ListOfLanguagesByCodeResponse listOfLanguagesByCode(

        @WebParam(partName = "parameters", name = "ListOfLanguagesByCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        ListOfLanguagesByCode parameters
    );

    /**
     * Find a language ISO code based on the passed language name
     */
    @WebMethod(operationName = "LanguageISOCode")
    @WebResult(name = "LanguageISOCodeResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", partName = "parameters")
    public LanguageISOCodeResponse languageISOCode(

        @WebParam(partName = "parameters", name = "LanguageISOCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        LanguageISOCode parameters
    );

    /**
     * Returns the  name of the captial city for the passed country code
     */
    @WebMethod(operationName = "CapitalCity")
    @WebResult(name = "CapitalCityResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", partName = "parameters")
    public CapitalCityResponse capitalCity(

        @WebParam(partName = "parameters", name = "CapitalCity", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        CapitalCity parameters
    );

    /**
     * Returns an array of languages ordered by name
     */
    @WebMethod(operationName = "ListOfLanguagesByName")
    @WebResult(name = "ListOfLanguagesByNameResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", partName = "parameters")
    public ListOfLanguagesByNameResponse listOfLanguagesByName(

        @WebParam(partName = "parameters", name = "ListOfLanguagesByName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        ListOfLanguagesByName parameters
    );

    /**
     * Returns a list of all stored counties grouped per continent
     */
    @WebMethod(operationName = "ListOfCountryNamesGroupedByContinent")
    @WebResult(name = "ListOfCountryNamesGroupedByContinentResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", partName = "parameters")
    public ListOfCountryNamesGroupedByContinentResponse listOfCountryNamesGroupedByContinent(

        @WebParam(partName = "parameters", name = "ListOfCountryNamesGroupedByContinent", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        ListOfCountryNamesGroupedByContinent parameters
    );

    /**
     * Returns a list of all stored counties ordered by country name
     */
    @WebMethod(operationName = "ListOfCountryNamesByName")
    @WebResult(name = "ListOfCountryNamesByNameResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", partName = "parameters")
    public ListOfCountryNamesByNameResponse listOfCountryNamesByName(

        @WebParam(partName = "parameters", name = "ListOfCountryNamesByName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        ListOfCountryNamesByName parameters
    );

    /**
     * Returns a list of continents ordered by name.
     */
    @WebMethod(operationName = "ListOfContinentsByName")
    @WebResult(name = "ListOfContinentsByNameResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", partName = "parameters")
    public ListOfContinentsByNameResponse listOfContinentsByName(

        @WebParam(partName = "parameters", name = "ListOfContinentsByName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        ListOfContinentsByName parameters
    );

    /**
     * Find a language name based on the passed ISO language code
     */
    @WebMethod(operationName = "LanguageName")
    @WebResult(name = "LanguageNameResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", partName = "parameters")
    public LanguageNameResponse languageName(

        @WebParam(partName = "parameters", name = "LanguageName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        LanguageName parameters
    );

    /**
     * Returns a list of continents ordered by code.
     */
    @WebMethod(operationName = "ListOfContinentsByCode")
    @WebResult(name = "ListOfContinentsByCodeResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", partName = "parameters")
    public ListOfContinentsByCodeResponse listOfContinentsByCode(

        @WebParam(partName = "parameters", name = "ListOfContinentsByCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        ListOfContinentsByCode parameters
    );

    /**
     * Returns a list of all countries that use the same currency code. Pass a ISO currency code
     */
    @WebMethod(operationName = "CountriesUsingCurrency")
    @WebResult(name = "CountriesUsingCurrencyResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", partName = "parameters")
    public CountriesUsingCurrencyResponse countriesUsingCurrency(

        @WebParam(partName = "parameters", name = "CountriesUsingCurrency", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        CountriesUsingCurrency parameters
    );

    /**
     * This function tries to found a country based on the passed country name.
     */
    @WebMethod(operationName = "CountryISOCode")
    @WebResult(name = "CountryISOCodeResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", partName = "parameters")
    public CountryISOCodeResponse countryISOCode(

        @WebParam(partName = "parameters", name = "CountryISOCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        CountryISOCode parameters
    );

    /**
     * Returns an array with all countries and all the language information stored
     */
    @WebMethod(operationName = "FullCountryInfoAllCountries")
    @WebResult(name = "FullCountryInfoAllCountriesResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", partName = "parameters")
    public FullCountryInfoAllCountriesResponse fullCountryInfoAllCountries(

        @WebParam(partName = "parameters", name = "FullCountryInfoAllCountries", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        FullCountryInfoAllCountries parameters
    );
}
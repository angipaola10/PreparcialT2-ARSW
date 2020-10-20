package edu.eci.arsw.coronavirusStats.Services;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public interface IHttpConectionServices {

    JSONObject getAllCases() throws CoronavirusStatsServicesException;

    JSONObject getCasesByCountry(String country) throws CoronavirusStatsServicesException;

    JSONObject getCordsOfCountry (String country) throws CoronavirusStatsServicesException;

}

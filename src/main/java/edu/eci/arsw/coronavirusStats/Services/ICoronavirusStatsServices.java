package edu.eci.arsw.coronavirusStats.Services;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.coronavirusStats.Model.Case;

import java.io.IOException;
import java.util.List;

public interface ICoronavirusStatsServices {

    List<Case> getAllCases() throws CoronavirusStatsServicesException;

    List<Case> getCasesByCountry(String country) throws CoronavirusStatsServicesException;

}

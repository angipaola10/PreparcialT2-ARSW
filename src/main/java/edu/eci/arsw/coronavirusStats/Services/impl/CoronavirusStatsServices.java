package edu.eci.arsw.coronavirusStats.Services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.eci.arsw.coronavirusStats.Cache.ICoronavirusStatsCache;
import edu.eci.arsw.coronavirusStats.Model.Case;
import edu.eci.arsw.coronavirusStats.Model.Latlng;
import edu.eci.arsw.coronavirusStats.Services.CoronavirusStatsServicesException;
import edu.eci.arsw.coronavirusStats.Services.ICoronavirusStatsServices;
import edu.eci.arsw.coronavirusStats.Services.IHttpConectionServices;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CoronavirusStatsServices implements ICoronavirusStatsServices {

    @Autowired
    IHttpConectionServices httpConectionServices;

    @Autowired
    ICoronavirusStatsCache cache;

    private final String cacheGeneral = "allcountries";
    private final String cacheCountries = "oneCountry";

    public CoronavirusStatsServices() {
    }

    @Override
    public List<Case> getAllCases() throws CoronavirusStatsServicesException {
        if (!cache.containsCache(cacheGeneral) || new Date().getTime() - cache.getCreationDate(cacheGeneral).getTime() >= 300000 ) {
            List<Case> cases = new ArrayList<>();
            try {
                JSONObject jsonObject = httpConectionServices.getAllCases().getJSONObject("data");
                JSONArray array = jsonObject.getJSONArray("covid19Stats");

                for (int i = 0; i < array.length(); i++) {
                    ObjectMapper mapper = new ObjectMapper();
                    Case c = mapper.readValue(array.getJSONObject(i).toString(), Case.class);
                    cases.add(c);
                }
            } catch (Exception e) {
                throw new CoronavirusStatsServicesException(e.getMessage());
            }
            if (cases.size() == 0) {
                throw new CoronavirusStatsServicesException("Cases not found");
            }
            cache.updateCacheData(cacheGeneral, cases);
        }
        return cache.getCacheByName(cacheGeneral);
    }

    @Override
    public List<Case> getCasesByCountry(String country) throws CoronavirusStatsServicesException {
        if (!cache.containsCache(cacheCountries) || new Date().getTime() - cache.getCreationDate(cacheCountries).getTime() >= 300000 ) {
            List<Case> cases = new ArrayList<>();
            try {
                JSONObject jsonObject = httpConectionServices.getCasesByCountry(country).getJSONObject("data");
                JSONArray array = jsonObject.getJSONArray("covid19Stats");

                for (int i = 0; i < array.length(); i++) {
                    ObjectMapper mapper = new ObjectMapper();
                    Case c = mapper.readValue(array.getJSONObject(i).toString(), Case.class);
                    JSONArray jsonArray = httpConectionServices.getCordsOfCountry(country).getJSONArray("latlng");
                    c.setLatlng(new Latlng(jsonArray.getDouble(0), jsonArray.getDouble(1)));
                    cases.add(c);
                }

            } catch (Exception e) {
                throw new CoronavirusStatsServicesException(e.getMessage());
            }
            if (cases.size() == 0) {
                throw new CoronavirusStatsServicesException("Cases by country not found");
            }
            cache.updateCacheData(cacheCountries, cases);
        }
        return cache.getCacheByName(cacheCountries);
    }

}

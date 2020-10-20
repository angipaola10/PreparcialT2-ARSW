package edu.eci.arsw.coronavirusStats.Services.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.coronavirusStats.Model.Case;
import edu.eci.arsw.coronavirusStats.Model.Latlng;
import edu.eci.arsw.coronavirusStats.Services.CoronavirusStatsServicesException;
import edu.eci.arsw.coronavirusStats.Services.ICoronavirusStatsServices;
import edu.eci.arsw.coronavirusStats.Services.IHttpConectionServices;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronavirusStatsServices implements ICoronavirusStatsServices {

    @Autowired
    IHttpConectionServices httpConectionServices;

    public CoronavirusStatsServices() {
    }

    @Override
    public List<Case> getAllCases() throws CoronavirusStatsServicesException {
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
        return cases;
    }

    @Override
    public List<Case> getCasesByCountry(String country) throws CoronavirusStatsServicesException {
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
        return cases;

    }
}

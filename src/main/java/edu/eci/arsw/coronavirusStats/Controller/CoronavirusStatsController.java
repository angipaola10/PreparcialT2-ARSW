package edu.eci.arsw.coronavirusStats.Controller;


import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.coronavirusStats.Services.CoronavirusStatsServicesException;
import edu.eci.arsw.coronavirusStats.Services.ICoronavirusStatsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoronavirusStatsController {

    @Autowired
    ICoronavirusStatsServices cs;

    @RequestMapping(value="/cases", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCases() {
        try {
            return new ResponseEntity<>(cs.getAllCases(), HttpStatus.ACCEPTED);
        } catch (CoronavirusStatsServicesException e) {
            if (e.getMessage().equals("Cases not found")){
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value="/cases/{country}", method = RequestMethod.GET)
    public ResponseEntity<?> getCasesByCountry(@PathVariable (name="country") String country) {
        try {
            return new ResponseEntity<>(cs.getCasesByCountry(country), HttpStatus.ACCEPTED);
        }catch (CoronavirusStatsServicesException e) {
            if (e.getMessage().equals("Cases not found")){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}

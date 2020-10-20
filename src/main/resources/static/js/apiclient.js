api = (function () {

    return {
        getCases: function(callback) {
            var promiseGetAllCases = $.getJSON("http://localhost:8080/cases");
            $.when (promiseGetAllCases).done(function (data) {
                callback(data);
            });
        },

        getCasesByCountry: function(country, callback){
            var promiseGetCasesByCountry = $.getJSON("http://localhost:8080/cases/"+ country);
            $.when (promiseGetCasesByCountry).done(function (data) {
                callback(data);
            });
        }
    }
})();


         
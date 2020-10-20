api = (function () {

    return {
        getCases: function(callback) {
            var promiseGetAllCases = $.getJSON("https://angijimenez-arsw-preparcialt2.herokuapp.com/cases");
            $.when (promiseGetAllCases).done(function (data) {
                callback(data);
            });
        },

        getCasesByCountry: function(country, callback){
            var promiseGetCasesByCountry = $.getJSON("https://angijimenez-arsw-preparcialt2.herokuapp.com/cases/"+ country);
            $.when (promiseGetCasesByCountry).done(function (data) {
                callback(data);
            });
        }
    }
})();


         
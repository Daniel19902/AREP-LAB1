

var index = (function(){

    return {
        //http://localhost:4567/hello/holaa
        conectar : function(tipo){
            //var invocation = new XMLHttpRequest();
            var url = 'http://localhost:4567/hello/ASD';
            fetch('http://localhost:4567/hello/holaa', {
                        method: 'GET',
                        headers: {
                            "Content-type": "application/json"
                        }})
                  .then(response => response.json())
                  .then(json => console.log(json))


        }
    }


})();
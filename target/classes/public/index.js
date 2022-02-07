

var index = (function(){

    return {

        conectar : function(tipo, numero){
            console.log(tipo)
            console.log(numero)
            var url = 'http://localhost:4567/Convertidor/'+ tipo + '/'+ numero;
            fetch(url)

                              .then(response => response.json())
                              .then(json => console.log(json))


                    }
    }


})();
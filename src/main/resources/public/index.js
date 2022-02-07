

var index = (function(){

    return {

        conectar : function(tipo, numero){
            console.log(tipo)
            console.log(numero)
            var url = 'https://agile-springs-22604.herokuapp.com/Convertidor/'+ tipo + '/'+ numero;
            fetch(url)

                              .then(response => response.json())
                              .then(json => console.log(json))


                    }
    }


})();
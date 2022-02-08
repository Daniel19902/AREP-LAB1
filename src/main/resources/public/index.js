

var index = (function(){

    let tipo;
    let tipo1;
    let temperatura;


    return {

        action : function (){
            $('#Celsius').click(function (){
                tipo = $('#Celsius').val()
                tipo1 = $('#Fahrenheit').val()
                $('#span').html("Fahrenheit to Celsius")
                console.log(tipo);
            })
            $('#Fahrenheit').click(function (){
                tipo = $('#Fahrenheit').val()
                tipo1 = $('#Celsius').val()
                $('#span').html("Celsius to Fahrenheit")
                console.log(tipo);
            })

            $('#convertir').click(function (){
                temperatura = $('#temperatura').val()
                index.conectar()
            })
        },


        conectar : function(){
            let urlLocal = 'http://localhost:4567/Convertidor/'+tipo+'/'+temperatura;
            let urlLocalHeroku = 'http://localhost:5000/Convertidor/'+tipo+'/'+temperatura;
            let urlHeroku = 'https://agile-springs-22604.herokuapp.com/Convertidor/'+ tipo + '/'+ temperatura;
            fetch(urlLocal)
                .then(response => response.json())
                .then(function (json){

                    let html =
                    "Temperatura en "+tipo1+": "+json.temperatura+"<br/>"
                    +"Temperatura en "+tipo+": "+json.conversion

                    $('#respuesta').html(html)

                });


        }
    }


})();
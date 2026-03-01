/**
 * @author ubaldo
 */
function sumar() {

    //Envolvemos todo el codigo en un bloque
    //try y catch para procesar la excepcion 
    //en caso de que haya ocurrido alguna

    try {

        //Pedimos el valor del operando a
        var a = prompt("Valor a:", "");

        //validamos parametro a 
        if (!a || isNaN(a)) {
            throw new Error("Valor invalido de a:" + a);
        }

        //pedimos el valor del operando b
        var b = prompt("Valor b:", "");

        //validamos parametro b
        if (!b || isNaN(b)) {
            throw new Error("Valor invalido de b:" + b)
        }

        /* Si no hay problema, hacemos la suma
         * necesitamos convertir a int los parametros
         * partseInt convierte a entero, si no es entero
         * no va a realizar la suma sino concatena los valores
         */

        var c = parseInt(a) + parseInt(b);
        alert("La suma es:" + c);

    } catch (e) {
        alert("El error es:" + e.message);
    }

}

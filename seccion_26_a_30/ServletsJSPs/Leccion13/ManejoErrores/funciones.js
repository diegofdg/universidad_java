var capa;

function cambio(idCapa){

  //Recuperamos la capa segun el elemento disponible
  if (document.layers)
    capa = eval("document." + idCapa);
  if (document.all)
    capa = eval(idCapa + ".style");
  if (document.getElementById)
    capa = eval('document.getElementById("' + idCapa + '").style');

  //Si esta visible la capa la ocultamo, o viceversa
  if ((capa.visibility == "hidden") || (capa.visibility == "hide")){
    capa.visibility = (document.layers) ? "show" : "visible" ;
  }else{
    capa.visibility = (document.layers) ? "hide" : "hidden" ;
  }
}
<!--Agregamos una declaracion de un JSP-->

<%!

    // Declaramos una variable y su metodo get asociado
    private String usuario = "Alberto";

    public String getUsuario(){
        return this.usuario;
    }

    //Declaramos un contador de visitas
    private int contadorVisitas = 1;

%>

<%
    // Declaracion de una variable con un scriptlet
    String nombre = "Juan";
%>
    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Declaraciones en un JSP</title>
    </head>
    <body>
        <h1>Declaraciones en un JSP!</h1>
        <p>Valor usuario por medio del atributo: <%=this.usuario%></p>
        <br/>
        <p>Valor usuario por medio del método: <%=this.getUsuario()%></p>
        <br/>
        <p>Contador de Visitas: <%=this.contadorVisitas++ %></p>
    </body>
</html>

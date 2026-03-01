<!DOCTYPE html>
<html>
    <head>
        <title>Busqueda Avanzada</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/ServletBuscar"
              method="post">
            B&uacute;squeda Avanzada de Alumnos
            <br />
            <br />
            <fieldset>
                <legend>
                    B&uacute;squeda por Alumno
                </legend>
                Nombre Alumno:
                <input type="text" name="nombreAlumno" size="50">
                <br>
                Apellido Paterno:
                <input type="text" name="apellidoPaterno" size="50">
                <br>
                Apellido Materno:
                <input type="text" name="apellidoMaterno" size="50">
            </fieldset>
            <fieldset>
                <legend>
                    <br>
                    B&uacute;squeda por datos de Contacto
                </legend>
                Tel&eacute;fono:
                <input type="text" name="telefono" size="50">
                <br>
                Email:
                <input type="text" name="email" size="50">
            </fieldset>
            <fieldset>
                <legend>
                    <br>
                    B&uacute;squeda por datos de Domicilio
                </legend>
                Calle:
                <input type="text" name="calle" size="50">
            </fieldset>
            <fieldset>
                <legend>
                    <br>
                    B&uacute;squeda por Curso
                </legend>
                Nombre Curso:
                <input type="text" name="nombreCurso" size="50">
            </fieldset>
            <br/>
            <input type="submit" value="Buscar">
        </form>
    </body>
</html>
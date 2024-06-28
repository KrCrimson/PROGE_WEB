<%-- 
    Document   : index
    Created on : 28 jun. 2024, 16:54:22
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="Modelo.clsECargo"%>
<%@page import="ModeloDAO.CargoDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Park Assist</title>
        <style>
            body {
                font-family: 'Arial', sans-serif;
                background-color: #f4f4f9;
                margin: 0;
                padding: 0;
            }

            header {
                background-color: #4CAF50;
                color: white;
                padding: 10px 0;
                text-align: center;
            }

            .container {
                width: 90%;
                margin: 50px auto;
                background-color: white;
                padding: 20px;
                box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
                border-radius: 8px;
            }

            h1 {
                text-align: center;
                color: #333;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            table, th, td {
                border: 1px solid #ddd;
            }

            th, td {
                padding: 10px;
                text-align: left;
            }

            th {
                background-color: #4CAF50;
                color: white;
            }

            tbody tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            form {
                display: flex;
                justify-content: center;
            }

            form button {
                margin: 5px;
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                background-color: #4CAF50;
                color: white;
                font-size: 16px;
                cursor: pointer;
                transition: background-color 0.3s ease, transform 0.3s ease;
            }

            form button:hover {
                background-color: #45a049;
                transform: scale(1.05);
            }

        </style>
    </head>
    <body>
        <header>
            <h1>Listado de Cargos</h1>
        </header>
        <div class="container">
            <table>
                <thead>
                    <tr>
                        <th>ID Cargo</th>
                        <th>Descripción</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    CargoDAO dao = new CargoDAO();
                    List<clsECargo> list = dao.listar();
                    for (clsECargo cargo : list) {
                    %>
                    <tr>
                        <td><%=cargo.getId_cargo()%></td>
                        <td><%=cargo.getDescripcion()%></td>
                        <td>
                            <!--<a href="ControladorCargo?accion=edit&id_cargo=<%= cargo.getId_cargo()%>">Editar</a>-->
                            <!--<a href="ControladorCargo?accion=eliminar&id_cargo=<%= cargo.getId_cargo()%>">Eliminar</a>-->
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </body>
</html>


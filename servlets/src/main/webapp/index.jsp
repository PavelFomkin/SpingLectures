<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
Cookie cookies [] = request.getCookies ();
Cookie myCookie = null;
if (cookies != null)
{
  for (int i = 0; i < cookies.length; i++)
  {
    if (cookies[i].getName().equals("count"))
    {
    myCookie = cookies[i];
    break;
    }
  }
}
if (myCookie == null) {
  Cookie cookie = new Cookie ("count", "1");
  cookie.setMaxAge(30);
  response.addCookie(cookie);
  }
%>
<!DOCTYPE html>
<html>
<head>
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js">
    </script>
</head>
<body>

<div id="msg"></div>

<table>
    <table>
    <thead>
        <tr>
        <th>GET</th>
        <th>POST</th>
        <th>PUT</th>
        <th>DELETE</th>
        <th>Count view</th>
        </tr>
    </thead>
    <tr>
        <td>
            <form method="GET" action="${pageContext.request.contextPath}/index">
                <table>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text"  name="name" /></td>
                    </tr>
                </table>
                <input type="submit"  value="submit"/>
            </form>
        </td>
        <td>
            <form method="POST" action="${pageContext.request.contextPath}/index">
                <table>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text"  name="name" /></td>
                    </tr>
                </table>
                <input type="submit"  value="submit"/>
            </form>
        </td>
        <td>
            <form id="put_method">
                <table>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text"  name="put_name" /></td>
                    </tr>
                </table>
                <input type="submit"  value="submit"/>
            </form>
        </td>
        <td>
            <form id="delete-method">
                <table>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text"  name="delete_name" /></td>
                    </tr>
                </table>
                <input type="submit"  value="submit"/>
            </form>
        </td>
        <td>
            <%
            if (myCookie != null)
            {
            %>
                <%=myCookie.getValue()%>
            <%
            } else {
            %>
              1
            <%
            }
            %>
        </td>
    </tr>
    </table>

    <table>
    <tr>
        <table>
            <c:forEach items="${data}" var="data">
                <tr>
                    <td>${data}</td>
                </tr>
            </c:forEach>
        </table>
    </tr>
    </table>
</table>

<script>
 $("#put_method").submit(function(event){
            event.preventDefault();
            var $form = $(this);
            var url = 'http://localhost:8888/index';
            var userName = $form.find('input[name="put_name"]').val();

            $.ajax({
                type : 'PUT',
                url : url,
                contentType: 'application/json',
                data : JSON.stringify(userName),
                success : function(data, status, xhr){
                   window.location.replace("http://localhost:8888/index");
                },
                error: function(xhr, status, error){
                $('#msg').html('<span style=\'color:red;\'>'+error+'</span>')
                }
            });
        });
  $("#delete-method").submit(function(event){
             event.preventDefault();
             var $form = $(this);
             var url = 'http://localhost:8888/index';
             var userName = $form.find('input[name="delete_name"]').val();

             $.ajax({
                 type : 'DELETE',
                 url : url,
                 contentType: 'application/json',
                 data : JSON.stringify(userName),
                 success : function(data, status, xhr){
                    window.location.replace("http://localhost:8888/index");
                 },
                 error: function(xhr, status, error){
                 $('#msg').html('<span style=\'color:red;\'>'+error+'</span>')
                 }
             });
         });
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>***Ajedrez***</title>
<script type="text/javascript">
function GuardarPartida(){
	var form=document.getElementById(formMovimiento);
	form.action="ServletGuardarPartida";
	form.submit();
}

function Movimiento(){
	var form=document.getElementById(formMovimiento);
	form.action="ServletMovimiento";
	form.submit();
}

</script>
</head>
<body background="Imagenes/1.jpg" >
<table border="3" style="position: absolute; top: 50%; left: 75%; transform:translate(-50%,-50%); width: 50% ; height: 90%;">

<%
// style="+"width=12,5%"+" font-size: 200%
//out.println("<td bgcolor="+"white"+"width="+"10%"+" height="+"10%"+"> </td>");
//out.println( "<td bgcolor="+"white"+" width="+"10%"+" height="+"10%"+"><img src="+"Imagenes/torreblanco.png"+"/></td>"); 
for (int i = 0; i < 8; i++) 
{
	out.println("<tr>");
    for (int j = 0; j < 8; j++) 
    {
       if(i==0){
		    	if(j==0)
		    	{ 
		    		out.println( "<td bgcolor="+"white"+" width="+"10%"+" height="+"10%"+"><img src="+"Imagenes/torreblanco.png"+" align="+"middle"+" /></td>"); 
		    	}
		    	if(j==1)
		    	{ 
		    		out.println( "<td bgcolor="+"black"+" width="+"10%"+" height="+"10%"+"><img src="+"Imagenes/caballoblanco.png"+" align="+"middle"+" /></td>"); 
		    	}
		    	if(j==2)
		    	{ 
		    		out.println( "<td bgcolor="+"white"+" width="+"10%"+" height="+"10%"+"><img src="+"Imagenes/alfilblanco.png"+" align="+"middle"+" /></td>"); 
		    	}
		    	if(j==3)
		    	{ 
		    		out.println( "<td bgcolor="+"black"+" width="+"10%"+" height="+"10%"+"><img src="+"Imagenes/reyblanco.png"+" align="+"middle"+" /></td>"); 
		    	}
		    	if(j==4)
		    	{ 
		    		out.println( "<td bgcolor="+"white"+" width="+"10%"+" height="+"10%"+"><img src="+"Imagenes/reinablanco.png"+" align="+"middle"+" /></td>"); 
		    	}
		    	if(j==5)
		    	{ 
		    		out.println( "<td bgcolor="+"black"+" width="+"10%"+" height="+"10%"+"><img src="+"Imagenes/alfilblanco.png"+" align="+"middle"+" /></td>"); 
		    	}
		    	if(j==6)
		    	{ 
		    		out.println( "<td bgcolor="+"white"+" width="+"10%"+" height="+"10%"+"><img src="+"Imagenes/caballoblanco.png"+" align="+"middle"+" /></td>"); 
		    	}
		    	if(j==7)
		    	{ 
		    		out.println( "<td bgcolor="+"black"+" width="+"10%"+" height="+"10%"+"><img src="+"Imagenes/torreblanco.png"+" align="+"middle"+" /></td>"); 
		    	}
		    	}
       		else { if(i==1){
       			
       		
			       			if ((i + j) % 2 == 0) 
				   			{
			       				out.println( "<td bgcolor="+"white"+" width="+"10%"+" height="+"10%"+"><img src="+"Imagenes/peonblanco.png"+" align="+"middle"+" /></td>");
							}
			   	 				else { 
			   	 				out.println( "<td bgcolor="+"black"+" width="+"10%"+" height="+"10%"+"><img src="+"Imagenes/peonblanco.png"+" align="+"middle"+" /></td>");
			       			
					       	}
       		}
		    		else{
		    				if ((i + j) % 2 == 0) 
		    	   			{
		    				out.println("<td bgcolor="+"white"+" width="+"10%"+" height="+"10%"+"></td>");
		    				}
		       	 				else { 
		       	 				out.println("<td bgcolor="+"black"+" width="+"10%"+" height="+"10%"+"></td>");} 
		    			}
       			}
    }
    out.println("</tr>");
  }

%>

</table>

<form action="" name="formMovimiento" id="formMovimiento" method="POST" style="position: absolute; top: 50% ; left: 15% ; transform: translate(-50%,-50%); font-size: 150%;">
<table>
<tr>
<td colspan="2" align="center" style="font: 150% verdana;">Movimiento: </td>
 </tr>
 <tr>
 <td>Fila Actual: </td>
 <td><input type="text" name="filaActual" id="filaActual"> </td>
 </tr>
 <tr>
  <td>Columna Actual: </td>
 <td><input type="text" name="columnaActual" id="columnaActual"> </td>
 </tr>
 <tr>
  <td>Fila Proxima: </td>
 <td><input type="text" name="filaProx" id="filaProx"> </td>
 </tr>
 <tr>
  <td>Fila Proxima: </td>
 <td><input type="text" name="columnaProx" id="columnaProx"> </td>
 </tr>
  <tr>
  <td><input type="button" value="Realizar Movimiento" onclick="Movimiento()" style="font-weight: bold;"></td>
 </tr>
 <tr>
 <td></td>
  </tr>
 <tr>
 <td></td>
  </tr>
  <tr>
 <td></td>
  </tr>
  <tr>
 <td></td>
  </tr>
  <tr>
 <td></td>
  </tr>
 <td><input type="button" value="Guardar partida" onclick="GuardarPartida()" style="font-weight: bold;"></td>
   </tr>
</table>

</form>

</body>
</html>
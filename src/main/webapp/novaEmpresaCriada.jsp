<%
	String nomeEmpresa = "Alura";
	System.out.println(nomeEmpresa);
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Empresa <% out.println(nomeEmpresa);%> Cadastrada com sucesso!
	</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c:if test="${not empty Empresa}">
			Empresa ${Empresa} Cadastrada com sucesso!
		</c:if>
		
		<c:if test="${empty Empresa}">
			Realize o cadastro para exibir o nome da Empresa.
		</c:if>
		
	</body>
</html>
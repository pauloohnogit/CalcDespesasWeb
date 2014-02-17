<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action=”adicionaCompra” method=”post” >
Titulo: <input type=”text” name=”titulo” />
Descrição: <textarea name=”descricao” rows=”5” cols=”100”></textarea>
Data:<input type=”text” name=”data” />
Valor:<input type=”text” name=”valor” />
No. De Parcelas: <input type=”text” name=”numeroDeParcelas” />
<input type=”submit” value=”gravar”/>
</form>
</body>
</html>
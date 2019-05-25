<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Welcome</title>
</head>
<body>

<div>
    <c:url value="/hello" var="hello"/>
    <a href="${hello}">hello</a>
</div>

<div>
    <c:url value="/helloLocale" var="helloLocale"/>
    <a href="${helloLocale}">model을 이용하여 jsp로 데이터 전송</a>
</div>

<div>
    <c:url value="/helloDto?id=99&message=10&&date=2015/05/25" var="helloDto"/>
    <a href="${helloDto}">queryString을 객체(dto)로 받으면 model에 직접 등록하지 않고 view로 보낼 수 있다</a>
</div>

<div>
    <c:url value="/datasource" var="datasource"/>
    <a href="${datasource}">DataSource 설정 보기</a>
</div>

<div>
    <c:url value="/mapper" var="mapper"/>
    <a href="${mapper}">mapper 로직</a>
</div>

<div>
    <c:url value="/helloPage?id=99&message=10&page=10&date=2015/05/25" var="helloPage"/>
    <a href="${helloPage}">6.4.1 ModelAttribute 사용하여 queryString을 model에 직접 등록하지 않고 view로 보내기</a>
</div>

<div>
    <c:url value="/redirect?id=99&message=10&page=10&date=2015/05/25" var="redirect"/>
    <a href="${redirect}">6.4.2 RedirectAttributes</a>
</div>

<div>
    <c:url value="/json?message=mememe" var="json"/>
    <a href="${json}">6.5.3 json 으로 응답!!!</a>
</div>

<div>
    <c:url value="/responseEntity?message=responsehaha" var="responseEntity"/>
    <a href="${responseEntity}">6.5.4 ResponseEntity로 응답!!</a>
</div>

<div>
    <c:url value="/fileUpload" var="fileUpload"/>
    <a href="${fileUpload}">6.5.5 파일 업로드 처리</a>
</div>

<div>
    <c:url value="/helloDto?id=notNumber" var="invalidHandler"/>
    <a href="${invalidHandler}">6.6.1 Invalid param handler</a>
</div>

<div>
    <c:url value="/ooooooooooooo" var="404"/>
    <a href="${404}">6.6.2 404 error handler</a>
</div>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: bactoria
  Date: 2019-05-25
  Time: 오후 4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
redirected

${id}
${name}
${requestDto}

post로 데이터 전송하고, redirect를 이용하는 방식으로 사용.

요청이 결국 2번 이루어지는데, 처음 요청의 응답의 상태코드는 302이며, 헤더에 location: 를 보면 어디로 redirect됬는지 알 수 있다.

</body>
</html>

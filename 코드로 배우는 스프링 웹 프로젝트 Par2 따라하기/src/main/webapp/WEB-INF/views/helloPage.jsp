<%--
  Created by IntelliJ IDEA.
  User: bactoria
  Date: 2019-05-24
  Time: 오후 3:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>DTO로 자동 전송된 데이터</h3>
${helloRequestDto}

============================

<h3>@ModelAttribute 사용함.</h3>
페이지 번호는 ${page} 이다.

로그 확인해보면 알겠지만, model에 helloRequestDto, page 가 자동으로 담아져 있다.

</body>
</html>

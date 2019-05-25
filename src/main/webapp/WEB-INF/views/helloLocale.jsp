<%--
  Created by IntelliJ IDEA.
  User: bactoria
  Date: 2019-05-24
  Time: 오후 3:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Client's Locale is
${locale}

============================================================
@GetMapping("/helloLocale")
public void helloLocale(Locale locale, Model model) {
model.addAttribute(locale);
}

</body>
</html>

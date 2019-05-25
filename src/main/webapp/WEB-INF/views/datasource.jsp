<%--
  Created by IntelliJ IDEA.
  User: bactoria
  Date: 2019-05-24
  Time: 오후 2:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
driverClassName : ${driverClassName}
username : ${username}

===============================================
@GetMapping("/datasource")
public String datasource(Model model) {
    model.addAttribute("driverClassName", hikariConfig.getDriverClassName());
    model.addAttribute("username", hikariConfig.getUsername());
    return "datasource";
}
</body>
</html>

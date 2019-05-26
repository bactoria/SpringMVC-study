<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp" %>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Tables</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">Board Modify Page</div>
            <!-- /.panel-heading -->
            <div class="panel-body">

                <form role="form" action="/board/modify" method="post">

                    <div class="form-group">
                        <label>Bno</label>
                        <input class="form-control" name="bno" value='<c:out value="${board.bno}" />'
                               readOnly="readonly"/>
                    </div>

                    <div class="form-group">
                        <label>Title</label>
                        <input class="form-control" name="title" value='<c:out value="${board.title}" />'/>
                    </div>

                    <div class="form-group">
                        <label>Text area</label>
                        <textarea class="form-control" name="content" rows="3">
                            <c:out value="${board.content}"/>
                        </textarea>
                    </div>

                    <div class="form-group">
                        <label>Writer</label>
                        <input class="form-control" name="writer" value='<c:out value="${board.writer}" />'
                               readOnly="readonly"/>
                    </div>

                    <button type="submit" data-oper="modify" class="btn btn-default">Modify</button>
                    <button type="submit" data-oper="remove" class="btn btn-danger">Remove</button>
                    <button type="submit" data-oper="list" class="btn btn-info">List</button>
                </form>
            </div>
        </div>
        <!-- /.panel -->
    </div>
</div>
<!-- /.row -->

<%@include file="../includes/footer.jsp" %>

<script type="text/javascript">
    $(document).ready(function () {
        const formObj = $("form");

        $('button').on("click", function (e) {
            e.preventDefault();

            const operation = $(this).data("oper");

            console.log(operation);

            if (operation === 'list') {
                formObj.attr("action", "/board/list").attr("method", "get");
                formObj.empty();
            }

            if (operation === 'remove') {
                formObj.attr("action", "/board/delete");
            }

            formObj.submit();
        })
    })
</script>
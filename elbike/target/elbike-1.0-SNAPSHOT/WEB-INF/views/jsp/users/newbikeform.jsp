<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

    <jsp:include page="../fragments/header.jsp" />

    <div class="container">

        <c:choose>
            <c:when test="${userForm['new']}">
                <h1>Add Bike</h1>
            </c:when>
            <c:otherwise>
                <h1>Add Bike</h1>
            </c:otherwise>
        </c:choose>
        <br />

        <spring:url value="/users" var="userActionUrl" />

        <form:form class="form-horizontal" method="post" modelAttribute="userForm" action="${userActionUrl}">

            <form:hidden path="id" />

            <spring:bind path="name">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-10">
                        <form:input path="name" type="text" class="form-control " id="name" placeholder="Name" />
                        <form:errors path="name" class="control-label" />
                    </div>
                </div>
            </spring:bind>
            <spring:bind path="date1">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Date1</label>
                    <div class="col-sm-10">
                        <form:input path="date1" type="text" class="form-control " id="date1" placeholder="Date1" />
                        <form:errors path="date1" class="control-label" />
                    </div>
                </div>
            </spring:bind>


            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <c:choose>
                        <c:when test="${userForm['new']}">
                            <button type="submit" class="btn-lg btn-edit pull-right">Add</button>
                        </c:when>
                        <c:otherwise>
                            <button type="submit" class="btn-lg btn-edit pull-right">Update</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>

    </div>

    <jsp:include page="../fragments/footer.jsp" />

</body>
</html>
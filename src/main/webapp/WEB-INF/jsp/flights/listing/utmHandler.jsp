<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="tfn" uri="/WEB-INF/tld/tfn-functions.tld" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="true" %>

<c:set var="utmSourceFromBean" value="${flightSearch.utmSource}" />
<c:set var="utmSourceFromParam" value="${param.utm_source}" />
<c:choose>
    <c:when test="${not empty utmSourceFromParam}">
        <c:set var="utmSource" value="${utmSourceFromParam}" />
    </c:when>
    <c:otherwise>
        <c:set var="utmSource" value="${utmSourceFromBean}" />
    </c:otherwise>
</c:choose>

<c:set var="tollFree" value="${tfn:getTFN(utmSource, pageContext.request)}" scope="session" />

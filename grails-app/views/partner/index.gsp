<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'partner.label', default: 'Partner')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-partner" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="list-partner" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table class="table table-striped table-hover" id="partners">
        <thead>
        <tr>
            <th>Code</th>
            <th>Subdomain</th>
            <th>Has Own Clinician</th>
            <th>States Available</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${partnerList}" status="i" var="partner">
            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                <td><a href="show/${partner.id}">${fieldValue(bean: partner, field: "code")}</a></td>
                <td>${fieldValue(bean: partner, field: "subdomain")}</td>
                <td>${fieldValue(bean: partner, field: "has_own_clinician")}</td>
                <td>${fieldValue(bean: partner, field: "partnerstatesavailable")}</td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>
</body>
</html>
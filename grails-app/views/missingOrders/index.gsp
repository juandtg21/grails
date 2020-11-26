<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'missingOrders.label', default: 'MissingOrders')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-missingOrders" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                    default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-missingOrders" role="main">
    <h1>Missing Orders <g:submitButton name="Clear Search" onclick="clearsearch()" id="clearsearch" value="Clear Search"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table class="table table-striped table-hover" id="orders">
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Dob</th>
            <th>Barcode</th>
            <th>Received Date</th>
            <th>Email</th>
            <th>Error code</th>
        </tr>
        </thead>
        <tbody>

        <g:each in="${missingOrdersList}" status="i" var="missingOrder">
            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                <td><a href="show/${missingOrder.id}">${fieldValue(bean: missingOrder, field: "first_name")}</a></td>
                <td>${fieldValue(bean: missingOrder, field: "last_name")}</td>
                <td>${fieldValue(bean: missingOrder, field: "dob")}</td>
                <td>${fieldValue(bean: missingOrder, field: "barcode")}</td>
                <td>${fieldValue(bean: missingOrder, field: "received_date")}</td>
                <td>${fieldValue(bean: missingOrder, field: "email")}</td>
                <td>${fieldValue(bean: missingOrder, field: "error_code")}</td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>
<g:javascript>
    $(document).ready(function data() {
        var table = tableformat();
        $('#orders thead tr').clone(true).appendTo('#orders thead');
        $('#orders thead tr:eq(1) th').each(function (i) {
            var title = $(this).text();

            $(this).html('<input type="text" class="cleansearch" placeholder="Search ' + title + '" id="' + title.replace(/ /g, '') + '" />');

            $('input', this).on('keyup change', function () {
                if (table.column(i).search() !== this.value) {
                    table.column(i).search(this.value).draw();
                }

            });
        });
        document.getElementById("Dob").style.display = "none";
        document.getElementById("ReceivedDate").type = "date";

    });
    function tableformat() {
        var table = $('#orders').DataTable({
            paging: false,
            bFilter: false,
            ordering: false,
            searching: true,
            dom: 't'
        });
        return table;
    }
    function clearsearch() {
        $('#orders thead tr:eq(1) th input').val('').change();
    }
</g:javascript>
</body>
</html>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>
    <g:layoutHead/>
</head>

<body>
<header>
    <nav class="navbar navbar-expand-md navbar-light bg-light " role="navigation">
        <div><a class="navbar-brand" href="/#"><asset:image src="binx.png" width="100" height="50" alt="Binx Logo"/></a></div>
        <ul class="navbar-nav">
            <li><a class="nav-link">ORDERS</a></li>
            <li><a class="nav-link">COUPONS</a></li>
            <li><a href="/partner/index" class="nav-link">PARTNERS</a></li>
            <li><a class="nav-link">KITS</a></li>
            <li><a href="/missingOrders/index" class="nav-link">MISSING ORDERS</a></li>
        </ul>

    </nav>
</header>


<g:layoutBody/>

<div class="myfooter" role="contentinfo">
    <div class="container">
        <span class="text-muted">binx-2020</span>
    </div>
</div>


<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>



</body>
</html>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <%
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);
        response.setHeader("Pragma", "no-cache");
    %>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="layout" content="main">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="${assetPath(src: 'ico-favicon.png')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${assetPath(src: 'ico-favicon.png')}">
    <link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'ico-favicon.png')}">
    <title>Smart City Gateway : <g:layoutTitle/></title>

    <!-- Bootstrap core CSS -->
    <asset:stylesheet src="bootstrap.css"/>
    <!-- Custom styles for this template -->
    <asset:stylesheet src="custom.css"/>
    <asset:stylesheet src="footer.css"/>
    <asset:stylesheet src="font-face.css"/>
    <asset:stylesheet src="font-awesome.css"/>

    <g:layoutHead/>
</head>

<body>
<!-- MAIN CONTAINER -->
<div id="wrap">
    <!-- HEADER -->
    <g:render template="/layouts/header"/> <!-- systemConfigurations -->
    <!-- / HEADER -->

    <!-- CONTENT -->
    <div class="main-content">
        <g:layoutBody/>
    </div>
    <!--  CONTENT -->
</div>
<!-- / MAIN CONTAINER -->

<!-- FOOTER -->
<div id="footer">
    <div class="container">
        <p class="copy">M8 / SwCraft / Fun Factory / F2 - Todos os direitos reservados.</p>
        <g:if env="development">
            <span class="version">v: ${grailsApplication?.metadata?.get('app.version')}</span>
        </g:if>
    </div>
</div>
<!-- / FOOTER -->

<!-- Bootstrap core JavaScript Placed at the end of the document so the pages load faster -->
<asset:javascript src="application.js"/>

<!-- CONTENT FOR ALL MODALS ON THIS PAGE -->
<g:render template="/general/modal-signin" />
<!-- / CONTENT FOR ALL MODALS ON THIS PAGE -->

</body>
</html>

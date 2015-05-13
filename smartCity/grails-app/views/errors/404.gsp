<!DOCTYPE html>
<html>
	<head>
		<title>Page not found</title>
        <meta name="layout" content="${layout ?: 'vendor'}">
	</head>
	<body>
    <div class="error-page-title">
        <h1>Error 404: Page Not Found</h1>
        <p>We are sorry, but it seems the page you are looking for is missing or does not exist.</p>
        <p>Please check the URL or use the navigation above to browse the system.</p>

        <g:if test="${!layout}">
            <div class="text-center">
                <form>
                    <input type="button" value="Return" class="btn btn-default btn-lg"
                           onClick="history.go(-1);return true;">
                </form>
            </div>
        </g:if>
    </div>
	</body>
</html>

<!DOCTYPE html>
<html>
	<head>
		<title><g:if env="development">Grails Runtime Exception</g:if><g:else>Error</g:else></title>
		<meta name="layout" content="${layout ?: 'vendor'}">
	</head>
	<body>
    <div class="error-page-title">
        <h1>Error 500: Internal Server Error</h1>
        <p>Sorry, unfortunately something went wrong unexpectedly, our team is already trying to solve it. In any case, please report this incident to administrator.</p>

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

<!-- PAGE FLASH MESSAGES -->
<g:if test="${flash.message}">
    <div class="alert alert-dismissible alert-warning" role="alert" id="add_alert-warning-message">
        <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <g:message message='${flash.message}'/>
    </div>
</g:if>
<g:if test="${flash.successMessage}">
    <div class="alert alert-dismissible alert-success" role="alert" id="add_alert-success-message">
        <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <g:message message='${flash.successMessage}'/>
    </div>
</g:if>
<g:if test="${flash.errorMessage}">
    <div class="alert alert-dismissible alert-danger" role="alert" id="add_alert-danger-message">
        <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <g:message message='${flash.errorMessage}'/>
    </div>
</g:if>
<g:if test="${flash.errors}">
    <div class="alert alert-dismissible alert-danger" role="alert" id="add_alert-dismissible-danger-message">
        <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <g:each in="${flash.errors.allErrors}" status="i" var="error"><g:message message='${error}'/><br></g:each>
    </div>
</g:if>
<!-- / PAGE FLASH MESSAGES -->



<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'event.label', default: 'Evento')}" />
		<title>Adicionar Evento</title>
	</head>
	<body>
		<div id="create-event" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${eventInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${eventInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:eventInstance, action:'save']" >
				<fieldset class="form">
                    <g:hiddenField name="status" value="O"/>
                    <fieldset class="form modal-body">

                        <div class="form-group row fieldcontain ${hasErrors(bean: eventInstance, field: 'type', 'error')} required">
                            <label for="type">
                                Tipo de Evento
                                <span class="required-indicator">*</span>
                            </label>
                            <g:select name="type" from="${availableTypes}"
                                      class="form-control width30p" required=""
                                      optionValue="description" optionKey="id"
                                      value="${eventInstance?.type?.name()}"/>

                        </div>

                        <div class="form-group row fieldcontain ${hasErrors(bean: eventInstance, field: 'lat', 'error')} required">
                            <label for="lat">
                                Latitude
                                <span class="required-indicator">*</span>
                            </label>
                            <g:textField name="lat" class="form-control width30p number-only" required="" maxlength="14"
                                         value="${eventInstance?.lat}"/>
                        </div>

                        <div class="form-group row fieldcontain ${hasErrors(bean: eventInstance, field: 'lng', 'error')} required">
                            <label for="lng">
                                Longitude
                                <span class="required-indicator">*</span>
                            </label>
                            <g:textField name="lng" class="form-control width30p number-only" required="" maxlength="14"
                                         value="${eventInstance?.lng}"/>

                        </div>


                        <g:if test="${eventInstance?.status}">
                            <div class="form-group row fieldcontain ${hasErrors(bean: eventInstance, field: 'status', 'error')} required">
                                <label for="status">
                                    Situação
                                    <span class="required-indicator">*</span>
                                </label>
                                <g:select name="status" from="${br.edu.cesar.reuso.Status?.values()}"
                                          keys="${br.edu.cesar.reuso.Status.values()*.name()}" class="form-control width30p" required=""
                                          value="${eventInstance?.status?.name()}"/>

                            </div>
                        </g:if>
                        <div class="form-group row fieldcontain ${hasErrors(bean: eventInstance, field: 'description', 'error')} ">
                            <label for="description">
                                Descrição do Evento
                            </label>
                            <g:textField name="description" class="form-control width30p" required="" value="${eventInstance?.description}"/>
                        </div>
                    </fieldset>
				</fieldset>

                <fieldset class="btn-group-sm" style="float: right">
                    <a type="button" class="btn btn-secondary" href="${createLink(uri: '/event/')}">
                        <span class="fa fa-close"></span> ${message(code: 'smartCity.default.cancel.label')}
                    </a>
                    <g:submitButton name="create" class="btn btn-primary" id="bt-confirm-create-entity"
                                    value="${message(code: 'smartCity.default.confirm.label')}" />
                </fieldset>

                <div class="clearfix"></div>
			</g:form>
		</div>
	</body>
</html>

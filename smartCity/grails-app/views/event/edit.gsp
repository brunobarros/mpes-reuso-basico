<%@ page import="br.edu.cesar.reuso.domain.Event" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'event.label', default: 'Event')}"/>
    <title>Editar Evento</title>
</head>

<body>

<div id="edit-event" class="content scaffold-edit" role="main">
    <h1>Editar Evento</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${eventInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${eventInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                        error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form url="[resource: eventInstance, action: 'update']" method="PUT">
        <g:hiddenField name="version" value="${eventInstance?.version}"/>
        <fieldset class="form modal-body">
            <g:hiddenField name="uid" value="${eventInstance.uid}"/>

            <g:if test="${eventInstance?.type}">
                <div class="form-group row fieldcontain ${hasErrors(bean: eventInstance, field: 'type', 'error')} required">
                    <label for="type">Tipo de Evento</label>
                    <span name="type" class="form-control width30p property-value" style="background-color: #dddddd"
                          aria-labelledby="type-label"><g:fieldValue bean="${eventInstance}"
                                                                     field="type"/></span>
                </div>
            </g:if>

            <g:if test="${eventInstance?.status}">
                <div class="form-group row fieldcontain ${hasErrors(bean: eventInstance, field: 'status', 'error')} required">
                    <label for="status">
                        Situação
                        <span class="required-indicator">*</span>
                    </label>
                    <g:select name="status" from="${br.edu.cesar.reuso.Status?.values()}"
                              keys="${br.edu.cesar.reuso.Status.values()*.name()}" class="form-control width30p"
                              required=""
                              value="${eventInstance?.status?.name()}"/>

                </div>
            </g:if>


            <g:if test="${eventInstance?.lat}">
                <div class="form-group row fieldcontain ${hasErrors(bean: eventInstance, field: 'lat', 'error')} required">
                    <label for="lat">Latitude</label>

                    <span class="property-value form-control width30p" aria-labelledby="lat-label"
                          style="background-color: #dddddd"><g:fieldValue
                            bean="${eventInstance}"
                            field="lat"/></span>

                </div>
            </g:if>

            <g:if test="${eventInstance?.lng}">
                <div class="form-group row fieldcontain ${hasErrors(bean: eventInstance, field: 'lng', 'error')} required">
                    <label for="lng">Longitude</label>

                    <span class="property-value form-control width30p" aria-labelledby="lng-label"
                          style="background-color: #dddddd"><g:fieldValue
                            bean="${eventInstance}"
                            field="lng"/></span>

                </div>
            </g:if>

            <g:if test="${eventInstance?.description}">
                <div class="form-group row fieldcontain ${hasErrors(bean: eventInstance, field: 'description', 'error')} required">
                    <label for="description">Descrição do Evento</label>

                    <span class="property-value form-control width30p" aria-labelledby="extra-label"
                          style="background-color: #dddddd"><g:fieldValue
                            bean="${eventInstance}"
                            field="description"/></span>

                </div>
            </g:if>

            <g:if test="${eventInstance?.openingDate}">
                <div class="form-group row fieldcontain ${hasErrors(bean: eventInstance, field: 'date', 'error')} required">
                    <label for="date">Date Created</label>

                    <span class="property-value form-control width30p" aria-labelledby="dateCreated-label"
                          style="background-color: #dddddd"><g:formatDate
                            date="${eventInstance?.openingDate}"/></span>

                </div>
            </g:if>
        </fieldset>


        <fieldset class="btn-group-sm" style="float: right">
            <a type="button" class="btn btn-secondary" href="${createLink(uri: '/event/show/')}${eventInstance.uid}">
                <span class="fa fa-close"></span> ${message(code: 'smartCity.default.cancel.label')}
            </a>
            <g:actionSubmit class="btn btn-primary save" action="update"
                            value="${message(code: 'default.button.update.label', default: 'Update')}"/>
        </fieldset>

        <div class="clearfix"></div>
    </g:form>
</div>
</body>
</html>

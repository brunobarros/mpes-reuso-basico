<%@ page import="br.edu.cesar.reuso.domain.Event" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'event.label', default: 'Event')}"/>
    <title>Visualizar Evento</title>
</head>

<body>
<div id="show-event" class="content scaffold-show" role="main">
    <h1>Visualizar Evento</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>


    <fieldset class="form modal-body col-lg-6">

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
                <label for="status">Situação do Evento</label>
                <span name="type" class="form-control width30p property-value" style="background-color: #dddddd"
                      aria-labelledby="type-label"><g:fieldValue bean="${eventInstance}"
                                                                 field="status"/></span>
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

    <fieldset class="form modal-body col-lg-6">
        <div class="form-group row fieldcontain">
            %{--<label>Mapa</label>--}%
            <span>
            <iframe width="550" height="450" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"
                    src="${eventInstance.mapUrl}"></iframe></span>
        </div>
    </fieldset>

    <div class="clearfix"></div>
    <fieldset class="form modal-body">

        <fieldset class="btn-group-sm" style="float: right">
            <a type="button" class="btn btn-secondary" href="${createLink(uri: '/event/')}">
                <span class="fa fa-close"></span> ${message(code: 'smartCity.default.cancel.label')}
            </a>
            <g:if test="${sec.loggedInUserInfo(field: 'id').length() > 0}">
                <a href="${createLink(uri: '/event/edit/')}${eventInstance.uid}" title="Visualizar evento"
                   class="edit btn btn-success">Editar</a>
            </g:if>
        </fieldset>

        <div class="clearfix"></div>
    </fieldset>
</div>
</body>
</html>

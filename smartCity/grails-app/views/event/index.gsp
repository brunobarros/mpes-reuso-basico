<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="layout" content="main">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Serviços</title>
</head>

<body>

<!-- PAGE MESSAGES -->
<g:render template="/general/modal-flash-message" />
<!-- / PAGE MESSAGES -->

<!-- TITLE -->
<div class="btn-group-sm pull-right">
    <a type="button" class="btn btn-primary" id="bt-create-entity" href="${createLink(uri: '/event/create')}">
        <span class="fa fa-plus"></span> ${message(code: 'default.new.label', args: ['Evento'])}
    </a>
</div>

<h1 class="page-title"><g:message code="smartCity.page.title" /></h1>
<!-- / TITLE -->

<div class="clearfix"></div>

<!-- PAGINATION TOP -->
<g:render template="/general/pagination-header" model="['myList':eventList, 'searchValue': params.search]"/>
<!-- / PAGINATION TOP -->

<!-- GRID -->
<div class="col-lg-12 padding0">

    <div class="table-responsive">

        %{--data e hora de abertura, descrição, status (em aberto, em andamento, concluído), geolocalização (latitude e longitude)--}%

        <table id="grid-entity-records" class="table grid table-hover table-striped">
            <thead>
            <tr>
                <g:sortableColumn property="type" title="${message(code: 'smartCity.default.type.label')}" params="[search: params.search]" class="width120"/>
                <th class="width240" id="extra">${message(code: 'smartCity.default.description.label')}</th>
                <g:sortableColumn property="status" title="${message(code: 'smartCity.default.status.label')}" params="[search: params.search]" class="width90"/>
                <th class="width90" id="latitude">${message(code: 'smartCity.default.lat.label')}</th>
                <th class="width90" id="longitude">${message(code: 'smartCity.default.lng.label')}</th>
                <th class="width90" id="map">Mapa</th>
                <g:sortableColumn property="openingDate" title="${message(code: 'smartCity.default.dateCreated.label')}" params="[search: params.search]" class="width30"/>
            </tr>
            </thead>
            <tbody id="entity-tbody">
            <g:if test="${!eventList}">
                <tr class="tr-empty-grid"><td colspan="7"><g:message code="smartCity.info.list.empty" /></td></tr>
            </g:if>
            <g:else>
                <g:each in="${eventList}" var="it" status="i">
                    <tr id="row-${i}" data-identifier="${it.uid}" data-model="Event">
                        <td>
                            <a href="${createLink(uri: '/event/show/')}${it.uid}" title="Visualizar evento" class="block">${it.type}</a>
                        </td>
                        <td>${it.description}</td>
                        <td>${it.status}</td>
                        <td>${it.lat}</td>
                        <td>${it.lng}</td>
                        <td><a data-toggle="modal" data-target="#md-map" data-link="${it?.mapUrl}"
                               data-backdrop="static" class="fa fa-map-marker lnkMap"> ver</a></td>
                        <td>${formatDate(format:'dd/MM/yyyy hh:mm a',date:it?.openingDate)}</td>
                    </tr>
                </g:each>
            </g:else>
            </tbody>
        </tbody>
        </table>
    </div>
</div>
<!-- GRID -->

<g:render template="modal-map" />

</body>
</html>
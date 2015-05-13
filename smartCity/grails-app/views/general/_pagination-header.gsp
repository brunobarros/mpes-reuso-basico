<g:set var="startIndex" value="${params.offset ? params.offset.toInteger() : 0}" />
<g:set var="messageResults" value=" Mostrando ${myList ? (startIndex + 1) + '-' + (startIndex + myList.size()) + ' de ' + myList.totalCount.toString() : '0'} " />
<input type="hidden" name="totalCount" id="totalCount" value="${myList?.size() ?: 0}" />
<div class="pagination-container clearfix">
    <div class="pagination-msg">
        <g:if test="${searchValue}">
            <span class="fa fa-search"></span>${myList ? messageResults : ' Não há'} resultados para "<strong>${searchValue}</strong>"
            <g:if test="${!myList}">Verifique se você digitou corretamente e tente novamente.</g:if>
            <a id="btn_clear_search" href="#" title="Clear search" class="a-icon" onclick="clearSearchAndSubmit();"><span class="fa fa-close"></span></a>
        </g:if>
        <g:else>${messageResults}resultados</g:else>
    </div>
    <g:if test="${myList}">
        <div class="pagination pagination-sm pull-right margin6" >
            <g:set var="customParams" value="${additionalParams ? [search: params.search] << (additionalParams as Map) : [search: params.search] }" />
            <g:paginate controller="${controller}" action="index" total="${myList.totalCount}" params="${customParams}"/>
        </div>
    </g:if>
    <div class="clearfix"></div>
</div>
package br.edu.cesar.reuso.controller

/**
 * Created on 2015-01-27.
 *
 * General controller to handle CRUD operations.
 */
class CRUDController {

    // Constants
    static final String METHOD_POST = 'POST'
    static final String METHOD_PUT = 'PUT'
    static final String METHOD_GET = 'GET'
    static final String METHOD_DELETE = 'DELETE'
    static final String ACTION_INDEX = 'index'
    static final Map ACTION_INDEX_METHOD_GET = [action: ACTION_INDEX, method: METHOD_GET]

    /**
     * Redirects to the entities list
     */
    protected redirectToIndex() {
        redirect(['params': session[SESSION_PARAMS_KEY_NAME]] << ACTION_INDEX_METHOD_GET)
    }

    /**
     * Save the parameters in session
     * @return
     */
    protected saveParams() {
        session[SESSION_PARAMS_KEY_NAME] = [
                'search': params.SEARCH,
                'offset': params.offset,
                'max'   : params.max,
                'sort'  : params.sort,
                'order' : params.order
        ]
    }

    /**
     * Check if a request for a transactional function is made by method GET.
     * @return
     */
    protected checkTransactionalFunctionByRequestGet() {
        if (request.get) {
            redirectToIndex()
            return false
        }
    }

    /**
     * Check if the last page of the list is empty. Case true, redirect to the previous page. Case the previous page is
     * also empty, redirect to the first page.
     * @param resultCount The count of records in the current page
     * @return
     */
    protected checkLastPageEmptyResult(Integer resultCount) {
        Integer offset = (params.offset == null || params.offset == '') ? 0 : params.offset.toInteger()
        Integer max = (params.max == null || params.max == '') ? 0 : params.max.toInteger()

        if (resultCount == 0 && offset > 0) {
            Integer newOffset = 0

            if (params.isLastPageEmptyResultChecked) {
                session[SESSION_PARAMS_KEY_NAME].isLastPageEmptyResultChecked = false
            } else {
                newOffset = offset - max
                session[SESSION_PARAMS_KEY_NAME].isLastPageEmptyResultChecked = true
            }

            session[SESSION_PARAMS_KEY_NAME].offset = newOffset
            redirectToIndex()
        }
    }
}

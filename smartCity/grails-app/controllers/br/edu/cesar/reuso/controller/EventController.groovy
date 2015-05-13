package br.edu.cesar.reuso.controller

import br.edu.cesar.reuso.EventUiElement
import groovyx.net.http.*
import br.edu.cesar.reuso.domain.Event
import grails.plugin.springsecurity.SpringSecurityService
import grails.transaction.Transactional
import org.springframework.security.access.annotation.Secured

@Secured('permitAll')
class EventController extends CRUDController {

    // Constants
    static final String SESSION_PARAMS_KEY_NAME = '____params_____'

    // Maps the http allowed method to the controller services.
    static allowedMethods = [
            index: METHOD_GET,
            show : METHOD_GET,
            save : METHOD_POST,
            update: METHOD_PUT,
            validate: METHOD_POST
    ]

    /**
     * Injection of the spring security service
     */
    SpringSecurityService springSecurityService

    /**
     * Redirect to index page
     */
    def index(Integer max) {
        params.max = Math.min(max ?: 100, 300)

        if (params.sort == null || params.sort == '') {
            params.sort = Event.DEFAULT_SORTING
        }

        saveParams()

        List<Event> events = loadEvents()
        checkLastPageEmptyResult(events.size())

        render view: 'index', model: [
                eventList: events
        ]
    }

    /**
     * Returns a event based on the object id.
     * @param eventInstance The event being returned
     */
    def show() {
        respond getEventDetails()
    }

    def create() {
        Set<EventUiElement> elements = loadEventTypeComponent()
        render view: 'create', model: [
                eventInstance: new Event(params),
                availableTypes : elements
        ]
    }

    def edit() {
        render view: 'edit', model: [
                eventInstance: getEventDetails()
        ]
    }

    /**
     * Creates a new event and returns it.
     */
    @Transactional
    def save(Event eventInstance) {
        if (eventInstance == null) {
            notFound()
            return
        }

        if (eventInstance.hasErrors()) {
            flash.errorMessage = message(code: 'default.validation.error')
        }
        else {
            boolean success = false

            try {
                def http = new HTTPBuilder('http://localhost:8080')
                http.request (Method.POST) { multipartRequest ->
                    def query = [
                            tipo_chamado: "${eventInstance.type}",
                            latitude: "${eventInstance.lat}",
                            longitude : "${eventInstance.lng}",
                            descricao : "${eventInstance.description}" ]

                    uri.path = '/chamados'
                    uri.query = query

                    response.success = { resp, data ->
                        success = true
                    }
                }
            }
            catch (Exception ex) {
                ex.printStackTrace()
            }

            if(success) {
                flash.successMessage = 'Evento criado com sucesso'
            }
            else {
                flash.ErrorMessage = 'Não foi possível criar o evento.'
            }
        }

        redirectToIndex()
    }

    /**
     * Updates an event and returns it.
     */
    @Secured(['IS_AUTHENTICATED_FULLY'])
    def update() {
        boolean success = false

        try {
            def http = new HTTPBuilder('http://localhost:8080')
            http.request (Method.PUT) { multipartRequest ->
                def query = [
                        id: "${params?.uid}",
                        status : "${params?.status}" ]

                uri.path = '/chamados'
                uri.query = query

                response.success = { resp, data ->
                    success = true
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace()
        }

        if(success) {
            flash.successMessage = 'Evento atualizado com sucesso'
        }
        else {
            flash.ErrorMessage = 'Não foi possível atualizar o evento.'
        }

        redirectToIndex()
    }

    /**
     * Redirects to this page to self and displays a not found message.
     */
    protected void notFound() {
        flash.message = message(code: 'default.not.found.message', args: [Event.ENTITY_NAME, params.id])
        redirect action: "index", method: "GET"
    }

    private Set<EventUiElement> loadEventTypeComponent() {
        Set<EventUiElement> elements = []

        def http = new HTTPBuilder('http://localhost:8080/chamados/tiposchamados')
        http.request(Method.GET, ContentType.JSON) { req ->
            response.success = { resp, json ->
                // handle response
                elements = json.collect {
                    new EventUiElement(id: it?.codigo, description: it?.descricao)
                }
            }
        }
        elements
    }

    private List<Event> loadEvents() {
        List<Event> events = []

        try {
            def http = new HTTPBuilder('http://localhost:8080/chamados/lista')
            http.request(Method.GET, ContentType.JSON) { req ->
                response.success = { resp, json ->
                    // handle response
                    events = json.collect {
                        //May 12, 2015 10:06:26 AM
                        Date date = Date.parse("EEE, dd MMM yyyy HH:mm:ss zzz", it.dataHoraAbertura)
                        new Event(uid: it?.id, description: it?.descricao, openingDate: date, status:it.status, lat: it.latitude,
                                lng: it.longitude, type: it.tipoChamado?.descricao, mapUrl: it.linkMapa)
                    }
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace()
        }


        if (!events.hasProperty('totalCount')) {
            events?.metaClass?.getTotalCount =  { events.size() }
        }

        events
    }

    private Event getEventDetails() {
        Event eventInstance = null

        def http = new HTTPBuilder('http://localhost:8080')
        http.request(Method.GET, ContentType.JSON) { req ->
            def query = [id: "${params.id}"]
            uri.path = '/chamados/detalhes'
            uri.query = query

            response.success = { resp, json ->
                // handle response
                eventInstance = new Event(uid: json?.id, description: json?.descricao, status: json.status,
                        lat: json.latitude, lng: json.longitude, type: json.tipoChamado?.descricao, mapUrl: json.linkMapa)
            }
        }
        eventInstance
    }
}
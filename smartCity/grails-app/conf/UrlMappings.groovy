class UrlMappings {

    static mappings = {

        /////////////////////////////////////////////
        // Default
        /////////////////////////////////////////////

        "/$controller/$action?/$id?(.$format)?" {
            constraints { id(matches: /[1-9][0-9]*/) }
        }

        "/"(redirect: "/event")
        "500"(controller: 'errors', action: 'unknownError')
        "404"(view: '/errors/404')
    }
}
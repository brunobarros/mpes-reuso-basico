grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination

// The ACCEPT header will not be used for content negotiation for user agents containing the following strings (defaults to the 4 major rendering engines)
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [ // the first one is the default format
                      all:           '*/*', // 'all' maps to '*' or the first available format in withFormat
                      atom:          'application/atom+xml',
                      css:           'text/css',
                      csv:           'text/csv',
                      form:          'application/x-www-form-urlencoded',
                      html:          ['text/html','application/xhtml+xml'],
                      js:            'text/javascript',
                      json:          ['application/json', 'text/json'],
                      multipartForm: 'multipart/form-data',
                      rss:           'application/rss+xml',
                      text:          'text/plain',
                      hal:           ['application/hal+json','application/hal+xml'],
                      xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// Legacy setting for codec used to encode data with ${}
grails.views.default.codec = "html"

// The default scope for controllers. May be prototype, session or singleton.
// If unspecified, controllers are prototype scoped.
grails.controllers.defaultScope = 'singleton'

// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        // filteringCodecForContentType.'text/html' = 'html'
    }
}


grails.converters.encoding = "UTF-8"
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

// configure passing transaction's read-only attribute to Hibernate session, queries and criterias
// set "singleSession = false" OSIV mode in hibernate configuration after enabling
grails.hibernate.pass.readonly = false
// configure passing read-only to OSIV session by default, requires "singleSession = false" OSIV mode
grails.hibernate.osiv.readonly = false


//def HOST_ADDRESS = '127.0.0.1'
//def hostname = InetAddress.getByName(HOST_ADDRESS).getHostAddress()

environments {
    development {
        grails.logging.jul.usebridge = true
        grails.serverURL = "http://localhost:8090/${appName}"
    }
    production {
        grails.logging.jul.usebridge = false
//        grails.serverURL = "http://localhost:8080/${appName}"
    }
}

log4j = {
    appenders {
        def catalinaBase = System.properties.getProperty('catalina.base')
        if (!catalinaBase) catalinaBase = '.'
        def logDirectory = "${catalinaBase}/logs/smartCity/"

        // Create a File object representing the log folder
        def folder = new File(logDirectory)

        // If it doesn't exist
        if (!folder.exists()) {
            // Create all folders up-to and including log
            folder.mkdirs()
        }

        rollingFile name: "smartCityRFAppender",
                maxFileSize: 1048576, // 1MB
                file: "${logDirectory}/smartCity-prod.log",
                layout: pattern(conversionPattern: "[%d{yyyy-MMM-dd HH:mm} %c %x %-5p]: %m%n")
        file name: "smartCityFileAppender",
                file: "$logDirectory/smartCity.log",
                layout: pattern(conversionPattern: "[%d{yyyy-MMM-dd HH:mm} %c %x %-5p]: %m%n")
    }
    environments {
        development {
            debug smartCityFileAppender:  'grails.app'
            // trace smartCityFileAppender:  'org.hibernate.type'
            // debug smartCityFileAppender:  'org.hibernate.SQL'
            root {
                error 'stdout', 'smartCityFileAppender'
            }
        }
        production {
            debug smartCityRFAppender:  'grails.app'
            root {
                error 'smartCityRFAppender'
            }
        }
    }
}

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'br.edu.cesar.reuso.domain.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'br.edu.cesar.reuso.domain.UserRole'
grails.plugin.springsecurity.authority.className = 'br.edu.cesar.reuso.domain.Role'

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        '/':                              ['permitAll'],
        '/index':                         ['permitAll'],
        '/index.gsp':                     ['permitAll'],
        '/assets/**':                     ['permitAll'],
        '/**/js/**':                      ['permitAll'],
        '/**/css/**':                     ['permitAll'],
        '/**/images/**':                  ['permitAll'],
        '/**/favicon.ico':                ['permitAll']
]
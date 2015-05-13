package br.edu.cesar.reuso.domain

import br.edu.cesar.reuso.Status

class Event {

    static final String ENTITY_NAME = 'Evento'
    static final String DEFAULT_SORTING = 'openingDate'


    /**
     * The event uid
     */
    long uid

    /**
     * The event type.
     */
    String type

    /**
     * The event latitude
     */
    BigDecimal lat

    /**
     * The event lngitude
     */
    BigDecimal lng

    /**
     * The event Status.
     */
    Status status

    /**
     * Extra description
     */
    String description

    /**
     * Extra description
     */
    String mapUrl

    /**
     * The date which the object was saved to the database.
     * This property is automatically set by Grails GORM when the object is saved.
     */
    Date openingDate

    static constraints = {
        description (unique: false, nullable: true, blank: true, size: 0..64)
        mapUrl (nullable: true)
        openingDate (nullable: true)
    }

}

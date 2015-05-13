import groovy.time.TimeCategory

/**
 * Created by miguel on 1/13/15.
 */
class DateHelperTagLib {
    def timePassed = { attrs, body ->
        def currentDate = new Date()

        out << """<span title="${formatDate(format:'MMM dd, yyyy hh:mm a', date: attrs?.date)}">"""
        use(TimeCategory) {
            def diff = currentDate - attrs?.date
            if (diff < 1.minute) {
                out << diff.seconds.toString() + " seconds ago"
            } else if (diff < 2.minutes) {
                out << diff.minutes.toString() + " minute ago"
            } else if (diff < 60.minutes) {
                out << diff.minutes.toString() + " minutes ago"
            } else if (diff < 2.hours) {
                out << diff.hours.toString() + " hour ago"
            } else if (diff < 1.day) {
                out << diff.hours.toString() + " hours ago"
            } else if (diff < 2.day) {
                out << "Yesterday"
            } else {
                out << formatDate(format:'MMM dd, yyyy hh:mm a', date: attrs?.date).toString()
            }
        }
        out << """</span>"""
        out << body()
    }
}

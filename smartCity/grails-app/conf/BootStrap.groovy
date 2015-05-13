import br.edu.cesar.reuso.domain.Event
import br.edu.cesar.reuso.EventType
import br.edu.cesar.reuso.domain.Role
import br.edu.cesar.reuso.Status
import br.edu.cesar.reuso.domain.User
import br.edu.cesar.reuso.domain.UserRole

class BootStrap {

    def init = { servletContext ->
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true, failOnError: true)
        def admin = new User(username: 'admin', enabled: true, password: 'admin').save(flush: true, failOnError: true)
        new UserRole(user: admin, role: adminRole).save(flush: true, failOnError: true)
    }

    def destroy = {
    }
}

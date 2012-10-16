import com.yourapp.Role
import com.yourapp.User
import com.yourapp.UserRole

class BootStrap {

    def init = { servletContext ->
        if(Role.list().size() == 0) {
            new Role(authority: 'ROLE_ADMIN').save(flush: true)
            new Role(authority: 'ROLE_USER').save(flush: true)
        }

        if(User.count() == 0){
            def newAdmin = new User(username: 'admin', enabled: true, password: 'zerod').save(flush: true)
            def newUser = new User(username: 'zerod', enabled: true, password: 'zerod').save(flush: true)

            UserRole.create newAdmin, Role.findByAuthority('ROLE_ADMIN'), true
            UserRole.create newUser, Role.findByAuthority('ROLE_USER'), true
        }


    }
    def destroy = {
    }
}

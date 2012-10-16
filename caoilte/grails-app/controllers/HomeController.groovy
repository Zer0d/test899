import grails.plugins.springsecurity.Secured

class HomeController {

    @Secured(['isFullyAuthenticated()'])
    def index() {
    render(view: 'index')
    }
}

import grails.test.mixin.*

@TestFor(HomeController)
class HomeControllerTests {

    void testHome() {
        controller.index()
        assert view.endsWith('/index')
    }
}

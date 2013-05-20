package linklike



import grails.test.mixin.*
import org.junit.*
import grails.test.mixin.domain.DomainClassUnitTestMixin


/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(LinkController)
@TestMixin(DomainClassUnitTestMixin)
@Mock([Link])
class LinkControllerTests {

    void testList() {
       mockDomain(Link,[[title:'google', url:'www.google.com'],
               			[title:'mangapark', url:'www.mangapark.com'],
               			[title:'9gag', url:'www.9gag.com'],
               			[title:'gamespot', url:'www.gamespot.com'],
               			[title:'steam', url:'store.steampowered.com']])
       def con = controller.index()
       assert con.links.size() == 5

       def gg = Link.get(1)
       def mp = Link.get(2)
       def steam = Link.get(5)
       assert gg != null
       assert mp != null
       assert steam != null
       assertEquals "google",gg.title
       assertEquals "www.google.com",gg.url
       assertEquals "mangapark",mp.title
       assertEquals "www.mangapark.com",mp.url
       assertEquals "steam",steam.title
       assertEquals "store.steampowered.com",steam.url
    }

    void testLikeAndUnlike()
    {
    	mockDomain(Link,[[title:'google', url:'www.google.com'],
               			[title:'mangapark', url:'www.mangapark.com'],
               			[title:'9gag', url:'www.9gag.com'],
               			[title:'gamespot', url:'www.gamespot.com'],
               			[title:'steam', url:'store.steampowered.com']])
        def gg = Link.get(1)
        def steam = Link.get(5)
        assert gg != null
        assert steam != null

        assertEquals 0, gg.lcount
        controller.testUnlike(gg)
        assertEquals 0, gg.lcount
        controller.testLike(gg)
        assertEquals 1, gg.lcount

        controller.testLike(steam)
        assertEquals 1, steam.lcount
        controller.testLike(steam)
        assertEquals 2, steam.lcount
        controller.testUnlike(steam)
        assertEquals 1, steam.lcount
    }
}

package linklike



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Link)
class LinkTests 
{

    void testAdd() 
    {
       def link = new Link(title: "google", url: "www.google.com")
       assert link != null
    }

    void testValue()
    {
    	def link = new Link(title: "google", url: "www.google.com")
       	assertEquals "google", link.title
       	assertEquals "www.google.com", link.url
       	assertEquals 0, link.lcount

       	def link2 = new Link(tile: "apple", url: "www.apple.com", lcount: 10)
       	assertEquals 10, link2.lcount
    }
}

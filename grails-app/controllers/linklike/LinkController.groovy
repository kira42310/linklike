package linklike

class LinkController {

    def index() 
    { 
    	def links = Link.findAll()
        [ links: links ]
    }

    def create()
    {
    	def link = new Link(title: params.title, url: params.url)
        link.save()
        redirect(action: "index")
    }

    def like()
    {
    	def link = Link.get(params.id)
    	link.lcount++
    	link.save()
    	redirect(action: "index")
    }

    def testLike(link)
    {
    	link.lcount++
    	link.save()
    }

    def unlike()
    {
    	def link = Link.get(params.id)
    	if(link.lcount >0) 
    	{
    		link.lcount--
    		link.save()
    	}
    	redirect(action: "index")
    }


    def testUnlike(link)
    {
    	if(link.lcount >0) 
    	{
    		link.lcount--
    		link.save()
    	}
    }
}

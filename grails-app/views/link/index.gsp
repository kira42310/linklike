<h1>Link Like</h1>

<g:form name="linkCreateForm" url="[action:'create']">
  Title: <g:textField name="title"/><br/>
  URL: <g:textField name="url"/><br/>
  <input type="submit" value="Add new link"/>
</g:form>

<hr>

<ul>
  <% if(links.size() == 0) { %>
    <li>No links</li>
  <% } else { %>
    <% for(link in links) { %>
      <li><%= link.title %> URL: <a href="http://<%= link.url %>"><%= link.url %></a> Like: <%= link.lcount %></li>
      <g:link action="like" id="${link.id}">Like</g:link>
      &nbsp;&nbsp;&nbsp;&nbsp;
      <g:link action="unlike" id="${link.id}">Dislike</g:link>
    <% } %> 
  <% } %>
</ul>

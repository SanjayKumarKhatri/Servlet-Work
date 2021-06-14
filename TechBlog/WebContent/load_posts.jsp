<%@page import="com.tech.blog.entities.Posts"%>
<%@page import="java.util.List"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<div class="row">
<%
	PostDao pd = new PostDao();
	int cid = Integer.parseInt(request.getParameter("cid"));
	System.out.println(cid);
	List<Posts> posts = null;
	if(cid == 0){
		posts = pd.getallposts();
	}else{
		posts = pd.getallpostsbyCategory(cid);
	}
	if(posts.size() == 0){
		response.getWriter().println("<h3 class='display-3 text-center text-white'>No Post in this Category..</h3>");
			return;
	}
	for(Posts p : posts){
			%>
			<div class="col-md-6 mt-2 mb-2">
				<div class="card" >
					<img class="card-img-top img-fluid" src="blogpic/<%=p.getpPic() %>" alt="Card-img-cap" >
					<div class="card-body">
						<b><%=p.getpTitle() %></b>
						<p class="content"><%=p.getpContent() %></p>
						<!-- <pre><%=p.getpCode() %></pre> -->
					</div>
					<div class="card-footer bg-primary text-center">
						<a href="#!" class="btn btn-outline-light btn-sm"><i class="fa fa-thumbs-o-up"></i><span>10</span></a>
						<a href="show_blog_page.jsp?post_id=<%=p.getPid() %>" class="btn btn-outline-light btn-sm">Read More..</a>
						<a href="#!" class="btn btn-outline-light btn-sm"><i class="fa fa-commenting-o"></i><span>10</span></a>
					</div>
				</div>
			</div>
			<%
		}
%>
</div>
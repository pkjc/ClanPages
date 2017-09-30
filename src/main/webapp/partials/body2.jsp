<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="nav.jsp" />

<div class="container jumbotron text-center">
	<div class="">
		<div class="text-center">
			<img src="http://lorempixel.com/125/125/" class="rounded" alt="">
		</div>
		<h1 class="display-4 mt-2">Fluid jumbotron</h1>
		<p class="lead">This is a modified jumbotron that occupies the
			entire horizontal space of its parent.</p>
	</div>
</div>

<div class="container">

	<%
		int counter = 0;
		int numOfCols = 3;
		int rowCount = 0;
	%>

	<div class="row justify-content-center">
		<c:forEach items="${personList}" var="person" varStatus="loopCount">
			<div class="col-md-4 col-sm-6 col-xs-6">
				<div class="card" style="" data-toggle="modal" data-target="#basicExample" style="width: 20rem;">
					<img class="card-img-top"
						src="http://lorempixel.com/150/100/people/<%=counter%>"
						alt="Card image cap">
					<div class="card-block">
						<h4 class="card-title">${person.name}</h4>
						<h6 class="card-subtitle mb-2 text-muted">${headlines[loopCount.index]}</h6>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
					</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">${locations[loopCount.index]}</li>
					</ul>
					<div class="card-block">
						<a href="#" class="card-link">More Info &rarr;</a>
					</div>
				</div>
			</div>
			<!-- col -->

			<%
					counter++;
					rowCount++;
					if (rowCount % numOfCols == 0) {
						out.write("</div><div class='row justify-content-center'>");
					};
			%>

		</c:forEach>

	</div>
</div>
<jsp:include page="fullProfileModal.jsp" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
     <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Shopping -${title}</title>
    
     <script>
     window.menu = '${title}';
     </script>
    <%-- <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/myapp.css" rel="stylesheet"> --%>
    
   
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
     <link href="<c:url value="/resources/css/myapp.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap-readable-theme.css" />" rel="stylesheet">
</head>

 

  <body>

    <!-- Navigation -->
    <div class="wrapper">
<%@include file="./shared/navbar.jsp" %>
    <!-- Page Content -->
    <div class="content"> 
    
    <c:if test="${userClickHome == true }">
    <%@include file="home.jsp" %>
    </c:if>
    <!-- load only when user clicks -->
    <c:if test="${userClickAbout == true }">
    <%@include file="about.jsp" %>
    </c:if>
    
    <c:if test="${userClickContact == true }">
    <%@include file="contact.jsp" %>
    </c:if>
    
    
    <c:if test="${userClickAllproducts == true or userClickCategoryProducts==true }">
    <%@include file="listProducts.jsp" %>
    </c:if>
    
    
    </div>
    
        <!-- /.container -->

    <!-- Footer -->
    <%@include file="./shared/footer.jsp" %>

    <%-- <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.js"></script>
    <script src="${js}/bootstrap.min.js"></script> --%>
    
    <script src="<c:url value="/resources/js/jquery.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.bundle.min.js" />"></script>
    
     <!-- self coded javascript -->
     <script src="<c:url value="/resources/js/myapp.js" />"></script>
     </div>
  </body>

</html>

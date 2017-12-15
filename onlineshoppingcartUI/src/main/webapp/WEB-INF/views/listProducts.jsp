<div class="container">
<div class="row">
<!-- would be to dispaly side bar -->
<div class="col-md-3">

<%@include file="./shared/sidebar.jsp"%>
</div>
<!-- To display the actual products -->
<div class ="col=md-7">
 <div class="row">
  <div class="col-lg-11.5">
  <c:if test="${userClickAllproducts == true }">
  <ol class="breadcrumb">
     <li><a href="/onlineshoppingcartUI/home">Home</a>
     <li class="active">&nbsp&nbsp&nbsp All Products</li>
  </ol>
  </c:if>
  
  <c:if test="${userClickCategoryProducts == true }">
  <ol class="breadcrumb">
     <li><a href="/onlineshoppingcartUI/home">Home</a>
     <li class="active"> &nbsp&nbsp&nbsp Category</li>
     <li class="active">&nbsp ${category.name}</li>
  </ol>
  </c:if>
  
  
  </div>
 
 </div>

</div>
</div>
</div>
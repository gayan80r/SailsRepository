
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %><!--api wada karana application springframework nisai-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- Using this tag for "looping"-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Purchase Order Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
<div class="genaric-container">
    <div class ="jumbotron" style=" background: #435d7d; color: #fff; ;
"> <center><h2>Purchase Order Form</h2></center></div>

    <sform:form method="POST" modelAttribute="PurchaseOrder">
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-1 control-label"></label>
                <label class="col-md-2 control-label" for="poDate">Date:</label>
                <div class ="col-md-3"><sform:input path="poDate" type="date" id="poDate"/>
                </div>
                <label class="col-md-1 control-label"></label>
                <label class="col-md-2 control-label" for="poNumber">Purchase Order #:</label>
                <div class ="col-md-3"><sform:input path="poNumber" type="text" id="poNumber"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-1 control-label"></label>

                <div class=" col-md-3">
                    <button type="button" data-toggle="modal" data-target="#ItemModel" class="btn btn-info">Add more Items</button>
                    <div class="modal fade" id="ItemModel" role="form">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h3> Add Item To Puchase</h3>
                                </div>
                                <div class="modal-body">
                                    <sform:form modelAttribute="product" method="POST">
                                        <div><label>Item</label></div>
                                        <div>
                                            <sform:select path="item" items="${itemList}" itemValue="id" itemLabel="name" id="product"> </sform:select>
                                        </div>
                                        <div>
                                            <label>Quantity</label>
                                        </div>
                                        <div>
                                            <sform:input type="text" path="quantity" id="quantity"/>
                                        </div>

                                    </sform:form>
                                    <div class="modal-footer">
                                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                        <input type="button" class="btn btn-success" value="Add" id="additem">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>


        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-1 control-label"></label>
                <!--<label class="">Item List</label>-->
                <div class="col-md-6">

                        <table class="table table-dark table-striped table-hover" >
                        <thead>
                        <tr>
                            <th>Item Name</th>
                            <th>Item Quantity</th>
                            <th>Price</th>
                            <th>Line Total</th>
                            <th>Remove</th>
                        </tr>
                        </thead>
                            <tbody>
                            <c:set var="totalAmount" value="0"></c:set>

                            <c:forEach var="product" items="${sessionScope.pList.productList}">
                                <c:set var="totalAmount" value="${totalAmount+product.lineTotal}">

                                </c:set>
                                <tr>

                                <td>${product.item.name}</td>
                                <td>${product.quantity}</td>
                                <td>${product.item.sellingPrice}</td>
                                <td>${product.lineTotal}</td>

                                <td>
                                    <a href="#" class="btn btn-danger"> Remove </a></td>
                                </tr>
                            </c:forEach>


                            <tr>

                                <td colspan="3">Total Amount</td>
                                <td>

                                    <sform:input readonly="true" path="totalPrice" id="totalprice" value=" ${totalAmount}"/>


                                </td>
                            </tr>
<%--                            product do not have item name but have item object then we can get the item.name--%>



                            </tbody>
                    </table>


                </div>

            </div>

        </div>
        <div> <input type="button" id="btnSave" class="btn btn-success" value="save"> </div>
    </sform:form>
</div>
</body>
</html>


<script type="application/javascript">
    function addItemAjaxCall() {
        //get the value of the product text box
       var product=document.getElementById("product").value;
        var quantity=document.getElementById("quantity").value;
        //create the java script object
        var contents = [p=product,q=quantity];
        //JSON.stringify is uesd to convert js object in json string
        //then pass the string in to the to controller from UI
        var jsonData = {json: JSON.stringify(contents)};
        $.ajax({
            type:'GET',
            //we added the Jsondata and call /pocontroller/additem' controller,
            url:'/pocontroller/additem',
            data:jsonData,
            dataType:"json",
            Success:function (data) {
                location.reload();
            },
            error:function (data) {
                location.reload();
            }


        });

    }

    function savePurchaseOrderAjaxCall(){
        var poDate=document.getElementById("poDate").value;
        var poNumber=document.getElementById("poNumber").value;
        var total=document.getElementById("totalprice").value;

        var contents = [pdate=poDate,pnum=poNumber,totalamn=total];
        var jsonData = {json: JSON.stringify(contents)};

        //var jsonData="";

        $.ajax({
            type:'POST',
            url:'/pocontroller/neworder',
            data:jsonData,
            dataType:"json",
            Success:function (data) {
                location.reload();
            },
            error:function (data) {
                location.reload();
            }


        });


    }
    $(document).ready(function () {
        //this section we implemented our business logic
        //when user click on the additem button it will call the addItemAjaxCall();
        $("#additem").click(function (event) {
            addItemAjaxCall();
            $("#ItemModel").modal('hide');

        });

        $("#btnSave").click(function (event) {
            savePurchaseOrderAjaxCall();


        });

    });

</script>




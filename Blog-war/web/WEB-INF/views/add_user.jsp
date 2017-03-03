<%-- 
    Document   : add_user
    Created on : Mar 2, 2017, 2:59:58 PM
    Author     : Avatar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JavaEE7 Blog</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <link href='https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="resources/css/newCascadeStyleSheet.css">
         <link rel="stylesheet" href="resources/css/grid.css">
       
    </head>
    <body>
        <div class="h1">
            
            <h1>Welcome to our JavaEE7 Blog </h1>
            
        </div>
        <div class="container">
           <form action="add_user" method="post"> 
                <div class="row">      
                    <div class="col-md-6 offset-md-3">
                        <label for="firstName">NAME</label>
                        <input name="firstName" class="form-control" type="text">    
                    </div>            
                </div>
            
                <div class="row">
                    <div class="col-md-6 offset-md-3">
                        <label for="email">EMAIL</label>
                        <input name="email" class="form-control" type="email">             
                    </div>            
                </div>
            
                <div class="row">
                   <div class="col-md-6 offset-md-3">
                        <label for="password">PASSWORD</label>
                        <input name="password" class="form-control" type="password">             
                    </div>            
                </div>
               
                <div class="row">
                   <div class="col-md-6 offset-md-3">
                       <label for="gender">Gender</label>
                        <select name="gender">
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                        </select>           
                    </div>            
                </div>
                <hr>
                
                <div class="row">
                    <div class="col-md-6 offset-md-3">
                        <button class="btn btn-default regbutton">Register</button>
                    </div>
                    
                </div>
           </form>
        </div>
    </body>
</html>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<title>eStock - Le site qui gère votre stock</title>
<link rel="icon" href="http://www.estock.co.uk/logo.png" />
 
<style>
	body{
		background-image: url("https://images.unsplash.com/photo-1587542513982-535059868fad?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1950&q=80");
	}
	
	@import url(https://fonts.googleapis.com/css?family=Open+Sans);


		
		.search {
		  width: 100%;
		  position: relative;
		  display: flex;
		}
		
		.searchTerm {
		  width: 40%;
		  border: 3px solid #00B4CC;
		  border-right: none;
		  padding: 5px;
		  height: 30px;
		  border-radius: 5px 0 0 5px;
		  outline: none;
		  color: #9DBFAF;
		}
		
		.searchTerm:focus{
		  color: #00B4CC;
		}
		
		.searchButton {
		  width: 40px;
		  height: 30px;
		  border: 1px solid #00B4CC;
		  background: #00B4CC;
		  text-align: center;
		  color: #fff;
		  border-radius: 0 5px 5px 0;
		  cursor: pointer;
		  font-size: 20px;
		}
		
		/*Resize the wrap to see the search bar change!*/
		.wrap{
		  width: 30%;
		  position: fixed;
		  top: 3%;
		  right: 7%;
		  transform: translate(-50%, -50%);
		}

</style>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

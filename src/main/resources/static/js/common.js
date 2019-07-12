/*
<link rel="stylesheet" type="text/css" media="screen" href="required/ui.jqgrid.css" /> 
<link rel="stylesheet" type="text/css" media="screen" href="required/jquery-ui.css" /> 
*/	
/*jQuery(document).ready(function(){
    $.getScript('/js/jquery/jquery.jqGrid.js');
    $.getScript('/js/jquery/grid.locale-en.js');
    $.getScript('/js/jquery/jquery-ui.js');
    $.getScript('/js/common.js');
    
    $.getScript('/css/jquery/jquery-ui.css');
    $.getScript('/css/jquery/ui.jqgrid.css');
    $.getScript('/css/common.css');
});
*/

/*<!-- The jQuery library is a prerequisite for all jqSuite products -->
<script type="text/ecmascript" src="/js/jquery/jquery.js"></script> 

<!-- This is the Javascript file of jqGrid -->   
<script type="text/ecmascript" src="/js/jquery/jquery.jqGrid.js"></script>

<!-- This is the localization file of the grid controlling messages, labels, etc.-->
 <!-- We support more than 40 localizations -->

<script type="text/ecmascript" src="/js/jquery/grid.locale-en.js"></script>   

<script type="text/ecmascript" src="/js/jquery/jquery-ui.js"></script>
*/
/*<!-- The link to the CSS that the grid needs -->*/
/*<link rel="stylesheet" type="text/css" media="screen" href="/css/jquery/ui.jqgrid.css" /> 

<!-- A link to a jQuery UI ThemeRoller theme, more than 22 built-in and many more custom -->
<link rel="stylesheet" type="text/css" media="screen" href="/css/jquery/jquery-ui.css" /> 

<link rel="stylesheet" type="text/css" media="screen" href="/css/common.css" />
	*/

var oldAction = "";

function loadPage(actionName){
	 $.ajax({
         url: "http://localhost:2222/pfintrack/"+actionName,
         success: function (result) {
        	 $("#FORM").html(result);
        	 if(actionName != "newTrxn"){
	        	 if(oldAction.length > 0){
	        		 $("#"+oldAction).removeClass("active");
	        	 }
	        	 $("#"+actionName).addClass("active");
	        	 oldAction = actionName;
        	 }
         }
       });
}
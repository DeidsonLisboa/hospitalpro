/**
 * 
 */


window.onload = function(){
	  
    $("#add-enfermeiro").click(function(){
    	
    	var enfermeiroAdicionado = function(idEnfermeiro){
    		var inputHiddenEnf = $("#enf-"+idEnfermeiro);
    		console.log(inputHiddenEnf);
    		console.log(inputHiddenEnf.lenght);
    		return (inputHiddenEnf.val());
    	};
    	
    	var selectEnfermeiro = $('#sel-enfermeiro').find(":selected");
    	var nomeEnfermeiro = selectEnfermeiro.text();
    	var idEnfermeiro = selectEnfermeiro.val();
    	
    	var html = "<li id='li-enf-" + idEnfermeiro + "' class='list-group-item d-flex justify-content-between align-items-center'> " +
		    		  	"<input id='enf-" + idEnfermeiro + "' type='hidden' name='enfermeirosIDs' value='" + idEnfermeiro + "'> " +
		    		  		nomeEnfermeiro +
		    		  		"<button type='button' class='del-enf btn btn-danger btn-sm' value='" + idEnfermeiro + "'>" +
		    		  		"<span class='glyphicon glyphicon-remove'></span> Remover " +
		    		  		"</button>" +
		    	   "</li>";
    	
		console.log(idEnfermeiro);
		console.log(enfermeiroAdicionado(idEnfermeiro));
		
		if(!enfermeiroAdicionado(idEnfermeiro)){
			$("#enfermeiros").append(html);
		}else{
			$.notify('O Enfermeiro <b>' + nomeEnfermeiro + '</b> jÃ¡ foi adicionado.');
		}
        
        
        $(".del-enf").click(function(){
        	var idEnfermeiro = $(this).attr("value");
        	$("#li-enf-" + idEnfermeiro).remove();
        });
    });
    
    
    $(".del-enf").click(function(){
    	var idEnfermeiro = $(this).attr("value");
    	$("#li-enf-" + idEnfermeiro).remove();
    });
    
    $.notifyDefaults({
    	type: 'success',
    	allow_dismiss: true,
    });
    
};

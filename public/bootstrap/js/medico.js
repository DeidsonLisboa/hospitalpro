/**
 * 
 */

window.onload = function(){
	  
    $("#add-medico").click(function(){
    	
    	var medicoAdicionado = function(idMedico){
    		var inputHiddenMed = $("#med-"+idMedico);
    		console.log(inputHiddenMed);
    		console.log(inputHiddenMed.lenght);
    		return (inputHiddenMed.val());
    	};
    	
    	var selectMedico = $('#sel-medico').find(":selected");
    	var nomeMedico = selectMedico.text();
    	var idMedico = selectMedico.val();
    	
    	var html = "<li id='li-med-" + idMedico + "' class='list-group-item d-flex justify-content-between align-items-center'> " +
		    		  	"<input id='med-" + idMedico + "' type='hidden' name='medicosIDs' value='" + idMedico + "'> " +
		    		  		nomeMedico +
		    		  		"<button type='button' class='del-med btn btn-danger btn-sm' value='" + idMedico + "'>" +
		    		  		"<span class='glyphicon glyphicon-remove'></span> Remover " +
		    		  		"</button>" +
		    	   "</li>";
    	
		console.log(idMedico);
		console.log(medicoAdicionado(idMedico));
		
		if(!medicoAdicionado(idMedico)){
			$("#medicos").append(html);
		}else{
			$.notify('O medico <b>' + nomeMedico + '</b> jÃ¡ foi adicionado.');
		}
        
        
        $(".del-med").click(function(){
        	var idMedico = $(this).attr("value");
        	$("#li-med-" + idMedico).remove();
        });
    });
    
    
    $(".del-med").click(function(){
    	var idMedico = $(this).attr("value");
    	$("#li-med-" + idMedico).remove();
    });
    
    $.notifyDefaults({
    	type: 'success',
    	allow_dismiss: true,
    });
    
};
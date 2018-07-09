/**
 * 
 */

window.onload = function(){
	  
    $("#add-paciente").click(function(){
    	
    	var pacienteAdicionado = function(idPaciente){
    		var inputHiddenPaci = $("#paci-"+idPaciente);
    		console.log(inputHiddenPaci);
    		console.log(inputHiddenPaci.lenght);
    		return (inputHiddenPaci.val());
    	};
    	
    	var selectPaciente = $('#sel-paciente').find(":selected");
    	var nomePaciente = selectPaciente.text();
    	var idPaciente = selectPaciente.val();
    	
    	var html = "<li id='li-paci-" + idPaciente + "' class='list-group-item d-flex justify-content-between align-items-center'> " +
		    		  	"<input id='paci-" + idPaciente + "' type='hidden' name='pacientesIDs' value='" + idPaciente + "'> " +
		    		  		nomePaciente +
		    		  		"<button type='button' class='del-paci btn btn-danger btn-sm' value='" + idPaciente + "'>" +
		    		  		"<span class='glyphicon glyphicon-remove'></span> Remover " +
		    		  		"</button>" +
		    	   "</li>";
    	
		console.log(idPaciente);
		console.log(pacienteAdicionado(idPaciente));
		
		if(!pacienteAdicionado(idPaciente)){
			$("#pacientes").append(html);
		}else{
			$.notify('O paciente <b>' + nomePaciente + '</b> jÃ¡ foi adicionado.');
		}
        
        
        $(".del-paci").click(function(){
        	var idPaciente = $(this).attr("value");
        	$("#li-paci-" + idPaciente).remove();
        });
    });
    
    
    $(".del-paci").click(function(){
    	var idPaciente = $(this).attr("value");
    	$("#li-paci-" + idPaciente).remove();
    });
    
    $.notifyDefaults({
    	type: 'success',
    	allow_dismiss: true,
    });
    
};
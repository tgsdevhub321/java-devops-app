var width="";
$( document ).ready(function() { 
	width=$(window).width();
	//if(width<=767)
});

function setAncillaries(ancillariesType, value, status){
	
	console.log("AncillariesType :: "+ancillariesType+" & Value :: "+value+" & Status :: "+status);
	
	/*alert("AncillariesType :: "+ancillariesType+" & Value :: "+value+" & Status :: "+status);*/
	var fareladderct = $("#fareladderct");
	var fareladdercp = $("#fareladdercp");
	var fareladderwc = $("#fareladderwc");
	var faresurefund = $("#faresurefund");
	
	var cancelProtAmount = $("#cancellationProtectAmount").val();
	
	var changeableTktAmt = $("#changeableTicketAmount").val();
	var webcheckinAmount = $("#webcheckinAmount").val();
	
	var surefuntAmount = $("#surefundAmount").val();
	
	console.log("surefuntAmount => "+surefuntAmount);
	//var surefuntAmount = value;
	
	var grandTotal = $("#grandTotal").val(); 
	var totalPrice = grandTotal;
	
	if(ancillariesType=='CT'){
		if(status=='Y'){
			fareladderct.slideDown(200);
			$("#changeableTickets").val("Yes");
			document.getElementById("ct_price").innerHTML = parseFloat(changeableTktAmt).toFixed(2);
			totalPrice = Number(changeableTktAmt)+Number(grandTotal)+Number(cancelProtAmount)+Number(webcheckinAmount)+Number(surefuntAmount);
		}
		else{
			fareladderct.slideUp(200);
			$("#changeableTickets").val("No");
			changeableTktAmt=0.00;
			document.getElementById("ct_price").innerHTML = parseFloat(changeableTktAmt).toFixed(2);
			totalPrice = Number(changeableTktAmt)+Number(grandTotal)+Number(cancelProtAmount)+Number(webcheckinAmount)+Number(surefuntAmount);
		}
	}
	
	if(ancillariesType=='CP'){
		if(status=='Y'){
			fareladdercp.slideDown(200);
			$("#cancellationProtectTaken").val("Yes");
			document.getElementById("cp_price").innerHTML = parseFloat(cancelProtAmount).toFixed(2);
			totalPrice = Number(grandTotal)+Number(cancelProtAmount)+Number(changeableTktAmt)+Number(webcheckinAmount)+Number(surefuntAmount);
		}
		else{
			fareladdercp.slideUp(200);
			$("#cancellationProtectTaken").val("No");
			cancelProtAmount=0.00;
			document.getElementById("cp_price").innerHTML = parseFloat(cancelProtAmount).toFixed(2);
			totalPrice = Number(grandTotal)+Number(cancelProtAmount)+Number(changeableTktAmt)+Number(webcheckinAmount)+Number(surefuntAmount);
		}
	}
	
	if(ancillariesType=='WC'){
		if(status=='Y'){
			fareladderwc.slideDown(200);
			$("#webcheckinTaken").val("Yes");
			document.getElementById("wc_price").innerHTML = parseFloat(webcheckinAmount).toFixed(2);
			totalPrice = Number(grandTotal)+Number(cancelProtAmount)+Number(changeableTktAmt)+Number(webcheckinAmount)+Number(surefuntAmount);
		}
		else{
			fareladderwc.slideUp(200);
			$("#webcheckinTaken").val("No");
			webcheckinAmount=0.00;
			document.getElementById("wc_price").innerHTML = parseFloat(webcheckinAmount).toFixed(2);
			totalPrice = Number(grandTotal)+Number(cancelProtAmount)+Number(changeableTktAmt)+Number(webcheckinAmount)+Number(surefuntAmount);
		}
	}
	
	if(ancillariesType=='SR'){
		if(status=='Y'){
			faresurefund.slideDown(200);
			$("#surefundTaken").val("Yes");
			
			console.log("surefund test = "+surefuntAmount);
			
			document.getElementById("sr_price").innerHTML = parseFloat(surefuntAmount).toFixed(2);
			totalPrice = Number(grandTotal)+Number(cancelProtAmount)+Number(changeableTktAmt)+Number(webcheckinAmount)+Number(surefuntAmount);
		}
		else{
			faresurefund.slideUp(200);
			$("#surefundTaken").val("No");
			surefuntAmount=0.00;
			document.getElementById("sr_price").innerHTML = parseFloat(surefuntAmount).toFixed(2);
			totalPrice = Number(grandTotal)+Number(cancelProtAmount)+Number(changeableTktAmt)+Number(webcheckinAmount)+Number(surefuntAmount);
		}
	}
	
	document.getElementById("total_price").innerHTML = parseFloat(totalPrice).toFixed(2);
	document.getElementById("tp_mob_ftr").innerHTML = parseFloat(totalPrice).toFixed(2);
} 
	
function addChangeTickets(name, amount, dispAmt){
		/*alert("AddChangeTickets "+name+" - "+amount);*/
	if(name=='Standard'){
		$("#changeableTicketAmount").val(Number(amount));
		$("#changeableTickets").val("Yes");
		$("#changeableTicketType").val("Standard");
		$("#changeableText").text("Standard Ticket Fee");
		
		$("#tktTxt").html("Standard Ticket");
		$("#tktcost").html(Number(dispAmt).toFixed(2));
		
		$("#basicCls").removeClass("selectedborder");
		$("#standCls").addClass("selectedborder");
		$("#flexCls").removeClass("selectedborder");
	    
		$('#btnStandardTicket').prop('checked', true);
		$("#btnFlexibleTicket").prop('checked', false);
		$("#btnBasicTicket").prop('checked', false);
		
		setAncillaries('CT', Number(amount), 'Y');
	}else if(name=='Flexible'){
		$("#changeableTicketAmount").val(Number(amount));
		$("#changeableTickets").val("Yes");
		$("#changeableTicketType").val("Flexible");
		$("#changeableText").text("Flexible Ticket Fee");
		
		$("#tktTxt").html("Flexible Ticket");
		$("#tktcost").html(Number(dispAmt).toFixed(2));

		$("#basicCls").removeClass("selectedborder");
		$("#standCls").removeClass("selectedborder");
		$("#flexCls").addClass("selectedborder");
		
		$("#btnFlexibleTicket").prop('checked', true);
		$('#btnStandardTicket').prop('checked', false);
		$("#btnBasicTicket").prop('checked', false);
		setAncillaries('CT', Number(amount), 'Y');
	}else if(name=='Basic'){
		
		$('.p-tick').removeClass('active-p');
        $('.p-tick button').text('Select');
        $("#basic_tkt").addClass('p-tick active-p');
        $("#btnBasicTicket").text('Selected');
        
		amount = 0.00;
		$("#changeableTicketAmount").val(Number(amount));
		$("#changeableTickets").val("No");
		$("#changeableTicketType").val("Basic");
		
		$("#tktTxt").html("Basic Ticket");
		$("#tktcost").html(Number(dispAmt).toFixed(2));
		
		$("#basicCls").addClass("selectedborder");
		$("#standCls").removeClass("selectedborder");
		$("#flexCls").removeClass("selectedborder");
		
		$("#btnBasicTicket").prop('checked', true);
		$("#btnFlexibleTicket").prop('checked', false);
		$('#btnStandardTicket').prop('checked', false);
		setAncillaries('CT', Number(amount), 'N');
	}
}

function addChangeTickets_old(name, amount){
	//alert("AddChangeTickets "+name+" - "+amount);
	if(name=='Standard'){
		$("#changeableTicketAmount").val(Number(amount));
		$("#changeableTickets").val("Yes");
		$("#changeableTicketType").val("Standard");
		$("#changeableText").text("Standard Ticket Fee");
		
		$("#btnBasicTicket").removeClass("activebtn");
		$("#btnStandardTicket").addClass("activebtn");
		$("#btnFlexibleTicket").removeClass("activebtn");
		$("#basicCls").removeClass("activebg");
		
		$("#tktTxt").html("Standard Ticket");
		$("#btnStandardTicket").val("Selected");
		$("#btnFlexibleTicket").val("Select");
		$("#btnBasicTicket").val("Select");
		setAncillaries('CT', Number(amount), 'Y');
	}else if(name=='Flexible'){
		$("#changeableTicketAmount").val(Number(amount));
		$("#changeableTickets").val("Yes");
		$("#changeableTicketType").val("Flexible");
		$("#changeableText").text("Flexible Ticket Fee");
		
		$("#btnBasicTicket").removeClass("activebtn");
		$("#btnStandardTicket").removeClass("activebtn");
		$("#btnFlexibleTicket").addClass("activebtn");
		$("#basicCls").removeClass("activebg");
		
		$("#tktTxt").html("Flexible Ticket");
		$("#btnFlexibleTicket").val("Selected");
		$("#btnStandardTicket").val("Select");
		$("#btnBasicTicket").val("Select");
		setAncillaries('CT', Number(amount), 'Y');
	}else if(name=='Basic'){
		amount = 0.00;
		$("#changeableTicketAmount").val(Number(amount));
		$("#changeableTickets").val("No");
		$("#changeableTicketType").val("Basic");
		
		$("#btnBasicTicket").addClass("activebtn");
		$("#btnStandardTicket").removeClass("activebtn");
		$("#btnFlexibleTicket").removeClass("activebtn");
		$("#basicCls").addClass("activebg");
		
		$("#tktTxt").html("Basic Ticket");
		$("#btnBasicTicket").val("Selected");
		$("#btnFlexibleTicket").val("Select");
		$("#btnStandardTicket").val("Select");
		setAncillaries('CT', Number(amount), 'N');
	}
}

function setCP(status, amount){
	if(status=='Add'){
		$("#cancellationProtectAmount").val(Number(amount));
		$("#cancellationProtectTaken").val("Yes");
		setAncillaries('CP',Number(amount),'Y');
	}
	else{
		$("#cancellationProtectAmount").val(Number(0.0));
		$("#cancellationProtectTaken").val("No");
		setAncillaries('CP',0.0,'N');
	}
}

function addWebCheckin(status, amount){
	if(status=='Add'){
		$("#wciaddbtn").removeClass("active").html("<i class='bi bi-check'></i> Added");
		$("#webcheckinAmount").val(Number(amount));
		$("#webcheckinTaken").val("Yes");
		$("#wcibtnremove").show();
		setAncillaries('WC',Number(amount),'Y');
	}
	else{
		$("#wciaddbtn").addClass("active").html("Add to booking");
		$("#webcheckinAmount").val(Number(0.0));
		$("#webcheckinTaken").val("No");
		$("#wcibtnremove").hide();
		setAncillaries('WC',0.0,'N');
	}
}

function removeWebCheckin(status, amount)
{
	if(status=='Remove'){
	$("#wciaddbtn").show();
	$("#wciaddbtn").addClass("active").html("Add to booking");
	$("#webcheckinAmount").val(Number(0.0));
	$("#webcheckinTaken").val("No");
	$("#wcibtnremove").hide();
	setAncillaries('WC',0.0,'N');
	}
}
function removeCP(status, amount){
	if(status=='Remove'){
		$("#yesCancel").removeClass("dvt6");
		$("#cancellationProtectAmount").val(Number(0.0));
		$("#cancellationProtectTaken").val("No");
		setAncillaries('CP',0.0,'N');
	}
}

function setSR(status, amount){
    if(status=='Add'){
        $("#surefundAmount").val(Number(amount));
        $("#surefundTaken").val("Yes");
        $("#btnYesRef").addClass('active-g');
        $('#btnNoRef').removeClass('active-g');
        $('input[name="refundable"][value="yes"]').prop('checked', true);
        setAncillaries('SR',Number(amount),'Y');
    }
    else{
        $("#surefundAmount").val(Number(0.0));
        $("#surefundTaken").val("No");
        $("#btnNoRef").addClass('active-g');
        $('#btnYesRef').removeClass('active-g');
        $('input[name="refundable"][value="no"]').prop('checked', true);
        setAncillaries('SR',0.0,'N');
    }
}
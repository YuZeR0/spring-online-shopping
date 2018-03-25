$(function() {
	//solving the active menu problem
	switch(menu) {
	
		case 'About Us':
			$('#about').addClass('active');
		break;
		
		case 'Contact Us':
			$('#contact').addClass('active');
		break;
		
		case 'All Products':
			$('#listProducts').addClass('active');
		
		default:
			if(menu == "Home") break;
			$('#listProducts').addClass('active');
			$('#a_'+menu).addClass('active');
		break;
	
	}
	
	//code for datatable
	
	var products = [		
		['1','ABC'],
		['2','CHS'],
		['3','ASF'],
		['4','AKF'],
		['5','VHS'],
		['6','VEA'],
		['7','OOP'],
		['8','PAL']
	];
	
	var $table = $('#productListTable')
	
	if ($table.length) {
		
		
		//console.log('Inside the table!');
		$table.DataTable({
			
			lengthMenu: [[3,5,10,-1], ['3 Records', '5 Records', '10 Records', 'All']],
			pageLength: 5,
			data: products
			
		});
		
	}
	
	
});
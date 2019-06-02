
		var dele = "";
		
		function openDeleteDialog(val){
			$( "#DELETE_DILOG" ).dialog( "open" );
			$("#VAL").html(val);	
			dele = val;			
		}
		
		function deleteRecord(){
			$( "#DELETE_DILOG" ).dialog( "close" );
			alert("delete successfully with val : "+dele);
		}
	 
        $(document).ready(function () {
					
			$("#DELETE_DILOG").dialog({
				autoOpen: false,
				width: 400,
				buttons: [
					{
						text: "Ok",
						click: function() {
							deleteRecord();
						}
					},
					{
						text: "Cancel",
						click: function() {
							$(this).dialog( "close" );
						}
					}
				]
			
			});

			
            $("#jqGrid").jqGrid({
                colModel: [
                    {
						label: 'Trx Name',
                        name: 'trxType',
                        width: 50,
                        formatter: printTitle
                    },
                    {
						label: 'Category',
                        name: 'categoryName',
                        width: 80
                    },
                    {
						label: 'Description',
                        name: 'description',
                        width: 80,
                        formatter: formatTitle
                    },
                    {
						label: 'Amount',
                        name: 'amount',
                        width: 50,
						sorttype:'integer',
						formatter: 'number',
						align: 'right'
                    },{
						label: 'Purchased Date',
                        name: 'purchasedDate',
                        width: 80,
						sorttype:'date',
						formatter: 'date',
						align: 'right'
                    },
                    {
						label: 'Action',
                        name: 'id',
                        width: 50,
						formatter: actionLink
                    }
                ],

                viewrecords: true, // show the current page, data rang and total records on the toolbar
                width: 1000,
                height: 400,
                rowNum: 100,
				datatype: 'local',
                pager: "#jqGridPager",
				caption: "Transaction History..."
            });

            function fetchGridData(monthId) {
                
                var gridArrayData = [];
				// show loading message
				$("#jqGrid")[0].grid.beginReq();
                $.ajax({
                    url: "http://localhost:2222/pfintrack/trxnHistoryData/"+monthId,
                    success: function (result) {
	                   if(result.status == "SUCCESS"){
	                    	console.info(result.trxnList);
	                        for (var i = 0; i < result.trxnList.length; i++) {
	                            var item = result.trxnList[i];
	                            gridArrayData.push({
	                            	description: item.description,
	                            	amount: item.amount,
	                            	purchasedDate: item.purchasedDate,
	                            	trxType: item.trxType,
	                            	categoryName: item.category.name,
	                            	id : item.id
	                            });                            
	                        }
                    	}else{
                    		console.info(result);
                    		gridArrayData.push(result.trxnList);
                    	}
						// set the new data
						$("#jqGrid").jqGrid('setGridParam', { data: gridArrayData});
						// hide the show message
						$("#jqGrid")[0].grid.endReq();
						// refresh the grid
						$("#jqGrid").trigger('reloadGrid');
                    }
                });
            }
            
            function printTitle(cellValue, options, rowObject) {
                if(cellValue == 1){
                	return "Expense";
                }
            	return "Income";
            };

            function formatTitle(cellValue, options, rowObject) {
            	if(cellValue != null && cellValue.length > 50){
            		return cellValue.substring(0, 50) + "...";
            	}else{
            		return cellValue;
            	}
            };

            function formatLink(cellValue, options, rowObject) {
                return "<a href='" + cellValue + "'>" + cellValue.substring(0, 25) + "..." + "</a>";
            };
			
			
			function actionLink(cellValue, options, rowObject) {
				return '<div><span class="ui-icon ui-icon-pencil" title="Edit"></span> &nbsp;&nbsp;<span class="ui-icon ui-icon-trash" title="Delete" onclick="openDeleteDialog('+cellValue+');"></span><div>';
			}
			
			fetchGridData(0);		            

        });


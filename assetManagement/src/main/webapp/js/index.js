function getContextPath() {
  var hostIndex = location.href.indexOf( location.host ) + location.host.length;
  return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
}

function getBtnTypeInformation () {
	const btnTypeInfo = {
			rentalBtn : { btnText:'대여', btnClass:'btn-primary', ajaxPath:'equipmentRental.do', ajaxMethod:'POST'},
			returnBtn : { btnText:'반납', btnClass:'btn-danger', ajaxPath:'equipmentReturn.do', ajaxMethod:'POST'}
	}
	return btnTypeInfo;
}
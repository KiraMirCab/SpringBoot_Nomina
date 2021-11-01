function eliminar(id) {
	swal({
		title: "Estás seguro?",
		text: "Cuando le des a 'OK' ya no podrás recuperar los datos de este empleado'!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/eliminar/"+id,
					success: function(res){
						console.log(res);
					}
				});
				swal("Adios!) El empleado ya no trabaja aquí!", {
					icon: "success",
				}).then((ok) => {
					if(ok){
						location.href="/listar";
					}
				});
			} else {
				swal("El empleado se queda en la empresa!");
			}
		});
}
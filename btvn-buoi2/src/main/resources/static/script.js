$(document).ready(function(){
    // Activate tooltip
    $('[data-toggle="tooltip"]').tooltip();

    // Select/Deselect checkboxes
    var checkbox = $('table tbody input[type="checkbox"]');
    $("#selectAll").click(function(){
        if(this.checked){
            checkbox.each(function(){
                this.checked = true;
            });
        } else{
            checkbox.each(function(){
                this.checked = false;
            });
        }
    });
    checkbox.click(function(){
        if(!this.checked){
            $("#selectAll").prop("checked", false);
        }
    });
});

function loadEmployee(id) {
    $.ajax({
        url: '/employees/edit/' + id,
        type: 'GET',
        success: function(employee) {
            $('#editId').val(employee.id);
            $('#editName').val(employee.name);
            $('#editEmail').val(employee.email);
            $('#editAddress').val(employee.address);
            $('#editPhone').val(employee.phone);

            $('#editForm').attr('action', '/employees/update/' + employee.id);

        }
    });
}

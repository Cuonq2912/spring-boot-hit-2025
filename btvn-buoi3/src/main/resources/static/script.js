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

function loadStudent(id) {
    $.ajax({
        url: '/students/edit/' + id,
        type: 'GET',
        success: function(student) {
            $('#editId').val(student.id);
            $('#editName').val(student.name);
            $('#editEmail').val(student.email);
            $('#editPhoneNumber').val(student.phoneNumber);
            $('#editAddress').val(student.address);

            $('#editForm').attr('action', '/students/update/' + student.id);

        }
    });
}
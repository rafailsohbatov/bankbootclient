$(function () {
    $('#addBtnId').click(function () {
        addCustomer();
    })
})

function addCustomer() {

    let username = $("#usernameId").val();
    let password = $("#passwordId").val();
    let name = $("#nameId").val();
    let surname = $("#surnameId").val();
    let phone = $("#phoneId").val();

    let request = {
        username: username,
        password: password,
        name: name,
        surname: surname,
        phone: phone,
    };

    $.ajax({
        url: 'addCustomer',
        type: 'POST',
        data: JSON.stringify(request),
        contentType: "application/json",
        dataType: 'text',
        success: function (response) {
            if (response == 'success') {
                alert('Customer Added')
                window.location = 'http://localhost:8084/client/GetCustomerList'
            } else {
                alert('Problem ! Customer not added')
            }
        }
    })
}
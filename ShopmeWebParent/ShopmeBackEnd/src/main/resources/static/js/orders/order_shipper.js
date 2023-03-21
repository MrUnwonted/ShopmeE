var iconNames = {
    'PICKED' : 'bxs-package',
    'SHIPPING': 'bxs-truck',
    'DELIVERED': 'bxl-dropbox',
    'RETURNED': 'bx-revision'
}

var confirmText;
var confirmModalDialog;
var yesButton;
var noButton;

$(document).ready(function (){

    confirmText = $("#confirmText");
    confirmModalDialog = $("#confirmModal");
    yesButton = $("#yesButton");
    noButton = $("#noButton");

    $(".linkUpdateStatus").on('click', function (e){
        e.preventDefault();
        link = $(this);
        showUpdateConfirmation(link);
    });

    addEventHandlerForYesButton();
});

function addEventHandlerForYesButton(){
    yesButton.click(function (e){
        e.preventDefault();
        sendResquestToUpdateOrderStatus($(this));
    })
}

function sendResquestToUpdateOrderStatus(button){
    requestURL = button.attr("href");
    $.ajax({
        type: 'POST',
        url: requestURL,
        beforeSend: function(xhr) {
            xhr.setRequestHeader(csrfHeaderName, csrfValue);
        }
    }).done(function(response) {
        console.log(response);
        showMessageModal("Order updated successfully");
        updateStatusIconColor(response.orderId, response.status);

        console.log(response);
    }).fail(function(err) {
        showResultAlert("Error updating order status");
    })
}

function showUpdateConfirmation(link){
    noButton.text("NO");
    yesButton.show();

    orderId = link.attr("orderId");
    status = link.attr("status");
    yesButton.attr("href", link.attr("href"));

    confirmText.text("Are you sure you want to update status of the order ID #" + orderId
        + " to " + status + "?");

    confirmModalDialog.modal('show');

}

function updateStatusIconColor(orderId,status){
    link = $('#link' + status + orderId);
    link.replaceWith(" <i class='bx " + iconNames[status] +  " bx-md' style=\"color: darkgreen\"></i>")
}

function showMessageModal(message) {
    noButton.text("Close");
    yesButton.hide();
    confirmText.text(message);
}
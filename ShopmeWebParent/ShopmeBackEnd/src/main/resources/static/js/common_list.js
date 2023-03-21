function showDeleteConfirmationModal(link, entityName){
    entityId = link.attr("entityId");

    $("#yesButton").attr("href",link.attr("href"));
    $("#confirmText").text("Are you sure you want to delete this "+entityName + " (ID: "+ entityId+") ?");
    $("#confirmModal").modal('show');
}
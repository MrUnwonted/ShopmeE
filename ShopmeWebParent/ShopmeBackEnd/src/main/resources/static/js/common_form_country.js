var dropDownCountry;
var dataListState;
var fieldState;


$(document).ready(function (){
    dropDownCountry = $("#country");
    dataListState = $("#listStates");
    fieldState = $("#state");

    dropDownCountry.on("change", function (){
        console.log("Here")
        loadStatesForCountry();
        fieldState.val("").focus();
    })

});

function loadStatesForCountry(){
    selectedCountry = $("#country option:selected");
    countryId = selectedCountry.val();
    url = contextPath + "states/list_by_country/" + countryId;

    $.get(url, function (responseJSON){
        dataListState.empty();

        $.each(responseJSON, function (index, state){
            $("<option>").val(state.name).text(state.name).appendTo(dataListState);
        });
    }).fail(function (){
        showErrorModal("Could not connect to server");
    });
}

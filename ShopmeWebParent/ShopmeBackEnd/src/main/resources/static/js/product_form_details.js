$(document).ready(function (){
    $("a[name='linkRemoveDetail']").each(function (index){
        $(this).click(function (){
            removeDetailSectionByIndex(index);
        });
    });

});


function addNextDetailSection(){

    allDivDetails = $("[id^='divDetail']");
    divDetailsCount = allDivDetails.length;



    htmlDetailSection = `
    <div class="row mb-3 form-inline flex-nowrap" id="divDetail${divDetailsCount}">
    <input type="hidden" name="detailIDs" value="0">
    <label class="col-sm-1 col-form-label"
           for="detailNames">Name</label>
    <div class="col-sm-4">
      <div class="input-group input-group-merge">
        <input type="text"
               id="detailNames"
               class="form-control"
               placeholder="Name"
               aria-label="detailNames"
               maxlength="255"
               name="detailNames"
        />
      </div>
    </div>
    <label class="col-sm-1 col-form-label"
           for="detailValues">Value</label>
    <div class="col-sm-4">
      <div class="input-group input-group-merge">
        <span class="input-group-text"><i class="bx bx-font"></i></span>
        <input type="text"
               name="detailValues"
               id="detailValues"
               class="form-control"
               placeholder="Value"
               aria-label="detailValues"
               th:field="*{name}"
               required
               maxlength="255"
        />
      </div>
    </div>
  </div>
    `;

    $("#divProductDetails").append(htmlDetailSection);

    previousDivDetailSection = allDivDetails.last();
    previousDivDetailId = previousDivDetailSection.attr("id");


    htmlLinkRemove = `
    <a class="bx bx-trash-alt text-dark"
    href="javascript:removeDetailSectionById('${previousDivDetailId}')"
     title="Remove this Field"></a>
    `;

    previousDivDetailSection.append(htmlLinkRemove);

    $("input[name='detailNames']").last().focus();
}


function removeDetailSectionByIndex(index){
    $("#divDetail" + index).remove();
}

function removeDetailSectionById(id){
    $("#"+id).remove();
}
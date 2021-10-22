window.onload = function () {
    $('.checkbox').each(function (i, val) {
        let check = this;
        let par = $(check.parentNode);
        let bought = check.checked;
        if (bought) {
            par.addClass("row-bought");
        } else {
            par.removeClass("row-bought");
        }
    });

    $(".checkbox").click((e) => {
        let check = $(e.currentTarget);
        let bought = check.is(":checked");
        let purchaseId = check.attr("data-purchase-id");
        let par = check.parent();
        if (bought) {
            par.addClass("row-bought");
        } else {
            par.removeClass("row-bought");
        }
        $.post("/items/" + purchaseId + "/buy");
    });
};
function toDelete(itemCode) {
    $.ajax({
        url: "/delete",
        method:"get",
        data:({
            "itemCode": itemCode
        }),
        success:function(){
            location.reload();
        }
    });
}
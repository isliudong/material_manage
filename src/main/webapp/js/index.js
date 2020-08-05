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

const a = [];
function check_box_click(itemCode) {



        var result= $.inArray(itemCode, a);
        if (result!=-1){
            a.splice($.inArray(itemCode,a),1);
        }else {
            a.push(itemCode);
        }

    console.log(a);
}
function del_checked() {

    $.ajax({
        url: "/del_checked",
        method:"get",
        data:({
            "itemCodes": a
        }),
        traditional: true,//数组去[]
        success:function(result){
            console.log(result.message);
            location.reload();
        }
    });
    a.splice(0,a.length);

}

function toIndex() {
    window.location.href = "/index";

}

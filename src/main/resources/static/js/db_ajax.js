
function fetchFaculties()
{
   var department_id = $("#dept").val();
   $.post(
       "/addHod",
       {department:department_id},
       function (data) {
         $("#fac_place").html(data);
       }
   )

}

function fetchGroups()
{
    var department_id = $("#dept").val();
    $.post(
        "/assigngrptofact",
        {department:department_id},
        function (data) {
            $("#grp_place").html(data);
        }
    )
}
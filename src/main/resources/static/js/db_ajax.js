
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

/*function fetchStudent()
{
    var Enrollment = $("#student").val();
    $.post(
        "/deallocatemember",
        {enrollment:Enrollment},
        function (data) {
            $("#std_place").html(data);
        }
    )
}*/
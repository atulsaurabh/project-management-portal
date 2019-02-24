function fetchFaculties()
{
   var deptid = $("#dept").val();
   $.post(
       "/addHod",
       {department:deptid},
       function (data) {
         $("#fac_place").html(data);
       }
   )
}
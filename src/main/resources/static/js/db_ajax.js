
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

function fetchStudent()
{
    var enrollment = $("#student").val();
    $.post(
        "/deallocatemember",
        {enrollment:enrollment},
        function (data) {
            $("#std_place").html(data);
        }
    )
}

function fetchstudents()
{
    var deptid = $("#dept").val();
    $.post(
        "/project",
        {department:deptid},
        function (data) {
            $("#student_place").html(data);
        }
    )
}

function addmembers()
{

    var enrollmentID = $("#student").val();
    $.post(
        "project/addmember",
        {enrollment:enrollmentID},
        function (data) {
            $("#member_place").html(data);
        }
    )
}


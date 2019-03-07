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

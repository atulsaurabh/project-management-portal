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
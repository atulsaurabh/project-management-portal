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

    var enrollmentID = $("#enroll").val();

    $.post(
        "/project/addmember",
        {enrollment:enrollmentID},
        function (data) {
            $("#member_place").html(data);
        }
    )
}

function sendJoinInGroupRequest(email){
    $.post(
        "/project/grouprequestmail",
        {email:email},
        function (data)
        {
            if (data === "success")
            {
                $("#member").css("color","green").html(data);
            }
        }
    )
}



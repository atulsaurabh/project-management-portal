
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
        "/handlemember",
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

    var enrollmentID = $("#enroll").val();

    $.post(
        "/project/addmember",
        {enrollment:enrollmentID},
        function (data) {
            $("#member_place").html(data);
        }
    )
}
function uploaddoc() {
    var docid = $("#docid").val();
    $.post(
        "/upload",
        {
            doctype: docid
        },
        function (data) {
            alert(data);
            $("#upload_place").html(data);
        }
    )

}
/*function selectgroup() {
    var year = $("#yearid").val();
    $.post(
        "/contect",
        {year:year},
        function () {
            $("#group_place").html(data);
        }
    )
}*/
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

function grpDetails()
{
    var grpdetails = $("#groups").val();
    $.post(
        "/faculty/assignedgroups",
        {group:groupId},
        function (data) {
            $("#grpDetails").html(data);
        }
    )
}
$(document).ready(function () {
    $('#menu a').click(function (e) {
        e.preventDefault();
        //var page=$(this).attr('href');
       // $('#content').load('content/' + page);
        $('#content').load($(this).attr('href'));
        //return false;
    });
});


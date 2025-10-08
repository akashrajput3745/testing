<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="table.css">






</head>

<body></body>

<?php















$conn = mysqli_connect("localhost:3306","root","emperor3745","testing");
if(mysqli_connect_error()) echo "not connect";

if(isset($_POST["update"])){
    $sino = $_POST["sino"];
    $uname = $_POST["uname"];
    $pass = $_POST["pass"];
    $user = trim($uname);
    $passw = trim($pass);

    try{
        $q = "UPDATE stdinfo SET name = '$uname', class = '$pass' where id = $sino; ";
        $result = mysqli_query($conn, $q);
        // if($result){echo"sussecs";}else{echo "un sussecs";}


    }catch(Exception $e){
        echo $e->getMessage();
    }
}

$qry = "SELECT * FROM stdinfo;";
$r = mysqli_query($conn,$qry);

echo "
</head>

<body></body>
    <table border='3'>
        <tr>
            <th> Si_no</th>
            <th> name </th>
            <th> class </th>
            <th> Update </th>
        </tr>


";
if(mysqli_num_rows($r) > 0){
    while($row = mysqli_fetch_array($r)){
       echo "
        <tr>
            <form action='test.php' method='post'>
                <td><input type='text' value='". trim($row[0]) ."  ' name='sino' id=''></td>
                <td><input type='text' value='". trim($row[1]) ." ' name='uname' id=''></td>
                <td><input type='text' value='". trim($row[2]) ." ' name='pass' id=''></td>
                <td><input type='submit' name='update' value='Update'></td>
            </form>
        </tr>
       ";
    }
    echo" </table>";
}
?>


</body>

</html>
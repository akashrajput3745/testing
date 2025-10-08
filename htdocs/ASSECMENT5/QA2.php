<?php
$servername = "127.0.0.1:3306";  // Usually "localhost"
$username = "root";         // Your MySQL username
$password = "emperor3745";             // Your MySQL password (empty in XAMPP)
$dbname = "testing";        // Your database name

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
$title = (string)$_POST['title'];
$status = (string)$_POST['status'];
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
$query = "SELECT eno, title FROM event WHERE title = ?";

$result = $conn->prepare($query);
$result->bind_param("s", $title);
$result->execute();
$result->bind_result($eno,$t);
$result->fetch();
$result->close();


$junc = "SELECT cno FROM event_committee WHERE eno = ?";
$rr =  $conn->prepare($junc);
$rr->bind_param("i",$eno);
$rr->execute();
$rr->bind_result($cno);
// $rr->close();
$arr = [];
$i = 0;
while ($rr->fetch()) {

    $arr[$i] = $cno;
    $i++;
    # code...
}
$rr->close();


foreach ($arr as $cid) {
    echo $cid." <br>";
    $query = "UPDATE  committee SET status = ? WHERE cno = ?";

$result = $conn->prepare($query);
$result->bind_param("si",$status, $cid);
$result->execute();

}


// echo "Committee Number: $cno <br>";

echo "Connected successfully! $eno  $t";

?>

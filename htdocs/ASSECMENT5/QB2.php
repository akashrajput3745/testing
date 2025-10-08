

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Competition Winner Info</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <h1>Competition Winner Info</h1>
        <!-- Form to submit competition name -->
        <form action="QB2.php" method="POST">
            <input type="text" name="c_name" placeholder="Enter Competition Name" required>
            <button type="submit">Search</button>
        </form>

        <!-- Result Area -->
        <div id="result">
            <!-- PHP will fill this area -->
           
            <?php
$conn = mysqli_connect("127.0.0.1:3306","root","emperor3745","studints_com");
if(!$conn){
    die("Connection Failed: ".mysqli_connect_error());
}

if(isset($_POST['c_name'])){
    $c_name = $_POST['c_name'];


$query = " SELECT s.* FROM participation p JOIN student s ON p.Stud_id = s.Stud_id JOIN competition c ON p.c_no = c.c_no WHERE c.c_name = ? AND p.rank =1;";
// $query = " SELECT p.* FROM owns   JOIN property p ON owns.pno = p.pno JOIN owner o ON owns.name = o.name WHERE o.phone 8765432109;"
$rel = $conn->prepare($query);
$rel->bind_param("s",$c_name);
$rel->execute();
$rel->bind_result($id,$name,$class);
while($rel->fetch()){
    // echo "ID: $id Name: $name Class: $class <br>";

}



    echo "<div id='result'>
        <h3>$name</h3>
        <p>Class: $class</p>
       
      </div>";

$rel->close();
}
?>
        </div>
    </div>
</body>
</html>

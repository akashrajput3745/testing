




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
        <form action="QC2.php" method="POST">
            <input type="text" name="c_name" placeholder="Enter Competition Name" required>
            <button type="submit">Search</button>
        </form>

        <!-- Result Area -->
        <div id="result">
            <!-- PHP will fill this area -->
           
            <?php
$conn = mysqli_connect("127.0.0.1:3306","root","emperor3745","proper");
if(!$conn){
    die("Connection Failed: ".mysqli_connect_error());
}

if(isset($_POST['c_name'])){
    $c_name = $_POST['c_name'];


/*
+-----+-------------+------+
| pno | description | area |
+-----+-------------+------+
| 102 | 3BHK Villa  | 3500 |
+-----+-------------+------+
*/


// $query = " SELECT s.* FROM participation p JOIN student s ON p.Stud_id = s.Stud_id JOIN competition c ON p.c_no = c.c_no WHERE c.c_name = ? AND p.rank =1;";
$query = "  SELECT p.* FROM owns K JOIN property p ON K.pno = p.pno JOIN owner o ON K.name = o.name WHERE o.name = ? ;";
$rel = $conn->prepare($query);
$rel->bind_param("s",$c_name);
$rel->execute();
$rel->bind_result($pno,$description,$area);
echo " the owner '$c_name' owns the following properties: <br>";
echo "<table border='2'><tr><th>Pno</th><th>Description</th><th>Area</th></tr>";
while($rel->fetch()){
   echo "<tr><td>$pno</td><td>$description</td><td>$area</td></tr>";

}
echo "</table>";


$rel->close();
}
?>
        </div>
    </div>
</body>
</html>













<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Example</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            display: flex;
            justify-content: space_between;
           flex-direction: column;
            align-items: center;
            height: 100vh;
            width: 100vw;
            margin: 0;
            flex-wrap: wrap;
            
            
        }
        .form-container {
            background: #fff;
            padding: 20px 30px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }
        .form-container h2 {
            margin-bottom: 20px;
            color: #333;
            text-align: center;
        }
        .form-container input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }
        .form-container button {
            width: 100%;
            padding: 10px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
        .form-container button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Simple Form</h2>
        <form action="QA2.php" method="post">
            <input type="text" name="title" placeholder="Enter Title" required>
            <input type="text" name="status" placeholder="Enter Status" required>
            <button type="submit">Submit</button>
        </form>";

    </div>
    <?php
    $servername = "127.0.0.1:3306";
$username = "root";
$password = "emperor3745";
$dbname = "testing";

$conn = new mysqli($servername, $username, $password, $dbname);

$qry = "SELECT * FROM event;";
$res = $conn->query($qry);
echo"       <table border='2'><tr><th>Eno</th><th>Title</th><th>Date</th></tr>";

while($row = $res->fetch_assoc()){
 echo"           <tr>";
 echo"               <td>". $row['eno'] ."</td>";
 echo"               <td>". $row['title'] ."</td>";
 echo"               <td>". $row['date'] ."</td>";
 echo"           </tr>";
}
echo"       </table>";



?>
<?php
$qry = "SELECT * FROM committee;";
$res = $conn->query($qry);
echo"       <table border='2'><tr><th>Cno</th><th>Name</th><th>Head</th>  <th>From Time</th> <th>To Time</th>  <th>Status</th></tr>";

while($row = $res->fetch_assoc()){
 echo"           <tr>";
 echo"               <td>". $row['cno'] ."</td>";
 echo"               <td>". $row['name'] ."</td>";
 echo"               <td>". $row['head'] ."</td>";
 echo"               <td>". $row['from_time'] ."</td>";
 echo"               <td>". $row['to_time'] ."</td>";
 echo"               <td><b>". $row['status'] ."</b></td>";
 echo"           </tr>";
}
echo"       </table>";


?>
</body>
</html>
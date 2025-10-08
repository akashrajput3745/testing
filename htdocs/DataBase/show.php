<?php
$conn = mysqli_connect("localhost:3306","root","emperor3745","testing");
if (mysqli_connect_errno()) {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  exit();
}

$sql = "select * from fb_login;";
$res = $conn->prepare($sql);
$res->execute();
$res->bind_result($sino,$user,$pass);

$res->fetch();
echo "<table border='2'>
<tr>
<th>Si No</th>
<th>User Name</th>
<th>Password</th>
</tr>";
do {
  echo "<tr>
  <td>$sino</td>
  <td>$user</td>
  <td>$pass</td>
  </tr>";
}while($res->fetch());
echo "</table>";



?>
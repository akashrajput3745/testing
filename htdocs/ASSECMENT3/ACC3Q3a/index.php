<?php
$index = $_POST['index'];
$subjext = $_POST['sub'];
$marks = $_POST['mark'];
echo "<h2>Student Markes Sheet</h2>";
$ind = explode(",",$index);
$sub = explode(",",$subjext);
$mar = explode(",",$marks);
$total = array_sum($mar);

echo "<table border='1'>";
if(count($ind) == count($sub) && count($ind) == count($mar)){
    $per = ($total / count($ind)*100)/100;
    echo "<tr><th>Index</th><th>Subject</th><th>Markes</th></tr>";
    for($i=0; $i < count($ind); $i++){
        echo "<tr><td> $ind[$i] </td> <td> $sub[$i] </td> <td> $mar[$i] </td> </tr>";
    }
    echo "<tr> <td colspan='2'> <b>Total </b></td> <td>$total </td></tr>";
    echo "<tr> <td colspan='2'> <b>Percentage </b></td> <td>$per </td></tr>";
        if($per < 50 )echo "<tr> <td colspan='2'> <b>  GRADE </b></td> <td> C </td></tr>";
        elseif($per < 75 )echo "<tr> <td colspan='2'> <b>  GRADE </b></td> <td> B </td></tr>";
        elseif($per < 80 )echo "<tr> <td colspan='2'> <b>  GRADE </b></td> <td> B+ </td></tr>";
        elseif($per < 90 )echo "<tr> <td colspan='2'> <b>  GRADE </b></td> <td> A </td></tr>";

}

?>
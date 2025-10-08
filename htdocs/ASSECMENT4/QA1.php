<?php
$highTemps = [];
for($i =0; $i< 30; $i++){
    $highTemps[$i] = rand(20,45);

}
$avg = array_sum($highTemps)/count($highTemps);
sort($highTemps);
$fiveCOll = array_slice($highTemps,0,5);
$fivehot = array_slice($highTemps,-5);


?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <table border="1">
        <tr>
        <?php
        for($i=0; $i<30; $i++){
            echo "<td> $highTemps[$i]°C</td>";
        }
        ?>
        </tr>
    </table>
    <h3>The avarge temprecher is : <?php echo $avg;?></h3>
    <h3>Top 5 warm temprecher is : <?php echo implode(",",$fivehot);?></h3>
    <h3>Top 5 coll temprecher is : <?php echo implode(", ",$fiveCOll);?></h3>
</body>
</html>
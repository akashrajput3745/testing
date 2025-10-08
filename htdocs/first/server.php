 <?php

$srt1 = (int)$_POST["ip1"];
$srt2 = (int)$_POST["ip2"];


function sum($a){
    if($a > 0){
        return $a + sum($a - 1);
    }
}
function fat($a){
    if($a < 0){
        return "Error";
    }elseif($a == 0){
        return 1;
    }else{
        return ($a * fat($a - 1));
    }
}

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
   <div class="cont">
    <div class="it">The MOD of two numbers is : <?php echo $srt1% $srt2?></div>
    <div class="it">The SUM of two numbers is : <?php echo pow( $srt1 , $srt2)?></div>
    <div class="it">The SUM of first value : <?php echo ($srt1 * ($srt1+1))/2 ?></div>
    <div class="it">The SUM of first value using 2<sub>nd</sub> : <?php echo sum($srt1) ?></div>
    <div class="it">The factorial  of secound  numbers is : <?php echo fat($srt2) ?></div>
    <div class="it">The DIVISION of two numbers is : <?php echo $srt1 / $srt2?></div>
   </div>
<b><?php echo $srt1 ?></b>
</body>
</html>
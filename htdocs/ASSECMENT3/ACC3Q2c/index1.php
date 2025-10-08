<?php
$str1 = $_POST['str1'];
$str2 = $_POST['str2'];
$smg =  $_POST['smg'];


function greet($student = "student",$collage = "yout collage",$smg = "welcome"){
    echo "$smg $student to aver collage $collage";
}
greet($str1,$str2,$smg);
?>



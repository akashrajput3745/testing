<?php
$arr = [
    "Sophia" => 31, 
    "Jacob" => 41, 
    "William" => 39, 
    "Ramesh" => 40
];
echo "<h4> Original array: </h4>";
echo " <pre>";
print_r($arr);
echo "</pre> <br>";

echo "<h4> After sorting the array by values: </h4> <br>";
asort($arr);
echo " <pre>";
print_r($arr);
echo "</pre> <br>";

echo "<h4> After sorting the array by keys: </h4> <br>";
ksort($arr);
echo " <pre>";
print_r($arr);
echo "</pre> <br>";
echo "<h4> After reverse sorting the array by values: </h4> <br>";
arsort($arr);
echo " <pre>";
print_r($arr);
echo "</pre> <br>";     
echo "<h4> After reverse sorting the array by keys: </h4> <br>";
krsort($arr);
echo " <pre>";
print_r($arr);  
echo "</pre> <br>";
?>
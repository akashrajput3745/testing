<?php
$st1 = isset($_POST['str1']) ? $_POST['str1'] : 'hi';
$bt1 = isset($_POST['str2']) ? $_POST['str2'] : 'hello and hi';
$n = (int)isset($_POST['num']) ? $_POST['num'] : '3';

if (strlen($st1) > strlen($bt1)) {
    $st = $bt1;
    $bt = $st1;
} else {
    $st = $st1;
    $bt = $bt1;
}

// echo "Small string: $st <br>";
// echo "Big string: $bt <br>";

$pos = strpos($bt, $st);
if ($pos !== false) {
    echo "* '$st' found in '$bt' at position: $pos";
} else {
    echo "'$st'* not found in '$bt'";
}
echo "<br>";
$st_chars = str_split($st);  // ['h','i']
$bt_chars = str_split($bt);  // ['a','k','a','s','h',' ','h','i']
$common = array_intersect($st_chars, $bt_chars);
echo "* Common characters: " . implode(", ", $common);

$bs = substr($bt,0,$n);
$ss = substr($st,0,$n);

echo "<br>* $n is $bs and $ss";

if(strtolower($bs) == strtolower($ss)){
    echo "<br>* IN not case sencitive  <b>: equle</b>";
}else{
    echo "<br>* IN not case sencitive   <b>: not equle</b>";
}
if($bs == $ss){
    echo "<br>* IN  case sencitive   <b> : equle</b>";
    

}else{
    echo "<br>* IN  case sencitive   <b> : not equle</b>";
}


?>
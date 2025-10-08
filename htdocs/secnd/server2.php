<?php
$str = (string)$_POST["str"];

function len($string) {
    $count = 0;
    for ($i = 0; isset($string[$i]); $i++) {
        $count++;
    }
    return $count;
}
function vowels($s){
    $vowels = ['a','e','i','o','u'];
    $count = 0;
    for($i = 0; $i < strlen($s); $i++){
        if(in_array($s[$i], $vowels)){
            $count++;
        }
    }
    return $count;
}
echo str_pad($str,20,"*",STR_PAD_BOTH)."<br>";

$string = "Hello, World!";
echo $str."   Length of the string: <b>" . len($str)."</b><br>"; // Outputs 13
echo "   Number of vowels in the string: <b>" . vowels($str)."</b><br>"; // Outputs 3
echo "   Lowar case : <b>" . strtolower($str) ."</b> and  Title case : <b>". ucwords($str)."</b><br>"; // Outputs "hello, world! and Hello, World!"
echo "   Leading Whitespaces removed : <b>". ltrim($str)."</b> <br>"; // Outputs "hello, world! and Hello, World!"
?>

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


$string = "Hello, World!";
echo $str."   Length of the string: " . len($str); // Outputs 13
echo "   Number of vowels in the string: " . vowels($str); // Outputs 3
echo "   Lowar case : " . strtolower($str) ." and  Title case : ". ucwords($str); // Outputs "hello, world! and Hello, World!"
?>

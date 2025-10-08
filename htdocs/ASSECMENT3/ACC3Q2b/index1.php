<?php
$str = isset($_POST['str1']) ? $_POST['str1'] : 'hi';
$sep = isset($_POST['sep']) ? $_POST['sep'] : ' ';
$new_sep = isset($_POST['new_sep']) ? $_POST['new_sep'] : " ";


$st = explode($sep, $str);
$st1 = implode($new_sep, $st);
$st2 = implode(" ", $st);

echo "$st2 <br> $st1";
echo "<br>the Last : ". end($st);
?>



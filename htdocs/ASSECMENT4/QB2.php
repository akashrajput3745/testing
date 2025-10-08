
<?php
$value = null;
$position = null;
$arr = [1,2,3,45,67,8,9,0];
if(isset($_POST['element'])){
    $value = (int)$_POST['element'];

if(in_array($value,$arr)){
    $position = array_search($value,$arr);
}
}
?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add element in array</title>
    <link rel="stylesheet" href="style.css">
    <style>
        form{
            display: flex;
            flex-direction: row;
            gap: 10px;
            flex-wrap: wrap;
        }
        input{
            flex-grow: 10;
        }
    </style>
<body>
    <div class="cont">
        <fieldset>
            <legend > Add at spesific position</legend>
            <form method="post">
                
                <input type="text" name="element" placeholder="Enter Value" > 
                
                <button style="flex-grow: 10;" name="action" value="pushStack" >Add in Array</button>
                <br><br>
            </form>
        </fieldset>
        <div style="color: #000000; width: 90%; height: 30px; margin-top: 10px; " class="bor">
<?php
 echo "<span class='high'> $value </span> found at position:<span class='high'> $position </span> <br>";
echo implode(", ", $arr);
?>
        </div>
    </div>
    </body>
</html>
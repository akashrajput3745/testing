
<?php
session_start();
$_SESSION['arr'] = $_SESSION['arr'] ?? [];
$arr = $_SESSION['arr'] ;
$value = $_POST['element'] ?? 0;
$position = $_POST['position'] ?? 0;

isset($_POST['reset']) ? session_destroy() : null;



if($position >= 0 && $position <= count($arr)){
    array_splice($arr, $position, 0, $value);
    $_SESSION['arr'] = $arr;
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
            width: 40%;
        }
    </style>
<body>
    <div class="cont">
        <fieldset>
            <legend> Add at spesific position</legend>
            <form method="post">
                
                <input type="text" name="element" placeholder="Enter Value" > 
                <input type="text" name="position" placeholder="Enter Position" > 
                
                <button style="flex-grow: 10;" name="action" value="pushStack" >Add in Array</button>
                <button style="flex-grow: 10;" name="reset" value="pushStack" >resetk</button>
                <br><br>
            </form>
        </fieldset>
        <div style="color: #000000; width: 90%; height: 30px; margin-top: 10px; " class="bor">
<?php
echo implode(", ", $arr);
?>
        </div>
    </div>
    </body>
</html>
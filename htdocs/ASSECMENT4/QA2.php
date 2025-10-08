<?php
session_start();

if (!isset($_SESSION['stack'])) {
    $_SESSION['stack'] = [];
}
if (!isset($_SESSION['queue'])) {
    $_SESSION['queue'] = [];
}


$element = $_POST['element'] ?? 0;
$action = $_POST['action'] ?? null;

$stack = &$_SESSION['stack'];
$queue = &$_SESSION['queue'];

if($action === 'pushStack'){
    array_push($stack, $element);
}
if($action === 'popStack'){
    array_pop($stack);
}
if($action === 'enqueue'){
    array_push($queue, $element);
}
if($action === 'dequeue'){
    array_shift($queue);
}


?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<link rel="stylesheet" href="style.css">
<body>
    <div class="cont">
        <fieldset>
            <legend> Stack & Queue</legend>
            <form method="post">
                <input type="text" name="element" placeholder="Enter Value" > 
                
                <button name="action" value="pushStack" >push in stack</button>
                <button name="action" value="popStack" >pop from stack</button>

                <button name="action" value="enqueue" >Add in queue</button>
                <button name="action" value="dequeue" >Remove from queue</button>
                <br><br>
            </form>
        </fieldset>
        <div>
            <div class="result">
            <h3> Stack </h3>

                <?php
                if(!empty($stack)){
                    echo implode(", ", $stack);
                } else {
                    echo "Stack is empty";
                }
                ?>
                </div>

                 <div class="result">
            <h3> Queue </h3>

                <?php
                if(!empty($queue)){
                    echo implode(", ", $queue);
                } else {
                    echo "Queue is empty";
                }
                ?>
                </div>
    </div>
</body>
</html>
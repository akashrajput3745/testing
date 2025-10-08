<?php
$email = (string)$_POST['email'];
// $email = "akashrana1087@gmail.com";
// Step 0: Check if email starts with a number
if(preg_match('/^[0-9]/', $email)){
    echo "this mail start with the number";
    exit;
}
if(substr_count($email,'@') !== 1){
    echo "@ most be one time ";
    exit;
}
list($afr,$bef) = explode("@",$email);

if(strpos($afr,'.')){
    echo " ' . ' must be come after '@' ";
    exit;
}

// If all checks pass
echo "✅ Looks like a valid email format.";
?>

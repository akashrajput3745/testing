<?php
// Get the POST data sent by Fetch API
$data = json_decode(file_get_contents("php://input"), true);

// Check if the data is received correctly
if (isset($data['input1']) && isset($data['input2'])) {
    $num1 = (int)$data['input1'];  // First number
    $num2 = (int)$data['input2'];  // Second number

    // Perform operations
    $modulus = findModulus($num1, $num2);
    $power = findPower($num1, $num2);
    $sumOfNumbers = findSumOfNumbers($num1);
    $factorial = findFactorial($num2);

    // Prepare the response
    $response = [
        'status' => 'success',
        'modulus' => $modulus,
        'power' => $power,
        'sumOfNumbers' => $sumOfNumbers,
        'factorial' => $factorial,
    ];
} else {
    // In case of missing data
    $response = [
        'status' => 'error',
        'message' => 'Missing input data'
    ];
}

// Send JSON response back to JavaScript
header('Content-Type: application/json');
echo json_encode($response);


// Function to find the modulus
function findModulus($num1, $num2) {
    return $num1 % $num2;
}

// Function to find the power of first number raised to the second
function findPower($num1, $num2) {
    return pow($num1, $num2);
}

// Function to find the sum of the first n numbers (1 + 2 + ... + num1)
function findSumOfNumbers($num1) {
    return ($num1 * ($num1 + 1)) / 2;  // Sum of first 'n' numbers formula
}

// Function to find the factorial of the second number
function findFactorial($num2) {
    if ($num2 < 0) {
        return "Factorial is not defined for negative numbers";
    }
    $factorial = 1;
    for ($i = 1; $i <= $num2; $i++) {
        $factorial *= $i;
    }
    return $factorial;
}
?>
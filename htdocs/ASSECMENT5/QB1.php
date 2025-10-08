<?php
// File name
$filename = "item.dat";

// Check if file exists
if (!file_exists($filename)) {
    die("File not found!");
}

// Read file line by line
$lines = file($filename);


echo "<h2 style='text-align:center;'>Item Bill</h2>";
echo "<table border='1' cellspacing='0' cellpadding='8' style='margin:auto; border-collapse:collapse; text-align:center;'>
<tr>
<th>Item Code</th>
<th>Item Name</th>
<th>Units Sold</th>
<th>Rate</th>
</tr>";

$grand_total = 0;

foreach ($lines as $line) {
    // Split each line by |
    list($code, $name, $units, $rate) = explode("|", $line);

    // Calculate total
    $total = $units * $rate;
    $grand_total += $total;

    echo "<tr>
    <td>$code</td>
    <td>$name</td>
    <td>$units</td>
    <td>$rate</td>
    </tr>";
}

//echo "<tr>
//<td colspan='4' style='text-align:right; font-weight:bold;'>Grand Total</td>
//<td style='font-weight:bold;'>$grand_total</td>
//</tr>";
echo "</table>";
?>

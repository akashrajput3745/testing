<?php
// File name (you can change this to any file you want to read)
$filename = "example.txt";

// Check if file exists
if (file_exists($filename)) {

    // Get file size
    $size = filesize($filename);

    // Read file contents
    $contents = file_get_contents($filename);

    // Display results
    echo "<h3>File Name: $filename</h3>";
    echo "<p><strong>File Size:</strong> $size bytes</p>";
    echo "<h4>File Contents:</h4>";
    echo "<pre>$contents</pre>";

} else {
    echo "File '$filename' not found!";
}
?>

<?php
// QC1.php
$clicked = '';
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    if (!empty($_POST['action'])) {
        $clicked = htmlspecialchars($_POST['action'], ENT_QUOTES);
    }
}
?>
<?php
// target file in the same directory as this script
$targetName = 'sample.txt';
$targetPath = __DIR__ . DIRECTORY_SEPARATOR . $targetName;

// helper: human readable size
function human_filesize($bytes, $decimals = 2) {
    $units = ['B','KB','MB','GB','TB'];
    if ($bytes <= 0) return '0 B';
    $i = floor(log($bytes, 1024));
    return sprintf("%.{$decimals}f %s", $bytes / pow(1024, $i), $units[$i]);
}

if ($clicked) {
    switch ($clicked) {
        // "Create" button -> display file type
        case 'create':
            if (!file_exists($targetPath)) {
                @file_put_contents($targetPath, "Sample file created on " . date('c') . "\n");
            }
            $type = null;
            if (function_exists('finfo_open')) {
                $f = @finfo_open(FILEINFO_MIME_TYPE);
                if ($f !== false) {
                    $type = @finfo_file($f, $targetPath);
                    finfo_close($f);
                }
            }
            if (empty($type) && function_exists('mime_content_type')) {
                $type = @mime_content_type($targetPath);
            }
            $type = $type ?: 'unknown';
            $clicked = "File type of {$targetName}: {$type}";
            break;

        // "Save" button -> display last access time
        case 'save':
            if (!file_exists($targetPath)) {
                $clicked = "File {$targetName} does not exist.";
            } else {
                $atime = @fileatime($targetPath);
                if ($atime === false) {
                    $clicked = "Unable to read last access time for {$targetName}.";
                } else {
                    $clicked = "Last access of {$targetName}: " . date('Y-m-d H:i:s', $atime);
                }
            }
            break;

        // "Preview" button -> display size
        case 'preview':
            if (!file_exists($targetPath)) {
                $clicked = "File {$targetName} does not exist.";
            } else {
                $size = @filesize($targetPath);
                if ($size === false) {
                    $clicked = "Unable to read size for {$targetName}.";
                } else {
                    $clicked = "Size of {$targetName}: " . human_filesize($size);
                }
            }
            break;

        // "Delete" button -> delete file
        case 'delete':
            if (!file_exists($targetPath)) {
                $clicked = "File {$targetName} does not exist.";
            } else {
                $ok = @unlink($targetPath);
                $clicked = $ok ? "Deleted {$targetName}." : "Failed to delete {$targetName}.";
            }
            break;

        default:
            $clicked = "Unknown action.";
            break;
    }
}
?>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Form with Four Buttons</title>
<meta name="viewport" content="width=device-width,initial-scale=1" />
<style>
  :root{
    --radius:8px;
    --padding:14px 22px;
    --font: 16px/1.2 system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial;
  }
  body{
    font: var(--font);
    background: linear-gradient(180deg,#f7fbff,#eef6ff);
    display:flex;
    align-items:center;
    justify-content:center;
    min-height:100vh;
    margin:0;
  }
  .card{
    background:#fff;
    padding:28px;
    border-radius:12px;
    box-shadow:0 8px 28px rgba(20,40,80,0.08);
    width:380px;
    text-align:center;
  }
  h1{ margin:0 0 12px; font-size:18px; color:#123; }
  p.small{ margin:0 0 18px; color:#557; font-size:13px; }

  form.button-row{
    display:flex;
    gap:10px;
    flex-wrap:wrap;
    justify-content:center;
  }

  .btn{
    appearance:none;
    -webkit-appearance:none;
    border:0;
    cursor:pointer;
    border-radius:var(--radius);
    padding:var(--padding);
    font-weight:600;
    font-size:15px;
    color:#fff;
    transition:transform .08s ease, box-shadow .12s ease, opacity .12s;
    box-shadow:0 6px 18px rgba(15,30,70,0.08);
    min-width:140px;
  }
  .btn:active{ transform:translateY(1px) scale(.998); }
  .btn:focus{ outline:3px solid rgba(20,120,255,0.12); outline-offset:3px; }

  .btn-primary{ background:linear-gradient(180deg,#2b7cff,#0b62ff); }
  .btn-success{ background:linear-gradient(180deg,#2ec27a,#1bb75f); }
  .btn-warning{ background:linear-gradient(180deg,#ffb74d,#ff9800); color:#1a1200; }
  .btn-danger{ background:linear-gradient(180deg,#ff6b6b,#ff3b3b); }

  .result{
    margin-top:16px;
    font-size:14px;
    color:#113;
    background:rgba(5,80,120,0.03);
    padding:10px;
    border-radius:8px;
  }

  @media(max-width:420px){
    .btn{ min-width:120px; padding:10px 14px; }
    .card{ width:92%; padding:18px; }
  }
</style>
</head>
<body>
  <div class="card">
    <h1>Choose an action</h1>
    <p class="small">A single form with four styled buttons. Each button submits the form with a different value.</p>

    <form class="button-row" method="post" action="">
      <button type="submit" name="action" value="create" class="btn btn-primary">Type of file</button>
      <button type="submit" name="action" value="save" class="btn btn-success">Last open </button>
      <button type="submit" name="action" value="preview" class="btn btn-warning"> Sise</button>
      <button type="submit" name="action" value="delete" class="btn btn-danger" onclick="return confirm('Delete?')">Delete</button>
    </form>

    <?php if ($clicked): ?>
      <div class="result">Submitted action: <strong><?php echo $clicked; ?></strong></div>
    <?php endif; ?>
  </div>
</body>
</html>
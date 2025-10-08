<?php
function safe($s){ return htmlspecialchars(trim($s)); }

$res = '';
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $big = $_POST['big'] ?? '';
    $small = $_POST['small'] ?? '';
    $op = $_POST['op'] ?? 'a';
    $pos_input = intval($_POST['pos'] ?? 0);
    $len_input = isset($_POST['len']) ? intval($_POST['len']) : null;

    // We'll treat position input from user as 1-based (more intuitive). Convert to 0-based for PHP.
    $pos = max(0, $pos_input - 1);

    if ($big === '') {
        $res = "Please enter the big string (sentence).";
    } else {
        switch ($op) {
            case 'a':
                // delete part from big starting at pos of length len_input
                $len = max(0, $len_input);
                $modified = substr_replace($big, '', $pos, $len);
                $res = "After deleting $len chars from position $pos_input: <pre>" . htmlspecialchars($modified) . "</pre>";
                break;
            case 'b':
                // insert small at pos without removing any chars -> length zero
                $modified = substr_replace($big, $small, $pos, 0);
                $res = "After inserting \"" . htmlspecialchars($small) . "\" at position $pos_input: <pre>" . htmlspecialchars($modified) . "</pre>";
                break;
            case 'c':
                // replace some characters from pos with small. We use len_input to specify how many characters to replace.
                $len = max(0, $len_input);
                $modified = substr_replace($big, $small, $pos, $len);
                $res = "After replacing $len chars at position $pos_input with \"" . htmlspecialchars($small) . "\": <pre>" . htmlspecialchars($modified) . "</pre>";
                break;
            case 'd':
                // replace all characters from pos till end with small string
                $modified = substr_replace($big, $small, $pos);
                $res = "After replacing everything from position $pos_input with \"" . htmlspecialchars($small) . "\": <pre>" . htmlspecialchars($modified) . "</pre>";
                break;
            default:
                $res = "Unknown operation.";
        }
    }
}
?>
<!doctype html>
<html>
<head><meta charset="utf-8"><title>Set C Q2</title></head>
<body>
<h2>Set C - Q2</h2>
<form method="post">
    <label>Big string (sentence):<br><textarea name="big" rows="3" cols="70"><?= htmlspecialchars($_POST['big'] ?? '') ?></textarea></label><br><br>
    <label>Small string (word to insert/replace):<br><input type="text" name="small" size="60" value="<?= htmlspecialchars($_POST['small'] ?? '') ?>"></label><br><br>

    <label>Operation:
        <select name="op">
            <option value="a" <?= (isset($_POST['op']) && $_POST['op']=='a')?'selected':'' ?>>a) Delete part (need position & length)</option>
            <option value="b" <?= (isset($_POST['op']) && $_POST['op']=='b')?'selected':'' ?>>b) Insert small string at position (no removal)</option>
            <option value="c" <?= (isset($_POST['op']) && $_POST['op']=='c')?'selected':'' ?>>c) Replace some chars/words at position (need length)</option>
            <option value="d" <?= (isset($_POST['op']) && $_POST['op']=='d')?'selected':'' ?>>d) Replace everything from position with small string</option>
        </select>
    </label><br><br>

    <label>Position (1-based): <input type="number" name="pos" value="<?= htmlspecialchars($_POST['pos'] ?? '1') ?>"></label><br><br>
    <label>Length (for ops a & c): <input type="number" name="len" value="<?= htmlspecialchars($_POST['len'] ?? '0') ?>"></label><br><br>
    <button type="submit">Perform</button>
</form>

<?php if ($res) echo "<div style='margin-top:20px;'>$res</div>"; ?>
<p><small>Note: Position is 1-based (first character = position 1). If you prefer 0-based, enter 0.</small></p>
</body>
</html>
